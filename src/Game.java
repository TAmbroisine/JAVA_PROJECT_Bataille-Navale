import Affichages.MenuGame;
import Navires.Sous_Marin;

public class Game {
    Player player,CPU;
    MenuGame menugame;

    Game()  {
        //nouvelle classe starting game pour rendre le constructeur game utilisable dans un chargement de partie
        player = new Player();
        CPU = new Player();
        menugame = new MenuGame();
    }

    public void Starting_GAME (boolean ChoixUser) throws Exception {
        while (ChoixUser) {
            player.navires.SpawnBoat(true);
            CPU.navires.SpawnBoat(false);
            ChoixUser = false;
        }
    }
    public void IN_GAME(boolean ChoixUser){
        boolean direction;
        while(ChoixUser){

            int[] playerschoice = menugame.SelectBoat();
            switch(playerschoice[0]){
                case 1 :
                    switch(playerschoice[1]){
                        case 1 :
                        if (menugame.ShootOrMove()){
                            //option 1
                            direction = menugame.WichDirection(player.navires.Sous_Marin.getOrientation());
                            if (!player.navires.Sous_Marin.Deplacement(direction)){
                                //afficher message d'erreur déplacement impossible
                            }
                            //option 2
                            player.navires.Sous_Marin.Deplacement(menugame.WichDirection(player.navires.Sous_Marin.getOrientation()));
                        }else{
                            //tire
                            Object[] coord = menugame.CoordonatesShoots();
                            player.navires.Sous_Marin.CheckImpact((int)coord[0],(char)coord[1]);
                        }
                        case 2 :
                        if (menugame.ShootOrMove()){
                            menugame.WichDirection(player.navires.Sous_Marin1.getOrientation());
                        }else {
                            //tire
                        }
                        case 3:
                        if (menugame.ShootOrMove()){
                            menugame.WichDirection(player.navires.Sous_Marin2.getOrientation());
                        }else{
                            //tire
                        }
                        case 4:
                        if (menugame.ShootOrMove()){
                            menugame.WichDirection(player.navires.Sous_Marin3.getOrientation());
                        }else{
                            //tire
                        }
                    }
                case 2: switch(playerschoice[1]){
                    case 1 :
                        if (menugame.ShootOrMove()){
                            menugame.WichDirection(player.navires.destroyer.getOrientation());
                        }else{
                            //tire
                        }
                    case 2 :
                        if (menugame.ShootOrMove()){
                            menugame.WichDirection(player.navires.destroyer1.getOrientation());
                        }else {
                            //tire
                        }
                    case 3:
                        if (menugame.ShootOrMove()){
                            menugame.WichDirection(player.navires.destroyer2.getOrientation());
                        }else{
                            //tire
                        }
                }
                case 3: switch(playerschoice[1]) {
                    case 1:
                        if (menugame.ShootOrMove()) {
                            menugame.WichDirection(player.navires.croiseur.getOrientation());
                        } else {
                            //tire
                        }
                    case 2:
                        if (menugame.ShootOrMove()) {
                            menugame.WichDirection(player.navires.croiseur1.getOrientation());
                        } else {
                            //tire
                        }
                }
                case 4:
                    if (menugame.ShootOrMove()) {
                        menugame.WichDirection(player.navires.cuirasse.getOrientation());
                    } else {
                        //tire
                    }


                    //player.navires.Sous_Marin
}


            //ChoixUser = false;
        }

    }
}
