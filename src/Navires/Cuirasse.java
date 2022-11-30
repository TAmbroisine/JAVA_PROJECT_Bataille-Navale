package Navires;

public class Cuirasse extends Navire
{
    int x;
    int y;
    int taille;
    int pTire;
    String orientation,pattern;
    String[][] bateau;
    public Cuirasse(){
        x = 0;
        y = 0;
        orientation = " ";
        taille = 7;
        pTire=9;
        pattern = "|Cu";
        bateau = new String[Plateau.x][Plateau.y];
    }

    public Cuirasse(int x, int y, String orientation,boolean user){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        taille = 7;
        pTire=9;
        bateau = new String[Plateau.x/2][Plateau.y];
        pattern = "|Cu";
        if (user==true) {
            super.positionnement(this.orientation, this.y, this.x, taille, pattern,true);
        }
        else {
            super.positionnementCPU(this.orientation, this.y, this.x, taille, pattern,true);
        }
        //super.Plateau.PrintGrid();
    }
/*
    @Override
    public void Tir(int x, int y)
    {

    }
*/
}
