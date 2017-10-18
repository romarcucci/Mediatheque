package mediatheque.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import mediatheque.OperationImpossible;

public class ClientTest {

	@Test
	public void nameConstructor() {
		Client c = new Client("marcucci", "romain");
		assertTrue(c.getNom().equals("marcucci"));
		assertTrue(c.getPrenom().equals("romain"));
	}

	@Test
	public void catConstructor() throws OperationImpossible {
		CategorieClient cc = new CategorieClient("marcucci");
		Client c = new Client("marcucci", "romain", "paris", cc);
		assertTrue(c.getNom().equals("marcucci"));
		assertTrue(c.getPrenom().equals("romain"));
		assertTrue(c.getAdresse().equals("paris"));
		assertTrue(c.getCategorie() == cc);
	}

	@Test(expected = OperationImpossible.class)
	public void catConstructorFail() throws OperationImpossible {
		CategorieClient cc = new CategorieClient("marcucci");
		cc.modifierCodeReducActif(true);
		Client c = new Client("marcucci", "romain", "paris", cc);
	}


	@Test
	public void codeConstructor() throws OperationImpossible{
		CategorieClient cc = new CategorieClient("marcucci");
		cc.modifierCodeReducActif(true);
		Client c = new Client("marcucci", "romain", "paris", cc, 0);
		assertTrue(c.getNom().equals("marcucci"));
		assertTrue(c.getPrenom().equals("romain"));
		assertTrue(c.getAdresse().equals("paris"));
		assertTrue(c.getCategorie() == cc);
		assertTrue(c.getReduc() == 0);

	}

	@Test(expected = OperationImpossible.class)
	public void codeConstructorFail() throws OperationImpossible {
		CategorieClient cc = new CategorieClient("marcucci");
		Client c = new Client("marcucci", "romain", "paris", cc, 0);
	}

//	@Test
//	public void initAttr(){
//		// TO DO
//	}

	@Test
	public void pasEmpruntsEnCours(){
		Client c = new Client("marcucci", "romain");
		assertTrue(!c.aDesEmpruntsEnCours());
	}

	@Test
	public void empruntsEnCours() throws OperationImpossible{
		CategorieClient cc = new CategorieClient("marcucci");
		Client c = new Client("marcucci", "romain", "paris", cc);
		assertTrue(!c.aDesEmpruntsEnCours());
		c.getCategorie().modifierMax(1);
		c.emprunter();
		assertTrue(c.aDesEmpruntsEnCours());
	}

	@Test
	public void peutEmprunter() throws OperationImpossible{
		CategorieClient cc = new CategorieClient("marcucci");
		Client c = new Client("marcucci", "romain", "paris", cc);
		c.getCategorie().modifierMax(10);
		assertTrue(c.peutEmprunter());

	}

	@Test
	public void nePeutEmprunter() throws OperationImpossible{
		CategorieClient cc = new CategorieClient("marcucci");
		Client c = new Client("marcucci", "romain", "paris", cc);
		assertTrue(!c.peutEmprunter());
	}

	@Test
	public void emprunter() throws OperationImpossible{
		CategorieClient cc = new CategorieClient("marcucci");
		Client c = new Client("marcucci", "romain", "paris", cc);
		int empruntsEffectues = c.getNbEmpruntsEffectues();
		int empruntsEnCours = c.getNbEmpruntsEnCours();
		c.getCategorie().modifierMax(10);
		c.emprunter();
		assertTrue(c.getNbEmpruntsEffectues() == empruntsEffectues + 1);
		assertTrue(c.getNbEmpruntsEnCours() == empruntsEnCours + 1);
	}

//	@Test
//	public void emprunterFiche() throws OperationImpossible, InvariantBroken{
//		CategorieClient cc = new CategorieClient("marcucci");
//		Client c = new Client("marcucci", "romain", "paris", cc);
//		int empruntsEffectues = c.getNbEmpruntsEffectues();
//		int empruntsEnCours = c.getNbEmpruntsEnCours();
//		c.getCategorie().modifierMax(10);
//		Mediatheque m = new Mediatheque("mediatheque");
//		Localisation l = new Localisation("A", "05");
//		Genre g = new Genre("genre");
//		Audio a = new Audio("code", l, "audio_doc", "auteur", "2017", g, "classification");
//		FicheEmprunt fiche = new FicheEmprunt(m, c, a);
//		c.emprunter(fiche);
//		assertTrue(c.getNbEmpruntsEffectues() == empruntsEffectues + 1);
//		assertTrue(c.getNbEmpruntsEnCours() == empruntsEnCours + 1);
//	}

