package jeu;

import java.util.Objects;

public class Joueur {
    private String nom;
    private ZoneDeJeu zoneDeJeu;

    public Joueur(String nom) {
        this.nom = nom;
        this.zoneDeJeu = new ZoneDeJeu();
    }

    public String getNom() {
        return nom;
    }

    public ZoneDeJeu getZoneDeJeu() {
        return zoneDeJeu;
    }
    

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Joueur joueur) {
            return nom.equals(joueur.getNom());
        }
        return false;
    }

    @Override
    public String toString() {
        return nom;
    }
}
