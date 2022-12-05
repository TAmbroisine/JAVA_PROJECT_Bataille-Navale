package Affichages;
/*
* Source:
* https://stackoverflow.com/a/47400150
* */

public class Affichage {

    public Affichage(){}

    //View
    public void PrintGrid(String[][] grid, int x,int y) {
        char ch = 'a';
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
        System.out.println();
    }

    //View
    /*public void PrintGridCPU(String[][] gridCPU, int x,int y) {
        char ch = 'a';
        Nom_Grille();
        PrintHeader();
        for(int outerLoopValue = 0; outerLoopValue<y;outerLoopValue++)
        {
            System.out.println();
            System.out.print(ch);
            ch++;
            for(int innerLoopValue = 0; innerLoopValue<(x/2);innerLoopValue++)
            {
                System.out.print(gridCPU[innerLoopValue][outerLoopValue]);
            }
            System.out.print("|");
        }
    }*/

    //View
    public void PrintHeader(int x){
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
            if(n>(x/2)-1 && reset){

                System.out.print("|   ");
                n=0;
                reset = false;
            }
        }
        System.out.print("|");
    }
     //View
     public void Nom_Grille(int x){
         System.out.println();
         for(int i = 0; i < (x/4)-2; i++){
             System.out.print("   ");
         }
         System.out.print("Grille du joueur");
         for(int i = 0; i < (x/4)+3-5; i++) { // +4 pour prendre en compte l'espacement
             System.out.print("   ");
         }
         //System.out.print("a");

         for(int i = 0; i < (x/4)-5; i++){
             System.out.print("   ");
         }
         System.out.print("Grille des dégats sur l'ordinateur");
         for(int i = 0; i < (x/4)-1; i++) {
             System.out.print("   ");
         }
         System.out.println("");

     }
}
