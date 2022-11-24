public class Croiseur extends Navire
{
    int x;
    int y;
    String orientation;
    int taille;
    String[][] bateau;

    private Croiseur(){
        x = 0;
        y = 0;
        orientation = " ";
        taille = 5;
    }

    public Croiseur(int x, int y, String orientation){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        taille = 5;
        bateau = new String[Plateau.x/2][Plateau.y];
        super.postionnement(this.orientation, this.y, this.x,taille,bateau);
        super.Plateau.PrintGrid();
    }

    @Override
    public void Tir(int x, int y)
    {

    }
}
