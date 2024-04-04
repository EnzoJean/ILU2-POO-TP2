package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class VillageTest {
	private Village village;
	private Chef abraracourcix;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}
	
	@Test
	void testPartirVendeur() {
		Gaulois bonemine = new Gaulois("Bonemine", 10);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "fleurs", 10);
		Etal etal = village.rechercherEtal(bonemine);
		village.partirVendeur(bonemine);
		assertFalse(etal.isEtalOccupe());
	}
	
	@Test
	void testDonnerVillageois() {
		Gaulois bonemine = new Gaulois("Bonemine", 10);
		village.ajouterHabitant(bonemine);
		Gaulois a = new Druide("a", 10, 3, 8);
		village.ajouterHabitant(a);
		String[] tab = village.donnerVillageois();
		assertTrue(tab[0].equals("Abraracourcix") && tab[1].equals("Bonemine") && tab[2].equals("le druide a"));	
	}
	
	@Test
	void testEtalgetProduit() {
		Gaulois bonemine = new Gaulois("Bonemine", 10);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "fleurs", 10);
		assertTrue(village.rechercherEtal(bonemine).getProduit() == "fleurs");
	}
	
	@Test
	void testEtalAcheterProduit() {
		Gaulois bonemine = new Gaulois("Bonemine", 10);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "fleurs", 10);
		village.rechercherEtal(bonemine).acheterProduit(10);
		assertTrue(village.rechercherEtal(bonemine).acheterProduit(10) == 0);
	}
	
	@Test
	void testMarcheDonnerEtat() {
		Gaulois bonemine = new Gaulois("Bonemine", 10);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "fleurs", 10);
		Gaulois a = new Gaulois("a", 10);
		village.ajouterHabitant(a);
		village.installerVendeur(a, "bonbons", 7);
		String[] tabAttendu = {"Bonemine", "10", "fleurs", "a", "7", "bonbons"};
		String[] tabRecu = village.donnerEtatMarche();
		for (int i=0; i<6; ++i) {
			System.out.println(tabRecu[i] + "  " +  tabAttendu[i]);
			assertTrue(tabRecu[i].equals(tabAttendu[i]));
		}
		
	}
	
}
