package Navires;

public class Destroyer extends Navire
{

    private Destroyer(){
        x = 0;
        y = 0;
        pTire=1;
        taille = 3;
        boatHp =taille;
        orientation = " ";
        pattern = "|D";
    }

    public Destroyer(int x, int y, String orientation,boolean user,int shipnumb){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.shipnumb = shipnumb;
        taille = 3;
        boatHp =taille;
        pTire=1;
        pattern = "|D";
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
