package mediatheque.document;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mediatheque.Genre;
import mediatheque.Localisation;
import mediatheque.OperationImpossible;
import util.InvariantBroken;

public class LivreTest {
	
	Livre l = null;
	
	@Test
	public void constructeurTest() throws OperationImpossible, InvariantBroken {
		l = new Livre("ALY252018TOP", new Localisation("Est", " Monde"), "La vie rêvée des Plantes", "Seung-U Lee", "2009", new Genre("Drame"), 0);
		assertTrue(l.getAnnee().equals("2009"));
		assertTrue(l.getAuteur().equals("Seung-U Lee"));
	}

	@Test
	public void testEmprunter() {
		fail("Not yet implemented");
	}

	@Test
	public void testLivre() {
		fail("Not yet implemented");
	}

	@Test
	public void testDureeEmprunt() {
		fail("Not yet implemented");
	}

	@Test
	public void testTarifEmprunt() {
		fail("Not yet implemented");
	}

	@Test
	public void testInvariantLivre() {
		fail("Not yet implemented");
	}

}
