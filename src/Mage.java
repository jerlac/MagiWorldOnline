
import java.util.ArrayList;


public class Mage extends Person {
    private int vieInitiale;

    Mage(int niveau, int force, int agility, int intelligence) {
        super(niveau, force, agility, intelligence);

        this.vieInitiale = this.getVie();
    }

    /**
     * boule de feu infligé sur pers
     * @param pers Personnage recevant le coup
     */
    @Override
    protected void attaqueBasique(Person pers) {
        MessagePerson msgPers =this.getMessagePerson();
        ArrayList<String> msgAttack =new ArrayList<String>();
        ArrayList<String> msgDef =new ArrayList<String>();

        int damage =this.getIntelligence();
        pers.setVie(pers.getVie() - damage);

        msgAttack.add("utilise Boule de Feu et inflige "+ damage+ " dommages.");
        msgDef.add("perd "+ damage+ " points de vie.");

        if(pers.getVie() <=0)
            msgDef.add("est mort.");

        msgPers.setPlayerInAttack(msgAttack);
        msgPers.setPlayerInDefense(msgDef);
    }

    /**
     * soin pour lui-même
     * @param pers inutile ici, passez null
     */
    @Override
    protected void attaqueSpeciale(Person pers) {
        MessagePerson msgPers =this.getMessagePerson();
        ArrayList<String> msgAttack =new ArrayList<String>();

        //Gain de vie pour lui-même
        int result =this.getIntelligence() * 2;
        int newVie = this.getVie() + result;

        if(newVie > this.vieInitiale)
            newVie =this.vieInitiale;

        this.setVie(newVie);

        msgAttack.add("utilise Soin et gagne "+ result+ " en vitalité.");

        msgPers.setPlayerInAttack(msgAttack);
        msgPers.setPlayerInDefense(null);
    }

}
