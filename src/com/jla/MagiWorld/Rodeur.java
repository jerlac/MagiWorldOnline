package com.jla.MagiWorld;

public class Rodeur extends Person {
    public Rodeur(int niveau, int force, int agility, int intelligence) {
        super(niveau, force, agility, intelligence);
    }

    /**
     * tir à l'arc infligé par pers1 sur pers2
     * @param pers1 personnage infligeant le coup
     * @param pers2 Personnage recevant le coup
     * @return String["texte du coup", "dégat infligé"]
     */
    @Override
    public String[] attaqueBasique(Person pers1, Person pers2) {
        int damage =pers1.getForce();
        pers2.setVie(pers2.getVie() - damage);

        return new String[]{"Tir à l'Arc", String.valueOf(damage)};
    }

    /**
     * concentration pour pers1
     * @param pers1 personnage concernée
     * @param pers2 inutile ici, passez null
     * @return String["texte du coup", "effet ressenti"]
     */
    @Override
    public String[] attaqueSpeciale(Person pers1, Person pers2) {
        //Gain d'agilité pour pers1
        int res =pers1.getNiveau() / 2;
        pers1.setAgility(res);

        return new String[]{"Concentration", String.valueOf(res)};
    }

}
