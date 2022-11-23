/*
* Source:
* https://stackoverflow.com/a/47400150
* */

public class Affichage {

    public static class Grid1 {
        int x = 16;
        int y = 16;
        public String [][] grid = new String[x][y];
        public Grid1() {
            int n = 0;
            //initialize grid
            for(int outerLoopValue = 0; outerLoopValue<y;outerLoopValue++)
            {
                for(int innerLoopValue = 0; innerLoopValue<x;innerLoopValue++)
                {
                    grid[outerLoopValue][innerLoopValue]= "|__";
                }
            }
        }
        public void PrintGrid() {
            char ch = 'a';
            PrintHeader();
            for(int outerLoopValue = 0; outerLoopValue<y;outerLoopValue++)
            {
                System.out.println();
                System.out.print(ch);
                ch++;
                for(int innerLoopValue = 0; innerLoopValue<x;innerLoopValue++)
                {
                    System.out.print(grid[outerLoopValue][innerLoopValue]);
                }
                System.out.print("|");
            }
        }

        private void PrintHeader(){
            int n = 0;
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
            }
            System.out.print("|");
        }
    }
}
