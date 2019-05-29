package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Main.Guerrier;
import Main.Person;

class GuerrierTest {

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
		persA =new Guerrier(10, 6, 2, 2);
		persB =new Guerrier(10, 7, 2, 1);
		persAVieInit = persA.getVie();
		persBVieInit = persB.getVie();
	}
	
	@Test
	void Given_guerrier_When_attaqueBasique_Then_checkLife() {
		//PersA attaque persB
		persA.attaqueBasique(persB);
		assertEquals(persBVieInit-persA.getForce(), persB.getVie());
	}

	@Test
	void Given_guerrier_When_attaqueSpeciale_Then_checkLife() {
		//PersA attaque persB
		persA.attaqueSpeciale(persB);
		assertEquals(persBVieInit-(persA.getForce()*2), persB.getVie());
		
		assertEquals(persAVieInit-(persA.getForce()/2), persA.getVie());
	}
}
