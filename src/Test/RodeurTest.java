package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Main.Rodeur;
import Main.Person;

class RodeurTest {

	private static Person persA;
	private static Person persB;
	private static int persBVieInit;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		persA =new Rodeur(10, 2, 2, 6);
		persB =new Rodeur(10, 1, 1, 8);
		persBVieInit = persB.getVie();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void Given_rodeur_When_attaqueBasique_Then_checkLife() {
		//PersA attaque persB
		persA.attaqueBasique(persB);
		assertEquals(persBVieInit-persA.getAgility(), persB.getVie());
	}
	
	@Test
	void Given_rodeur_When_attaqueSpeciale_Then_checkLife() {
		//PersA gagne de l'agilité
		persA.attaqueSpeciale(null);
		assertEquals(2+(persA.getNiveau()/2), persA.getAgility());
	}

}
