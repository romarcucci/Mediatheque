package mediatheque;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import mediatheque.client.CategorieClient;
import mediatheque.client.Client;
import mediatheque.document.Audio;
import util.InvariantBroken;

public class MediathequeTest {

	Mediatheque media = null;

	@Before
	public void setUp() throws Exception {
		media = new Mediatheque("media");
		media.saveToFile();
	}

	@Test
	public void testConstructeur() {
		assertNotNull(media);
	}

	@Test
	public void testChercherGenre() throws OperationImpossible {
		media.ajouterGenre("genre");
		assertEquals(media.chercherGenre("genre"), new Genre("genre"));
	}

	@Test
	public void testChercherGenreFail() {
		assertEquals(media.chercherGenre("genre"), null);
	}

	@Test
	public void testSupprimerGenre() throws OperationImpossible {
		media.ajouterGenre("genre");
		media.supprimerGenre("genre");
	}

	@Test(expected = OperationImpossible.class)
	public void testSupprimerGenreFail() throws OperationImpossible {
		media.supprimerGenre("genre");
	}

	@Test(expected = OperationImpossible.class)
	public void testSupprimerGenreNullFail() throws OperationImpossible {
		media.supprimerGenre(null);
	}

	@Test
	public void testAjouterGenre() throws OperationImpossible {
		media.ajouterGenre("genre");
	}

	@Test
	public void testAjouterGenreFail() throws OperationImpossible {
		media.ajouterGenre(null);
	}

	@Test
	public void testModifierGenre() throws OperationImpossible {
		media.ajouterGenre("genre");
		media.modifierGenre("genre", "Erneg");
	}

	@Test(expected = OperationImpossible.class)
	public void testModifierGenreFail() throws OperationImpossible {
		media.modifierGenre("genre", "Erneg");
	}

	@Test
	public void testSupprimerLocalisation() throws OperationImpossible {
		media.ajouterLocalisation("salle", "rayon");
		media.supprimerLocalisation("salle", "rayon");
	}

	@Test(expected = OperationImpossible.class)
	public void testSupprimerLocalisationFail() throws OperationImpossible {
		media.supprimerLocalisation("salle", "rayon");
	}

	@Test
	public void testChercherLocalisation() throws OperationImpossible {
		media.ajouterLocalisation("salle", "rayon");
		assertEquals(media.chercherLocalisation("salle", "rayon"), new Localisation("salle", "rayon"));
	}

	@Test
	public void testChercherLocalisationFail() throws OperationImpossible {
		assertNull(media.chercherLocalisation("salle", "rayon"));
	}

	@Test
	public void testAjouterLocalisation() throws OperationImpossible {
		media.ajouterLocalisation("salle", "rayon");
		assertEquals(media.chercherLocalisation("salle", "rayon"), new Localisation("salle", "rayon"));
	}

	@Test(expected = OperationImpossible.class)
	public void testAjouterLocalisationFail() throws OperationImpossible {
		media.ajouterLocalisation("salle", "rayon");
		media.ajouterLocalisation("salle", "rayon");
	}

	@Test
	public void testModifierLocalisation() throws OperationImpossible {
		media.ajouterLocalisation("salle", "rayon");
		media.modifierLocalisation(new Localisation("salle", "rayon"), "ellas", "noyar");
		Localisation l = media.chercherLocalisation("ellas", "noyar");
		assertEquals(new Localisation("ellas", "noyar"), l);
	}

	@Test(expected = OperationImpossible.class)
	public void testModifierLocalisationFail() throws Exception {
		media.modifierLocalisation(new Localisation("salle", "rayon"), "ellas", "noyar");
	}

	@Test
	public void testChercherCatClient() throws OperationImpossible {
		media.ajouterCatClient("romain", 0, 0, 0, 0, true);
		assertEquals(new CategorieClient("romain", 0, 0, 0, 0, true), media.chercherCatClient("romain"));
	}

	@Test
	public void testChercherCatClientFail() {
		assertNull(media.chercherCatClient("romain"));
	}

	@Test
	public void testSupprimerCatClient() throws OperationImpossible {
		media.ajouterCatClient("romain", 0, 0, 0, 0, true);
		media.supprimerCatClient("romain");
	}

	@Test(expected = OperationImpossible.class)
	public void testSupprimerCatClientFail() throws OperationImpossible {
		media.supprimerCatClient("romain");
	}

