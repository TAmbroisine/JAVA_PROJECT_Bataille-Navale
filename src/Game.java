import Navires.Navire;
import java.util.Scanner;

public class Game {
    Navire bato;
    Game() throws Exception {
        bato = new Navire();
        // Generate user's boats
        bato.SpawnBoat(true);
        // Generate CPU's boats
        bato.SpawnBoat(false);

    }

    public void Start(){
        while(true){

        }

    }
}
