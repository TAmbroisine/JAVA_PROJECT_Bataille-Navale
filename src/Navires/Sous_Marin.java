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
        pattern = "|S";
    }

    public Sous_Marin(int x, int y, String orientation,boolean user,int shipnumb){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.shipnumb = shipnumb;
        taille = 1;
        Pv=taille;
        pTire=1;
        pattern = "|S";
        if(user){
            super.positionnement(true);
        }else {
            super.positionnementCPU(true);
        }
    }
    public int GetNum_Sous_Marin(){
        return shipnumb;
    }
    /*

    @Override
    public void Tir(int x, int y) {

    }*/
}
