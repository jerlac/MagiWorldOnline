package com.jla.MagiWorld;

import javax.rmi.CORBA.Util;

public class Player {
    private Person pers;
    private int niveau;
    private int force;
    private int agility;
    private int intelligence;

    Player(){

    }

    protected boolean createPlayer(int typePers, int niveau, int force, int agility, int intelligence){
        boolean isCreated =false;

        if(false==this.checkInputValues())
            return false;

        //1: Guerrier
        //2: Rôdeur
        //3: Mage
        switch (typePers){
            case 1:
                pers =new Guerrier(niveau, force, agility, intelligence);

                isCreated =true;
                break;
            case 2:
                pers =new Rodeur(niveau, force, agility, intelligence);
                isCreated =true;
                break;
            case 3:
                pers =new Mage(niveau, force, agility, intelligence);
                isCreated =true;
                break;

        }
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
}
