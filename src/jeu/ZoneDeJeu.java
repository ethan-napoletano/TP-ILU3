package jeu;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;
import cartes.Botte;

public class ZoneDeJeu {

    private LinkedList<Carte> pileDeLimite;
    private LinkedList<Carte> pileBataille;
    private LinkedList<Carte> Borne;
    private Set<Botte> bottes;

    public ZoneDeJeu() {
        pileDeLimite = new LinkedList<>();
        pileBataille = new LinkedList<>();
        Borne = new LinkedList<>();
        bottes = new HashSet<>();
    }

    public int donnerLimitationVitesse() {
        if (pileDeLimite.isEmpty() || pileDeLimite.getLast() instanceof FinLimite) {
            return 200;
        }
        return 50;
    }


    public int donnerKmParcourus() {
        int total = 0;
        for (Carte carte : Borne) {
            if (carte instanceof Borne borne) {
                total += borne.getkm();
            }
        }
        return total;
    }


    public void deposer(Carte carte) {
        if (carte instanceof Borne) {
            Borne.addLast(carte);
        } else if (carte instanceof Limite) {
            pileDeLimite.addLast(carte);
        } else if (carte instanceof Bataille) {
            pileBataille.addLast(carte);
        }
    }

    public boolean peutAvancer() {
        if (pileBataille.isEmpty()) {
            return false;
        }
        Carte sommet = pileBataille.getLast();
        return sommet.equals(Cartes.FEU_VERT);
    }


    private boolean estDepotFeuVertAutorise() {
        if (pileBataille.isEmpty()) {
            return true;
        }
        Carte sommet = pileBataille.getLast();
        return sommet.equals(Cartes.FEU_ROUGE) || (sommet instanceof Parade && !sommet.equals(Cartes.FEU_VERT));
    }

    private boolean estDepotBorneAutorise(Borne borne) {
        boolean pasBloque = peutAvancer();
        boolean respectLimite = borne.getkm() <= donnerLimitationVitesse();
        boolean scoreOk = (donnerKmParcourus() + borne.getkm()) <= 1000;
        return pasBloque && respectLimite && scoreOk;
    }

    private boolean estDepotLimiteAutorise(Limite limite) {
        if (limite instanceof DebutLimite) {
            return pileDeLimite.isEmpty() || pileDeLimite.getLast() instanceof FinLimite;
        } else if (limite instanceof FinLimite) {
            return !pileDeLimite.isEmpty() && pileDeLimite.getLast() instanceof DebutLimite;
        }
        return false;
    }


    private boolean estDepotBatailleAutorise(Bataille bataille) {
        if (bataille instanceof Attaque) {
            return peutAvancer();
        } else if (bataille instanceof Parade parade) {
            if (parade.equals(Cartes.FEU_VERT)) {
                return estDepotFeuVertAutorise();
            }
            if (pileBataille.isEmpty()) {
                return false;
            }
            Carte sommet = pileBataille.getLast();
            return sommet instanceof Attaque && ((Attaque) sommet).getType().equals(parade.getType());
        }
        return false;
    }


    public boolean estDepotAutorise(Carte carte) {
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
    
    public Set<Botte> getBottes() {
        return bottes;
    }
    public void deposerBotte(Botte botte) {
        bottes.add(botte);
    }

    public boolean possedeBotte(Botte botte) {
        return bottes.contains(botte);
    }
    
    
}