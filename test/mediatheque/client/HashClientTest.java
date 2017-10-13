package mediatheque.client;

import static org.junit.Assert.*;

import org.junit.Test;

public class HashClientTest {

	@Test
	public void setup() {
		HashClient hc = new HashClient("marcucci", "romain");
		assertTrue(hc.getPrenom().equals("romain"));
		assertTrue(hc.getNom().equals("marcucci"));
	}

}
