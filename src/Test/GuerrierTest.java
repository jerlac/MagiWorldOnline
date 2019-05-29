package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Main.Guerrier;
import Main.Person;

class GuerrierTest {
	
	@Test
	void Given_guerrier_When_attaquebasique_Then_checkLife() {
		Person Pers =new Guerrier(10, 6, 2, 2)	;
	}

}
