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

	public String[] listeVendeurs(String produit) {
		String[] infosEtals = village.donnerEtatMarche();
		String[] vendeurs = null;
		int taille = 0;
		for (int i = 0; i<infosEtals.length; ++i) {
			if (infosEtals[i].equals(produit)) {
				vendeurs[taille] = infosEtals[i-1];
				taille++;
			}
		}
		return vendeurs;
	}
}
