package com.jla.MagiWorld;

import java.util.ArrayList;

abstract class Person {
    private int niveau;
    private int vie;
    private int force;
    private int agility;
    private int intelligence;
    private MessagePerson msgPerson;

    Person(int niveau, int force, int agility, int intelligence) {
        this.niveau = niveau;
        this.force = force;
        this.agility = agility;
        this.intelligence = intelligence;

        this.vie =5 * this.niveau;

        this.msgPerson =new MessagePerson();
    }

    MessagePerson getMessagePerson(){ return msgPerson; }

    int getNiveau() {
        return niveau;
    }

    int getVie() {
        return vie;
    }

    void setVie(int vie) {
        this.vie = vie;
    }

    int getForce() {
        return force;
    }

    int getAgility() {
        return agility;
    }

    void setAgility(int agility) {
        this.agility = agility;
    }

    int getIntelligence() {
        return intelligence;
    }

    /**
     * action sur la personne
     * @param pers Personnage recevant le coup
     */
    protected abstract void attaqueBasique(Person pers);

    /**
     * action sur la personne
     * @param pers Personnage recevant le coup, mais peut être null au besoin
     */
    protected abstract void attaqueSpeciale(Person pers);

    boolean isAlive(){
        return (this.vie > 0);
    }

    /**
     * Permet d'avoir le smessages à destination des joueurs en attaque ou en défense
     */
    class MessagePerson{
        private ArrayList<String> playerInAttack;
        private ArrayList<String> playerInDefense;

        MessagePerson(){

        }

        ArrayList<String> getPlayerInAttack() {
            return playerInAttack;
        }

        ArrayList<String> getPlayerInDefense() {
            return playerInDefense;
        }

        void setPlayerInAttack(ArrayList<String> playerInAttack) {
            this.playerInAttack = playerInAttack;
        }

        void setPlayerInDefense(ArrayList<String> playerInDefense) {
            this.playerInDefense = playerInDefense;
        }
    }
}
