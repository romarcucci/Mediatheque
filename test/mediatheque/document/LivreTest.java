package mediatheque.document;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import mediatheque.Genre;
import mediatheque.Localisation;
<<<<<<< HEAD

public class LivreTest {

	Livre livre = null;

	@Before
	public void setUp() throws Exception {
		Localisation l = new Localisation("salle", "rayon");
		Genre g = new Genre("genre");

		livre = new Livre("01", l, "titre", "auteur", "2017", g, 200);
	}

	@Test
	public void testConstructeur() {

	}

	@Test
	public void testConstructeurFail() {

=======
import mediatheque.OperationImpossible;
import util.InvariantBroken;

public class LivreTest {
	
	Livre l = null;
	
	@Test
	public void constructeurTest() throws OperationImpossible, InvariantBroken {
		l = new Livre("ALY252018TOP", new Localisation("Est", " Monde"), "La vie rêvée des Plantes", "Seung-U Lee", "2009", new Genre("Drame"), 0);
		assertTrue(l.getAnnee().equals("2009"));
		assertTrue(l.getAuteur().equals("Seung-U Lee"));
>>>>>>> 732b0d092a8b5cd30db9dff8384f04603b97ffd4
	}

	@Test
	public void testEmprunter() {

	}

	@Test
	public void testLivre() {

	}

	@Test
	public void testDureeEmprunt() {

	}

	@Test
	public void testTarifEmprunt() {

	}

	@Test
	public void testInvariantLivre() {

	}

}
