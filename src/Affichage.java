/*
* Source:
* https://stackoverflow.com/a/47400150
* */

import java.util.Objects;

public class Affichage {

    Affichage(){}

    public static class Grid1 {
        int x = 16*2;
        int y = 16;

        int separateur = x/2 + 1;
        public String [][] grid = new String[x+1][y];
        public Grid1() {
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
                    if (Objects.equals(Navire[outerLoopValue][innerLoopValue], "|##")){
                        grid[outerLoopValue][innerLoopValue]= "|##";
                    }
                    /* if grid[x][y] != |## -> grid[x][y] = |__
                        Empêche l'effacement d'un bateau déjà présent
                     */
                    else if (!Objects.equals(grid[outerLoopValue][innerLoopValue], "|##")){
                        grid[outerLoopValue][innerLoopValue]= "|__";
                    }
                }
            }
        }
        public void PrintGrid() {
            char ch = 'a';
            Nom_Grille();
            PrintHeader();
            for(int outerLoopValue = 0; outerLoopValue<y;outerLoopValue++)
            {
                System.out.println();
                System.out.print(ch);
                ch++;
                for(int innerLoopValue = 0; innerLoopValue<x+1;innerLoopValue++)
                {
                    System.out.print(grid[innerLoopValue][outerLoopValue]);
                }
                System.out.print("|");
            }
        }

        private void PrintHeader(){
            int n = 0;
            boolean reset = true;
            System.out.print(" ");
            for(int innerLoopValue = 0; innerLoopValue<x;innerLoopValue++)
            {
                if (n < 10)
                {
                    System.out.print("| "+ n);
                }
                else{
                    System.out.print("|"+ n);
                }
                n++;
                if(n>15 && reset){

                    System.out.print("|   ");
                    n=0;
                    reset = false;
                }
            }
            System.out.print("|");
        }
     public void Nom_Grille(){
         System.out.println();
         System.out.print("                   ");
         System.out.print("Grille du joueur");
         System.out.print("                   ");
         System.out.print("       ");
         System.out.println("Grille des dégats sur l'ordinateur");
     }

    }
}
