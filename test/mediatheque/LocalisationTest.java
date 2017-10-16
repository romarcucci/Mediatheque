package mediatheque;

import static org.junit.Assert.*;

import org.junit.Test;

public class LocalisationTest {

	Localisation l, l1;
	private int h1, h2;

	@Test
	public void constructeurTest() {
		l = new Localisation("Sud", "Musique du Monde");
		assertTrue(l.getSalle().equals("Sud"));
		assertTrue(l.getRayon().equals("Musique du Monde"));
	}
	
	@Test
	public void testHashCode() {
		l1 = new Localisation ("Nord", "Polar");
		h1 = l1.getSalle().hashCode();
		h2 = l1.getRayon().hashCode();
		assertFalse(h1 == l1.hashCode());
		assertTrue(h2 == l1.hashCode());		
	}

}
