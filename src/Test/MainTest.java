package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Main.Main;
import Main.Player;

class MainTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	@BeforeEach
	void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
	}
	
	@AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }
	
	@Test
	void Given_playerData_When_getplayer_Then_checkOutput() {
		int numPlayer=1;
		
		//type 1 guerrier, niveau 10, force 7, agilit� 2, intelligence 1
		System.setIn(new ByteArrayInputStream("1\n10\n7\n2\n1\n".getBytes()));
		
		Scanner sc =new Scanner(System.in);
		Player player =Main.getPlayer(sc, numPlayer);
		
		String[] output = outContent.toString().replace("\r\n","\n").split("\n");
		assertEquals("Cr�ation du personnage du Joueur "+ numPlayer, output[0]);
		assertEquals("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2: R�deur, 3: Mage)", output[1]);
		assertEquals("Niveau du personnage ? (1 � 100)", output[2]);
		assertEquals("Force du personnage ? (0 � 100)", output[3]);
		assertEquals("Agilit� du personnage ? (0 � 100)", output[4]);
		assertEquals("Intelligence du personnage ? (0 � 100)", output[5]);
		
		String expectedMsg ="Woarg je suis le Guerrier Joueur "+ numPlayer+" niveau 10 je poss�de 50 de vitalit�, 7 de force, 2 d'agilit�, 1 d'intelligence !";
		assertEquals(expectedMsg, output[6]);

		//v�rification que la vie = 5*niveau
		assertEquals(50, player.getVitality());
	}

	
	
}
