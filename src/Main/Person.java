package Main;

import java.util.ArrayList;

public abstract class Person {
    private int niveau;
    private int vie;
    private int force;
    private int agility;
    private int intelligence;
    private MessagePerson msgPerson;

    public Person(int niveau, int force, int agility, int intelligence) {
        this.niveau = niveau;
        this.force = force;
        this.agility = agility;
        this.intelligence = intelligence;

        this.vie =5 * this.niveau;

        this.msgPerson =new MessagePerson();
    }

    public MessagePerson getMessagePerson(){ return msgPerson; }

    public int getNiveau() {
        return niveau;
    }

    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public int getForce() {
        return force;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    /**
     * action sur la personne
     * @param pers Personnage recevant le coup
     */
    public abstract void attaqueBasique(Person pers);

    /**
     * action sur la personne
     * @param pers Personnage recevant le coup, mais peut être null au besoin
     */
    public abstract void attaqueSpeciale(Person pers);

    public boolean isAlive(){
        return (this.vie > 0);
    }

    /**
     * Permet d'avoir les messages à destination des joueurs en attaque ou en défense
     */
    public class MessagePerson{
        private ArrayList<String> playerInAttack;
        private ArrayList<String> playerInDefense;

        public MessagePerson(){

        }

        public ArrayList<String> getPlayerInAttack() {
            return playerInAttack;
        }

        public ArrayList<String> getPlayerInDefense() {
            return playerInDefense;
        }

        public void setPlayerInAttack(ArrayList<String> playerInAttack) {
            this.playerInAttack = playerInAttack;
        }

        public void setPlayerInDefense(ArrayList<String> playerInDefense) {
            this.playerInDefense = playerInDefense;
        }
    }
}
