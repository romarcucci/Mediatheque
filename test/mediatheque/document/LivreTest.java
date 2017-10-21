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
		Localisation l = new Localisation("Salle", "Rayon");
		Genre g = new Genre("Genre");
		livre = new Livre("01", l, "Titre", "Auteur", "2017", g, 200);
	}

	@Test
	public void testConstructeur() {
		assertTrue(livre.getCode().equals("01"));
		assertEquals(new Localisation("Salle","Rayon"), livre.getLocalisation());
		assertTrue(livre.getTitre().equals("Titre"));
		assertTrue(livre.getAuteur().equals("Auteur"));
		assertTrue(livre.getAnnee().equals("2017"));
		assertEquals(new Genre("Genre"), livre.getGenre());
		assertEquals(true, livre.invariantLivre());
	}

	@Test
	public void testConstructeurFail() throws OperationImpossible, InvariantBroken {
		livre = new Livre("01", new Localisation("Salle", "Rayon"), "Titre", "Auteur", "2017", new Genre("Genre"), -4);
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
