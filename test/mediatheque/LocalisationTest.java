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
}
