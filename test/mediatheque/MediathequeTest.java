package mediatheque;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import mediatheque.client.Client;
import mediatheque.document.Livre;
import util.InvariantBroken;

public class MediathequeTest {

	Mediatheque media = null;

	@Before
	public void setUp() throws Exception {
		media = new Mediatheque("media");
		media.saveToFile();
	}

	// @Test
	// public void testConstructeur() {
	// assertNotNull(media);
	// }
	//
	// @Test
	// public void testChercherGenre() throws OperationImpossible {
	// media.ajouterGenre("Genre");
	// Genre g = media.chercherGenre("Genre");
	// assertEquals(g, new Genre("Genre"));
	// }
	//
	// @Test
	// public void testChercherGenreFail() {
	// Genre g = media.chercherGenre("Genre");
	// assertEquals(g, null);
	// }
	//
	// @Test
	// public void testSupprimerGenre() throws OperationImpossible {
	// media.ajouterGenre("Genre");
	// media.supprimerGenre("Genre");
	// }
	//
	// @Test(expected = OperationImpossible.class)
	// public void testSupprimerGenreFail() throws OperationImpossible {
	// media.supprimerGenre("Genre");
	// }
	//
	// @Test(expected = OperationImpossible.class)
	// public void testSupprimerGenreNullFail() throws OperationImpossible {
	// media.supprimerGenre(null);
	// }
	//
	// @Test
	// public void testAjouterGenre() throws OperationImpossible {
	// media.ajouterGenre("Genre");
	// }
	//
	// @Test
	// public void testAjouterGenreFail() throws OperationImpossible {
	// media.ajouterGenre(null);
	// }
	//
	// @Test
	// public void testModifierGenre() throws OperationImpossible {
	// media.ajouterGenre("Genre");
	// media.modifierGenre("Genre", "Erneg");
	// }
	//
	// @Test(expected = OperationImpossible.class)
	// public void testModifierGenreFail() throws OperationImpossible {
	// media.modifierGenre("Genre", "Erneg");
	// }
	//
	// @Test
	// public void testSupprimerLocalisation() throws OperationImpossible {
	// media.ajouterLocalisation("salle", "rayon");
	// media.supprimerLocalisation("salle", "rayon");
	// }
	//
	// @Test(expected = OperationImpossible.class)
	// public void testSupprimerLocalisationFail() throws OperationImpossible {
	// media.supprimerLocalisation("salle", "rayon");
	// }
	//
	// @Test
	// public void testChercherLocalisation() throws OperationImpossible {
	// media.ajouterLocalisation("salle", "rayon");
	// Localisation l = media.chercherLocalisation("salle", "rayon");
	// assertEquals(l, new Localisation("salle", "rayon"));
	// }
	//
	// @Test
	// public void testChercherLocalisationFail() throws OperationImpossible {
	// assertNull(media.chercherLocalisation("salle", "rayon"));
	// }
	//
	// @Test
	// public void testAjouterLocalisation() throws OperationImpossible {
	// media.ajouterLocalisation("salle", "rayon");
	// Localisation l = media.chercherLocalisation("salle", "rayon");
	// assertEquals(l, new Localisation("salle", "rayon"));
	// }
	//
	// @Test(expected = OperationImpossible.class)
	// public void testAjouterLocalisationFail() throws OperationImpossible {
	// media.ajouterLocalisation("salle", "rayon");
	// media.ajouterLocalisation("salle", "rayon");
	// }
	//
	// @Test
	// public void testModifierLocalisation() throws OperationImpossible {
	// Localisation oldOne = new Localisation("salle", "rayon");
	// Localisation newOne = new Localisation("ellas", "noyar");
	// media.ajouterLocalisation("salle", "rayon");
	// media.modifierLocalisation(oldOne, "ellas", "noyar");
	// Localisation l = media.chercherLocalisation("ellas", "noyar");
	// assertEquals(newOne, l);
	// }
	//
	// @Test(expected = OperationImpossible.class)
	// public void testModifierLocalisationFail() throws Exception {
	// Localisation l = new Localisation("salle", "rayon");
	// media.modifierLocalisation(l, "ellas", "noyar");
	// }
	//
	// @Test
	// public void testChercherCatClient() throws OperationImpossible {
	// CategorieClient cc = new CategorieClient("romain", 0, 0, 0, 0, true);
	// media.ajouterCatClient("romain", 0, 0, 0, 0, true);
	// assertEquals(cc, media.chercherCatClient("romain"));
	// }
	//
	// @Test
	// public void testChercherCatClientFail() {
	// CategorieClient cc = media.chercherCatClient("romain");
	// assertNull(cc);
	// }
	//
	// @Test
	// public void testSupprimerCatClient() throws OperationImpossible {
	// media.ajouterCatClient("romain", 0, 0, 0, 0, true);
	// media.supprimerCatClient("romain");
	// }
	//
	// @Test(expected = OperationImpossible.class)
	// public void testSupprimerCatClientFail() throws OperationImpossible {
	// media.supprimerCatClient("romain");
	// }
	//
	// @Test
	// public void testAjouterCatClient() throws OperationImpossible {
	// media.ajouterCatClient("romain", 0, 0, 0, 0, true);
	// CategorieClient cc = new CategorieClient("romain");
	// assertEquals(cc, media.chercherCatClient("romain"));
	// }
	//
	// @Test(expected = OperationImpossible.class)
	// public void testAjouterCatClientFail() throws OperationImpossible {
	// media.ajouterCatClient("romain", 0, 0, 0, 0, true);
	// media.ajouterCatClient("romain", 0, 0, 0, 0, true);
	// }
	//
	// @Test
	// public void testModifierCatClient() throws OperationImpossible {
	// CategorieClient cc = new CategorieClient("romain", 0, 0, 0, 0, true);
	// media.ajouterCatClient("romain", 0, 0, 0, 0, true);
	// media.modifierCatClient(cc, "romain", 0, 0, 0, 0, true);
	// assertNotNull(media.chercherCatClient("romain"));
	// }
	//
	// @Test(expected = OperationImpossible.class)
	// public void testModifierCatClientFail() throws OperationImpossible {
	// CategorieClient cc = new CategorieClient("romain", 0, 0, 0, 0, true);
	// media.modifierCatClient(cc, "romain", 0, 0, 0, 0, true);
	// }
	//
	// @Test
	// public void testChercherDocument() throws OperationImpossible,
	// InvariantBroken {
	// Livre doc = new Livre("01", new Localisation("salle", "rayon"), "titre",
	// "auteur", "2017", new Genre("genre"),
	// 100);
	// media.ajouterGenre("genre");
	// media.ajouterLocalisation("salle", "rayon");
	// media.ajouterDocument(doc);
	// assertEquals(doc, media.chercherDocument("01"));
	// }
	//
	// @Test
	// public void testChercherDocumentFail() throws OperationImpossible,
	// InvariantBroken {
	// assertNull(media.chercherDocument("01"));
	// }
	//
	// @Test
	// public void testAjouterDocument() throws OperationImpossible,
	// InvariantBroken {
	// Livre doc = new Livre("01", new Localisation("salle", "rayon"), "titre",
	// "auteur", "2017", new Genre("genre"),
	// 100);
	// media.ajouterGenre("genre");
	// media.ajouterLocalisation("salle", "rayon");
	// media.ajouterDocument(doc);
	// assertNotNull(media.chercherDocument("01"));
	// }
	//
	// @Test(expected = OperationImpossible.class)
	// public void testAjouterDocumentExisteDejaFail() throws
	// OperationImpossible, InvariantBroken {
	// Livre doc = new Livre("01", new Localisation("salle", "rayon"), "titre",
	// "auteur", "2017", new Genre("genre"),
	// 100);
	// media.ajouterGenre("genre");
	// media.ajouterLocalisation("salle", "rayon");
	// media.ajouterDocument(doc);
	// media.ajouterDocument(doc);
	// }
	//
	// @Test(expected = OperationImpossible.class)
	// public void testAjouterDocumentLocalisationFail() throws
	// OperationImpossible, InvariantBroken {
	// Livre doc = new Livre("01", new Localisation("salle", "rayon"), "titre",
	// "auteur", "2017", new Genre("genre"),
	// 100);
	// media.ajouterGenre("genre");
	// media.ajouterDocument(doc);
	// }
	//
	// @Test(expected = OperationImpossible.class)
	// public void testAjouterDocumentGenreFail() throws OperationImpossible,
	// InvariantBroken {
	// Livre doc = new Livre("01", new Localisation("salle", "rayon"), "titre",
	// "auteur", "2017", new Genre("genre"),
	// 100);
	// media.ajouterLocalisation("salle", "rayon");
	// media.ajouterDocument(doc);
	// }
	//
	// @Test
	// public void testRetirerDocument() throws OperationImpossible,
	// InvariantBroken {
	// Livre doc = new Livre("01", new Localisation("salle", "rayon"), "titre",
	// "auteur", "2017", new Genre("genre"),
	// 100);
	// media.ajouterGenre("genre");
	// media.ajouterLocalisation("salle", "rayon");
	// media.ajouterDocument(doc);
	// assertNotNull(media.chercherDocument("01"));
	// media.retirerDocument("01");
	// assertNull(media.chercherDocument("01"));
	// }
	//
	// @Test(expected = OperationImpossible.class)
	// public void testRetirerDocumentFail() throws OperationImpossible,
	// InvariantBroken {
	// media.retirerDocument("01");
	// }
	//
	// @Test(expected = OperationImpossible.class)
	// public void testRetirerDocumentEmpruntFail() throws OperationImpossible,
	// InvariantBroken {
	// Livre doc = new Livre("01", new Localisation("salle", "rayon"), "titre",
	// "auteur", "2017", new Genre("genre"),
	// 100);
	// media.ajouterGenre("genre");
	// media.ajouterLocalisation("salle", "rayon");
	// media.ajouterDocument(doc);
	// assertNotNull(media.chercherDocument("01"));
	// media.emprunter("marcucci", "romain", "01");
	// media.retirerDocument("01");
	// }
	//
	// @Test
	// public void testMetEmpruntable() throws OperationImpossible,
	// InvariantBroken {
	// Livre doc = new Livre("01", new Localisation("salle", "rayon"), "titre",
	// "auteur", "2017", new Genre("genre"),
	// 100);
	// media.ajouterGenre("genre");
	// media.ajouterLocalisation("salle", "rayon");
	// media.ajouterDocument(doc);
	// assertNotNull(media.chercherDocument("01"));
	// media.metEmpruntable("01");
	// assertTrue(media.chercherDocument("01").estEmpruntable());
	// }
	//
	// @Test(expected = OperationImpossible.class)
	// public void testMetEmpruntableFail() throws OperationImpossible,
	// InvariantBroken {
	// media.metEmpruntable("01");
	// }
	//
	// @Test
	// public void testMetConsultable() throws OperationImpossible,
	// InvariantBroken {
	// Livre doc = new Livre("01", new Localisation("salle", "rayon"), "titre",
	// "auteur", "2017", new Genre("genre"),
	// 100);
	// media.ajouterGenre("genre");
	// media.ajouterLocalisation("salle", "rayon");
	// media.ajouterDocument(doc);
	// assertNotNull(media.chercherDocument("01"));
	// media.chercherDocument("01").metEmpruntable();
	// assertTrue(media.chercherDocument("01").estEmpruntable());
	// media.metConsultable("01");
	// assertFalse(media.chercherDocument("01").estEmpruntable());
	// }
	//
	// @Test(expected = OperationImpossible.class)
	// public void testMetConsultableFail() throws OperationImpossible,
	// InvariantBroken {
	// media.metConsultable("01");
	// }
	//
	// @Test
	// public void testEmprunter() throws OperationImpossible, InvariantBroken {
	// Livre doc = new Livre("01", new Localisation("salle", "rayon"), "titre",
	// "auteur", "2017", new Genre("genre"),
	// 100);
	// media.ajouterGenre("genre");
	// media.ajouterLocalisation("salle", "rayon");
	// doc.metEmpruntable();
	// media.ajouterDocument(doc);
	// assertNotNull(media.chercherDocument("01"));
	// media.ajouterCatClient("catcli", 10, 10, 10, 10, false);
	// media.inscrire("marcucci", "romain", "paris", "catcli");
	// assertFalse(media.getDocumentAt(0).estEmprunte());
	// media.emprunter("marcucci", "romain", "01");
	// assertTrue(media.getDocumentAt(0).estEmprunte());
	// }
	//
	// @Test(expected = OperationImpossible.class)
	// public void testEmprunterClientFail() throws OperationImpossible,
	// InvariantBroken {
	// media.emprunter("marcucci", "romain", "01");
	// }
	//
	// @Test(expected = OperationImpossible.class)
	// public void testEmprunterDocumentFail() throws OperationImpossible,
	// InvariantBroken {
	// media.ajouterCatClient("catcli", 10, 10, 10, 10, false);
	// media.inscrire("marcucci", "romain", "paris", "catcli");
	// media.emprunter("marcucci", "romain", "01");
	// }
	//
	// @Test(expected = OperationImpossible.class)
	// public void testEmprunterDoubleEmpruntFail() throws OperationImpossible,
	// InvariantBroken {
	// Livre doc = new Livre("01", new Localisation("salle", "rayon"), "titre",
	// "auteur", "2017", new Genre("genre"),
	// 100);
	// media.ajouterCatClient("catcli", 10, 10, 10, 10, false);
	// media.inscrire("marcucci", "romain", "paris", "catcli");
	// media.ajouterGenre("genre");
	// media.ajouterLocalisation("salle", "rayon");
	// doc.metEmpruntable();
	// media.ajouterDocument(doc);
	// media.emprunter("marcucci", "romain", "01");
	// media.emprunter("marcucci", "romain", "01");
	// }
	//
	// @Test(expected = OperationImpossible.class)
	// public void testEmprunterEmpruntableFail() throws OperationImpossible,
	// InvariantBroken {
	// Livre doc = new Livre("01", new Localisation("salle", "rayon"), "titre",
	// "auteur", "2017", new Genre("genre"),
	// 100);
	// media.ajouterCatClient("catcli", 10, 10, 10, 10, false);
	// media.inscrire("marcucci", "romain", "paris", "catcli");
	// media.ajouterGenre("genre");
	// media.ajouterLocalisation("salle", "rayon");
	// media.ajouterDocument(doc);
	// media.emprunter("marcucci", "romain", "01");
	// }
	//
	// @Test
	// public void testRestituer() throws OperationImpossible, InvariantBroken {
	// Livre doc = new Livre("01", new Localisation("salle", "rayon"), "titre",
	// "auteur", "2017", new Genre("genre"),
	// 100);
	// media.ajouterCatClient("catcli", 10, 10, 10, 10, false);
	// media.inscrire("marcucci", "romain", "paris", "catcli");
	// media.ajouterGenre("genre");
	// media.ajouterLocalisation("salle", "rayon");
	// doc.metEmpruntable();
	// media.ajouterDocument(doc);
	// media.emprunter("marcucci", "romain", "01");
	//
	// assertTrue(media.getDocumentAt(0).estEmprunte());
	// media.restituer("marcucci", "romain", "01");
	// assertFalse(media.getDocumentAt(0).estEmprunte());
	// }
	//
	// @Test(expected = OperationImpossible.class)
	// public void testRestituerClientFail() throws OperationImpossible,
	// InvariantBroken {
	// media.restituer("marcucci", "romain", "01");
	// }
	//
	// @Test(expected = OperationImpossible.class)
	// public void testRestituerDocumentFail() throws OperationImpossible,
	// InvariantBroken {
	// media.ajouterCatClient("catcli", 10, 100.0, 2.0, 2.0, false);
	// media.inscrire("marcucci", "romain", "paris", "catcli");
	//
	// media.restituer("marcucci", "romain", "01");
	// }
	//
	// @Test(expected = OperationImpossible.class)
	// public void testRestituerEmpruntableFail() throws OperationImpossible,
	// InvariantBroken {
	// Livre doc = new Livre("01", new Localisation("salle", "rayon"), "titre",
	// "auteur", "2017", new Genre("genre"),
	// 100);
	// media.ajouterCatClient("catcli", 10, 100.0, 2.0, 2.0, false);
	// media.inscrire("marcucci", "romain", "paris", "catcli");
	// media.ajouterGenre("genre");
	// media.ajouterLocalisation("salle", "rayon");
	// doc.metEmpruntable();
	// media.ajouterDocument(doc);
	// media.restituer("marcucci", "romain", "01");
	// }
	//
	// @Test
	// public void testVerifier() throws OperationImpossible, InvariantBroken {
	// Livre doc = new Livre("01", new Localisation("salle", "rayon"), "titre",
	// "auteur", "2017", new Genre("genre"),
	// 100);
	// media.ajouterCatClient("catcli", 10, 10, 10, 10, false);
	// media.inscrire("marcucci", "romain", "paris", "catcli");
	//
	// media.ajouterGenre("genre");
	// media.ajouterLocalisation("salle", "rayon");
	// doc.metEmpruntable();
	// media.ajouterDocument(doc);
	// media.emprunter("marcucci", "romain", "01");
	//
	// assertFalse(media.getFicheEmpruntAt(0).getDepasse());
	// media.verifier();
	// assertFalse(media.getFicheEmpruntAt(0).getDepasse());
	// }
	//
	// @Test
	// public void testInscrire() throws OperationImpossible {
	// media.ajouterCatClient("catcli", 10, 10, 10, 10, false);
	// int codeReduction = 10;
	// assertNull(media.chercherClient("marcucci", "romain"));
	// media.inscrire("marcucci", "romain", "paris", "catcli");
	// assertNotNull("Le client devrait exister",
	// media.chercherClient("marcucci", "romain"));
	// assertNull(media.chercherClient("iccucram", "niamor"));
	// media.inscrire("iccucram", "niamor", "paris", "catcli", codeReduction);
	// assertNotNull("Le client devrait exister",
	// media.chercherClient("iccucram", "niamor"));
	// }
	//
	// @Test(expected = OperationImpossible.class)
	// public void testInscrireCatClientFail() throws OperationImpossible {
	// media.inscrire("marcucci", "romain", "paris", "catcli");
	// }
	//
	// @Test(expected = OperationImpossible.class)
	// public void testinscrireCatClientReducFail() throws OperationImpossible {
	// int codeReduction = 10;
	// media.inscrire("marccucci", "romain", "paris", "catcli", codeReduction);
	// }
	//
	// @Test
	// public void testResilier() throws OperationImpossible, InvariantBroken {
	// media.ajouterCatClient("catcli", 10, 10, 10, 10, false);
	// media.inscrire("marcucci", "romain", "paris", "catcli");
	//
	// assertNotNull(media.chercherClient("marcucci", "romain"));
	// media.resilier("marcucci", "romain");
	// assertNull(media.chercherClient("marcucci", "romain"));
	// }
	//
	// @Test(expected = OperationImpossible.class)
	// public void testResilierClientFail() throws OperationImpossible {
	// media.resilier("marcucci", "romain");
	// }
	//
	// @Test(expected = OperationImpossible.class)
	// public void testResilierEmpruntFail() throws OperationImpossible,
	// InvariantBroken {
	// Livre doc = new Livre("01", new Localisation("salle", "rayon"), "titre",
	// "auteur", "2017", new Genre("genre"),
	// 100);
	// media.ajouterCatClient("catcli", 10, 10, 10, 10, false);
	// media.inscrire("marcucci", "romain", "paris", "catcli");
	// media.ajouterGenre("genre");
	// media.ajouterLocalisation("salle", "rayon");
	// doc.metEmpruntable();
	// media.ajouterDocument(doc);
	// media.emprunter("marcucci", "romain", "01");
	// media.resilier("marcucci", "romain");
	// }
	//
	// @Test
	// public void testModifierClient() throws OperationImpossible {
	// media.ajouterCatClient("catcli", 10, 10, 10, 10, false);
	// media.inscrire("marcucci", "romain", "paris", "catcli");
	// int codeReduction = 10;
	//
	// assertNull(media.chercherClient("iccucram", "niamor"));
	// media.modifierClient(media.chercherClient("marcucci", "romain"),
	// "iccucram", "niamor", "paris", "catcli",
	// codeReduction);
	// assertNotNull(media.chercherClient("iccucram", "niamor"));
	// }
	//
	// @Test(expected = OperationImpossible.class)
	// public void testModifierClientFail() throws OperationImpossible {
	// int codeReduction = 10;
	// media.modifierClient(new Client("marcucci", "romain"), "iccucram",
	// "niamor", "paris", "catcli", codeReduction);
	// }

