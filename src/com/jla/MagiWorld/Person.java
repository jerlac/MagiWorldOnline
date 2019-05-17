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

    protected int getAgility() {
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

    class MessagePerson{
        private ArrayList<String> playerInAttack;
        private ArrayList<String> playerInDefense;

        MessagePerson(){
            this.playerInAttack =new ArrayList<String>();
            this.playerInDefense =new ArrayList<String>();
        }

        public ArrayList<String> getPlayerInAttack() {
            return playerInAttack;
        }

        public ArrayList<String> getPlayerInDefense() {
            return playerInDefense;
        }
    }
}
