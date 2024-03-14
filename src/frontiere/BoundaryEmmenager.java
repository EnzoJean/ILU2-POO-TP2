package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous �tes d�j� un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("�tes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					System.out.println(
							"Bienvenue villageois "+ nomVisiteur);
					int forceVillageois = Clavier.entrerEntier("Quelle est votre force ?");
					controlEmmenager.ajouterGaulois(nomVisiteur, forceVillageois);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println(
				"Bienvenue druide "+ nomVisiteur);
		int forceDruide = Clavier.entrerEntier("Quelle est votre force ?");
		int effetPotionMin, effetPotionMax;
		do {
			effetPotionMin = Clavier.entrerEntier("Quelle est la force de potion la plus faible que vous produisiez ?");
			effetPotionMax = Clavier.entrerEntier("Quelle est la force de potion la plus forte que vous produisiez ?");
			if (effetPotionMax < effetPotionMin) {
				System.out.println(
						"Attention Druide, vous vous �tes tromp� entre le minimum et le maximum");
			}
		} while (effetPotionMax < effetPotionMin);
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
	}
}