	@Test
	public void testAjouterCatClient() throws OperationImpossible {
		media.ajouterCatClient("romain", 0, 0, 0, 0, true);
		assertEquals(new CategorieClient("romain"), media.chercherCatClient("romain"));
	}

	@Test(expected = OperationImpossible.class)
	public void testAjouterCatClientFail() throws OperationImpossible {
		media.ajouterCatClient("romain", 0, 0, 0, 0, true);
		media.ajouterCatClient("romain", 0, 0, 0, 0, true);
	}

	@Test
	public void testModifierCatClient() throws OperationImpossible {
		media.ajouterCatClient("romain", 0, 0, 0, 0, true);
		media.modifierCatClient(new CategorieClient("romain", 0, 0, 0, 0, true), "romain", 0, 0, 0, 0, true);
		assertNotNull(media.chercherCatClient("romain"));
	}

	@Test(expected = OperationImpossible.class)
	public void testModifierCatClientFail() throws OperationImpossible {
		media.modifierCatClient(new CategorieClient("romain", 0, 0, 0, 0, true), "romain", 0, 0, 0, 0, true);
	}

	@Test
	public void testChercherDocument() throws OperationImpossible, InvariantBroken {
		Audio doc = new Audio("01", new Localisation("salle", "rayon"), "titre", "auteur", "2017", new Genre("genre"),
				"R");
		media.ajouterGenre("genre");
		media.ajouterLocalisation("salle", "rayon");
		media.ajouterDocument(doc);
		assertEquals(doc, media.chercherDocument("01"));
	}

	@Test
	public void testChercherDocumentFail() throws OperationImpossible, InvariantBroken {
		assertNull(media.chercherDocument("01"));
	}

	@Test
	public void testAjouterDocument() throws OperationImpossible, InvariantBroken {
		Audio doc = new Audio("01", new Localisation("salle", "rayon"), "titre", "auteur", "2017", new Genre("genre"),
				"R");
		media.ajouterGenre("genre");
		media.ajouterLocalisation("salle", "rayon");
		media.ajouterDocument(doc);
		assertNotNull(media.chercherDocument("01"));
	}

	@Test(expected = OperationImpossible.class)
	public void testAjouterDocumentExisteDejaFail() throws OperationImpossible, InvariantBroken {
		Audio doc = new Audio("01", new Localisation("salle", "rayon"), "titre", "auteur", "2017", new Genre("genre"),
				"R");
		media.ajouterGenre("genre");
		media.ajouterLocalisation("salle", "rayon");
		media.ajouterDocument(doc);
		media.ajouterDocument(doc);
	}

	@Test(expected = OperationImpossible.class)
	public void testAjouterDocumentLocalisationFail() throws OperationImpossible, InvariantBroken {
		Audio doc = new Audio("01", new Localisation("salle", "rayon"), "titre", "auteur", "2017", new Genre("genre"),
				"R");
		media.ajouterGenre("genre");
		media.ajouterDocument(doc);
	}

	@Test(expected = OperationImpossible.class)
	public void testAjouterDocumentGenreFail() throws OperationImpossible, InvariantBroken {
		Audio doc = new Audio("01", new Localisation("salle", "rayon"), "titre", "auteur", "2017", new Genre("genre"),
				"R");
		media.ajouterLocalisation("salle", "rayon");
		media.ajouterDocument(doc);
	}

	@Test
	public void testRetirerDocument() throws OperationImpossible, InvariantBroken {
		Audio doc = new Audio("01", new Localisation("salle", "rayon"), "titre", "auteur", "2017", new Genre("genre"),
				"R");
		media.ajouterGenre("genre");
		media.ajouterLocalisation("salle", "rayon");
		media.ajouterDocument(doc);
		assertNotNull(media.chercherDocument("01"));
		media.retirerDocument("01");
		assertNull(media.chercherDocument("01"));
	}

	@Test(expected = OperationImpossible.class)
	public void testRetirerDocumentFail() throws OperationImpossible, InvariantBroken {
		media.retirerDocument("01");
	}

