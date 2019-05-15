package com.jla.MagiWorld;

abstract class Person {
    private int niveau;
    private int vie;
    private int force;
    private int agility;
    private int intelligence;

    Person(int niveau, int force, int agility, int intelligence) {
        this.niveau = niveau;
        this.force = force;
        this.agility = agility;
        this.intelligence = intelligence;

        this.vie =5 * this.niveau;
    }

    int getNiveau() {
        return niveau;
    }

    int getVie() {
        return vie;
    }

    void setVie(int vie) {
        this.vie = vie;
    }

    int getForce() {
        return force;
    }

    protected int getAgility() {
        return agility;
    }

    void setAgility(int agility) {
        this.agility = agility;
    }

    int getIntelligence() {
        return intelligence;
    }

    /**
     * action de pers1 sur pers2
     * @param pers1 personnage infligeant le coup
     * @param pers2 Personnage recevant le coup
     * @return String["texte du coup", "dégat infligé"]
     */
    protected abstract String[] attaqueBasique(Person pers1, Person pers2);

    /**
     * action de pers1 sur pers2
     * @param pers1 personnage infligeant le coup
     * @param pers2 Personnage recevant le coup, Prs2 peut-être null au besoin
     * @return String["texte du coup", "dégat infligé"]
     */
    protected abstract String[] attaqueSpeciale(Person pers1, Person pers2);

    /**
     * Vérifie si la somme des caractéristiques de force, agilité et intelligence est égal au niveau du joueur
     * @return true si la somme est égale, false sinon
     */
    public boolean checkSumInputSkills(){
        int sumSkills =this.force + this.agility + this.intelligence;

        return (sumSkills == this.niveau);
    }

    /**
     * Vérifie si la caractéristique est comprise entre 1 et 100
     * @return true si ok, false sinon
     */
    protected boolean checkInputMinMaxNiveau(){
        return (this.niveau>=1 && this.niveau <= 100);
    }
    /**
     * Vérifie si la caractéristique est comprise entre 0 et 100
     * @return true si ok, false sinon
     */
    protected boolean checkInputMinMaxForce(){
        return (this.force >=0 && this.force <= 100);
    }

    /**
     * Vérifie si la caractéristique est comprise entre 0 et 100
     * @return true si ok, false sinon
     */
    protected boolean checkInputMinMaxAgility(){
        return (this.agility >=0 && this.agility <= 100);
    }

    /**
     * Vérifie si la caractéristique est comprise entre 0 et 100
     * @return true si ok, false sinon
     */
    protected boolean checkInputMinMaxIntelligence(){
        return (this.intelligence >=0 && this.intelligence <= 100);
    }

}
