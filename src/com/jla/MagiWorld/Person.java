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

    /**
     * Vérifie si la somme des caractéristiques de force, agilité et intelligence est égale au niveau du joueur
     * @return true si la somme est égale, false sinon
     */
    public boolean checkSumInputSkills(){
        int sumSkills =this.force + this.agility + this.intelligence;

        return (sumSkills == this.niveau);
    }

    /**
     * Vérifie si la caractéristique est comprise entre 1 et 100
     * @return true si ok, false sinon
     */
    protected boolean checkInputMinMaxNiveau(){
        return (this.niveau>=1 && this.niveau <= 100);
    }
    /**
     * Vérifie si la caractéristique est comprise entre 0 et 100
     * @return true si ok, false sinon
     */
    protected boolean checkInputMinMaxForce(){
        return (this.force >=0 && this.force <= 100);
    }

    /**
     * Vérifie si la caractéristique est comprise entre 0 et 100
     * @return true si ok, false sinon
     */
    protected boolean checkInputMinMaxAgility(){
        return (this.agility >=0 && this.agility <= 100);
    }

    /**
     * Vérifie si la caractéristique est comprise entre 0 et 100
     * @return true si ok, false sinon
     */
    protected boolean checkInputMinMaxIntelligence(){
        return (this.intelligence >=0 && this.intelligence <= 100);
    }

    protected boolean isAlive(){
        return (this.vie > 0);
    }

    protected  class MessagePerson{
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
