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

    private Sous_Marin(int x, int y, String orientation){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        taille = 1;
        bateau = new String[Plateau.x][Plateau.y];
        super.postionnement(this.orientation, this.y, this.x,taille,bateau);
        Plateau.PrintGrid();
    }
    @Override
    public void Tir(int x, int y) {

    }
}
