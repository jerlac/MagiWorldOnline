package com.jla.MagiWorld;

import javax.rmi.CORBA.Util;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

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
            for (int i = 1; i <= 2; i++) {
                playerAction(sc, players, i);
                if (!playerStillAlive(players))
                    return;
            }
        }
        catch(Exception exp) {
            Utility.writeMsg("Une erreur est survenue !");
        }
    }

    /**
     * Lance les actions du personnage
     * @param sc le scanner pour récupérer la saisie de l'utilisateur
     * @param players les joueurs
     * @param numPlayer le numéro du joueur en cours
     */
    private static void playerAction(Scanner sc, Player[] players, int numPlayer) {
        Player player =players[numPlayer-1];
        Utility.writeMsg("Joueur "+numPlayer+ " ("+ player.getVitality()+ "vitalité), veuillez choisir votre action (1: attaque basique, 2: Attaque spéciale)");
        int input;
        do{
            input = sc.nextInt();
            if(input<1 || input>2) {
                Utility.writeMsg("Veuillez saisir 1 ou 2 !%n");
            }
        } while(input<1 || input>2);

        switch (input){
            case 1://Attaque basique
                //players[numPlayer] => joueur adverse
                player.executeAction(Player.TypeAttack.attaqueBasique, players[numPlayer]);
                break;
            case 2://Attaque spéciale
                //players[numPlayer] => joueur adverse
                player.executeAction(Player.TypeAttack.attaqueSpeciale, players[numPlayer]);
                break;
        }

        Person.MessagePerson msgPers =player.getMessagePerson();
        if(msgPers!=null) {
            ArrayList<String> msgAttacks =msgPers.getPlayerInAttack();
            for (int j=0; j<msgAttacks.size(); j++){
                Utility.writeMsg("Joueur " + (numPlayer-1) + " "+ msgAttacks.get(j)+"%n");
            }

            ArrayList<String> msgDefenses =msgPers.getPlayerInDefense();
            for (int j=0; j<msgDefenses.size(); j++){
                Utility.writeMsg("Joueur " + numPlayer + " "+ msgDefenses.get(j)+"%n");
            }
        }
    }

    /**
     * Vérifie si le joueur est encore en vie et affiche un message sinon
     * @param players les joueurs
     * @return true si vivant, false sinon
     */
    private static boolean playerStillAlive(Player[] players){
        if(!players[0].isalive()) {
            Utility.writeMsg("Joueur 1 a perdu !");
            return false;
        }

        if(!players[1].isalive()) {
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
        int inputTypePers =askTypePers(sc);
        int inputNiveau =askInput(sc, 1, 100, "Niveau");
        int inputForce =askInput(sc, 0, 100, "Force");
        int inputAgility =askInput(sc, 0, 100, "Agilité");
        int inputIntelligence =askInput(sc, 0, 100, "Intelligence");

        Player player = new Player();
        if(!player.createPlayer(numPlayer, inputTypePers, inputNiveau, inputForce, inputAgility, inputIntelligence)) {
            Utility.writeMsg("erreur à la création joueur 1%n Fin du programme !");
            return null;
        }
        return player;
    }

    /**
     * demande le type de joueur à créer
     * @param sc le scanner pour récupérer la saisie de l'utilisateur
     * @return le type du joueur choisi
     */
    private static int askTypePers(Scanner sc){
        int input;
        Utility.writeMsg("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2: Rôdeur, 3: Mage)%n");
        do{
            input = sc.nextInt();
            if(input<1 || input>3) {
                Utility.writeMsg("Veuillez saisir une valeur entre 1 et 3 inclus !%n");
            }
        } while(input<1 || input>3);

        return input;
    }

    /**
     * demande les informations pour le joueur
     * @param sc le scanner pour récupérer la saisie de l'utilisateur
     * @param min la vleur minimale possible
     * @param max la valeur maximale possible
     * @param type la caractéristique à traiter
     * @return la valeur de la caractéristique
     */
    private static int askInput(Scanner sc, int min, int max, String type) {
        int input;
        Utility.writeMsg(type + " du personnage ? ("+ min+ " à "+ max +") %n");
        do{
            input = sc.nextInt();
            if(input<min || input >max) {
                Utility.writeMsg("Veuillez saisir une valeur entre "+ min+ " et "+ max+ " inclus !%n");
            }
        } while(input<min || input >max);

        return input;
    }


}

