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
	}

	@Test
	public void testConstructeur() {
		assertNotNull(a);
		assertTrue(a.getCode().equals("01"));
		assertEquals(new Localisation("Salle", "Rayon"), a.getLocalisation());
		assertTrue(a.getTitre().equals("Titre"));
		assertTrue(a.getAuteur().equals("Auteur"));
		assertTrue(a.getAnnee().equals("2017"));
		assertEquals(new Genre("Genre"), a.getGenre());
		assertTrue(a.getClassification().equals("Classification")); 
		assertEquals(false,a.estEmpruntable());
		assertEquals(false,a.estEmprunte());
		assertEquals(0,a.getNbEmprunts());
	}

	@Test(expected = OperationImpossible.class)
	public void testConstructeurFail() throws OperationImpossible, InvariantBroken {
        a = new Audio("01", new Localisation("Salle", "Rayon"), "Titre", "Auteur", "2017", new Genre("Genre"), null);
	}
}
