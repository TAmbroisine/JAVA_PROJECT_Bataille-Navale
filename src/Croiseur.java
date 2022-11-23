public class Croiseur extends Navire
{
    int x;
    int y;
    String orientation;
    private Croiseur(){
        x = 0;
        y = 0;
        orientation = " ";
    }

    private Croiseur(int x, int y, String orientation){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    @Override
    public void Tir(int x, int y)
    {

    }

    @Override
    public void Positionnement()
    {

    }
}
