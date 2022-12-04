package Navires;

public class Sous_Marin extends Navire
{

    private Sous_Marin(){
        x = 0;
        y = 0;
        pTire=1;
        taille = 1;
        Pv=taille;
        orientation = " ";
        pattern = "|Sm";
    }

    public Sous_Marin(int x, int y, String orientation,boolean user,int shipnumb){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        taille = 1;
        Pv=taille;
        pTire=1;
        bateau = new String[Grid.x/2][Grid.y];
        pattern = "|Sm";
        if(user){
            super.positionnement(true);
        }else {
            super.positionnementCPU(true);
        }
    }/*
    @Override
    public void Tir(int x, int y) {

    }*/
}
