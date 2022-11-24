import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException
    {
        //Menu.print();

        Cuirasse cuirasse = new Cuirasse(5,5,"vertical");
        Destroyer destroyer = new Destroyer(3,4,"horizontal");
        Sous_Marin sous_marin = new Sous_Marin(1,1,"vertical");
        Croiseur croiseur = new Croiseur(6,6,"vertical");

    }

}