package testsFonctionnels;

import cartes.Attaque;
import cartes.Borne;
import cartes.Botte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Parade;
import cartes.Type;
import jeu.Cartes;
import jeu.ZoneDeJeu;


	

	public class TestZoneDeJeu {
		public static void main(String[] args) {
			ZoneDeJeu zoneDeJeu = new ZoneDeJeu();
			System.out.println("Deposer carte 25 km");
			zoneDeJeu.deposerCarte(new Borne(25));
			System.out.println("Deposer carte 50 km");
			zoneDeJeu.deposerCarte(new Borne(50));
			System.out.println("Deposer carte 75 km");
			zoneDeJeu.deposerCarte(new Borne(75));
			System.out.println("Total des bornes : " + zoneDeJeu.donnerKmParcourus());
	
			System.out.println("Limite : " + zoneDeJeu.donnerLimitationVitesse());
			zoneDeJeu.deposerCarte(new DebutLimite());
			System.out.println("Limite : " + zoneDeJeu.donnerLimitationVitesse());
			zoneDeJeu.deposerCarte(new FinLimite());
			System.out.println("Limite : " + zoneDeJeu.donnerLimitationVitesse());

			boolean depotOK = false;
			ZoneDeJeu zoneDeJeu1 = new ZoneDeJeu();

			System.out.println("Deposer carte Feu rouge");
			depotOK = zoneDeJeu1.estDepotAutorise(Cartes.FEU_ROUGE);
			System.out.println("d�p�t ok ? " + depotOK);
			if (depotOK) {
				zoneDeJeu1.deposerCarte(Cartes.FEU_ROUGE);
			}
			System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());

			System.out.println("Deposer carte attaque - accident");
			depotOK = zoneDeJeu.estDepotAutorise(new Attaque(Type.ACCIDENT));
			System.out.println("d�p�t ok ? " + depotOK);
			if (depotOK) {
				zoneDeJeu.deposerCarte(new Attaque(Type.ACCIDENT));
			}
			System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());

			System.out.println("Deposer carte Feu vert");
			depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_VERT);
			System.out.println("d�p�t ok ? " + depotOK);
			if (depotOK) {
				zoneDeJeu.deposerCarte(Cartes.FEU_VERT);
			}
			System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
			// panne d'essence
			System.out.println("Deposer carte attaque - essence");
			depotOK = zoneDeJeu.estDepotAutorise(new Attaque(Type.ESSENCE));
			System.out.println("d�p�t ok ? " + depotOK);
			if (depotOK) {
				zoneDeJeu.deposerCarte(new Attaque(Type.ESSENCE));
			}
			System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());

			System.out.println("Deposer carte parade - roue de secours");
			depotOK = zoneDeJeu.estDepotAutorise(new Parade(Type.CREVAISON));
			if (depotOK) {
				zoneDeJeu.deposerCarte(new Parade(Type.CREVAISON));
			}
			System.out.println("d�p�t ok ? " + depotOK);
			System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());

			System.out.println("Deposer carte parade - essence");
			depotOK = zoneDeJeu.estDepotAutorise(new Parade(Type.ESSENCE));
			if (depotOK) {
				zoneDeJeu.deposerCarte(new Parade(Type.ESSENCE));
			}
			System.out.println("d�p�t ok ? " + depotOK);
			System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());

			System.out.println("Deposer carte Feu vert");
			depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_VERT);
			System.out.println("d�p�t ok ? " + depotOK);
			if (depotOK) {
				zoneDeJeu.deposerCarte(Cartes.FEU_VERT);
			}
			System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());

			System.out.println("Deposer carte borne - 100");
			depotOK = zoneDeJeu.estDepotAutorise(new Borne(100));
			System.out.println("d�p�t ok ? " + depotOK);
			if (depotOK) {
				zoneDeJeu.deposerCarte(new Borne(100));
			}
			System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());

			System.out.println("Deposer carte limite - 50");
			depotOK = zoneDeJeu.estDepotAutorise(new DebutLimite());
			System.out.println("d�p�t ok ? " + depotOK);
			if (depotOK) {
				zoneDeJeu.deposerCarte(new DebutLimite());
			}
			System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
			// D�pot 100 bornes
			System.out.println("Deposer carte borne - 100");
			depotOK = zoneDeJeu.estDepotAutorise(new Borne(100));
			System.out.println("d�p�t ok ? " + depotOK);
			if (depotOK) {
				zoneDeJeu.deposerCarte(new Borne(100));
			}
			System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
			// Depot 25 bornes
			System.out.println("Deposer carte borne - 25");
			depotOK = zoneDeJeu.estDepotAutorise(new Borne(25));
			System.out.println("d�p�t ok ? " + depotOK);
			if (depotOK) {
				zoneDeJeu.deposerCarte(new Borne(25));
			}
			System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
			// D�pot fin limitation
			System.out.println("Deposer carte fin limite - 50");
			depotOK = zoneDeJeu.estDepotAutorise(new FinLimite());
			System.out.println("d�p�t ok ? " + depotOK);
			if (depotOK) {
				zoneDeJeu.deposerCarte(new FinLimite());
			}
			System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
			// D�pot 100 bornes
			System.out.println("Deposer carte borne - 100");
			depotOK = zoneDeJeu.estDepotAutorise(new Borne(100));
			System.out.println("d�p�t ok ? " + depotOK);
			if (depotOK) {
				zoneDeJeu.deposerCarte(new Borne(100));
			}
			System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());

	// RESULTAT ATTENDU POUR LA PARTIE 3 (ne pas d�commenter)
