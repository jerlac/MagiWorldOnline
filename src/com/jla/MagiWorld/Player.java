package com.jla.MagiWorld;

public class Player {
    private Person pers;
    private int niveau;
    private int force;
    private int agility;
    private int intelligence;

    protected enum TypeAttack{
        attaqueBasique,
        attaqueSpeciale
    }

    Player(){

    }

    protected int getVitality(){
        return this.pers.getVie();
    }

    protected Person.MessagePerson getMessagePerson(){
        return this.pers.getMessagePerson();
    }

    protected boolean createPlayer(int numPlayer, int typePers, int niveau, int force, int agility, int intelligence){
        boolean isCreated =false;

        if(false==this.checkInputValues())
            return false;

        String msgPers="";
        //1: Guerrier
        //2: Rôdeur
        //3: Mage
        switch (typePers){
            case 1:
                pers =new Guerrier(niveau, force, agility, intelligence);
                msgPers ="Woarg je suis le Guerrier";
                isCreated =true;
                break;
            case 2:
                pers =new Rodeur(niveau, force, agility, intelligence);
                msgPers ="Wizz je suis le Rôdeur";
                isCreated =true;
                break;
            case 3:
                pers =new Mage(niveau, force, agility, intelligence);
                msgPers ="Abracadabra je suis le Mage";
                isCreated =true;
                break;
        }
        if(isCreated)
            Utility.writeMsg(msgPers + "Joueur "+ numPlayer+ "niveau "+ niveau+ " je possède "+ pers.getVie()+ " de vitalité, "+ force+ " de force, "+ agility+ " d'agilité, "+ intelligence+ "d'intelligence !");

        return isCreated;
    }

    /**
     * vérifie si les caractéristiques sont correctes
     * @return true si ok, false sinon.
     */
    private boolean checkInputValues(){

        if(!this.pers.checkInputMinMaxAgility()){
            Utility.writeMsg("L'agilité doit être entre 0 et 100");
            return false;
        }
        if(!this.pers.checkInputMinMaxForce()){
            Utility.writeMsg("La force doit être entre 0 et 100");
            return false;
        }
        if(!this.pers.checkInputMinMaxIntelligence()){
            Utility.writeMsg("L'intelligence doit être entre 0 et 100");
            return false;
        }
        if(!this.pers.checkInputMinMaxNiveau()){
            Utility.writeMsg("La force doit être entre 1 et 100");
            return false;
        }
        if(!this.pers.checkSumInputSkills()) {
            Utility.writeMsg("La somme des caractéristiques ne doit pas dépasser le niveau !");
            return false;
        }

        return true;
    }


    /**
     * Exécute l'action du joueur
     * @param attack Le type d'attaque
     * @param playerAdverse le joueur advsrse sur lequel lancer l'action
     */
    protected void executeAction(TypeAttack attack, Player playerAdverse){
        switch (attack){
            case attaqueBasique:
                this.pers.attaqueBasique(playerAdverse.pers);
                break;
            case attaqueSpeciale:
                this.pers.attaqueSpeciale(playerAdverse.pers);
                break;
        }
    }

    /**
     * Vérifie si le joueur est encore en vie
     * @return true si vivant, false sinon
     */
    protected boolean isalive(){
        return this.pers.isAlive();
    }
}
