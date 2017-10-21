package mediatheque.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import mediatheque.OperationImpossible;

public class ClientTest {

	CategorieClient cc = null;
	Client c = null;

	@Before
	public void setup() throws OperationImpossible {
		//nom, max, cot, coefduree, coefftarif
		cc = new CategorieClient("Subscriber", 1, 1, 3, 10, false);
		c = new Client("marcucci", "romain", "paris", cc);
		c.getCategorie().modifierMax(0);
	}

	@Test
	public void nameConstructor() {
		Client client = new Client("marcucci", "romain");
		assertTrue(client.getNom().equals("marcucci"));
		assertTrue(client.getPrenom().equals("romain"));
	}

	@Test
	public void catConstructor() throws OperationImpossible {
		CategorieClient clientCat = new CategorieClient("marcucci");
		Client client = new Client("marcucci", "romain", "paris", clientCat);
		assertTrue(client.getNom().equals("marcucci"));
		assertTrue(client.getPrenom().equals("romain"));
		assertTrue(client.getAdresse().equals("paris"));
		assertTrue(client.getCategorie() == clientCat);
	}

	@Test(expected = OperationImpossible.class)
	public void catConstructorFail() throws OperationImpossible {
		CategorieClient clientCat = new CategorieClient("marcucci");
		clientCat.modifierCodeReducActif(true);
		Client client = new Client("marcucci", "romain", "paris", clientCat);
	}

	@Test
	public void codeConstructor() throws OperationImpossible {
		CategorieClient clientCat = new CategorieClient("marcucci");
		clientCat.modifierCodeReducActif(true);
		Client client = new Client("marcucci", "romain", "paris", clientCat, 0);
		assertTrue(client.getNom().equals("marcucci"));
		assertTrue(client.getPrenom().equals("romain"));
		assertTrue(client.getAdresse().equals("paris"));
		assertTrue(client.getCategorie() == clientCat);
		assertTrue(client.getReduc() == 0);

	}

	@Test(expected = OperationImpossible.class)
	public void codeConstructorFail() throws OperationImpossible {
		CategorieClient clientCat = new CategorieClient("marcucci");
		Client client = new Client("marcucci", "romain", "paris", clientCat, 0);
	}

	// @Test
	// public void initAttr(){
	// // TO DO
	// }

	@Test
	public void pasEmpruntsEnCours() {
		assertTrue(!c.aDesEmpruntsEnCours());
	}

	@Test
	public void empruntsEnCours() throws OperationImpossible {
		assertTrue(!c.aDesEmpruntsEnCours());
		c.getCategorie().modifierMax(1);
		c.emprunter();
		assertTrue(c.aDesEmpruntsEnCours());
	}

	@Test
	public void peutEmprunter() throws OperationImpossible {
		c.getCategorie().modifierMax(10);
		assertTrue(c.peutEmprunter());

	}

	@Test
	public void nePeutEmprunter() throws OperationImpossible {

		assertTrue(!c.peutEmprunter());
	}

	@Test
	public void emprunter() throws OperationImpossible {
		int empruntsEffectues = c.getNbEmpruntsEffectues();
		int empruntsEnCours = c.getNbEmpruntsEnCours();
		c.getCategorie().modifierMax(10);
		c.emprunter();
		assertTrue(c.getNbEmpruntsEffectues() == empruntsEffectues + 1);
		assertTrue(c.getNbEmpruntsEnCours() == empruntsEnCours + 1);
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
	public void marquer() throws OperationImpossible {
		c.getCategorie().modifierMax(10);
		int nbRetard = c.getNbEmpruntsEnRetard();
		c.emprunter();
		c.marquer();
		assertTrue(c.getNbEmpruntsEnRetard() == nbRetard + 1);
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
		assertTrue(c.getNbEmpruntsEnCours() == 0);
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
		assertTrue(c.sommeDue(10) == (10 * cc.getCoefTarif()));
	}
}
