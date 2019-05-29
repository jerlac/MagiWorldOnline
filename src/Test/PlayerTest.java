package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Main.Player;


class PlayerTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private static Player playerA;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	@BeforeEach
	void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));

		playerA =new Player(10, 6, 2, 2);
	}
	
	@AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }


	@Test
	void Given_guerrier_When_CreatePlayer_Then_checkCreationAndMsg() {
		boolean result = playerA.createPlayer(1, Player.TypePlayer.Guerrier);
		assertTrue(result==true);
		
		String output = outContent.toString().replace("\r\n","\n");
		String expectedMsg ="Woarg je suis le Guerrier Joueur 1 niveau 10 je possède 50 de vitalité, 6 de force, 2 d'agilité, 2 d'intelligence !\n";
		assertEquals(expectedMsg, output);
	}

	@Test
	void Given_mage_When_CreatePlayer_Then_checkCreationAndMsg() {
		boolean result = playerA.createPlayer(1, Player.TypePlayer.Mage);
		assertTrue(result==true);
		
		String output = outContent.toString().replace("\r\n","\n");
		String expectedMsg ="Abracadabra je suis le Mage Joueur 1 niveau 10 je possède 50 de vitalité, 6 de force, 2 d'agilité, 2 d'intelligence !\n";
		assertEquals(expectedMsg, output);
	}
	
	@Test
	void Given_rodeur_When_CreatePlayer_Then_checkCreationAndMsg() {
		boolean result = playerA.createPlayer(1, Player.TypePlayer.Rodeur);
		assertTrue(result==true);
		
		String output = outContent.toString().replace("\r\n","\n");
		String expectedMsg ="Wizz je suis le Rôdeur Joueur 1 niveau 10 je possède 50 de vitalité, 6 de force, 2 d'agilité, 2 d'intelligence !\n";
		assertEquals(expectedMsg, output);
	}
	
	@Test
	void Given_rodeur_When_CreatePlayer_Then_ErrorForce() {
		Player playertest =new Player(10, 120, 10, 1);
		boolean result = playertest.createPlayer(1, Player.TypePlayer.Rodeur);
		assertTrue(result==false);
		
		String output = outContent.toString().replace("\r\n","\n");
		String expectedMsg ="La force doit être entre 0 et 100\n";
		assertEquals(expectedMsg, output);
	}
	
	@Test
	void Given_rodeur_When_CreatePlayer_Then_ErrorAgility() {
		Player playertest =new Player(10, 5, 110, 1);
		boolean result = playertest.createPlayer(1, Player.TypePlayer.Rodeur);
		assertTrue(result==false);
		
		String output = outContent.toString().replace("\r\n","\n");
		String expectedMsg ="L'agilité doit être entre 0 et 100\n";
		assertEquals(expectedMsg, output);
	}
	
	@Test
	void Given_rodeur_When_CreatePlayer_Then_ErrorIntelligence() {
		Player playertest =new Player(10, 10, 10, -2);
		boolean result = playertest.createPlayer(1, Player.TypePlayer.Rodeur);
		assertTrue(result==false);
		
		String output = outContent.toString().replace("\r\n","\n");
		String expectedMsg ="L'intelligence doit être entre 0 et 100\n";
		assertEquals(expectedMsg, output);
	}
	
	@Test
	void Given_rodeur_When_CreatePlayer_Then_ErrorNiveau() {
		Player playertest =new Player(110, 5, 10, 1);
		boolean result = playertest.createPlayer(1, Player.TypePlayer.Rodeur);
		assertTrue(result==false);
		
		String output = outContent.toString().replace("\r\n","\n");
		String expectedMsg ="Le niveau doit être entre 1 et 100\n";
		assertEquals(expectedMsg, output);
	}
	
	@Test
	void Given_rodeur_When_CreatePlayer_Then_ErrorSomme() {
		Player playertest =new Player(10, 10, 10, 10);
		boolean result = playertest.createPlayer(1, Player.TypePlayer.Rodeur);
		assertTrue(result==false);
		
		String output = outContent.toString().replace("\r\n","\n");
		String expectedMsg ="La somme des caractéristiques ne doit pas dépasser le niveau !\n";
		assertEquals(expectedMsg, output);
	}
}
