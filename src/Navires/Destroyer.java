package Navires;

public class Destroyer extends Navire
{

    private Destroyer(){
        x = 0;
        y = 0;
        pTire=1;
        taille = 3;
        Pv=taille;
        orientation = " ";
        pattern = "|De";
    }

    public Destroyer(int x, int y, String orientation,boolean user,int shipnumb){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        taille = 3;
        Pv=taille;
        pTire=1;
        bateau = new String[Grid.x/2][Grid.y];
        pattern = "|De";
        if(user){
            super.positionnement(true);
        }else {
            super.positionnementCPU(true);
        }
    }
/*
    @Override
    public void Tir(int x, int y)
    {

    }*/
}
