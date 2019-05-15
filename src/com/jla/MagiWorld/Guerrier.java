package com.jla.MagiWorld;

public class Guerrier extends Person {
    public Guerrier(int niveau, int force, int agility, int intelligence) {
        super(niveau, force, agility, intelligence);
    }

    /**
     * coup d'épée infligé par pers1 sur pers2
     * @param pers1 personnage infligeant le coup
     * @param pers2 Personnage recevant le coup
     * @return String["texte du coup", "dégat infligé"]
     */
    @Override
    public String[] attaqueBasique(Person pers1, Person pers2) {
        int damage =pers1.getForce();
        pers2.setVie(pers2.getVie() - damage);

        return new String[]{"Coup d'épée", String.valueOf(damage)};
    }

    /**
     * coupe de rage infligé par pers1 sur pers2
     * @param pers1 personnage infligeant le coup
     * @param pers2 Personnage recevant le coup
     * @return String["texte du coup", "dégat infligé"]
     */
    @Override
    public String[] attaqueSpeciale(Person pers1, Person pers2) {
        //Perte de vie pour pers2
        int damage =pers1.getForce() * 2;
        pers2.setVie(pers2.getVie() - damage);

        //Perte de vie pour le pers1
        pers1.setVie(pers1.getVie() - (pers1.getForce() /2));

        return new String[]{"Coup de rage", String.valueOf(damage)};
    }
}
