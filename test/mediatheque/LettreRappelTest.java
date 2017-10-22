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
		Mediatheque m = new Mediatheque("Mediatheque");
		Client c = new Client("Nom", "Prenom");
		Localisation l = new Localisation("Salle", "Rayon");
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
