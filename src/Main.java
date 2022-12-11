import Affichages.Menu;

import java.io.IOException;

/**
 * Main
 */
public class Main {
    /**
     * Main
     * @param args arguemnt
     * @throws Exception Exception
     */
    public static void main(String[] args) throws Exception {
        Game Game = new Game();
        Menu menu = new Menu();
        if(menu.print()){
            Game.Starting_GAME(true);
            Game.IN_GAME(true);
        }


    }
}