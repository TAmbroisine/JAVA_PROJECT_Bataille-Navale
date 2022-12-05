import Navires.Navire;
import java.util.Scanner;

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
            Navires.Navire navire = new Navires.Navire();
            navire.SpawnBoat(true);
            navire.SpawnBoat(false);

            ChoixUser = false;
        }

    }
}
