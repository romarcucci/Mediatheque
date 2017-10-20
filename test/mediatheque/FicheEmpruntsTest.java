package mediatheque;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import mediatheque.client.Client;
import mediatheque.document.Audio;
import mediatheque.document.Document;
import util.Datutil;
import util.InvariantBroken;

public class FicheEmpruntsTest {

	FicheEmprunt fiche = null;

	@Before
	public void setup() throws OperationImpossible, InvariantBroken {
		Mediatheque m = new Mediatheque("mediatheque");
		Client c = new Client("marcucci", "romain");
		Localisation l = new Localisation("A", "05");
		Genre g = new Genre("genre");
		Document d = new Audio("code", l, "audio_doc", "auteur", "2017", g, "classification");
		fiche = new FicheEmprunt(m, c, d);
	}

	@Test
	public void testConstructeur() {
		assertTrue(fiche.getDateEmprunt() == Datutil.dateDuJour());
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
