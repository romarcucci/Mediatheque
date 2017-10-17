package mediatheque;

import static org.junit.Assert.*;

import org.junit.Test;

public class GenreTest {
	
	Genre g;
	
	@Test
	public void constructeurTest() {
		g = new Genre("Horror");
		assertTrue(g.getNom().equals("Horror"));
	}
	
	@Test
	public void emprunterTest() {
		g = new Genre("KPOP");
		g.emprunter();
		assertEquals(g.getNbEmprunts(),12);
	}
	
	@Test
	public void modifierTest() {
		g = new Genre("Animation");
		g.modifier("Anime");
		assertTrue(g.getNom().equals("Anime"));	
	}

}