	@Test(expected = OperationImpossible.class)
	public void testRetirerDocumentEmpruntFail() throws OperationImpossible, InvariantBroken {
		Audio doc = new Audio("01", new Localisation("salle", "rayon"), "titre", "auteur", "2017", new Genre("genre"),
				"R");
		media.ajouterGenre("genre");
		media.ajouterLocalisation("salle", "rayon");
		media.ajouterDocument(doc);
		assertNotNull(media.chercherDocument("01"));
		media.emprunter("marcucci", "romain", "01");
		media.retirerDocument("01");
	}

	@Test
	public void testMetEmpruntable() throws OperationImpossible, InvariantBroken {
		Audio doc = new Audio("01", new Localisation("salle", "rayon"), "titre", "auteur", "2017", new Genre("genre"),
				"R");
		media.ajouterGenre("genre");
		media.ajouterLocalisation("salle", "rayon");
		media.ajouterDocument(doc);
		assertNotNull(media.chercherDocument("01"));
		media.metEmpruntable("01");
		assertTrue(media.chercherDocument("01").estEmpruntable());
	}

	@Test(expected = OperationImpossible.class)
	public void testMetEmpruntableFail() throws OperationImpossible, InvariantBroken {
		media.metEmpruntable("01");
	}

	@Test
	public void testMetConsultable() throws OperationImpossible, InvariantBroken {
		Audio doc = new Audio("01", new Localisation("salle", "rayon"), "titre", "auteur", "2017", new Genre("genre"),
				"R");
		media.ajouterGenre("genre");
		media.ajouterLocalisation("salle", "rayon");
		media.ajouterDocument(doc);
		assertNotNull(media.chercherDocument("01"));
		media.chercherDocument("01").metEmpruntable();
		assertTrue(media.chercherDocument("01").estEmpruntable());
		media.metConsultable("01");
		assertFalse(media.chercherDocument("01").estEmpruntable());
	}

	@Test(expected = OperationImpossible.class)
	public void testMetConsultableFail() throws OperationImpossible, InvariantBroken {
		media.metConsultable("01");
	}

	@Test
	public void testEmprunter() throws OperationImpossible, InvariantBroken {
		Audio doc = new Audio("01", new Localisation("salle", "rayon"), "titre", "auteur", "2017", new Genre("genre"),
				"R");
		media.ajouterGenre("genre");
		media.ajouterLocalisation("salle", "rayon");
		doc.metEmpruntable();
		media.ajouterDocument(doc);
		assertNotNull(media.chercherDocument("01"));
		media.ajouterCatClient("catcli", 10, 10, 10, 10, false);
		media.inscrire("marcucci", "romain", "paris", "catcli");
		assertFalse(media.getDocumentAt(0).estEmprunte());
		media.emprunter("marcucci", "romain", "01");
		assertTrue(media.getDocumentAt(0).estEmprunte());
	}

	@Test(expected = OperationImpossible.class)
	public void testEmprunterClientFail() throws OperationImpossible, InvariantBroken {
		media.emprunter("marcucci", "romain", "01");
	}

	@Test(expected = OperationImpossible.class)
	public void testEmprunterDocumentFail() throws OperationImpossible, InvariantBroken {
		media.ajouterCatClient("catcli", 10, 10, 10, 10, false);
		media.inscrire("marcucci", "romain", "paris", "catcli");
		media.emprunter("marcucci", "romain", "01");
	}

	@Test(expected = OperationImpossible.class)
	public void testEmprunterDoubleEmpruntFail() throws OperationImpossible, InvariantBroken {
		Audio doc = new Audio("01", new Localisation("salle", "rayon"), "titre", "auteur", "2017", new Genre("genre"),
				"R");
		media.ajouterCatClient("catcli", 10, 10, 10, 10, false);
		media.inscrire("marcucci", "romain", "paris", "catcli");
		media.ajouterGenre("genre");
		media.ajouterLocalisation("salle", "rayon");
		doc.metEmpruntable();
		media.ajouterDocument(doc);
		media.emprunter("marcucci", "romain", "01");
		media.emprunter("marcucci", "romain", "01");
	}

	@Test(expected = OperationImpossible.class)
	public void testEmprunterEmpruntableFail() throws OperationImpossible, InvariantBroken {
		Audio doc = new Audio("01", new Localisation("salle", "rayon"), "titre", "auteur", "2017", new Genre("genre"),
				"R");
		media.ajouterCatClient("catcli", 10, 10, 10, 10, false);
		media.inscrire("marcucci", "romain", "paris", "catcli");
		media.ajouterGenre("genre");
		media.ajouterLocalisation("salle", "rayon");
		media.ajouterDocument(doc);
		media.emprunter("marcucci", "romain", "01");
	}

