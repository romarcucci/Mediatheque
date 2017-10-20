package mediatheque.document;

import org.junit.Before;
import org.junit.Test;

import mediatheque.Genre;
import mediatheque.Localisation;
import mediatheque.OperationImpossible;
import util.InvariantBroken;

public class VideoTest {

	Video video = null;

	@Before
	public void setup() throws OperationImpossible, InvariantBroken {
		Localisation l = new Localisation("salle", "rayon");
        Genre g = new Genre("genre");

        video = new Video("01", l, "title", "auteur", "2017", g, 10, "mention");
	}

	@Test
	public void testConstructeur() {

	}

	@Test
	public void testEmprunter() {

	}

	@Test
	public void testInvariantVideo() {

	}
}
