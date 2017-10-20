package mediatheque;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import mediatheque.client.Client;
import mediatheque.document.Audio;
import mediatheque.document.Document;
import util.Datutil;
import util.InvariantBroken;

public class LettreRappelTest {

	LettreRappel lettre = null;

	@Before
	public void setup() throws OperationImpossible, InvariantBroken {
		Mediatheque m = new Mediatheque("mediatheque");
		Client c = new Client("marcucci", "romain");
		Localisation l = new Localisation("A", "05");
		Genre g = new Genre("genre");
		Document d = new Audio("code", l, "audio_doc", "auteur", "2017", g, "classification");
		FicheEmprunt fiche = new FicheEmprunt(m, c, d);
		lettre = new LettreRappel("audio", fiche);
	}

	@Test
	public void testConstructeur() {
		assertTrue(lettre != null);
	}

	@Test
	public void testRelancer() {
		lettre.relancer();
		assertTrue(lettre.getDateRappel() == Datutil.dateDuJour());
	}
}
