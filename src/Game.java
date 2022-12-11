import Affichages.MenuGame;
import Affichages.ResetConsole;
import Navires.Navire;
import Navires.Sous_Marin;

/**
 * Création de la classe Game.
 */
public class Game {
    /**
     * Création d'un instance d'objet de type Player.
     */
    Player player,CPU;
    /**
     * Création d'un instance d'objet de type MenuGame.
     */
    MenuGame menugame;

    /**
     * Création d'un constructeur par default.
     * Initialisation des variables player, CPU et menugame.
     */
    Game()  {
        //nouvelle classe starting game pour rendre le constructeur game utilisable dans un chargement de partie
        player = new Player();
        CPU = new Player();
        menugame = new MenuGame();
    }

    /**
     * La méthode Starting_GAME permet de lancer le jeu en créant les navires.
     * @param ChoixUser true si joueur
     * @throws Exception Exception
     */
    public void Starting_GAME (boolean ChoixUser) throws Exception {
        while (ChoixUser) {
            player.navires.SpawnBoat(true);
            CPU.navires.SpawnBoat(false);
            ChoixUser = false;
        }
    }

    /**
     * La méthode IN_GAME permet de vérifier la vie des navires.
     * @param ChoixUser utilisateur
     */
    public void IN_GAME(boolean ChoixUser){
        while(ChoixUser){
            // Move or Shoot according to the player's choice
            controllerChoice();
            player.navires.checkAllboatLife();
            CPU.navires.checkAllboatLife();

            //ChoixUser = false;
        }

    }

    /**
     * La méthode charToInt permet de convertir un caractère en entier.
     * @param input Caractère
     * @return Entier
     */

    private int charToInt(char input){
        int n = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            if (c==input){
                //System.out.println(input+" = "+n);
                return n;
            }
            n++;
        }
        return 0;
    }

    /**
     * La méthode clearConsole permet de supprimer l'historique du console.
     */
    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            //  Handle any exceptions.
        }
    }

    /**
     * La méthode Tire permet de lancer les méthodes pour réaliser une tire.
     * @param bato Navire
     */

    private void Tire(Navire bato){
        Object[] coord = menugame.CoordonatesShoots();
        /*
         * charToInt(coord[1].toString().charAt(0))
         *   --> Convert Object containing a char to char
         *       --> then convert that char to its int equivalent
         */
        ResetConsole.FullClear();
        int x = (int)coord[0];
        int y = charToInt(coord[1].toString().charAt(0));
        bato.CheckImpact(x,y,true);
        player.navires.PrintGrid(true);
        CPU.navires.PrintGrid(false);
    }
    /**
     * La méthode Move permet de lancer les méthodes pour réaliser un déplacement .
     * @param bato Navire
     */

    private void Move(Navire bato){
        boolean direction;
        direction = menugame.WichDirection(bato.getOrientation());
        if (!bato.Deplacement(direction)){
            //afficher message d'erreur déplacement impossible
            menugame.printMoveError();
        }
        ResetConsole.FullClear();
        player.navires.PrintGrid(true);
    }

    /**
     * La méthode controllerChoice permet de lancer les méthodes de choix (menu).
     */

    private void controllerChoice(){
        boolean direction;
        int[] playerschoice = menugame.SelectBoat();
        switch(playerschoice[0]){
            case 1 :
                switch(playerschoice[1]){
                    case 1 :
                        if (menugame.ShootOrMove()){
                            //option 1
                            Move(player.navires.Sous_Marin);
                        }else{
                            //tire
                            Tire(player.navires.Sous_Marin);
                        }
                        break;
                    case 2 :
                        if (menugame.ShootOrMove()){
                            Move(player.navires.Sous_Marin1);
                        }else {
                            //tire
                            Tire(player.navires.Sous_Marin1);
                        }
                        break;
                    case 3:
                        if (menugame.ShootOrMove()){
                            Move(player.navires.Sous_Marin2);
                        }else{
                            //tire
                            Tire(player.navires.Sous_Marin2);
                        }
                        break;
                    case 4:
                        if (menugame.ShootOrMove()){
                            Move(player.navires.Sous_Marin3);
                        }else{
                            //tire
                            Tire(player.navires.Sous_Marin3);
                        }
                        break;
                }
                break;
            case 2:
                switch(playerschoice[1]){
                    case 1 :
                        if (menugame.ShootOrMove()){
                            Move(player.navires.destroyer);
                        }else{
                            //tire
                            Tire(player.navires.destroyer);
                        }
                        break;
                    case 2 :
                        if (menugame.ShootOrMove()){
                            Move(player.navires.destroyer1);
                        }else {
                            //tire
                            Tire(player.navires.destroyer1);
                        }
                        break;
                    case 3:
                        if (menugame.ShootOrMove()){
                            Move(player.navires.destroyer2);
                        }else{
                            //tire
                            Tire(player.navires.destroyer2);
                        }
                        break;
                }
                break;
            case 3:
                switch(playerschoice[1]) {
                    case 1:
                        if (menugame.ShootOrMove()) {
                            Move(player.navires.croiseur);
                        } else {
                            //tire
                            Tire(player.navires.croiseur);
                        }
                        break;
                    case 2:
                        if (menugame.ShootOrMove()) {
                            Move(player.navires.croiseur1);
                        } else {
                            //tire
                            Tire(player.navires.croiseur1);
                        }
                        break;
                }
                break;
            case 4:
                if (menugame.ShootOrMove()) {
                    Move(player.navires.cuirasse);
                } else {
                    //tire
                    Tire(player.navires.cuirasse);
                }
                break;
        }
    }

    /**
     * La méthode GameplayCPU permet de lancer les attaques et le déplacement.
     */


}
