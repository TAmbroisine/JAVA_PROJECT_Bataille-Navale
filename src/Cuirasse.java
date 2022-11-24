public class Cuirasse extends Navire
{
    int x;
    int y;
    int taille;
    String orientation;
    String[][] bateau;
    public Cuirasse(){
        x = 0;
        y = 0;
        orientation = " ";
        taille = 7;
        bateau = new String[Plateau.x][Plateau.y];
    }

    public Cuirasse(int x, int y, String orientation){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        taille = 7;
        bateau = new String[Plateau.x][Plateau.y];
        super.postionnement(this.orientation, this.y, this.x,taille,bateau);
        Plateau.PrintGrid();

    }

    @Override
    public void Tir(int x, int y)
    {

    }

}
