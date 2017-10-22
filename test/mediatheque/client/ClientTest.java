package mediatheque.client;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import mediatheque.OperationImpossible;

public class ClientTest {
	
	CategorieClient cc = null;
	Client c = null;

	@Before
	public void setup() throws OperationImpossible {
		cc = new CategorieClient("Categorie", 0, 0, 0, 0, false);
		c = new Client("Nom", "Prenom", "Adresse", cc);
		c.getCategorie().modifierMax(5);
	}

	@Test
	public void nomConstructeurTest() {
		Client client = new Client("Nom", "Prenom");
		assertTrue(client.getNom().equals("Nom"));
		assertTrue(client.getPrenom().equals("Prenom"));
	}

	@Test
	public void constructeurTest() throws OperationImpossible {
		Client client = new Client("Nom", "Prenom", "Adresse", cc);
		assertTrue(client.getNom().equals("Nom"));
		assertTrue(client.getPrenom().equals("Prenom"));
		assertTrue(client.getAdresse().equals("Adresse"));
		assertEquals(cc,client.getCategorie());
	}

	@Test(expected = OperationImpossible.class)
	public void constructeurTestFail() throws OperationImpossible {
		cc.modifierCodeReducActif(true);
		Client client = new Client("Nom", "Prenom", "Adresse", cc);
	}

	@Test
	public void codeConstructeurTest() throws OperationImpossible {
		cc.modifierCodeReducActif(true);
		Client client = new Client("Nom", "Prenom", "Adresse", cc, 0);
		assertTrue(client.getNom().equals("Nom"));
		assertTrue(client.getPrenom().equals("Prenom"));
		assertTrue(client.getAdresse().equals("Adresse"));
		assertEquals(cc,client.getCategorie());
		assertEquals(0,client.getReduc());
	}

	@Test(expected = OperationImpossible.class)
	public void codeConstructeurFail() throws OperationImpossible {
		Client client = new Client("Nom", "Prenom", "Adresse", cc, 0);
	}

	@Test
	public void initAttrTest(){ // --> private not be tested
		
	}

	@Test
	public void pasEmpruntsEnCours() {
		assertEquals(false, c.aDesEmpruntsEnCours());	
	}

	@Test
	public void empruntsEnCours() throws OperationImpossible {
		assertEquals(false,c.aDesEmpruntsEnCours());
		c.emprunter();
		assertTrue(c.aDesEmpruntsEnCours());
	}

	@Test
	public void peutEmprunter() throws OperationImpossible {
		c.getCategorie().modifierMax(10);
		assertTrue(c.peutEmprunter());

	}

	@Test
	public void nePeutEmprunter1() throws OperationImpossible { //a atteint son max
		c.getCategorie().modifierMax(1);
		c.emprunter();
		assertEquals(false,c.peutEmprunter());
	}
	
	@Test
	public void nePeutEmprunter2() throws OperationImpossible { //retard 
		c.getCategorie().modifierMax(1);
		c.emprunter();
		assertEquals(c.getNbEmpruntsEnRetard(),c.getNbEmpruntsEnCours());
		assertEquals(false,c.peutEmprunter());
	}

	@Test
	public void emprunter() throws OperationImpossible {
		int empruntsEffectues = c.getNbEmpruntsEffectues();
		int empruntsEnCours = c.getNbEmpruntsEnCours();
		c.getCategorie().modifierMax(10);
		c.emprunter();
		assertEquals(empruntsEffectues + 1, c.getNbEmpruntsEffectues());
		assertEquals(empruntsEnCours + 1, c.getNbEmpruntsEnCours());
	}

	// @Test
	// public void emprunterFiche() throws OperationImpossible, InvariantBroken{
	// int empruntsEffectues = c.getNbEmpruntsEffectues();
	// int empruntsEnCours = c.getNbEmpruntsEnCours();
	// c.getCategorie().modifierMax(10);
	// Mediatheque m = new Mediatheque("mediatheque");
	// Localisation l = new Localisation("A", "05");
	// Genre g = new Genre("genre");
	// Audio a = new Audio("code", l, "audio_doc", "auteur", "2017", g,
	// "classification");
	// FicheEmprunt fiche = new FicheEmprunt(m, c, a);
	// c.emprunter(fiche);
	// assertTrue(c.getNbEmpruntsEffectues() == empruntsEffectues + 1);
	// assertTrue(c.getNbEmpruntsEnCours() == empruntsEnCours + 1);
	// }

