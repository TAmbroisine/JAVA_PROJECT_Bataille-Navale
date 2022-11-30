import Affichages.Menu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {

        Menu menu = new Menu();
        menu.print();
        Game game = new Game();
        game.Start();
         //Navires.Navire navire = new Navires.Navire();
         //navire.SpawnBoat(true);


    }
}