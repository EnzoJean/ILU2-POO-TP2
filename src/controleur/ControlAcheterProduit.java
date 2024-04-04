package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlAcheterProduit(ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public int acheterProduit(String nomVendeur, int quantite) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		if (etal == null)
			return -1;
		return etal.acheterProduit(quantite);
	}
	
	public String[] listeVendeurs(String produit) {
		Gaulois[] tabVendeurs = village.rechercherVendeursProduit(produit);
		int tailleTab = tabVendeurs.length;
		String[] nomVendeurs = new String[tailleTab];
		for(int i= 0; i<tailleTab; ++i) {
			nomVendeurs[i] = tabVendeurs[i].getNom();
		}
		return nomVendeurs;
	}
	
	public int qteDisponible(String nomVendeur) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		if (etal == null)
			return -1;
		return etal.getQuantite();
	}



}

	