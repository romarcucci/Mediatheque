package mediatheque;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import mediatheque.client.CategorieClient;
import mediatheque.document.Audio;
import mediatheque.document.Document;
import util.InvariantBroken;

public class MediathequeTest {

	Mediatheque media = null;

	@Before
	public void setUp() throws Exception {
		media = new Mediatheque("media");
	}

	// @Test
	// public void testConstructeur() {
	// assertTrue(media != null);
	// }
	//
	// @Test
	// public void testChercherGenre() throws OperationImpossible {
	// media.ajouterGenre("Genre");
	// Genre g = media.chercherGenre("Genre");
	// assertTrue(g.equals(new Genre("Genre")));
	// }
	//
	// @Test
	// public void testChercherGenreFail() {
	// Genre g = media.chercherGenre("Genre");
	// assertTrue(g == null);
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
	// assertTrue(l.equals(new Localisation("salle", "rayon")));
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
	// assertTrue(l.equals(new Localisation("salle", "rayon")));
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
	// Localisation l = new Localisation("salle", "rayon");
	// media.ajouterLocalisation("salle", "rayon");
	// media.modifierLocalisation(l, "ellas", "noyar");
	// assertNotNull(media.chercherLocalisation("ellas", "noyar"));
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
	// assertTrue(cc.equals(media.chercherCatClient("romain")));
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
	// public void testSupprimerCatClientFail() throws OperationImpossible{
	// media.supprimerCatClient("romain");
	// }
	//
	//
	// @Test
	// public void testAjouterCatClient() throws OperationImpossible {
	// media.ajouterCatClient("romain", 0, 0, 0, 0, true);
	// CategorieClient cc = new CategorieClient("romain");
	// assertTrue(cc.equals(media.chercherCatClient("romain")));
	// }
	//
	// @Test(expected = OperationImpossible.class)
	// public void testAjouterCatClientFail() throws OperationImpossible {
	// media.ajouterCatClient("romain", 0, 0, 0, 0, true);
	// media.ajouterCatClient("romain", 0, 0, 0, 0, true);
	// }
	//
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
	// Localisation l = new Localisation("salle", "rayon");
	// Genre g = new Genre("Genre");
	// Audio doc = new Audio("01", l, "titre", "auteur", "2017", g, "class");
	// media.ajouterDocument(doc);
	// assertTrue(doc.equals(media.chercherDocument("01")));
	// }
	//
	// @Test
	// public void testChercherDocumentFail() throws OperationImpossible,
	// InvariantBroken{
	// assertNull(media.chercherDocument("01"));
	// }
	//
	// @Test
	// public void testAjouterDocument() throws OperationImpossible,
	// InvariantBroken {
	// Localisation l = new Localisation("salle", "rayon");
	// Genre g = new Genre("Genre");
	// Audio doc = new Audio("01", l, "titre", "auteur", "2017", g, "class");
	// media.ajouterDocument(doc);
	// assertTrue(doc.equals(media.chercherDocument("01")));
	// }
	//
	// @Test(expected = OperationImpossible.class)
	// public void testAjouterDocumentFail() throws OperationImpossible,
	// InvariantBroken{
	// Localisation l = new Localisation("salle", "rayon");
	// Genre g = new Genre("Genre");
	// Audio doc = new Audio("01", l, "titre", "auteur", "2017", g, "class");
	// media.ajouterDocument(doc);
	// media.ajouterDocument(doc);
	// }
//
//	@Test
//	public void testRetirerDocument() throws OperationImpossible, InvariantBroken {
//		Localisation l = new Localisation("salle", "rayon");
//		Genre g = new Genre("Genre");
//		Audio doc = new Audio("01", l, "titre", "auteur", "2017", g, "class");
//		media.ajouterDocument(doc);
//		media.retirerDocument("01");
//	}
//
//	@Test(expected = OperationImpossible.class)
//	public void testRetirerDocumentFail() throws OperationImpossible, InvariantBroken {
//		media.retirerDocument("01");
//	}
//
//	@Test(expected = OperationImpossible.class)
//	public void testRetirerDocumentEmpruntFail() throws OperationImpossible, InvariantBroken {
//		Localisation l = new Localisation("salle", "rayon");
//		Genre g = new Genre("Genre");
//		Audio doc = new Audio("01", l, "titre", "auteur", "2017", g, "class");
//		media.ajouterDocument(doc);
//		media.emprunter("marcucci", "romain", "01");
//		media.retirerDocument("01");
//	}
//

	@Test
	public void testMetEmpruntable() throws OperationImpossible, InvariantBroken{
		Localisation l = new Localisation("salle", "rayon");
		Genre g = new Genre("Genre");
		Document doc = new Audio("01", l, "titre", "auteur", "2017", g, "class");
		media.ajouterDocument(doc);
		media.metEmpruntable("01");
	}

	@Test(expected = OperationImpossible.class)
	 public void testMetEmpruntableFail() throws OperationImpossible, InvariantBroken {
		media.metEmpruntable("01");
	 }

	// @Test
	// public void testMetConsultable() {
	//
	// }
	//
	// @Test
	// public void testListerDocuments() {
	//
	// }
	//
	// @Test
	// public void testExisteDocument() {
	//
	// }
	//
	// @Test
	// public void testEmprunter() {
	//
	// }
	//
	// @Test
	// public void testRestituer() {
	//
	// }
	//
	// @Test
	// public void testVerifier() {
	//
	// }
	//
	// @Test
	// public void testListerFicheEmprunts() {
	//
	// }
	//
	// @Test
	// public void testInscrire() {
	//
	// }
	//
	// @Test
	// public void testResilier() {
	//
	// }
	//
	// @Test
	// public void testModifierCient() {
	//
	// }
	//
	// @Test
	// public void testChangerCategorie() {
	//
	// }
	//
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
