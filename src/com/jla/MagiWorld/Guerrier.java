package com.jla.MagiWorld;

import java.util.*;

public class Guerrier extends Person {
    public Guerrier(int niveau, int force, int agility, int intelligence) {
        super(niveau, force, agility, intelligence);
    }

    /**
     * coup d'épée infligé sur  la personne
     * @param pers Personnage recevant le coup
     */
    @Override
    public void attaqueBasique(Person pers) {
        MessagePerson msgPers =this.getMessagePerson();
        ArrayList<String> msgAttack =msgPers.getPlayerInAttack();
        ArrayList<String> msgDef =msgPers.getPlayerInDefense();

        int damage =this.getForce();
        pers.setVie(pers.getVie() - damage);
        msgAttack.add("utilise Coup d'épée et inflige "+ damage+ " dommages.");

        msgDef.add("perd "+ damage+ " points de vie.");

        if(pers.getVie() <=0)
            msgDef.add("est mort.");
    }

    /**
     * coupe de rage infligé sur la personne
     * @param pers Personnage recevant le coup
     */
    @Override
    public void attaqueSpeciale(Person pers) {
        MessagePerson msgPers =this.getMessagePerson();
        ArrayList<String> msgAttack =msgPers.getPlayerInAttack();
        ArrayList<String> msgDef =msgPers.getPlayerInDefense();

        //Perte de vie pour pers
        int damage =this.getForce() * 2;
        pers.setVie(pers.getVie() - damage);
        msgAttack.add("utilise Coup de rage et inflige "+ damage+ " dommages.");

        msgDef.add("perd "+ damage+ " points de vie.");

        if(pers.getVie() <=0)
            msgDef.add("est mort.");

        //Perte de vie pour lui-même
        int thisDamage =this.getForce() /2;
        this.setVie(this.getVie() - thisDamage);
        msgAttack.add("perd "+ String.valueOf(thisDamage)+ " points de vie.");
    }
}
