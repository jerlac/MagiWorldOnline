
import java.util.ArrayList;

public class Rodeur extends Person {
    Rodeur(int niveau, int force, int agility, int intelligence) {
        super(niveau, force, agility, intelligence);
    }

    /**
     * tir � l'arc inflig� sur pers
     * @param pers Personnage recevant le coup
     */
    @Override
    protected void attaqueBasique(Person pers) {
        MessagePerson msgPers =this.getMessagePerson();
        ArrayList<String> msgAttack =new ArrayList<String>();
        ArrayList<String> msgDef =new ArrayList<String>();

        int damage =this.getAgility();
        pers.setVie(pers.getVie() - damage);

        msgAttack.add("utilise Tir � l'Arc et inflige "+ damage+ " dommages.");
        msgDef.add("perd "+ damage+ " points de vie.");

        if(pers.getVie() <=0)
            msgDef.add("est mort.");

        msgPers.setPlayerInAttack(msgAttack);
        msgPers.setPlayerInDefense(msgDef);
    }

    /**
     * concentration sur lui-m�me
     * @param pers inutile ici, passez null
     */
    @Override
    protected void attaqueSpeciale(Person pers) {
        MessagePerson msgPers =this.getMessagePerson();
        ArrayList<String> msgAttack =new ArrayList<String>();

        //Gain d'agilit� pour lui-m�me
        int result =this.getNiveau() / 2;
        this.setAgility(this.getAgility() +result);

        msgAttack.add("utilise Concentration et gagne "+ result+ " en agilit�.");

        msgPers.setPlayerInAttack(msgAttack);
        msgPers.setPlayerInDefense(null);
    }

}
