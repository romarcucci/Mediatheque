package mediatheque.document;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mediatheque.Genre;
import mediatheque.Localisation;
import mediatheque.OperationImpossible;
import util.InvariantBroken;

public class AudioTest {

	Audio a = null;

	@Before
	public void setUp() throws OperationImpossible, InvariantBroken {
		Localisation l = new Localisation("Salle", "Rayon");
        Genre g = new Genre("Genre");
        a = new Audio("01", l, "Titre", "Auteur", "2017", g, "Classification");
        //a.metEmpruntable();
	}

	@Test
	public void testConstructeur() {
		assertNotNull(a);
		assertTrue(a.getTitre().equals("Titre"));
		assertTrue(a.getAuteur().equals("Auteur"));
		assertTrue(a.getAnnee().equals("2017"));
		assertTrue(a.getClassification().equals("Classification")); 	
		assertEquals(false,a.estEmpruntable());
	}

	@Test(expected = OperationImpossible.class)
	public void testConstructeurFail() throws OperationImpossible, InvariantBroken {
        a = new Audio("01", new Localisation("salle", "rayon"), "titre", "auteur", "2017", new Genre("genre"), null);
	}

	@Test
	public void testEmprunter() throws InvariantBroken, OperationImpossible {
		int nb = a.getNbEmprunts();
		assertTrue(a.emprunter());
		assertTrue(nb + 1 == a.getNbEmprunts());
		
	}
}
