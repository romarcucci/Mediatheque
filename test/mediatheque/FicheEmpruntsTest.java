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
	Client c = null;
	CategorieClient cc = null;
	Document d = null;
	
	@Before
	public void setUp() throws OperationImpossible, InvariantBroken {
		Mediatheque m = new Mediatheque("Mediatheque");
		cc = new CategorieClient("Normal Rate", 5, 0, 1, 1, false);
		c = new Client("Nom", "Prenom","Adresse", cc);
		d = new Livre("01", new Localisation("Salle", "Rayon"), "Titre", "Auteur", "2017", new Genre("Genre"), 200);
		m.saveToFile();
		d.metEmpruntable();
		f = new FicheEmprunt(m,c,d);
	}

	@Test
	public void constructeurTest() {
		assertNotNull(f);
		assertEquals(c,f.getClient());
		assertEquals(d,f.getDocument());
		assertTrue(f.getDateEmprunt().equals(Datutil.dateDuJour()));
	}

	@Test
	public void verifierTest1() throws OperationImpossible {
		Datutil.addAuJour(365);
		assertEquals(false,f.getDepasse());
		f.verifier(); //should verifier() first to have depasse true
		assertEquals(true,f.getDepasse());
	}
	
	@Test
	public void verifierTest2() throws OperationImpossible {
		Datutil.addAuJour(365);
		assertEquals(false,f.getDepasse());
		f.verifier(); //should verifier() first to have depasse true
		assertEquals(true,f.getDepasse());
		f.verifier();
	}

	@Test
	public void modifierClientTest() throws OperationImpossible {
		CategorieClient cc = new CategorieClient("Normal Rate", 5, 0, 1, 1, false);
		Client c = new Client("Nouveau Nom", "Nouveau Prenom","Nouvelle Adresse", cc);
		f.modifierClient(c);
		assertTrue(f.getClient().getNom().equals("Nouveau Nom"));
		assertTrue(f.getClient().getPrenom().equals("Nouveau Prenom"));
		assertTrue(f.getClient().getAdresse().equals("Nouvelle Adresse"));
	}

	@Test
	public void correspondTest() throws OperationImpossible, InvariantBroken {
		CategorieClient new_cc = new CategorieClient("Subscriber", 10, 50, 2, 2, false);
		Client new_c = new Client("Nouveau Nom", "Nouveau Prenom","Nouvelle Adresse", new_cc);
		Document new_d = new Livre("02", new Localisation("Salle", "Rayon"), "Nouveau Titre", "Nouvel Auteur", "2018", new Genre("Nouveau Genre"), 500);
		assertEquals(c,f.getClient());
		assertEquals(d,f.getDocument());
		assertTrue(f.correspond(c, d));
		assertFalse(f.correspond(new_c, new_d));
		assertFalse(f.correspond(c, new_d));	
		assertFalse(f.correspond(new_c, d));	
	}

	@Test
	public void restituerTest() throws InvariantBroken, OperationImpossible {
		assertEquals(true,d.estEmprunte());
		f.restituer();
		assertEquals(false,d.estEmprunte());
	}

	@Test
	public void changementCategorieTest1() throws OperationImpossible {
		cc.modifierNom("Subscriber");
		cc.modifierMax(10);
		cc.modifierCotisation(50);
		cc.modifierCoefDuree(2);
		cc.modifierCoefTarif(2);
		cc.modifierCodeReducActif(false);
		assertFalse(f.getDepasse());
		assertEquals(false,f.changementCategorie());
	}
	
	@Test
	public void changementCategorieTest2() throws OperationImpossible {
		cc.modifierNom("Subscriber");
		cc.modifierMax(10);
		cc.modifierCotisation(50);
		cc.modifierCoefDuree(2);
		cc.modifierCoefTarif(2);
		cc.modifierCodeReducActif(false);
		Datutil.addAuJour(365);
		f.verifier();
		assertTrue(f.getDepasse());
		assertEquals(false,f.changementCategorie());
	}
}
