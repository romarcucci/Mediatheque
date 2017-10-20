package mediatheque;

import static org.junit.Assert.*;

import org.junit.Test;

public class GenreTest {

	Genre g = null;

	@Test
	public void constructeurTest() {
		g = new Genre("Horror");
		assertTrue(g.getNom().equals("Horror"));
		assertTrue(g.getNbEmprunts() == 0);
	}

	@Test
	public void emprunterTest() {
		g = new Genre("KPOP");
		int nb = g.getNbEmprunts();
		g.emprunter();
		assertTrue(g.getNbEmprunts() == nb + 1);
	}

	@Test
	public void modifierTest() {
		g = new Genre("Animation");
		assertTrue(g.getNom().equals("Animation"));
		g.modifier("Anime");
		assertTrue(g.getNom().equals("Anime"));
	}
	
}
