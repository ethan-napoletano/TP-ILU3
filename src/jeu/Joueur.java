package jeu;


import java.util.Objects;

import cartes.Carte;

public class Joueur {
    private final String nom;
    private final ZoneDeJeu zoneDeJeu;
    private final MainJoueur main;

    public Joueur(String nom) {
        this.nom = nom;
        this.zoneDeJeu = new ZoneDeJeu();
        this.main = new MainJoueur();
    }

    public String getNom() {
        return nom;
    }

    public ZoneDeJeu getZoneDeJeu() {
        return zoneDeJeu;
    }

    public MainJoueur getMain() {
        return main;
    }

    public void donner(Carte carte) {
        main.prendre(carte);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Joueur joueur)) return false;
        return Objects.equals(nom, joueur.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    @Override
    public String toString() {
        return nom;
    }
    
    public Carte prendreCarte(Sabot sabot) {
        Carte carte = sabot.piocher();

        if (carte != null) {
            donner(carte);
        }

        return carte;
    }
}