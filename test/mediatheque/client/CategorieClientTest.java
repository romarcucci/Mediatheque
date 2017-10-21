package mediatheque.client;

import static org.junit.Assert.*;

import org.junit.Test;

public class CategorieClientTest {

	CategorieClient cc = null;
	
	@Test
	public void nomConstructeurTest() {
		cc = new CategorieClient("Subscriber");
		assertNotNull(cc);
		assertTrue(cc.getNom().equals("Subscriber"));
		assertEquals(0, cc.getNbEmpruntMax());
		assertEquals(0,cc.getCotisation(),0.001);
		assertEquals(0,cc.getCoefDuree(),0.001);
		assertEquals(0,cc.getCoefTarif(),0.001);
		assertEquals(false,cc.getCodeReducUtilise());
	}

	@Test
	public void constructeurTest() {
		CategorieClient cc = new CategorieClient("Subscriber", 10, 10, 10,10, true);
		assertNotNull(cc);
		assertTrue(cc.getNom().equals("Subscriber"));
		assertEquals(10, cc.getNbEmpruntMax());
		assertEquals(10,cc.getCotisation(),0.001);
		assertEquals(10,cc.getCoefDuree(),0.001);
		assertEquals(10,cc.getCoefTarif(),0.001);
		assertEquals(true,cc.getCodeReducUtilise());
	}
	
	@Test
	public void modifierNomTest(){
		CategorieClient cc = new CategorieClient("Subscriber", 10, 10, 10,10, true);
		cc.modifierNom("Normal Rate");
		assertTrue(cc.getNom().equals("Normal Rate"));
	}
	
	@Test
	public void modifierMaxTest(){
		CategorieClient cc = new CategorieClient("Subscriber", 10, 10, 10,10, true);
		cc.modifierMax(20);
		assertEquals(20,cc.getNbEmpruntMax());
	}
	
	@Test
	public void modifierCotisationTestFail(){
		CategorieClient cc = new CategorieClient("Subscriber", 10, 10, 10,10, true);
		cc.modifierCotisation(20);
		assertEquals(20,cc.getCotisation(),0.001);
	}
	
	@Test
	public void modifCoefDuree(){
		CategorieClient cc = new CategorieClient("Subscriber", 10, 10, 10,10, true);
		cc.modifierCoefDuree(20);
		assertEquals(20,cc.getCoefDuree(),0.001);
	}
	
	@Test
	public void modifCoefTarif(){
		CategorieClient cc = new CategorieClient("Subscriber", 10, 10, 10,10, true);
		cc.modifierCoefTarif(20);
		assertEquals(20,cc.getCoefTarif(),0.001);
	}
	
	@Test
	public void modifCodeReducActif(){
		CategorieClient cc = new CategorieClient("marcucci", 10, 10, 10,10, true);
		cc.modifierCodeReducActif(false);
		assertEquals(false,cc.getCodeReducUtilise());		
	}
}