	@Test
	public void marquer() throws OperationImpossible { //we changed to return value of getNbEmpruntsEnRetard
		c.getCategorie().modifierMax(10);
		int nbRetard = c.getNbEmpruntsEnRetard(); 
		c.emprunter();
		c.marquer();
		assertEquals(nbRetard+1,c.getNbEmpruntsEnRetard());
	}

	@Test(expected = OperationImpossible.class)
	public void marquerFail() throws OperationImpossible {
		c.getCategorie().modifierMax(10);
		c.marquer();
	}

	// @Test
	// public void restituerFiche(){
	// CategorieClient cc = new CategorieClient("marcucci");
	// Client c = new Client("marcucci", "romain", "paris", cc);
	// int empruntsEffectues = c.getNbEmpruntsEffectues();
	// c.getCategorie().modifierMax(10);
	// Mediatheque m = new Mediatheque("mediatheque");
	// Localisation l = new Localisation("A", "05");
	// Genre g = new Genre("genre");
	// Audio a = new Audio("code", l, "audio_doc", "auteur", "2017", g,
	// "classification");
	// FicheEmprunt fiche = new FicheEmprunt(m, c, a);
	// c.emprunter(fiche);
	// c.restituer(fiche);
	// assertTrue(c.getNbEmpruntsEnCours() == empruntsEnCours - 1);
	// }
	//
	// @Test(expected = OperationImpossible)
	// public void restituerFicheFail(){
	// CategorieClient cc = new CategorieClient("marcucci");
	// Client c = new Client("marcucci", "romain", "paris", cc);
	// int empruntsEffectues = c.getNbEmpruntsEffectues();
	// c.getCategorie().modifierMax(10);
	// Mediatheque m = new Mediatheque("mediatheque");
	// Localisation l = new Localisation("A", "05");
	// Genre g = new Genre("genre");
	// Audio a = new Audio("code", l, "audio_doc", "auteur", "2017", g,
	// "classification");
	// FicheEmprunt fiche = new FicheEmprunt(m, c, a);
	// c.emprunter(fiche);
	// Mediatheque m1 = new Mediatheque("error");
	// FicheEmprunt fiche = new FicheEmprunt(m1, c, a);
	// c.restituer(fiche);
	// assertTrue(c.getNbEmpruntsEnCours() == empruntsEnCours - 1);
	// }

	@Test
	public void restituerBool() throws OperationImpossible {
		c.getCategorie().modifierMax(10);
		c.emprunter();
		c.restituer(false);
		assertEquals(0,c.getNbEmpruntsEnCours());
	}

	// @Test
	// public void restituerBoolRetard() throws OperationImpossible{
	// CategorieClient cc = new CategorieClient("marcucci");
	// Client c = new Client("marcucci", "romain", "paris", cc);
	// c.getCategorie().modifierMax(10);
	// c.emprunter();
	// c.restituer(true);
	// assertTrue(c.getNbEmpruntsEnCours() == 0);
	// assertTrue(c.getNbEmpruntsEnRetard() == 0);
	// }

	@Test(expected = OperationImpossible.class)
	public void restituerBoolFail() throws OperationImpossible {
		c.restituer(false);
	}

	@Test(expected = OperationImpossible.class)
	public void restituerBoolRetardFail() throws OperationImpossible {
		c.getCategorie().modifierMax(10);
		c.emprunter();
		c.restituer(true);
	}

	@Test
	public void metAJourEmprunts() {
		// TODO
	}

	@Test
	public void dateRetour() throws OperationImpossible {
		assertEquals(addDays(new Date(), 20), c.dateRetour(new Date(), 10));
	}

	public static Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days); // minus number would decrement the days
		return cal.getTime();
	}

	@Test
	public void sommeDue() throws OperationImpossible {
		assertEquals(10 * cc.getCoefTarif(),c.sommeDue(10),0.001);
	}
	
}
