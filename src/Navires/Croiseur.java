package Navires;

public class Croiseur extends Navire
{
    private Croiseur(){
        x = 0;
        y = 0;
        orientation = " ";
        taille = 5;
        Pv= taille;
        pTire=4;
        bateau = new String[Grid.x/2][Grid.y];
        pattern = "|Cr";
        tireB = new String[Grid.x/2][Grid.y];
    }

    public Croiseur(int x, int y, String orientation, boolean user){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.shipnumb = shipnumb;
        taille = 5;
        Pv= taille;
        pTire=4;
        bateau = new String[Grid.x/2][Grid.y];
        tireB = new String[Grid.x/2][Grid.y];
        pattern = "|Cr";
        if(user){
            positionnement(true);
        }else {
            positionnementCPU(true);
        }
    }
/*
    @Override
    public void Tir(int x, int y)
    {

    }

 */
}
