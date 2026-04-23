package jeu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;
import cartes.Type;

public class ZoneDeJeu {
	
	private List <Carte> pileDeLimite;
	private List <Carte> pileBataille;
	private List <Carte> collectionDeBornes;

	private Set<Botte> ensembleBottes;
	
	
	public ZoneDeJeu() {
		pileDeLimite = new ArrayList<>();
		pileBataille = new ArrayList<>();
		collectionDeBornes = new ArrayList<>();
		ensembleBottes = new HashSet<>(); 
		
	}

	public boolean estPrioritaire() {
		return ensembleBottes.contains(Cartes.PRIORITAIRE);
	}

	private boolean possedeBotte(Type type) {
		return ensembleBottes.contains(new Botte(type));
	}
	

	
	public int donnerLimitationVitesse() {

	    if (estPrioritaire() || pileDeLimite.isEmpty() || pileDeLimite.get(pileDeLimite.size() - 1) instanceof FinLimite) {
	        return 200;
	    }
	    return 50;
	}

	public int donnerKmParcourus() {
	    int total = 0;
	    for (Carte carte : collectionDeBornes) {
	        if (carte instanceof Borne borne) {
	            total += borne.getkm();
	        }
	    }
	    return total;
	}
	public void deposerCarte(Carte carte) {
	    if (carte instanceof Borne) {
	        collectionDeBornes.add(carte);
	        
	    } else if (carte instanceof Limite) {
	        pileDeLimite.add(carte);
	        
	    } else if (carte instanceof Bataille) {
	        pileBataille.add(carte);
	        
	    } else if (carte instanceof Botte botte) {
	    	ensembleBottes.add(botte);
	    }
	}
	

	
	public boolean peutAvancer() {
        if (pileBataille.isEmpty()) {
        	return estPrioritaire();
        }
        Carte sommet = pileBataille.get(pileBataille.size() - 1);      
        return sommet.equals(Cartes.FEU_VERT);
    }
	
	private boolean estDepotFeuVertAutorise() {
		if (estPrioritaire()) {
			return false;
		}
		
        if (pileBataille.isEmpty()) { 
        	return true;
        }
        Carte sommet = pileBataille.get(pileBataille.size() - 1);
        
        if (sommet.equals(Cartes.FEU_ROUGE) || (sommet instanceof Parade && !sommet.equals(Cartes.FEU_VERT))) {
        	return true;
        }  
 
        if (sommet instanceof Attaque attaque && possedeBotte(attaque.getType())) {
        	return true;
        }
        
        return false;
    }
	
	
	private boolean estDepotBorneAutorise(Borne borne) {
        boolean pasBloque = peutAvancer();
        
        boolean respectLimite = borne.getkm() <= donnerLimitationVitesse();
        
        boolean scoreOk = (donnerKmParcourus() + borne.getkm()) <= 1000;
        
        return pasBloque && respectLimite && scoreOk;
    }
	

	private boolean estDepotLimiteAutorise(Limite limite) {

		if (estPrioritaire()) { 
			return false; 
		}
			
        if (limite instanceof DebutLimite) {
            return pileDeLimite.isEmpty() || pileDeLimite.get(pileDeLimite.size() - 1) instanceof FinLimite;
            
        } else if (limite instanceof FinLimite) {
        	return !pileDeLimite.isEmpty() && pileDeLimite.get(pileDeLimite.size() - 1) instanceof DebutLimite;
        }
        
        return false;
    }
	

	private boolean estDepotBatailleAutorise(Bataille bataille) {

		if (possedeBotte(bataille.getType())) { 
			return false;
		}
				
        if (bataille instanceof Attaque) {
            return peutAvancer(); 
            
        } else if (bataille instanceof Parade parade) {
            if (parade.equals(Cartes.FEU_VERT)) {
                return estDepotFeuVertAutorise();
            }

            if (pileBataille.isEmpty()) {
            	return false;
            }
            
            Carte sommet = pileBataille.get(pileBataille.size() - 1);
            
            return (sommet instanceof Attaque && ((Attaque) sommet).getType().equals(parade.getType()));
        }
        return false;
    }

    

    public boolean estDepotAutorise(Carte carte) {
    	if (carte instanceof Botte) {
    		return true; 
    	}	
        if (carte instanceof Borne borne) {
        	return estDepotBorneAutorise(borne);
        }    
        if (carte instanceof Limite limite) {
        	return estDepotLimiteAutorise(limite);
        }
        
        if (carte instanceof Bataille bataille) {
        	return estDepotBatailleAutorise(bataille);
        }
        
        return false;
    }
    
}
	
	