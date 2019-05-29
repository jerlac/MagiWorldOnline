package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Main.Guerrier;
import Main.Mage;
import Main.Person;

class MageTest {

	private static Person persA;
	private static Person persB;
	private static int persAVieInit;
	private static int persBVieInit;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		persA =new Mage(10, 2, 2, 6);
		persB =new Mage(10, 1, 1, 8);
		persAVieInit = persA.getVie();
		persBVieInit = persB.getVie();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void Given_mage_When_attaqueBasique_Then_checkLife() {
		//PersA attaque persB
		persA.attaqueBasique(persB);
		assertEquals(persBVieInit-persA.getIntelligence(), persB.getVie());
	}

	@Test
	void Given_mage_When_attaqueSpeciale_Then_checkLife() {
		//PersA gagne de la vie
		persA.attaqueSpeciale(null);
				
		assertTrue(persAVieInit >= persA.getVie());
	}
	
	@Test
	void Given_guerrier_When_attaqueBasique_and_attaqueSpeciale_Then_checkLife() {
		//guerrier attaque persA
		Person guerrier =new Guerrier(10, 7, 2, 1);
		guerrier.attaqueBasique(persA);//perd 7
		guerrier.attaqueBasique(persA);//perd 7 => donc 14

		//PersA gagne de la vie
		persA.attaqueSpeciale(null);
		assertEquals(50-14+12, persA.getVie());
	}

}
