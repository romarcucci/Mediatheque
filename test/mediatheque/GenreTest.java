package mediatheque;

import static org.junit.Assert.*;

import org.junit.Test;

public class GenreTest {

	Genre g = null;

	@Test
	public void testConstructeur() {
		g = new Genre("Horror");
		assertTrue(g.getNom().equals("Horror"));
		assertTrue(g.getNbEmprunts() == 0);
	}

	@Test
	public void testEmprunter() {
		g = new Genre("KPOP");
		int nb = g.getNbEmprunts();
		g.emprunter();
		assertTrue(g.getNbEmprunts() == nb + 1);
	}

	@Test
	public void testModifier() {
		g = new Genre("Animation");
		assertTrue(g.getNom().equals("Animation"));
		g.modifier("Anime");
		assertTrue(g.getNom().equals("Anime"));
	}

}
