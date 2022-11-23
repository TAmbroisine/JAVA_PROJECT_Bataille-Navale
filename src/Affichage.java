/*
* Source:
* https://stackoverflow.com/a/47400150
* */

public class Affichage {

    public class Grid1 {
        public char [][] grid = new char [10][10];
        public Grid1() {
            //initialize grid
            for(int outerLoopValue = 0; outerLoopValue<10;outerLoopValue++)
            {
                for(int innerLoopValue = 0; innerLoopValue<10;innerLoopValue++)
                {
                    grid[outerLoopValue][innerLoopValue]='O';
                }
            }
        }
        public void PrintGrid() {
            for(int outerLoopValue = 0; outerLoopValue<10;outerLoopValue++)
            {
                System.out.println("");
                for(int innerLoopValue = 0; innerLoopValue<10;innerLoopValue++)
                {
                    System.out.print(grid[outerLoopValue][innerLoopValue]+"  ");
                }
            }
        }
    }
}
