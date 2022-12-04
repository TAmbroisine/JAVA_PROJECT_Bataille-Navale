import Navires.Navire;
import java.util.Scanner;

public class Game {
    Navire bato;
    Game()  {
        //nouvelle classe starting game pour rendre le constructeur game utilisable dans un chargement de partie
    }

    public void Starting_GAME(boolean ChoixUser)throws Exception{
        while(ChoixUser){
            bato = new Navire();
            // Generate user's boats
            bato.SpawnBoat(true);
            // Generate CPU's boats
            bato.SpawnBoat(false);
            bato.SpawnBoat(true);
            // Generate CPU's boats
            bato.SpawnBoat(false);

            ChoixUser = false;
        }

    }
}
