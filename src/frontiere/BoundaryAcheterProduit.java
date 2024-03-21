package frontiere;


import controleur.ControlAcheterProduit;


public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;
	

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterQte(String nomVendeur, String nomAcheteur, String produit) {
		System.out.println(
				nomAcheteur+ " se déplace jusqu'é l'étal du vendeur "+nomVendeur);
		int quantite = Clavier.entrerEntier("Combien de "+ produit + " voulez-vous acheter ?");
		int quantiteDisponible = controlAcheterProduit.qteDisponible(nomVendeur, quantite);
		if(quantiteDisponible == 0) {
			System.out.println(
					nomAcheteur+" veut acheter "+quantite+" "+ produit
					+", malheureusement il n'y en a plus !");
		}
		else if (quantiteDisponible!=0 && quantiteDisponible<quantite) {
			System.out.println(
					nomAcheteur+" veut acheter "+quantite+" "+produit+
					", malheureusement "+nomVendeur+ " n'en a plus que "+quantiteDisponible
					+". "+nomAcheteur+ " achéte tout le stock de "+nomVendeur);
			controlAcheterProduit.acheterProduit(nomVendeur, quantiteDisponible);
		}
		else {
			System.out.println(
					nomAcheteur+" achéte "+quantite+" "+produit+" é "+ nomVendeur);
			controlAcheterProduit.acheterProduit(nomVendeur, quantite);
		}
		
	}
	
	
	public void acheterProduit(String nomAcheteur) {
		String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
		String [] vendeurs = controlAcheterProduit.listeVendeurs(produit);
		int tailleTabVendeurs = vendeurs.length;
		boolean produitExistant = false;
		if (tailleTabVendeurs != 0)
			produitExistant = true;
		if(!produitExistant) {
			System.out.println(
					"Désolé, personne ne vend ce produit au marché.");
		}
		else {
			int choixUtilisateur;
			do {
				StringBuilder qui = new StringBuilder();
				qui.append("De quel commerçant voulez-vous acheter des "+produit+" ?\n");
				for (int i =0; i<tailleTabVendeurs; ++i) {
					qui.append(i+1 + " - " + vendeurs[i]+"\n");
				}
				choixUtilisateur = Clavier.entrerEntier(qui.toString());
				if (choixUtilisateur>0 && choixUtilisateur<=tailleTabVendeurs) {
					acheterQte(vendeurs[(choixUtilisateur-1)*3], nomAcheteur, produit);
				}
				else 
					System.out.println(
							"Vous devez entrer un chiffre entre 1 et "+tailleTabVendeurs);
			} while (choixUtilisateur<1 || choixUtilisateur>tailleTabVendeurs);
		}
	}
}