	@Test
	public void testRestituer() throws OperationImpossible, InvariantBroken {
		Audio doc = new Audio("01", new Localisation("salle", "rayon"), "titre", "auteur", "2017", new Genre("genre"),
				"R");
		media.ajouterCatClient("catcli", 10, 10, 10, 10, false);
		media.inscrire("marcucci", "romain", "paris", "catcli");
		media.ajouterGenre("genre");
		media.ajouterLocalisation("salle", "rayon");
		doc.metEmpruntable();
		media.ajouterDocument(doc);
		media.emprunter("marcucci", "romain", "01");

		assertTrue(media.getDocumentAt(0).estEmprunte());
		media.restituer("marcucci", "romain", "01");
		assertFalse(media.getDocumentAt(0).estEmprunte());
	}

	@Test(expected = OperationImpossible.class)
	public void testRestituerClientFail() throws OperationImpossible, InvariantBroken {
		media.restituer("marcucci", "romain", "01");
	}

	@Test(expected = OperationImpossible.class)
	public void testRestituerDocumentFail() throws OperationImpossible, InvariantBroken {
		media.ajouterCatClient("catcli", 10, 10, 10, 10, false);
		media.inscrire("marcucci", "romain", "paris", "catcli");

		media.restituer("marcucci", "romain", "01");
	}

	@Test(expected = OperationImpossible.class)
	public void testRestituerEmpruntableFail() throws OperationImpossible, InvariantBroken {
		Audio doc = new Audio("01", new Localisation("salle", "rayon"), "titre", "auteur", "2017", new Genre("genre"),
				"R");
		media.ajouterCatClient("catcli", 10, 10, 10, 10, false);
		media.inscrire("marcucci", "romain", "paris", "catcli");
		media.ajouterGenre("genre");
		media.ajouterLocalisation("salle", "rayon");
		doc.metEmpruntable();
		media.ajouterDocument(doc);
		media.restituer("marcucci", "romain", "01");
	}

	@Test
	public void testVerifier() throws OperationImpossible, InvariantBroken {
		Audio doc = new Audio("01", new Localisation("salle", "rayon"), "titre", "auteur", "2017", new Genre("genre"),
				"R");
		media.ajouterCatClient("catcli", 10, 10, 10, 10, false);
		media.inscrire("marcucci", "romain", "paris", "catcli");

		media.ajouterGenre("genre");
		media.ajouterLocalisation("salle", "rayon");
		doc.metEmpruntable();
		media.ajouterDocument(doc);
		media.emprunter("marcucci", "romain", "01");

		assertFalse(media.getFicheEmpruntAt(0).getDepasse());
		media.verifier();
		assertFalse(media.getFicheEmpruntAt(0).getDepasse());
	}

	@Test
	public void testInscrire() throws OperationImpossible {
		media.ajouterCatClient("catcli", 10, 10, 10, 10, false);
		assertNull(media.chercherClient("marcucci", "romain"));
		media.inscrire("marcucci", "romain", "paris", "catcli");
		assertNotNull("Le client devrait exister", media.chercherClient("marcucci", "romain"));
		assertNull(media.chercherClient("iccucram", "niamor"));
		media.inscrire("iccucram", "niamor", "paris", "catcli", 10);
		assertNotNull("Le client devrait exister", media.chercherClient("iccucram", "niamor"));
	}

	@Test(expected = OperationImpossible.class)
	public void testInscrireCatClientFail() throws OperationImpossible {
		media.inscrire("marcucci", "romain", "paris", "catcli");
	}

	@Test(expected = OperationImpossible.class)
	public void testinscrireCatClientReducFail() throws OperationImpossible {
		media.inscrire("marccucci", "romain", "paris", "catcli", 10);
	}

	@Test
	public void testResilier() throws OperationImpossible, InvariantBroken {
		media.ajouterCatClient("catcli", 10, 10, 10, 10, false);
		media.inscrire("marcucci", "romain", "paris", "catcli");

		assertNotNull(media.chercherClient("marcucci", "romain"));
		media.resilier("marcucci", "romain");
		assertNull(media.chercherClient("marcucci", "romain"));
	}

