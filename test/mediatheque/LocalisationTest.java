package mediatheque;

import static org.junit.Assert.*;

import org.junit.Test;

public class LocalisationTest {

	Localisation loc = null;

	@Test
	public void testConstructeur() {
		loc = new Localisation("Sud", "Musique du Monde");
		assertTrue(loc.getSalle().equals("Sud"));
		assertTrue(loc.getRayon().equals("Musique du Monde"));
	}
}
