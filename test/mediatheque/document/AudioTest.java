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
	public void constructeurTest() {
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
	public void constructeurTestFail() throws OperationImpossible, InvariantBroken {
        a = new Audio("01", new Localisation("Salle", "Rayon"), "Titre", "Auteur", "2017", new Genre("Genre"), null);
	}
	
	@Test
	public void dureeEmpruntTest() {
		assertEquals(4*7, a.dureeEmprunt());
	}
	
	@Test
	public void tarifEmpruntTest() {
		assertEquals(1.0, a.tarifEmprunt(), 0.001);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void incrementationEmprunterTest() throws InvariantBroken, OperationImpossible {
		int stat_avant = a.getStat();
		a.metEmpruntable();
		a.emprunter();
		int stat_apres = a.getStat();
		assertEquals(stat_apres,stat_avant+1);
	}
}
