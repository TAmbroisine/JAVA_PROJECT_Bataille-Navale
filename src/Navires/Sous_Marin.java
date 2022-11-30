package Navires;

public class Sous_Marin extends Navire
{
    int x,y,taille,pTire,Pv;
    String orientation,pattern;
    String[][] bateau,tireB;

    private Sous_Marin(){
        x = 0;
        y = 0;
        pTire=1;
        taille = 1;
        Pv=taille;
        orientation = " ";
        pattern = "|Sm";
    }

    public Sous_Marin(int x, int y, String orientation,boolean user){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        taille = 1;
        Pv=taille;
        pTire=1;
        bateau = new String[Plateau.x/2][Plateau.y];
        pattern = "|Sm";
        if(user){
            super.positionnement(this.orientation, this.y, this.x,taille, pattern,true );
        }else {
            super.positionnementCPU(this.orientation, this.y, this.x,taille, pattern,true );
        }
    }/*
    @Override
    public void Tir(int x, int y) {

    }*/
}
