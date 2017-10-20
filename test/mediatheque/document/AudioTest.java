package mediatheque.document;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import mediatheque.Genre;
import mediatheque.Localisation;
import mediatheque.OperationImpossible;
import util.InvariantBroken;

public class AudioTest {

	Audio audio = null;

	@Before
	public void setup() throws OperationImpossible, InvariantBroken {
		Localisation l = new Localisation("salle", "rayon");
        Genre g = new Genre("genre");

        audio = new Audio("01", l, "titre", "auteur", "2017", g, "classif");
	}

	@Test
	public void constructeur() {
		assertTrue(audio != null);
	}

	@Test(expected = OperationImpossible.class)
	public void constructeurFail() throws OperationImpossible, InvariantBroken {
        audio = new Audio("01", new Localisation("salle", "rayon"), "titre", "auteur", "2017", new Genre("genre"), null);
	}

	@Test
	public void emprunter() throws InvariantBroken, OperationImpossible {
		int nb = audio.getNbEmprunts();
		assertTrue(audio.emprunter());
		assertTrue(nb + 1 == audio.getNbEmprunts());
	}
}
