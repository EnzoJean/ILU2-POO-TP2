package frontiere;


import controleur.ControlAcheterProduit;


public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;
	

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterQte(String nomVendeur, String nomAcheteur, String produit) {
		System.out.println(
				nomAcheteur+ " se déplace jusqu'à l'étal du vendeur "+nomVendeur);
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
					+". "+nomAcheteur+ " achète tout le stock de "+nomVendeur);
			controlAcheterProduit.acheterProduit(nomVendeur, quantiteDisponible);
		}
		else {
			System.out.println(
					nomAcheteur+" achète "+quantite+" "+produit+" à "+ nomVendeur);
			controlAcheterProduit.acheterProduit(nomVendeur, quantite);
		}
		
	}
	
	
	public void acheterProduit(String nomAcheteur) {
		String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
		String [] vendeurs = controlAcheterProduit.listeVendeurs(produit);
		boolean produitExistant = false;
		for(int i = 0; i<vendeurs.length && produitExistant == false; ++i ) {
			if (vendeurs[i].equals(produit)) {
				produitExistant = true;
			}
		}
		if(!produitExistant) {
			System.out.println(
					"Désolé, personne ne vend ce produit au marché.");
		}
		else {
			int choixUtilisateur;
			do {
				System.out.println("De quel commerçant voulez-vous acheter des "+produit+" ?");
				StringBuilder question = new StringBuilder();
				int indicepar3 = 0;
				for (int i =0; i<vendeurs.length; i*=3) {
					indicepar3 = i/3+1;
					question.append(indicepar3 + " - " + vendeurs[i]+"\n");
				}
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				if (choixUtilisateur>0 && choixUtilisateur<=vendeurs.length/3) {
					acheterQte(vendeurs[(choixUtilisateur-1)*3], nomAcheteur, produit);
				}
				else 
					System.out.println(
							"Vous devez entrer un chiffre entre 1 et "+vendeurs.length/3);
			} while (choixUtilisateur<1 || choixUtilisateur>vendeurs.length/3);
		}
	}
}
