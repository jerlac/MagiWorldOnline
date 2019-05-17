package com.jla.MagiWorld;

import java.util.ArrayList;
import java.util.List;

public class Rodeur extends Person {
    public Rodeur(int niveau, int force, int agility, int intelligence) {
        super(niveau, force, agility, intelligence);
    }

    /**
     * tir à l'arc infligé sur pers
     * @param pers Personnage recevant le coup
     */
    @Override
    public void attaqueBasique(Person pers) {
        MessagePerson msgPers =this.getMessagePerson();
        List<String> msgAttack =msgPers.getPlayerInAttack();
        List<String> msgDef =msgPers.getPlayerInDefense();

        int damage =this.getForce();
        pers.setVie(pers.getVie() - damage);

        msgAttack.add("utilise Tir à l'Arc et inflige "+ String.valueOf(damage)+ " dommages.");
        msgDef.add("perd "+ String.valueOf(damage)+ " points de vie.");

        if(pers.getVie() <=0)
            msgDef.add("est mort.");
    }

    /**
     * concentration sur lui-même
     * @param pers inutile ici, passez null
     */
    @Override
    public void attaqueSpeciale(Person pers) {
        MessagePerson msgPers =this.getMessagePerson();
        List<String> msgAttack =msgPers.getPlayerInAttack();

        //Gain d'agilité pour lui-même
        int result =this.getNiveau() / 2;
        this.setAgility(result);

        msgAttack.add("utilise Concentration et gagne "+ String.valueOf(result)+ " en agilité.");
    }

}
