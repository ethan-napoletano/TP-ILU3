package utils;

import java.util.*;

public class GestionCartes {
	
    private static final Random rand = new Random();
    
    private GestionCartes() {
    	throw new IllegalStateException("Utility class");
    }


    public static <T> T extraire(List<T> liste) {
        int indice = rand.nextInt(liste.size());
        return liste.remove(indice);
    }


    public static <T> T extraireIterateur(List<T> liste) {
        int indice = rand.nextInt(liste.size());

        ListIterator<T> it = liste.listIterator(indice);
        T element = it.next();
        it.remove();

        return element;
    }


    
    

    public static <T> List<T> melanger(List<T> liste) {
        List<T> resultat = new ArrayList<>();

        while (!liste.isEmpty()){
            resultat.add(extraire(liste));
        }
        return resultat;
    }

    
    

    public static <T> boolean verifierMelange(List<T> l1, List<T> l2) {
        if (l1.size() != l2.size()) return false;

        for (T e : l1) {

            if (Collections.frequency(l1, e)
                    != Collections.frequency(l2, e)) {
                return false;
            }
        }
        return true;
    }

    
    

    public static <T> List<T> rassembler(List<T> liste) {
        List<T> resultat = new ArrayList<>();

        while (!liste.isEmpty()) {
            T element = liste.remove(0);
            resultat.add(element);

            Iterator<T> it = liste.iterator();

            while (it.hasNext()) {
                T e = it.next();
                if (e.equals(element)) {
                    resultat.add(e);
                    it.remove();
                }
            }
        }
        return resultat;
    }

    
    
    public static <T> boolean verifierRassemblement(List<T> liste) {
        if (liste.isEmpty()) return true;

        ListIterator<T> it1 = liste.listIterator();
        T precedent = it1.next();

        while (it1.hasNext()) {
            T courant = it1.next();

            if (!courant.equals(precedent)) {
                if (!pasDupli(liste, it1.nextIndex(), precedent)) {
                    return false;
                }
            }

            precedent = courant;
        }

        return true;
    }


    private static <T> boolean pasDupli(List<T> liste, int startIndex, T valeur) {
        ListIterator<T> it = liste.listIterator(startIndex);

        while (it.hasNext()) {
            if (it.next().equals(valeur)) {
                return false; 
            }
        }

        return true; 
    }

}