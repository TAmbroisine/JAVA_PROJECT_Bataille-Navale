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
                if (!Objects.equals(Navire[innerLoopValue][outerLoopValue], "|__")){
                    if(Navire[innerLoopValue][outerLoopValue] != null)
                    {
                        grid[innerLoopValue][outerLoopValue] = Navire[innerLoopValue][outerLoopValue];
                    }
                }
            }
        }
    }


    public void AddTireImpactOnMonitor(int x, int y, int type) {
        if(type == 1){
            grid[x+separateur][y]= "\033[31m|TT\033[0m";
        } else if (type == 0){
            grid[x+separateur][y]= "\033[34m|XX\033[0m";
        } else {
            grid[x+separateur][y]= "\033[32m|U1\033[0m";
        }

    }
    public void AddTireImpactOnPlayerGrid(int x, int y, int type) {
        if(type == 1){
            grid[x][y]= "\033[31m|TT\033[0m";
        } else if (type == 0){
            grid[x][y]= "\033[34m|XX\033[0m";
        } else {
            grid[x][y]= "\033[32m|U1\033[0m";
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