	@Test(expected = OperationImpossible.class)
	public void testResilierClientFail() throws OperationImpossible {
		media.resilier("marcucci", "romain");
	}

	@Test(expected = OperationImpossible.class)
	public void testResilierEmpruntFail() throws OperationImpossible, InvariantBroken {
		Audio doc = new Audio("01", new Localisation("salle", "rayon"), "titre", "auteur", "2017", new Genre("genre"),
				"R");
		media.ajouterCatClient("catcli", 10, 10, 10, 10, false);
		media.inscrire("marcucci", "romain", "paris", "catcli");
		media.ajouterGenre("genre");
		media.ajouterLocalisation("salle", "rayon");
		doc.metEmpruntable();
		media.ajouterDocument(doc);
		media.emprunter("marcucci", "romain", "01");
		media.resilier("marcucci", "romain");
	}

	@Test
	public void testModifierClient() throws OperationImpossible {
		media.ajouterCatClient("catcli", 10, 10, 10, 10, false);
		media.inscrire("marcucci", "romain", "paris", "catcli");

		assertNull(media.chercherClient("iccucram", "niamor"));
		media.modifierClient(media.chercherClient("marcucci", "romain"), "iccucram", "niamor", "paris", "catcli", 10);
		assertNotNull(media.chercherClient("iccucram", "niamor"));
	}

	@Test(expected = OperationImpossible.class)
	public void testModifierClientFail() throws OperationImpossible {
		media.modifierClient(new Client("marcucci", "romain"), "iccucram", "niamor", "paris", "catcli", 10);
	}

	@Test
	public void testChangerCategorie() throws OperationImpossible {
		media.ajouterCatClient("catcli", 10, 10, 10, 10, false);
		media.ajouterCatClient("clicat", 10, 10, 10, 10, false);
		media.inscrire("marcucci", "romain", "paris", "catcli");
		assertEquals("catcli", media.chercherClient("marcucci", "romain").getCategorie().getNom());
		media.changerCategorie("marcucci", "romain", "clicat", 10);
		assertEquals("clicat", media.chercherClient("marcucci", "romain").getCategorie().getNom());
	}

	@Test(expected = OperationImpossible.class)
	public void testChangerCategorieClientFail() throws OperationImpossible {
		media.changerCategorie("marcucci", "romain", "catcli", 10);
	}

	@Test(expected = OperationImpossible.class)
	public void testChangerCategorieFail() throws OperationImpossible {
		media.ajouterCatClient("catcli", 10, 10, 10, 10, false);
		media.inscrire("marcucci", "romain", "paris", "catcli");
		media.changerCategorie("marcucci", "romain", "clicat", 10);
	}

	@Test
	public void testChangerCodeReduction() throws OperationImpossible {
		media.ajouterCatClient("catcli", 10, 10, 10, 10, true);
		media.inscrire("marcucci", "romain", "paris", "catcli", 10);
		assertEquals(10, media.chercherClient("marcucci", "romain").getReduc());
		media.changerCodeReduction("marcucci", "romain", 20);
		assertEquals(20, media.chercherClient("marcucci", "romain").getReduc());
	}

	@Test(expected = OperationImpossible.class)
	public void testChangerCodeReductionClientFail() throws OperationImpossible {
		media.changerCodeReduction("marcucci", "romain", 20);
	}

	@Test(expected = OperationImpossible.class)
	public void testChangerCodeReductionCodeFail() throws OperationImpossible {
		media.ajouterCatClient("catcli", 10, 10, 10, 10, false);
		media.inscrire("marcucci", "romain", "paris", "catcli", 10);
		media.changerCodeReduction("marcucci", "romain", 20);
	}

	@Test
	public void testChercherClient() throws OperationImpossible {
		media.ajouterCatClient("catcli", 10, 10, 10, 10, false);
		assertNull(media.chercherClient("marcucci", "romain"));
		media.inscrire("marcucci", "romain", "paris", "catcli");
		assertNotNull(media.chercherClient("marcucci", "romain"));
	}

	@Test
	public void testExisteClient() throws OperationImpossible {
		media.ajouterCatClient("catcli", 10, 10, 10, 10, false);
		assertFalse(media.existeClient(media.chercherCatClient("catcli")));
		media.inscrire("marcucci", "romain", "paris", "catcli");
		assertTrue(media.existeClient(media.chercherCatClient("catcli")));
	}
}
