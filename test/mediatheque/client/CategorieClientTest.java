package mediatheque.client;

import static org.junit.Assert.*;

import org.junit.Test;

public class CategorieClientTest {

	@Test
	public void nameConstructor() {
		CategorieClient cc = new CategorieClient("marcucci");
		assertTrue(cc.getNom().equals("marcucci"));
		assertTrue(cc.getNbEmpruntMax() == 0);
		assertTrue(cc.getCotisation() == 0);
		assertTrue(cc.getCoefDuree() == 0);
		assertTrue(cc.getCoefTarif() == 0);
		assertTrue(!cc.getCodeReducUtilise());
	}

	@Test
	public void fullConstructor() {
		CategorieClient cc = new CategorieClient("marcucci", 10, 10, 10,10, true);
		assertTrue(cc.getNom().equals("marcucci"));
		assertTrue(cc.getNbEmpruntMax() == 10);
		assertTrue(cc.getCotisation() == 10);
		assertTrue(cc.getCoefDuree() == 10);
		assertTrue(cc.getCoefTarif() == 10);
		assertTrue(cc.getCodeReducUtilise());
	}
	
	@Test
	public void modifNom(){
		CategorieClient cc = new CategorieClient("marcucci", 10, 10, 10,10, true);
		cc.modifierNom("iccucram");
		assertTrue(cc.getNom().equals("iccucram"));
	}
	
	@Test
	public void modifMax(){
		CategorieClient cc = new CategorieClient("marcucci", 10, 10, 10,10, true);
		cc.modifierMax(20);
		assertTrue(cc.getNbEmpruntMax() == 20);
	}
	
	@Test
	public void modifCotisation(){
		CategorieClient cc = new CategorieClient("marcucci", 10, 10, 10,10, true);
		cc.modifierCotisation(20);
		assertTrue(cc.getCotisation() == 20);
	}
	
	@Test
	public void modifCoefDuree(){
		CategorieClient cc = new CategorieClient("marcucci", 10, 10, 10,10, true);
		cc.modifierCoefDuree(20);
		assertTrue(cc.getCoefDuree() == 20);
	}
	
	@Test
	public void modifCoefTarif(){
		CategorieClient cc = new CategorieClient("marcucci", 10, 10, 10,10, true);
		cc.modifierCoefTarif(20);
		assertTrue(cc.getCoefTarif() == 20);
	}
	
	@Test
	public void modifCodeReducActif(){
		CategorieClient cc = new CategorieClient("marcucci", 10, 10, 10,10, true);
		cc.modifierCodeReducActif(false);
		assertTrue(!cc.getCodeReducUtilise());		
	}
}













