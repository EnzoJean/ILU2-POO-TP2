package controleur;

import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public int acheterProduit(String nomVendeur, int quantite) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).acheterProduit(quantite);
	}
	
	public String[] listeVendeurs(String produit) {
		return village.donnerEtatMarche();
	}
	
	public int qteDisponible(String nomVendeur, int quantite) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).getQuantite();
	}



}

	