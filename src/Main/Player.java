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
     * Vérifie si la caractéristique est comprise entre 1 et 100
     * @return true si ok, false sinon
     */
    private boolean checkInputMinMaxNiveau(){
        return (this.niveau>=1 && this.niveau <= 100);
    }

    /**
     * Vérifie si la caractéristique est comprise entre 0 et 100
     * @return true si ok, false sinon
     */
    private boolean checkInputMinMaxForce(){
        return (this.force >=0 && this.force <= 100);
    }

    /**
     * Vérifie si la caractéristique est comprise entre 0 et 100
     * @return true si ok, false sinon
     */
    private boolean checkInputMinMaxAgility(){
        return (this.agility >=0 && this.agility <= 100);
    }

    /**
     * Vérifie si la caractéristique est comprise entre 0 et 100
     * @return true si ok, false sinon
     */
    private boolean checkInputMinMaxIntelligence(){
        return (this.intelligence >=0 && this.intelligence <= 100);
    }

    /**
     * Vérifie si la somme des caractéristiques de force, agilité et intelligence est égale au niveau du joueur
     * @return true si la somme est inférieure ou égale, false sinon
     */
    private boolean checkSumInputSkills(){
        int sumSkills =this.force + this.agility + this.intelligence;

        return (sumSkills <= this.niveau);
    }

    /**
     * Crée le type de joueur choisi
     * @param numPlayer le numéro du joueur
     * @param typePlayer le type choisi
     * @return true si la création s'est bien passée, false sinon
     */
    boolean createPlayer(int numPlayer, TypePlayer typePlayer){
        if(!this.checkInputValues())
            return false;

        String msgPers="";
        //1: Guerrier
        //2: Rôdeur
        //3: Mage
        switch (typePlayer){
            case Guerrier:
                pers =new Guerrier(this.niveau, this.force, this.agility, this.intelligence);
                msgPers ="Woarg je suis le Guerrier";
                break;
            case Rodeur:
                pers =new Rodeur(this.niveau, this.force, this.agility, this.intelligence);
                msgPers ="Wizz je suis le Rôdeur";
                break;
            case Mage:
                pers =new Mage(this.niveau, this.force, this.agility, this.intelligence);
                msgPers ="Abracadabra je suis le Mage";
                break;
        }

        Utility.writeMsg(msgPers + " Joueur "+ numPlayer+ " niveau "+ this.niveau+ " je possède "+ this.pers.getVie()+ " de vitalité, "+ this.force+ " de force, "+ this.agility+ " d'agilité, "+ this.intelligence+ " d'intelligence !");

        return true;
    }

    /**
     * vérifie si les caractéristiques sont correctes
     * @return true si ok, false sinon.
     */
    private boolean checkInputValues(){

        if(!this.checkInputMinMaxAgility()){
            Utility.writeMsg("L'agilité doit être entre 0 et 100");
            return false;
        }
        if(!this.checkInputMinMaxForce()){
            Utility.writeMsg("La force doit être entre 0 et 100");
            return false;
        }
        if(!this.checkInputMinMaxIntelligence()){
            Utility.writeMsg("L'intelligence doit être entre 0 et 100");
            return false;
        }
        if(!this.checkInputMinMaxNiveau()){
            Utility.writeMsg("La force doit être entre 1 et 100");
            return false;
        }
        if(!this.checkSumInputSkills()) {
            Utility.writeMsg("La somme des caractéristiques ne doit pas dépasser le niveau !");
            return false;
        }

        return true;
    }


    /**
     * Exécute l'action du joueur
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
     * Vérifie si le joueur est encore en vie
     * @return true si vivant, false sinon
     */
    boolean isAlive(){
        return this.pers.isAlive();
    }
}
