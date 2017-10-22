package mediatheque.document;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mediatheque.Genre;
import mediatheque.Localisation;
import mediatheque.OperationImpossible;
import util.InvariantBroken;

public class DocumentTest {
	
	DocumentNonAbstract d = null; //create this to test Document (instead of testing the inherited methods in Document's children)
	int nb_before = 0, nb_after = 0;
	
	@Before
	public void setUp() throws OperationImpossible, InvariantBroken {
		Localisation l = new Localisation("Salle", "Rayon");
        Genre g = new Genre("Genre");
        d = new DocumentNonAbstract("01", l, "Titre", "Auteur", "2017", g);
	}
	
	@Test
	public void constructeurTest1() {
		assertNotNull(d);
		assertTrue(d.getCode().equals("01"));
		assertEquals(new Localisation("Salle", "Rayon"), d.getLocalisation());
		assertTrue(d.getTitre().equals("Titre"));
		assertTrue(d.getAuteur().equals("Auteur"));
		assertTrue(d.getAnnee().equals("2017"));
		assertEquals(new Genre("Genre"), d.getGenre());
		assertEquals(false,d.estEmpruntable());
		assertEquals(false,d.estEmprunte());
		assertEquals(0,d.getNbEmprunts());
	}
	
	@Test
	public void constructeurTest2() throws OperationImpossible {
		DocumentNonAbstract d = new DocumentNonAbstract("01", null, "Titre", "Auteur", "2017", new Genre("Genre"));
	}
	
	@Test
	public void metEmpruntableTest1() throws InvariantBroken, OperationImpossible {
		d.metEmpruntable();
		assertEquals(true,d.estEmpruntable());
	}
	
	@Test
	public void metEmpruntableTest2() throws InvariantBroken, OperationImpossible {
		d.metEmpruntable(); 
		d.metEmpruntable(); //document is already empruntable
	}
	
	@Test
	public void metConsultableTest1() throws InvariantBroken, OperationImpossible {
		d.metEmpruntable();
		d.metConsultable();
		assertEquals(false,d.estEmpruntable());
	}
	
	@Test
	public void metConsultableTest2() throws InvariantBroken, OperationImpossible {
		d.metEmpruntable();
		d.emprunter();
		d.metConsultable();
	}
	
	@Test
	public void emprunteTest() throws InvariantBroken, OperationImpossible {
		d.metEmpruntable();
		d.emprunter();
		assertEquals(true,d.estEmpruntable());
		assertEquals(true,d.estEmprunte());
	}
	
	@Test
	public void incrementEmprunteTest() throws InvariantBroken, OperationImpossible {
		//check it's empruntable
		d.metEmpruntable();
		assertEquals(true,d.estEmpruntable());
		nb_before = d.getNbEmprunts();
		//check it's emprunted
		d.emprunter();
		nb_after = d.getNbEmprunts();
		assertEquals(true,d.estEmprunte());
		//check incrementation
		assertEquals(nb_after,nb_before+1);
	}
	
	@Test
	public void restituerTest1() throws InvariantBroken, OperationImpossible {
		d.metEmpruntable();
		d.emprunter();
		d.restituer();	
	}
	
	@Test
	public void restituerTest2() throws InvariantBroken, OperationImpossible {
		d.restituer();	
	}
	
	@Test
	public void invariantTest(){
		d.invariant();
	}
	
	@Test
	public void empruntableTestFail() throws InvariantBroken, OperationImpossible {
		assertEquals(false,d.estEmpruntable());
		assertEquals(false,d.estEmprunte());
	}
	
	@Test
	public void emprunteTestFail1() throws InvariantBroken, OperationImpossible {
		//must be Empruntable first before we can emprunt it
		d.emprunter();
	}
	
	@Test
	public void emprunteTestFail2() throws InvariantBroken, OperationImpossible {
		d.metEmpruntable();
		d.emprunter();
		assertEquals(true,d.estEmprunte());
		//can't be borrowed twice
		d.emprunter();
	}
	
	@Test
	public void consultableTestFail() throws InvariantBroken, OperationImpossible {
		//already consultable (should set metEmpruntable then metConsultable)
		d.metConsultable();
	}
	
	@Test
	public void restituerTestFail() throws InvariantBroken, OperationImpossible {
		d.metEmpruntable();
		//doit être emprunté avant d'être restitué
		d.restituer();	
	}
	
	@Test
	public void invariantTestFail() throws OperationImpossible, InvariantBroken {
		d.metEmpruntable();
		d.invariant();
	}
}