	@Test
	public void testChangerCategorie() throws OperationImpossible {
		int codeReduction = 10;
		media.ajouterCatClient("catcli", 10, 100.0, 2.0, 2.0, false);
		media.ajouterCatClient("clicat", 10, 100.0, 2.0, 2.0, false);
		media.inscrire("marcucci", "romain", "paris", "catcli");

		assertEquals("catcli", media.chercherClient("marcucci", "romain").getCategorie().getNom());
		media.changerCategorie("marcucci", "romain", "clicat", codeReduction);
		assertEquals("clicat", media.chercherClient("marcucci", "romain").getCategorie().getNom());
	}
//
//	@Test(expected = OperationImpossible.class)
//	public void testChangerCategorieClientFail() throws OperationImpossible {
//		int codeReduction = 10;
//		media.changerCategorie("marcucci", "romain", "catcli", codeReduction);
//	}
//
//	@Test(expected = OperationImpossible.class)
//	public void testChangerCategorieFail() throws OperationImpossible {
//		int codeReduction = 10;
//		media.ajouterCatClient("catcli", 10, 10, 10, 10, false);
//		media.inscrire("marcucci", "romain", "paris", "catcli");
//
//		media.changerCategorie("marcucci", "romain", "clicat", codeReduction);
//	}

	// @Test
	// public void testChangerCOdeReduction() {
	//
	// }
	//
	// @Test
	// public void testChercherClient() {
	//
	// }
	//
	// @Test
	// public void testListerClients() {
	//
	// }
	//
	// @Test
	// public void testExisteClient() {
	//
	// }
	//
	// @Test
	// public void testInitFromFile() {
	//
	// }
	//
	// @Test
	// public void testSaveToFile() {
	//
	// }

}
