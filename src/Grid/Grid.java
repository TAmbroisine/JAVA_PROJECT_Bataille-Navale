package Grid;

import java.util.Objects;

public class Grid {
    public int x = 16*2;
    public int y = x/2;

    int separateur = x/2 + 1;
    public String [][] grid = new String[x+1][y];
    public Grid() {
        int n = 0;
        //initialize grid
        for(int outerLoopValue = 0; outerLoopValue<y;outerLoopValue++)
        {
            // grille USER
            for(int innerLoopValue = 0; innerLoopValue<(x/2);innerLoopValue++)
            {
                grid[innerLoopValue][outerLoopValue]= "|__";
            }
            // Séparation
            for(int innerSepareurValue = x/2; innerSepareurValue < separateur; innerSepareurValue++)
            {

                grid[innerSepareurValue][outerLoopValue]= "|   ";
            }
            // grille CPU
            for(int innerLoopValue = separateur; innerLoopValue<x+1;innerLoopValue++)
            {
                grid[innerLoopValue][outerLoopValue]= "|__";
            }

        }
    }
    public void AddBoat(String[][] Navire) {
        int n = 0;
        //initialize grid
        for(int outerLoopValue = 0; outerLoopValue<y;outerLoopValue++)
        {
            // grille USER
            for(int innerLoopValue = 0; innerLoopValue<(x/2);innerLoopValue++)
            {
                    /* if navire[x][y]== |## -> grid[x][y] = |##
                        Implémente le bateau dans la grille
                    */
                if (!Objects.equals(Navire[outerLoopValue][innerLoopValue], "|__")){
                    if(Navire[outerLoopValue][innerLoopValue] != null)
                    {
                        grid[outerLoopValue][innerLoopValue] = Navire[outerLoopValue][innerLoopValue];
                    }
                }
            }
        }
    }


    public void AddTireImpact(int x, int y, boolean flag) {
        if(flag){
            grid[x][y]= "|TT";
        } else if (flag) {
            grid[x][y]= "|XX";
        }

    }

    public String[][] getGrid() {
        return grid;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
