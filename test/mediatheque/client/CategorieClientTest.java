package mediatheque.client;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CategorieClientTest {

	CategorieClient cc = null, subscriber = null, discounted = null, normal = null;
	
	@Before
	public void setUp() throws Exception {
		cc = new CategorieClient("Categorie", 0, 0, 0, 0, true);
		subscriber = new CategorieClient("Subscriber", 10, 50, 2, 0, false);
		normal = new CategorieClient("Normal Rate", 5, 0, 1, 1, false);
		discounted = new CategorieClient("Discounted", 2, 0, 0.5, 0.5, true);	
	}
	
	@Test
	public void nomConstructeurTest() {
		CategorieClient cc = new CategorieClient("Categorie");
		assertNotNull(cc);
		assertTrue(cc.getNom().equals("Categorie"));
	}

	@Test
	public void constructeurTest() {
		assertNotNull(cc);
		assertEquals(0, cc.getNbEmpruntMax());
		assertEquals(0,cc.getCotisation(),0.001);
		assertEquals(0,cc.getCoefDuree(),0.001);
		assertEquals(0,cc.getCoefTarif(),0.001);
		assertEquals(true,cc.getCodeReducUtilise());
	}
	
	@Test
	public void constructeurRandomCategoryTest() {
		cc = new CategorieClient("LMFAO", 1000, 1000, 1000, 1000, true);
		assertNotNull(cc);
		//at least one should
		assertFalse(cc.getNom().equals("Subscriber"));
		assertFalse(cc.getNom().equals("Normal Rate"));
		assertFalse(cc.getNom().equals("Discounted"));
	}
	
	@Test
	public void subscriberTest() {
		assertNotNull(subscriber);
		assertEquals(10,subscriber.getNbEmpruntMax()); //10 documents max
		assertEquals(50,subscriber.getCotisation(),0.001);
		assertEquals(2,subscriber.getCoefDuree(),0.001); 
		assertEquals(0,subscriber.getCoefTarif(),0.001); 
		assertEquals(false,subscriber.getCodeReducUtilise());
	}
	
	@Test
	public void normalRateTest() {
		assertNotNull(normal);
		assertEquals(5,normal.getNbEmpruntMax()); 
		assertEquals(0,normal.getCotisation(),0.001);
		assertEquals(1,normal.getCoefDuree(),0.001); 
		assertEquals(1,normal.getCoefTarif(),0.001);
		assertEquals(false,normal.getCodeReducUtilise());
	}
	
	@Test
	public void discountedTest() {
		assertNotNull(discounted);
		assertEquals(2,discounted.getNbEmpruntMax()); 
		assertEquals(0,discounted.getCotisation(),0.001);
		assertEquals(0.5,discounted.getCoefDuree(),0.001); 
		assertEquals(0.5,discounted.getCoefTarif(),0.001);
		assertEquals(true,discounted.getCodeReducUtilise()); 
	}
	
	//L'énoncé du projet fixe déjà les variables autorisées pour chaque catégorie
	//On ne devrait pas pouvoir changer une valeur sans changer tout le reste (ainsi que la catégorie)
	@Test 
	public void subscriberTestFail() { 
		subscriber.modifierCodeReducActif(true);
		assertEquals(false,discounted.getCodeReducUtilise()); 
	}

	@Test 
	public void normalTestFail() {
		normal.modifierCoefTarif(5);
		assertEquals(1,normal.getCoefTarif(),0.001);
	}
	
	@Test 
	public void discountedTestFail() {
		discounted.modifierCoefDuree(50);
		assertEquals(0.5,discounted.getCoefDuree(),0.001);
	}
	
	@Test
	public void modifierNomTest(){
		cc.modifierNom("New Categorie");
		assertTrue(cc.getNom().equals("New Categorie"));
	}
	
	@Test
	public void modifierMaxTest(){
		cc.modifierMax(20);
		assertEquals(20,cc.getNbEmpruntMax());
	}
	
	@Test
	public void modifCoefTarifTest(){
		cc.modifierCoefTarif(20);
		assertEquals(20,cc.getCoefTarif(),0.001);
	}
	
	@Test
	public void modifCodeReducActifTest(){
		cc.modifierCodeReducActif(false);
		assertEquals(false,cc.getCodeReducUtilise());		
	}
	
	@Test
	public void modifierCotisationTestFail(){
		cc.modifierCotisation(20);
		assertEquals(20,cc.getCotisation(),0.001); //bc it returns 4
	}
	
	@Test
	public void modifCoefDuree(){
		cc.modifierCoefDuree(20);
		assertEquals(20,cc.getCoefDuree(),0.001);
	}
}













