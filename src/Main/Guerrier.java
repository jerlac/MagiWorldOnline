package Main;

import java.util.ArrayList;

public class Guerrier extends Person {
    public Guerrier(int niveau, int force, int agility, int intelligence) {
        super(niveau, force, agility, intelligence);
    }

    /**
     * coup d'épée infligé sur  la personne
     * @param pers Personnage recevant le coup
     */
    @Override
    protected void attaqueBasique(Person pers) {
        MessagePerson msgPers =this.getMessagePerson();
        ArrayList<String> msgAttack =new ArrayList<String>();
        ArrayList<String> msgDef =new ArrayList<String>();

        int damage =this.getForce();
        pers.setVie(pers.getVie() - damage);
        msgAttack.add("utilise Coup d'épée et inflige "+ damage+ " dommages.");

        msgDef.add("perd "+ damage+ " points de vie.");

        if(pers.getVie() <=0)
            msgDef.add("est mort.");

        msgPers.setPlayerInAttack(msgAttack);
        msgPers.setPlayerInDefense(msgDef);
    }

    /**
     * coupe de rage infligé sur la personne
     * @param pers Personnage recevant le coup
     */
    @Override
    protected void attaqueSpeciale(Person pers) {
        MessagePerson msgPers =this.getMessagePerson();
        ArrayList<String> msgAttack =new ArrayList<String>();
        ArrayList<String> msgDef =new ArrayList<String>();

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
        msgAttack.add("perd "+ thisDamage+ " points de vie.");

        msgPers.setPlayerInAttack(msgAttack);
        msgPers.setPlayerInDefense(msgDef);
    }
}
