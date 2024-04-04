package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private Chef abraracourcix;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}
	
	@Test
	void testControlAcheterProduit() {
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlTrouverEtalVendeur, village);
		assertNotNull(controlAcheterProduit);
	}

	@Test
	void testAcheterProduitPile() {
		Gaulois bonemine = new Gaulois("Bonemine", 10);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "fleurs", 10);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlTrouverEtalVendeur, village);
		assertTrue(controlAcheterProduit.acheterProduit("Bonemine", 10) == 10);
	}
	
	@Test
	void testAcheterProduitMoins() {
		Gaulois bonemine = new Gaulois("Bonemine", 10);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "fleurs", 10);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlTrouverEtalVendeur, village);
		assertTrue(controlAcheterProduit.acheterProduit("Bonemine", 5) == 5);
	}
	
	@Test
	void testAcheterProduitPlus() {
		Gaulois bonemine = new Gaulois("Bonemine", 10);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "fleurs", 10);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlTrouverEtalVendeur, village);
		assertTrue(controlAcheterProduit.acheterProduit("Bonemine", 100) == 10);
	}
	
	@Test
	void testAcheterProduit() {
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlTrouverEtalVendeur, village);
		assertTrue(controlAcheterProduit.acheterProduit("null", 100) == -1);
	}
	
	@Test
	void testListeVendeurs() {
		Gaulois bonemine = new Gaulois("Bonemine", 10);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "fleurs", 10);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlTrouverEtalVendeur, village);
		assertTrue(controlAcheterProduit.listeVendeurs("fleurs")[0].equals("Bonemine"));
	}
	
	@Test
	void testQteDisponible10() {
		Gaulois bonemine = new Gaulois("Bonemine", 10);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "fleurs", 10);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlTrouverEtalVendeur, village);
		assertTrue(controlAcheterProduit.qteDisponible("Bonemine") == 10);
		controlAcheterProduit.acheterProduit("Bonemine", 10);
		assertTrue(controlAcheterProduit.qteDisponible("Bonemine") == 0);
	}
	
	@Test
	void testQteDisponiblenull() {
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlTrouverEtalVendeur, village);
		assertTrue(controlAcheterProduit.qteDisponible("null") == -1);
	}
}