	@Test
	public void marquer() throws OperationImpossible{
		CategorieClient cc = new CategorieClient("marcucci");
		Client c = new Client("marcucci", "romain", "paris", cc);
		c.getCategorie().modifierMax(10);
		int nbRetard = c.getNbEmpruntsEnRetard();
		c.emprunter();
		c.marquer();
		assertTrue(c.getNbEmpruntsEnRetard() == nbRetard + 1);
	}

	@Test(expected = OperationImpossible.class)
	public void marquerFail() throws OperationImpossible{
		CategorieClient cc = new CategorieClient("marcucci");
		Client c = new Client("marcucci", "romain", "paris", cc);
		c.getCategorie().modifierMax(10);
		c.marquer();
	}

//	@Test
//	public void restituerFiche(){
//		CategorieClient cc = new CategorieClient("marcucci");
//		Client c = new Client("marcucci", "romain", "paris", cc);
//		int empruntsEffectues = c.getNbEmpruntsEffectues();
//		c.getCategorie().modifierMax(10);
//		Mediatheque m = new Mediatheque("mediatheque");
//		Localisation l = new Localisation("A", "05");
//		Genre g = new Genre("genre");
//		Audio a = new Audio("code", l, "audio_doc", "auteur", "2017", g, "classification");
//		FicheEmprunt fiche = new FicheEmprunt(m, c, a);
//		c.emprunter(fiche);
//		c.restituer(fiche);
//		assertTrue(c.getNbEmpruntsEnCours() == empruntsEnCours - 1);
//	}
//
//	@Test(expected = OperationImpossible)
//	public void restituerFicheFail(){
//		CategorieClient cc = new CategorieClient("marcucci");
//		Client c = new Client("marcucci", "romain", "paris", cc);
//		int empruntsEffectues = c.getNbEmpruntsEffectues();
//		c.getCategorie().modifierMax(10);
//		Mediatheque m = new Mediatheque("mediatheque");
//		Localisation l = new Localisation("A", "05");
//		Genre g = new Genre("genre");
//		Audio a = new Audio("code", l, "audio_doc", "auteur", "2017", g, "classification");
//		FicheEmprunt fiche = new FicheEmprunt(m, c, a);
//		c.emprunter(fiche);
//		Mediatheque m1 = new Mediatheque("error");
//		FicheEmprunt fiche = new FicheEmprunt(m1, c, a);
//		c.restituer(fiche);
//		assertTrue(c.getNbEmpruntsEnCours() == empruntsEnCours - 1);
//	}

	@Test
	public void restituerBool() throws OperationImpossible{
		CategorieClient cc = new CategorieClient("marcucci");
		Client c = new Client("marcucci", "romain", "paris", cc);
		c.getCategorie().modifierMax(10);
		c.emprunter();
		c.restituer(false);
		assertTrue(c.getNbEmpruntsEnCours() == 0);
	}

//	@Test
//	public void restituerBoolRetard() throws OperationImpossible{
//		CategorieClient cc = new CategorieClient("marcucci");
//		Client c = new Client("marcucci", "romain", "paris", cc);
//		c.getCategorie().modifierMax(10);
//		c.emprunter();
//		c.restituer(true);
//		assertTrue(c.getNbEmpruntsEnCours() == 0);
//		assertTrue(c.getNbEmpruntsEnRetard() == 0);
//	}

	@Test(expected = OperationImpossible.class)
	public void restituerBoolFail() throws OperationImpossible{
		CategorieClient cc = new CategorieClient("marcucci");
		Client c = new Client("marcucci", "romain", "paris", cc);
		c.restituer(false);
	}

	@Test(expected = OperationImpossible.class)
	public void restituerBoolRetardFail() throws OperationImpossible{
		CategorieClient cc = new CategorieClient("marcucci");
		Client c = new Client("marcucci", "romain", "paris", cc);
		c.getCategorie().modifierMax(10);
		c.emprunter();
		c.restituer(true);
	}

	@Test
	public void metAJourEmprunts(){
		//TODO
	}

	@Test
	public void dateRetour() throws OperationImpossible{
		CategorieClient cc = new CategorieClient("marcucci", 1, 1, 3, 10, false);
		Client c = new Client("marcucci", "romain", "paris", cc);
		System.out.println(c.dateRetour(new Date(), 10));
		System.out.println(addDays(new Date(), 20));
		assertEquals(addDays(new Date(), 20), c.dateRetour(new Date(), 10));
	}

	public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }

	@Test
	public void sommeDue() throws OperationImpossible{
		CategorieClient cc = new CategorieClient("marcucci", 1, 1, 1, 10, false);
		Client c = new Client("marcucci", "romain", "paris", cc);
		assertTrue(c.sommeDue(10) == (10*cc.getCoefTarif()));
	}
}
