package mediatheque.client;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

import com.sun.xml.internal.txw2.Document;

import mediatheque.FicheEmprunt;
import mediatheque.Genre;
import mediatheque.Localisation;
import mediatheque.Mediatheque;
import mediatheque.OperationImpossible;
import mediatheque.document.Audio;
import util.Datutil;
import util.InvariantBroken;

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

}


