package Main;

class Player {
    private Person pers;
    private int niveau;
    private int force;
    private int agility;
    private int intelligence;

    protected enum TypePlayer{
        Guerrier,
        Rodeur,
        Mage
    }

    protected enum TypeAttack{
        attaqueBasique,
        attaqueSpeciale
    }

    Player(int niveau, int force, int agility, int intelligence){
        this.niveau =niveau;
        this.force =force;
        this.agility =agility;
        this.intelligence =intelligence;
    }

    int getVitality(){
        return this.pers.getVie();
    }

    Person.MessagePerson getMessagePerson(){
        return this.pers.getMessagePerson();
    }

    /**
     * V�rifie si la caract�ristique est comprise entre 1 et 100
     * @return true si ok, false sinon
     */
    private boolean checkInputMinMaxNiveau(){
        return (this.niveau>=1 && this.niveau <= 100);
    }

    /**
     * V�rifie si la caract�ristique est comprise entre 0 et 100
     * @return true si ok, false sinon
     */
    private boolean checkInputMinMaxForce(){
        return (this.force >=0 && this.force <= 100);
    }

    /**
     * V�rifie si la caract�ristique est comprise entre 0 et 100
     * @return true si ok, false sinon
     */
    private boolean checkInputMinMaxAgility(){
        return (this.agility >=0 && this.agility <= 100);
    }

    /**
     * V�rifie si la caract�ristique est comprise entre 0 et 100
     * @return true si ok, false sinon
     */
    private boolean checkInputMinMaxIntelligence(){
        return (this.intelligence >=0 && this.intelligence <= 100);
    }

    /**
     * V�rifie si la somme des caract�ristiques de force, agilit� et intelligence est �gale au niveau du joueur
     * @return true si la somme est inf�rieure ou �gale, false sinon
     */
    private boolean checkSumInputSkills(){
        int sumSkills =this.force + this.agility + this.intelligence;

        return (sumSkills <= this.niveau);
    }

    /**
     * Cr�e le type de joueur choisi
     * @param numPlayer le num�ro du joueur
     * @param typePlayer le type choisi
     * @return true si la cr�ation s'est bien pass�e, false sinon
     */
    boolean createPlayer(int numPlayer, TypePlayer typePlayer){
        if(!this.checkInputValues())
            return false;

        String msgPers="";
        //1: Guerrier
        //2: R�deur
        //3: Mage
        switch (typePlayer){
            case Guerrier:
                pers =new Guerrier(this.niveau, this.force, this.agility, this.intelligence);
                msgPers ="Woarg je suis le Guerrier";
                break;
            case Rodeur:
                pers =new Rodeur(this.niveau, this.force, this.agility, this.intelligence);
                msgPers ="Wizz je suis le R�deur";
                break;
            case Mage:
                pers =new Mage(this.niveau, this.force, this.agility, this.intelligence);
                msgPers ="Abracadabra je suis le Mage";
                break;
        }

        Utility.writeMsg(msgPers + " Joueur "+ numPlayer+ " niveau "+ this.niveau+ " je poss�de "+ this.pers.getVie()+ " de vitalit�, "+ this.force+ " de force, "+ this.agility+ " d'agilit�, "+ this.intelligence+ " d'intelligence !");

        return true;
    }

    /**
     * v�rifie si les caract�ristiques sont correctes
     * @return true si ok, false sinon.
     */
    private boolean checkInputValues(){

        if(!this.checkInputMinMaxAgility()){
            Utility.writeMsg("L'agilit� doit �tre entre 0 et 100");
            return false;
        }
        if(!this.checkInputMinMaxForce()){
            Utility.writeMsg("La force doit �tre entre 0 et 100");
            return false;
        }
        if(!this.checkInputMinMaxIntelligence()){
            Utility.writeMsg("L'intelligence doit �tre entre 0 et 100");
            return false;
        }
        if(!this.checkInputMinMaxNiveau()){
            Utility.writeMsg("La force doit �tre entre 1 et 100");
            return false;
        }
        if(!this.checkSumInputSkills()) {
            Utility.writeMsg("La somme des caract�ristiques ne doit pas d�passer le niveau !");
            return false;
        }

        return true;
    }


    /**
     * Ex�cute l'action du joueur
     * @param attack Le type d'attaque
     * @param playerAdverse le joueur adverse sur lequel lancer l'action
     */
    void executeAction(TypeAttack attack, Player playerAdverse){
        switch (attack){
            case attaqueBasique:
                this.pers.attaqueBasique(playerAdverse.pers);
                break;
            case attaqueSpeciale:
                this.pers.attaqueSpeciale(playerAdverse.pers);
                break;
        }
    }

    /**
     * V�rifie si le joueur est encore en vie
     * @return true si vivant, false sinon
     */
    boolean isAlive(){
        return this.pers.isAlive();
    }
}
