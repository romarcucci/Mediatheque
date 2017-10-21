package mediatheque.document;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mediatheque.Genre;
import mediatheque.Localisation;

import mediatheque.OperationImpossible;
import util.InvariantBroken;

public class LivreTest {
	
	Livre livre = null;
	
	@Before
	public void setUp() throws Exception {
		Localisation l = new Localisation("salle", "rayon");
		Genre g = new Genre("genre");

		livre = new Livre("01", l, "titre", "auteur", "2017", g, 200);
	}

	@Test
	public void testConstructeur() {

	}

	@Test
	public void testConstructeurFail() {
		
	}

	@Test
	public void testEmprunter() {

	}

	@Test
	public void testLivre() {

	}

	@Test
	public void testDureeEmprunt() {

	}

	@Test
	public void testTarifEmprunt() {

	}

	@Test
	public void testInvariantLivre() {

	}

}
