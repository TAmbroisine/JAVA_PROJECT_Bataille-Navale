public class Sous_Marin extends Navire
{
    int x;
    int y;
    String orientation;
    int taille;
    String[][] bateau;
    private Sous_Marin(){
        x = 0;
        y = 0;
        orientation = " ";
    }

    public Sous_Marin(int x, int y, String orientation){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        taille = 1;
        bateau = new String[Plateau.x/2][Plateau.y];
        super.positionnement(this.orientation, this.y, this.x,taille,bateau);
        super.Plateau.PrintGrid();
    }
    @Override
    public void Tir(int x, int y) {

    }
}
