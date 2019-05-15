package com.jla.MagiWorld;

public class Mage extends Person {
    private int vieInitiale;

    public Mage(int niveau, int force, int agility, int intelligence) {
        super(niveau, force, agility, intelligence);

        this.vieInitiale = this.getVie();
    }

    /**
     * boule de feu infligé par pers1 sur pers2
     * @param pers1 personnage infligeant le coup
     * @param pers2 Personnage recevant le coup
     * @return String["texte du coup", "dégat infligé"]
     */
    @Override
    public String[] attaqueBasique(Person pers1, Person pers2) {
        int damage =pers1.getIntelligence();
        pers2.setVie(pers2.getVie() - damage);

        return new String[]{"Boule de Feu", String.valueOf(damage)};
    }

    /**
     * soin pour pers1
     * @param pers1 personnage concernée
     * @param pers2 inutile ici, passez null
     * @return String["texte du coup", "effet ressenti"]
     */
    @Override
    public String[] attaqueSpeciale(Person pers1, Person pers2) {
        //Gain de vie pour pers1
        int result =pers1.getIntelligence() * 2;
        int newVie = pers1.getVie() + result;

        if(newVie > this.vieInitiale)
            newVie =this.vieInitiale;

        pers1.setVie(newVie);

        return new String[]{"Soin", String.valueOf(result)};
    }

}
