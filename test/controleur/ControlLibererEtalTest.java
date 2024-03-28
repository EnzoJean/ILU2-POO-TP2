package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
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
	void testControlLibererEtal() {
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertNotNull(controlLibererEtal, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testIsVendeur() {
		Gaulois bonemine = new Gaulois("Bonemine", 10);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "fleurs", 10);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertFalse(controlLibererEtal.isVendeur("Abraracourcix"));
		assertTrue(controlLibererEtal.isVendeur("Bonemine"));
	}

	@Test
	void testLibererEtal() {
		Gaulois bonemine = new Gaulois("Bonemine", 10);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "fleurs", 10);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		String[] test = controlLibererEtal.libererEtal("Bonemine");
		assertTrue(test[0].equals("true") && test[1].equals("Bonemine") && test[2].equals("fleurs")  && 
				   test[3].equals("10") && test[4].equals("0"));
	}
	
}
