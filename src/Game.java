import Navires.Navire;

public class Game {
    Navire bato;

    Game(){
        bato = new Navire();
        // Generate user's boats
        bato.SpawnBoat(true);
        // Generate CPU's boats
        bato.SpawnBoat(false);
    }

    public void Start(){


    }
}
