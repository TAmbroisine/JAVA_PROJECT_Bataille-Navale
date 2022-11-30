package Navires;

public class Croiseur extends Navire
{
    int x;
    int y;
    int pTire;
    String orientation,pattern;
    int taille;
    String[][] bateau;
    String[][] tireB;

    private Croiseur(){
        x = 0;
        y = 0;
        orientation = " ";
        taille = 5;
        pTire=4;
        bateau = new String[Plateau.x/2][Plateau.y];
        pattern = "|Cr";
        tireB = new String[Plateau.x/2][Plateau.y];
    }

    public Croiseur(int x, int y, String orientation, boolean user){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        taille = 5;
        pTire=4;
        bateau = new String[Plateau.x/2][Plateau.y];
        tireB = new String[Plateau.x/2][Plateau.y];
        pattern = "|Cr";
        if(user){
            super.positionnement(this.orientation, this.y, this.x,taille,pattern,true );
        }else {
            super.positionnementCPU(this.orientation, this.y, this.x,taille,pattern,true );
        }
    }
/*
    @Override
    public void Tir(int x, int y)
    {

    }

 */
}
