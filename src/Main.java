import Affichages.Menu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        Menu menu = new Menu();
        if(menu.print()){
            game.Starting_GAME(true);
        }


         //Navires.Navire navire = new Navires.Navire();
         //navire.SpawnBoat(true);


    }
}