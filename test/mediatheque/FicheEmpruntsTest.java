package mediatheque;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mediatheque.client.CategorieClient;
import mediatheque.client.Client;
import mediatheque.document.Audio;
import mediatheque.document.Document;
import mediatheque.document.Livre;
import util.Datutil;
import util.InvariantBroken;

public class FicheEmpruntsTest {

	FicheEmprunt f = null;

	@Before
	public void setUp() throws OperationImpossible, InvariantBroken {
		
		Mediatheque m = new Mediatheque("Mediatheque");
		CategorieClient cc = new CategorieClient("Normal Rate", 5, 0, 1, 1, false);
		Client c = new Client("Nom", "Prenom","Adresse", cc);
		Document d = new Livre("01", new Localisation("Salle", "Rayon"), "Titre", "Auteur", "2017", new Genre("Genre"), 200);
		m.saveToFile();
		d.metEmpruntable();
		d.emprunter();
		f = new FicheEmprunt(m,c,d);
	}

	@Test
	public void constructeurTest() {
		assertTrue(f.getDateEmprunt() == Datutil.dateDuJour());
	}

	@Test
	public void verifierTest() {

	}

	@Test
	public void premierRappelTest() {

	}

	@Test
	public void relancerTest() {

	}

	@Test
	public void modifierClientTest() {

	}

	@Test
	public void correspondTest() {

	}

	@Test
	public void restituerTest() {

	}

	@Test
	public void changementCategorieTest() {

	}
}
