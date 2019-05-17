package com.jla.MagiWorld;

import java.util.ArrayList;
import java.util.List;

public class Mage extends Person {
    private int vieInitiale;

    public Mage(int niveau, int force, int agility, int intelligence) {
        super(niveau, force, agility, intelligence);

        this.vieInitiale = this.getVie();
    }

    /**
     * boule de feu infligé sur pers
     * @param pers Personnage recevant le coup
     */
    @Override
    public void attaqueBasique(Person pers) {
        MessagePerson msgPers =this.getMessagePerson();
        List<String> msgAttack =msgPers.getPlayerInAttack();
        List<String> msgDef =msgPers.getPlayerInDefense();

        int damage =this.getIntelligence();
        pers.setVie(pers.getVie() - damage);

        msgAttack.add("utilise Boule de Feu et inflige "+ String.valueOf(damage)+ " dommages.");
        msgDef.add("perd "+ String.valueOf(damage)+ " points de vie.");

        if(pers.getVie() <=0)
            msgDef.add("est mort.");
    }

    /**
     * soin pour lui-même
     * @param pers inutile ici, passez null
     */
    @Override
    public void attaqueSpeciale(Person pers) {
        MessagePerson msgPers =this.getMessagePerson();
        List<String> msgAttack =msgPers.getPlayerInAttack();

        //Gain de vie pour lui-même
        int result =this.getIntelligence() * 2;
        int newVie = this.getVie() + result;

        if(newVie > this.vieInitiale)
            newVie =this.vieInitiale;

        this.setVie(newVie);

        msgAttack.add("utilise Soin et gagne "+ String.valueOf(result)+ " en vitalité.");
    }

}