//	 			Deposer carte Feu rouge
//				d�p�t ok ? false
//				peut avancer ? false
//				Deposer carte attaque - accident
//				d�p�t ok ? false
//				peut avancer ? false
//				Deposer carte Feu vert
//				d�p�t ok ? true
//				peut avancer ? true
//				Deposer carte attaque - essence
//				d�p�t ok ? true
//				peut avancer ? false
//				Deposer carte parade - roue de secours
//				d�p�t ok ? false
//				peut avancer ? false
//				Deposer carte parade - essence
//				d�p�t ok ? true
//				peut avancer ? false
//				Deposer carte Feu vert
//				d�p�t ok ? true
//				peut avancer ? true
//				Deposer carte borne - 100
//				d�p�t ok ? true
//				peut avancer ? true
//				Deposer carte limite - 50
//				d�p�t ok ? true
//				peut avancer ? true
//				Deposer carte borne - 100
//				d�p�t ok ? false
//				peut avancer ? true
//				Deposer carte borne - 25
//				d�p�t ok ? true
//				peut avancer ? true
//				Deposer carte fin limite - 50
//				d�p�t ok ? true
//				peut avancer ? true
//				Deposer carte borne - 100
//				d�p�t ok ? true
//				peut avancer ? true

			
//			// TP4 Partie 1
			zoneDeJeu = new ZoneDeJeu();
			
			System.out.println("\n");
			System.out.println("TP4 partie 1");
			boolean depotOKK = false;
			// Feu rouge
			System.out.println("Deposer carte Feu rouge");
			depotOKK = zoneDeJeu.estDepotAutorise(Cartes.FEU_ROUGE);
			System.out.println("d�p�t ok ? " + depotOKK);
			if (depotOKK) {
				zoneDeJeu.deposerCarte(Cartes.FEU_ROUGE);
			}
			System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
			// Botte Vehicule prioritaire
			System.out.println("Deposer carte Vehicule prioritaire");
			depotOKK = zoneDeJeu.estDepotAutorise(Cartes.PRIORITAIRE);
			System.out.println("d�p�t ok ? " + depotOKK);
			if (depotOKK) {
				zoneDeJeu.deposerCarte(Cartes.PRIORITAIRE);
			}
			System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
			// accident
			System.out.println("Deposer carte attaque - accident");
			depotOKK = zoneDeJeu.estDepotAutorise(new Attaque(Type.ACCIDENT));
			System.out.println("d�p�t ok ? " + depotOKK);
			if (depotOKK) {
				zoneDeJeu.deposerCarte(new Attaque(Type.ACCIDENT));
			}
			System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		

			System.out.println("Deposer botte - roue de secours");
			depotOKK = zoneDeJeu.estDepotAutorise(new Botte(Type.CREVAISON));
			if (depotOKK) {
				zoneDeJeu.deposerCarte(new Botte(Type.CREVAISON));
			}
			System.out.println("d�p�t ok ? " + depotOKK);
			System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
			// botte as du volant
			System.out.println("Deposer carte as du volant");
			depotOKK = zoneDeJeu.estDepotAutorise(new Botte(Type.ACCIDENT));
			if (depotOKK) {
				zoneDeJeu.deposerCarte(new Botte(Type.ACCIDENT));
			}
			System.out.println("d�p�t ok ? " + depotOKK);
			System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
			// Feu vert
			System.out.println("Deposer carte Feu vert");
			depotOKK = zoneDeJeu.estDepotAutorise(Cartes.FEU_VERT);
			System.out.println("d�p�t ok ? " + depotOKK);
			if (depotOKK) {
				zoneDeJeu.deposerCarte(Cartes.FEU_VERT);
			}
			System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
			// D�pot attaque accident
			System.out.println("Deposer carte accident");
			depotOKK = zoneDeJeu.estDepotAutorise(new Attaque(Type.ACCIDENT));
			System.out.println("d�p�t ok ? " + depotOKK);
			if (depotOKK) {
				zoneDeJeu.deposerCarte(new Attaque(Type.ACCIDENT));
			}
			System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
			// D�pot limitation de vitesse 50 bornes
			System.out.println("Deposer carte limite - 50");
			depotOKK = zoneDeJeu.estDepotAutorise(new DebutLimite());
			System.out.println("d�p�t ok ? " + depotOKK);
			if (depotOKK) {
				zoneDeJeu.deposerCarte(new DebutLimite());
			}
			System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
			

		}
	}