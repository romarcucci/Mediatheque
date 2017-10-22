package mediatheque.document;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import mediatheque.Genre;
import mediatheque.Localisation;
import mediatheque.OperationImpossible;
import util.InvariantBroken;

public class VideoTest {

	Video v = null;

	@Before
	public void setup() throws OperationImpossible, InvariantBroken {
		Localisation l = new Localisation("Salle", "Rayon");
        Genre g = new Genre("Genre");
        v = new Video("01", l, "Titre", "Auteur", "2017", g, 10, "Mention");
	}

	@Test
	public void constructeurTest() throws OperationImpossible, InvariantBroken {
		assertNotNull(v);
		assertTrue(v.getCode().equals("01"));
		assertEquals(new Localisation("Salle", "Rayon"), v.getLocalisation());
		assertTrue(v.getTitre().equals("Titre"));
		assertTrue(v.getAuteur().equals("Auteur"));
		assertTrue(v.getAnnee().equals("2017"));
		assertEquals(new Genre("Genre"), v.getGenre());
		assertTrue(v.getMentionLegale().equals("Mention"));
		assertEquals(10,v.getDureeFilm());
		assertEquals(false,v.estEmpruntable());
		assertEquals(false,v.estEmprunte());
		assertEquals(0,v.getNbEmprunts());
	}
	
	@Test
	public void constructeurTestFail() throws OperationImpossible, InvariantBroken {
		v = new Video("01", new Localisation("Salle", "Rayon") , "Titre", "Auteur", "2017", new Genre("Genre"), 10, null);
	}

	@Test
	public void invariantVideoTest() {
		v.invariantVideo();
	}
	
	/* No need because we already test it in DocumentTest (through DocumentNonAbstract class)
	@Test
	public void emprunterTest() throws InvariantBroken, OperationImpossible {
		v.metEmpruntable();
		v.emprunter();
	}
	
	@Test
	public void emprunterTestFail() throws InvariantBroken, OperationImpossible {
		v = new Video("01", new Localisation("Salle", "Rayon") , "Titre", "Auteur", "2017", new Genre("Genre"), 10, null);
		v.metEmpruntable();
		v.emprunter();
	}
	*/
	
	@Test
	public void testInvariantVideoFail() throws OperationImpossible, InvariantBroken {
		v = new Video("01", new Localisation("Salle", "Rayon") , "Titre", "Auteur", "2017", new Genre("Genre"), 0, "Mention");
		v.invariantVideo();
	}
	
	@Test
	public void dureeEmpruntTest() {
		assertEquals(2*7, v.dureeEmprunt());
	}
	
	@Test
	public void tarifEmpruntTest() {
		assertEquals(1.5, v.tarifEmprunt(), 0.001);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void incrementationEmprunterTestFail() throws InvariantBroken, OperationImpossible {
		int stat_avant = v.getStat();
		v.metEmpruntable();
		v.emprunter();
		int stat_apres = v.getStat();
		assertEquals(stat_apres,stat_avant+1);
	}
}
