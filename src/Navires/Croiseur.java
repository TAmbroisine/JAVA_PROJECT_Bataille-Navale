package Navires;

public class Croiseur extends Navire
{
    private Croiseur(){
        x = 0;
        y = 0;
        orientation = " ";
        taille = 5;
        boatHp = taille;
        pTire=4;
        pattern = "|C";
    }

    public Croiseur(int x, int y, String orientation, boolean user,int shipnumb){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.shipnumb = shipnumb;
        taille = 5;
        boatHp = taille;
        pTire=4;
        pattern = "|C"+shipnumb;
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
