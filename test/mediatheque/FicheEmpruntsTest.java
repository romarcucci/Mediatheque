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
	public void constructeur() {
		assertTrue(fiche.getDateEmprunt() == Datutil.dateDuJour());
	}

	@Test
	public void verifier() {

	}

	@Test
	public void premierRappel() {

	}

	@Test
	public void relancher() {

	}

	@Test
	public void modifierClient() {

	}

	@Test
	public void correspond() {

	}

	@Test
	public void restituer() {

	}

	@Test
	public void changementCategorie() {

	}
}
