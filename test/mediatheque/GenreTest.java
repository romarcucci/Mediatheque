package mediatheque;

import static org.junit.Assert.*;

import org.junit.Test;

public class GenreTest {

	Genre g = null;

	@Test
	public void constructeurTest() {
		g = new Genre("Nom");
		assertTrue(g.getNom().equals("Nom"));
		assertEquals(0,g.getNbEmprunts());
	}

	@Test
	public void emprunterTest() {
		g = new Genre("Nom");
		int nb = g.getNbEmprunts();
		g.emprunter();
		assertEquals(nb + 1,g.getNbEmprunts());
	}

	@Test
	public void modifierTest() {
		g = new Genre("Nom");
		assertTrue(g.getNom().equals("Nom"));
		g.modifier("Nouveau Nom");
		assertTrue(g.getNom().equals("Nouveau Nom"));
	}

}
