package mediatheque.document;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mediatheque.Genre;
import mediatheque.Localisation;
import mediatheque.OperationImpossible;
import util.InvariantBroken;

public class AudioTest {

	Audio a = null;
	int nb_before = 0, nb_after = 0;

	@Before
	public void setUp() throws OperationImpossible, InvariantBroken {
		Localisation l = new Localisation("Salle", "Rayon");
        Genre g = new Genre("Genre");
        a = new Audio("01", l, "Titre", "Auteur", "2017", g, "Classification");
	}

	@Test
	public void testConstructeur() {
		assertNotNull(a);
		assertTrue(a.getCode().equals("01"));
		assertEquals(new Localisation("Salle", "Rayon"), a.getLocalisation());
		assertTrue(a.getTitre().equals("Titre"));
		assertTrue(a.getAuteur().equals("Auteur"));
		assertTrue(a.getAnnee().equals("2017"));
		assertEquals(new Genre("Genre"), a.getGenre());
		assertTrue(a.getClassification().equals("Classification")); 
		assertEquals(false,a.estEmpruntable());
		assertEquals(false,a.estEmprunte());
		assertEquals(0,a.getNbEmprunts());
	}

	@Test(expected = OperationImpossible.class)
	public void testConstructeurFail() throws OperationImpossible, InvariantBroken {
        a = new Audio("01", new Localisation("Salle", "Rayon"), "Titre", "Auteur", "2017", new Genre("Genre"), null);
	}

	@Test
	public void testEmpruntable() throws InvariantBroken, OperationImpossible {
		a.metEmpruntable();
		assertEquals(true,a.estEmpruntable());
	}
	
	@Test
	public void testEmprunte() throws InvariantBroken, OperationImpossible {
		a.metEmpruntable();
		a.emprunter();
		assertEquals(true,a.estEmpruntable());
		assertEquals(true,a.estEmprunte());
	}
	
	@Test
	public void testConsultable() throws InvariantBroken, OperationImpossible {
		a.metEmpruntable();
		a.metConsultable();
		assertEquals(false,a.estEmpruntable());
	}
	
	@Test
	public void testIncrementEmprunte() throws InvariantBroken, OperationImpossible {
		//check it's empruntable
		a.metEmpruntable();
		assertEquals(true,a.estEmpruntable());
		nb_before = a.getNbEmprunts();
		//check it's emprunted
		a.emprunter();
		nb_after = a.getNbEmprunts();
		assertEquals(true,a.estEmprunte());
		//check incrementation
		assertEquals(nb_after,nb_before+1);
	}
	
	@Test
	public void testEmpruntableFail() throws InvariantBroken, OperationImpossible {
		assertEquals(false,a.estEmpruntable());
		assertEquals(false,a.estEmprunte());
	}
	
	@Test
	public void testEmprunteFail() throws InvariantBroken, OperationImpossible {
		//must be Empruntable first before we can emprunt it
		a.emprunter();
	}
	
	@Test
	public void testConsultableFail() throws InvariantBroken, OperationImpossible {
		//already consultable 
		a.metConsultable();
	}

	

	

}
