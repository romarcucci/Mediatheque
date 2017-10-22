package mediatheque.client;

import static org.junit.Assert.*;

import org.junit.Test;

public class HashClientTest {

	@Test
	public void constructor() {
		HashClient hc = new HashClient("Nom", "Prenom");
		assertTrue(hc.getPrenom().equals("Prenom"));
		assertTrue(hc.getNom().equals("Nom"));
	}

}
