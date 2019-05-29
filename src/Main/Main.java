package Main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}
	
	public static void main(String[] args) {
		try {

            Scanner sc = new Scanner(System.in);

            Player[] players = new Player[2];
            for (int i = 1; i <= 2; i++) {
                Player player = getPlayer(sc, i);
                if (player == null) return;
                players[i - 1] = player;
            }

            //déroulement du combat
            boolean continueGame =true;
            int numPlayer =1;
            while (continueGame){
                playerAction(sc, players, numPlayer);
                if (!playerStillAlive(players))
                    continueGame =false;
                numPlayer++;
                if(numPlayer%2==1)
                    numPlayer =1;
                else
                    numPlayer =2;
            }
        }
        catch(Exception exp) {
            Utility.writeMsg("Une erreur est survenue !");
        }
        finally{
            Utility.writeMsg("%nLe jeu est terminé !");
        }
    }

    /**
     * Lance les actions du personnage
     * @param sc le scanner pour récupérer la saisie de l'utilisateur
     * @param players les joueurs
     * @param numPlayer le numéro du joueur en cours
     */
    private static void playerAction(Scanner sc, Player[] players, int numPlayer) {
        int numPlayerAdverse=-1;
        if(1==numPlayer)
            numPlayerAdverse =1;
        else if(2==numPlayer)
            numPlayerAdverse=0;

        if(-1==numPlayerAdverse)
            throw new ArithmeticException("[playerAction] le numéro du joueur n'est pas 1 ou 2");

        Player player =players[numPlayer-1];
        Utility.writeMsg("Joueur "+numPlayer+ " ("+ player.getVitality()+ " vitalité), veuillez choisir votre action (1: Attaque basique, 2: Attaque spéciale)");
        int input;
        do{
            input = sc.nextInt();
            if(input<1 || input>2) {
                Utility.writeMsg("Veuillez saisir 1 ou 2 !%n");
            }
        } while(input<1 || input>2);

        switch (input){
            case 1://Attaque basique
                player.executeAction(Player.TypeAttack.attaqueBasique, players[numPlayerAdverse]);
                break;
            case 2://Attaque spéciale
                player.executeAction(Player.TypeAttack.attaqueSpeciale, players[numPlayerAdverse]);
                break;
        }

        //Affiche le résultat des actions
        Person.MessagePerson msgPers =player.getMessagePerson();
        if(msgPers!=null) {
            ArrayList<String> msgAttacks =msgPers.getPlayerInAttack();
            if(msgAttacks!=null) {
                for(String str : msgAttacks){
                    Utility.writeMsg("Joueur " + numPlayer + " " + str);
                }
            }

            ArrayList<String> msgDefenses =msgPers.getPlayerInDefense();
            if(msgDefenses!=null) {
                for (String str : msgDefenses) {
                    Utility.writeMsg("Joueur " + (numPlayerAdverse + 1) + " " + str);
                }
            }
        }
    }

    /**
     * Vérifie si le joueur est encore en vie et affiche un message sinon
     * @param players les joueurs
     * @return true si vivant, false sinon
     */
    private static boolean playerStillAlive(Player[] players){
        if(!players[0].isAlive()) {
            Utility.writeMsg("Joueur 1 a perdu !");
            return false;
        }

        if(!players[1].isAlive()) {
            Utility.writeMsg("Joueur 2 a perdu !");
            return false;
        }

        return true;
    }

    /**
     * demande les informations du joueur
     * @param sc le scanner pour récupérer la saisie de l'utilisateur
     * @param numPlayer le numéro du joueur en cours
     * @return Le Player créé
     */
    private static Player getPlayer(Scanner sc, int numPlayer) {
        Utility.writeMsg("Création du personnage du Joueur " +numPlayer);
        Player.TypePlayer typePlayer =askTypePers(sc);
        int inputNiveau =askInput(sc, 1, 100, "Niveau");
        int inputForce =askInput(sc, 0, 100, "Force");
        int inputAgility =askInput(sc, 0, 100, "Agilité");
        int inputIntelligence =askInput(sc, 0, 100, "Intelligence");

        Player player = new Player(inputNiveau, inputForce, inputAgility, inputIntelligence);
        if(!player.createPlayer(numPlayer, typePlayer)) {
            Utility.writeMsg("Erreur lors de la création du joueur "+ numPlayer +"%nFin du programme !");
            return null;
        }
        return player;
    }

    /**
     * demande le type de joueur à créer
     * @param sc le scanner pour récupérer la saisie de l'utilisateur
     * @return le type du joueur choisi
     */
    private static Player.TypePlayer askTypePers(Scanner sc){
        int input;
        Utility.writeMsg("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2: Rôdeur, 3: Mage)");
        do{
            input = sc.nextInt();
            if(input<1 || input>3) {
                Utility.writeMsg("Veuillez saisir une valeur entre 1 et 3 inclus !");
            }
        } while(input<1 || input>3);

        //Par défaut, on dit qu'il est un guerrier
        Player.TypePlayer typePlayer= Player.TypePlayer.Guerrier;
        switch (input){
            case 1:
                typePlayer = Player.TypePlayer.Guerrier;
                break;
            case 2:
                typePlayer = Player.TypePlayer.Rodeur;
                break;
            case 3:
                typePlayer = Player.TypePlayer.Mage;
                break;
        }
        return typePlayer;
    }

    /**
     * demande les informations pour le joueur
     * @param sc le scanner pour récupérer la saisie de l'utilisateur
     * @param min la valeur minimale possible
     * @param max la valeur maximale possible
     * @param type la caractéristique à traiter
     * @return la valeur de la caractéristique
     */
    private static int askInput(Scanner sc, int min, int max, String type) {
        int input;
        Utility.writeMsg(type + " du personnage ? ("+ min+ " à "+ max +")");
        do{
            input = sc.nextInt();
            if(input<min || input >max) {
                Utility.writeMsg("Veuillez saisir une valeur entre "+ min+ " et "+ max+ " inclus !");
            }
        } while(input<min || input >max);

        return input;
    }
	
}