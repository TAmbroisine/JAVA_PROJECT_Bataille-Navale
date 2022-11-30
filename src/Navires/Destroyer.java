package Navires;

public class Destroyer extends Navire
{
    int x,y,pTire,taille,Pv;
    String orientation,pattern;
    String[][] bateau,tireB;
    private Destroyer(){
        x = 0;
        y = 0;
        pTire=1;
        orientation = " ";
        pattern = "|De";
    }

    public Destroyer(int x, int y, String orientation,boolean user){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        taille = 3;
        pTire=1;
        bateau = new String[Plateau.x/2][Plateau.y];
        pattern = "|De";
        if(user){
            super.positionnement(this.orientation, this.y, this.x,taille,pattern,true );
        }else {
            super.positionnementCPU(this.orientation, this.y, this.x,taille,pattern,true );
        }

        //super.Plateau.PrintGrid();
    }
/*
    @Override
    public void Tir(int x, int y)
    {

    }*/
}
