public class Destroyer extends Navire
{
    int x;
    int y;
    String orientation;
    private Destroyer(){
        x = 0;
        y = 0;
        orientation = " ";
    }

    private Destroyer(int x, int y, String orientation){
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
