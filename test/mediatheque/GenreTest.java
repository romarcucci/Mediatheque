package mediatheque;

import static org.junit.Assert.*;

import org.junit.Test;

public class GenreTest {
	
	Genre g, g1, g2;
	
	@Test
	public void constructeurTest() {
		g = new Genre("Horror");
		g1 = new Genre ("Documentary");
		assertTrue(g.getNom().equals("Horror"));
		assertTrue(g1.getNom().equals("Documentary"));
	}
	
	@Test
	public void emprunterTest() {
		g = new Genre("KPOP");
		g2 = new Genre("Hip Hop");
		g.emprunter();
		g2.emprunter();
		g2.emprunter();
		assertEquals(g.getNbEmprunts(),12);
		assertEquals(g2.getNbEmprunts(),14);
	}
	
	@Test
	public void modifierTest() {
		g = new Genre("Animation");
		g.modifier("Anime");
		assertTrue(g.getNom().equals("Anime"));	
	}
	
	public void afficherstatTest () {
		g = new Genre("Thriller");
		g.emprunter();
		g.afficherStatistiques(); // ??
	}

}
