package Navires;

public class Cuirasse extends Navire
{
    public Cuirasse(){
        x = 0;
        y = 0;
        orientation = " ";
        taille = 7;
        Pv=taille;
        pTire=9;
        pattern = "|Cu";
    }

    public Cuirasse(int x, int y, String orientation,boolean user,int shipnumb){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.shipnumb = shipnumb;
        taille = 7;
        pTire=9;
        pattern = "|U";
        if (user) {
            super.positionnement(true);
        }
        else {
            super.positionnementCPU(true);
        }
    }
/*
    @Override
    public void Tir(int x, int y)
    {

    }
*/
}
