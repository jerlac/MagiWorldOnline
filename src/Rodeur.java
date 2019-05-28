
import java.util.ArrayList;

public class Rodeur extends Person {
    Rodeur(int niveau, int force, int agility, int intelligence) {
        super(niveau, force, agility, intelligence);
    }

    /**
     * tir à l'arc infligé sur pers
     * @param pers Personnage recevant le coup
     */
    @Override
    protected void attaqueBasique(Person pers) {
        MessagePerson msgPers =this.getMessagePerson();
        ArrayList<String> msgAttack =new ArrayList<String>();
        ArrayList<String> msgDef =new ArrayList<String>();

        int damage =this.getAgility();
        pers.setVie(pers.getVie() - damage);

        msgAttack.add("utilise Tir à l'Arc et inflige "+ damage+ " dommages.");
        msgDef.add("perd "+ damage+ " points de vie.");

        if(pers.getVie() <=0)
            msgDef.add("est mort.");

        msgPers.setPlayerInAttack(msgAttack);
        msgPers.setPlayerInDefense(msgDef);
    }

    /**
     * concentration sur lui-même
     * @param pers inutile ici, passez null
     */
    @Override
    protected void attaqueSpeciale(Person pers) {
        MessagePerson msgPers =this.getMessagePerson();
        ArrayList<String> msgAttack =new ArrayList<String>();

        //Gain d'agilité pour lui-même
        int result =this.getNiveau() / 2;
        this.setAgility(this.getAgility() +result);

        msgAttack.add("utilise Concentration et gagne "+ result+ " en agilité.");

        msgPers.setPlayerInAttack(msgAttack);
        msgPers.setPlayerInDefense(null);
    }

}
