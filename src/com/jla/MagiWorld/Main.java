package com.jla.MagiWorld;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i=1; i<=2; i++) {
            Utility.writeMsg("Création du personnage du Joueur " +i);
            askTypePers(sc);
            askInput(sc, 1, 100, "Niveau");
            askInput(sc, 0, 100, "Force");
            askInput(sc, 0, 100, "Agilité");
            askInput(sc, 0, 100, "Intelligence");
            //TODO à finir
        }
    }

    private static void askTypePers(Scanner sc){
        int input;
        Utility.writeMsg("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2: Rôdeur, 3: Mage)%n");
        do{
            input = sc.nextInt();
            if(input<1 || input>3) {
                Utility.writeMsg("Veuillez saisir une valeur entre 1 et 3 inclus !%n");
            }
        } while(input<1 || input>3);
    }

    private static void askInput(Scanner sc, int min, int max, String type) {
        int input;
        Utility.writeMsg(type + " du personnage ? ("+ min+ " à "+ max +") %n");
        do{
            input = sc.nextInt();
            if(input<min || input >max) {
                Utility.writeMsg("Veuillez saisir une valeur entre "+ min+ " et "+ max+ " inclus !%n");
            }
        } while(input<min || input >max);
    }


}

