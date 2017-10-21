package mediatheque;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mediatheque.client.Client;
import mediatheque.document.Audio;
import mediatheque.document.Document;
import util.Datutil;
import util.InvariantBroken;

public class FicheEmpruntsTest {

	FicheEmprunt f = null;

	@Before
	public void setUp() throws OperationImpossible, InvariantBroken {
		Mediatheque m = new Mediatheque("Mediatheque");
		m.saveToFile();
		Client c = new Client("Nom", "Prenom");
		Localisation l = new Localisation("Salle", "Rayon");
		Genre g = new Genre("Genre");
		Document d = new Audio("01", l, "Titre", "Auteur", "2017", g, "Classification");
		d.metEmpruntable();
		d.emprunter();
		assertEquals(false,c.peutEmprunter());
		c.emprunter();
		System.out.println(c.getNbEmpruntsEnCours());
		f = new FicheEmprunt(m, c, d);		
	}

	@Test
	public void testConstructeur() {
		assertTrue(f.getDateEmprunt() == Datutil.dateDuJour());
	}

	@Test
	public void testVerifier() {

	}

	@Test
	public void testPremierRappel() {

	}

	@Test
	public void testRelancer() {

	}

	@Test
	public void testModifierClient() {

	}

	@Test
	public void testCorrespond() {

	}

	@Test
	public void testRestituer() {

	}

	@Test
	public void testChangementCategorie() {

	}
}
