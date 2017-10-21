package mediatheque.document;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mediatheque.document.Document;
import mediatheque.Genre;
import mediatheque.Localisation;
import mediatheque.OperationImpossible;
import util.InvariantBroken;

public class DocumentTest {
	
	DocumentNonAbstract d = null;
	int nb_before = 0, nb_after = 0;
	
	@Before
	public void setUp() throws OperationImpossible, InvariantBroken {
		Localisation l = new Localisation("Salle", "Rayon");
        Genre g = new Genre("Genre");
        d = new DocumentNonAbstract("01", l, "Titre", "Auteur", "2017", g);
	}
	@Test
	public void testDocument() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testEmpruntable() throws InvariantBroken, OperationImpossible {
		d.metEmpruntable();
		assertEquals(true,d.estEmpruntable());
	}
	
	@Test
	public void testEmprunte() throws InvariantBroken, OperationImpossible {
		d.metEmpruntable();
		d.emprunter();
		assertEquals(true,d.estEmpruntable());
		assertEquals(true,d.estEmprunte());
	}
	
	@Test
	public void testConsultable() throws InvariantBroken, OperationImpossible {
		d.metEmpruntable();
		d.metConsultable();
		assertEquals(false,d.estEmpruntable());
	}
	
	@Test
	public void testIncrementEmprunte() throws InvariantBroken, OperationImpossible {
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
	public void testEmpruntableFail() throws InvariantBroken, OperationImpossible {
		assertEquals(false,d.estEmpruntable());
		assertEquals(false,d.estEmprunte());
	}
	
	@Test
	public void testEmprunteFail() throws InvariantBroken, OperationImpossible {
		//must be Empruntable first before we can emprunt it
		d.emprunter();
	}
	
	@Test
	public void testConsultableFail() throws InvariantBroken, OperationImpossible {
		//already consultable 
		d.metConsultable();
	}
	
	@Test
	public void testRestituer() {
		fail("Not yet implemented");
	}

	@Test
	public void testInvariant() {
		fail("Not yet implemented");
	}

}
