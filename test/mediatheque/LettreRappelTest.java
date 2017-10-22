package mediatheque;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import mediatheque.client.CategorieClient;
import mediatheque.client.Client;
import mediatheque.document.Audio;
import mediatheque.document.Document;
import mediatheque.document.Livre;
import util.Datutil;
import util.InvariantBroken;

public class LettreRappelTest {

	LettreRappel lettre = null;
	FicheEmprunt f = null;

	@Before
	public void setUp() throws OperationImpossible, InvariantBroken {
		Mediatheque m = new Mediatheque("Mediatheque");
		CategorieClient cc = new CategorieClient("Normal Rate", 5, 0, 1, 1, false);
		Client c = new Client("Nom", "Prenom","Adresse", cc);
		Document d = new Livre("01", new Localisation("Salle", "Rayon"), "Titre", "Auteur", "2017", new Genre("Genre"), 200);
		m.saveToFile();
		d.metEmpruntable();
		f = new FicheEmprunt(m,c,d);
		lettre = new LettreRappel("Audio", f);
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
