package Navires;

import Global.Model;
import Grid.Grid;


import javax.security.auth.login.AccountLockedException;
import java.util.Objects;
import java.util.Random;

public class Navire implements Model {

    //No need for Deplacement to be abstract because it works the same for Every ship
    //Pas besoin pour Deplacement d'être abstrait car il fonctionne de la même manière pour tout les bateaux

    int xMax = Grid.getX()/2;
    int yMax = Grid.getY();
    int x,y,tempx,tempy,taille,pTire, boatHp,shipnumb;
    boolean direction, IsDMG;
    public String orientation;
    String pattern;
    String[][] bateau,tireB;
    public Cuirasse cuirasse;
    public Croiseur croiseur,croiseur1;
    public Destroyer destroyer,destroyer1,destroyer2;
    public Sous_Marin Sous_Marin,Sous_Marin1,Sous_Marin2,Sous_Marin3;

    public Navire(){
        x = 0;
        y = 0;
        shipnumb = 0;
        direction = false;
        orientation = "";
        pattern = "";
        bateau = new String[Grid.x/2][Grid.y];
        tireB = new String[Grid.x/2][Grid.y];
        IsDMG = false;
    }

    /**
     * Move the boat to the given coordonates
     * @return
     */
    public boolean Deplacement(boolean direction){
        if (!IsDMG) {
            this.direction = direction;
            tempx = x;
            tempy = y;
            IncrementCoord();
            return AddMoveToGrid();
        }else {
            System.out.println("IsDMG1");
            return false;
        }
    }

    /**
     * Try to execute move and register
     * @return boolean reprensenting the possibility of the move
     */
    private boolean AddMoveToGrid(){
        if (Objects.equals(orientation, "vertical")) {
            //debug
            System.out.println("y = "+y+"/ y + taille = "+(y+taille)+"/ yMax = "+yMax);
            System.out.println((y >= 0 & (y+taille) < yMax));
            if (y >= 0 & (y+taille) <= yMax){
                //debug
                System.out.println("Start positionnement");
                if (!positionnement(false)){
                    ResetCoord(orientation,direction);
                    return false;
                }
            }
        }
        if (Objects.equals(orientation, "horizontal")) {
            //debug
            System.out.println("x = "+x+"/ x + taille = "+(x+taille)+"/ xMax = "+xMax);
            System.out.println((x >= 0 & (x+taille) < xMax));
            if (x >= 0 & (x+taille) <= xMax){
                if (!positionnement(false)){
                    ResetCoord(orientation,direction);
                    return false;
                }
            }
        }
        return true;
    }

    //abstract public void Tir (int x, int y);

    public boolean positionnement(boolean init) {

        if (CheckSpace(orientation,y,x,taille)) {
            // Debug
            System.out.println("CheckSpace successful");
            if (Objects.equals(orientation, "vertical")) {
                for (int i = y; i < (y + taille); i++) {
                    bateau[x][i] = pattern;
                }
            }
            if (Objects.equals(orientation, "horizontal")) {
                for (int i = x; i < (x + taille); i++) {
                    bateau[i][y] = pattern;
                }
            }
            Grid.AddBoat(bateau);
            if (!init){
                clearBoat();
            }
            return true;
        }
        else if (init){
            orientation = RandOrientation();
            int[] coord = RandCoord(orientation,taille);
            x = coord[0];
            y = coord[1];
            positionnement(true);
        }
        //Debug
        System.out.println("CheckSpace failed");
        return false;
    }

    public boolean positionnementCPU(boolean init) {
        if (CheckSpaceCPU(orientation,y,x,taille)) {
            //bateau[x][y] = "|0" + shipnumb;
            if (Objects.equals(orientation, "vertical")) {
                for (int i = y; i < (y + taille); i++) {
                    bateau[x][i] = pattern;
                }
            }
            if (Objects.equals(orientation, "horizontal")) {
                for (int i = x; i < (x + taille); i++) {
                    bateau[i][y] = pattern;
                }
            }
            GridCPU.AddBoat(bateau);
            if (!init){
                clearBoat();
            }
            return true;
        }
        else if (init){
            orientation = RandOrientation();
            int[] coord = RandCoord(orientation,taille);
            x = coord[0];
            y = coord[1];
            positionnementCPU(true);
        }
        return false;
    }

    private boolean CheckSpace(String orientation, int y, int x, int taille){
        if (Objects.equals(orientation, "vertical")) {
            for (int i = y; i < (y + taille); i++) {
                //debug
                System.out.println("Grid.grid[x]["+i+"] = " + Grid.grid[x][i]);
                System.out.println("pattern = " + pattern);
                System.out.println("(!Objects.equals(Grid.grid[x][i], '|__') = "+(!Objects.equals(Grid.grid[x][i], "|__")));
                System.out.println("(!Objects.equals(Grid.grid[x][i], pattern)) = "+(!Objects.equals(Grid.grid[x][i], pattern)));
                System.out.println((!Objects.equals(Grid.grid[x][i], "|__") & (!Objects.equals(Grid.grid[x][i], pattern))));
                if (!Objects.equals(Grid.grid[x][i], "|__") & (!Objects.equals(Grid.grid[x][i], pattern))){
                    return false;
                }
            }
        }
        else if (Objects.equals(orientation, "horizontal")) {
            for (int i = x; i < (x + taille); i++) {
                //debug
                System.out.println("Grid.grid["+i+"][y] = " + Grid.grid[i][x]);
                System.out.println("(!Objects.equals(Grid.grid[i][y], '|__') = "+(!Objects.equals(Grid.grid[i][y], "|__")));
                System.out.println("(!Objects.equals(Grid.grid[i][y], pattern)) = "+(!Objects.equals(Grid.grid[i][y], pattern)));
                System.out.println((!Objects.equals(Grid.grid[i][y], "|__") & (!Objects.equals(Grid.grid[i][y], pattern))));
                if (!Objects.equals(Grid.grid[i][y], "|__") & (!Objects.equals(Grid.grid[i][y], pattern))){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean CheckSpaceCPU(String orientation, int y, int x, int taille){
        if (Objects.equals(orientation, "vertical")) {
            for (int i = y; i < (y + taille); i++) {
                if (!Objects.equals(GridCPU.grid[x][i], "|__")) {
                    return false;
                }
            }
        }
        else if (Objects.equals(orientation, "horizontal")) {
            for (int i = x; i < (x + taille); i++) {
                if (!Objects.equals(GridCPU.grid[i][y], "|__")){
                    return false;
                }
            }
        }
        return true;
    }

    public void SpawnBoat(boolean user) throws Exception {
        // Chaque joueur possède une flotte de 10 navires : 1 cuirassé, 2 croiseurs, 3 destroyers et 4 sous-marins/

        GenerateCroiseur(user);
        GenerateDestroyer(user);
        GenerateCuirrasse(user);
        GenerateSous_Marin(user);
        if(user){
            PrintGrid();
        }else {
            PrintGridCPU();
        }

    }

    private int[] RandCoord(String orientation, int taille){
        int borneInf= 0;
        int borneSup= Grid.y;
        int[] nb = new int[2];
        Random random= new Random();
        if (Objects.equals(orientation, "horizontal")) {
            // Generate x
            nb[0] = borneInf + random.nextInt((borneSup - taille) - borneInf);
            // Generate y
            nb[1] = borneInf + random.nextInt(borneSup - borneInf);
        }
        else{
            // Generate x
            nb[0] = borneInf+random.nextInt(borneSup - borneInf);
            // Generate y
            nb[1] = borneInf+random.nextInt((borneSup-taille) - borneInf);
        }
        return nb;
    }
    private String RandOrientation(){
        String orientation="";
        int borneInf= 1;
        int borneSup= 3;
        int nb;
        Random random= new Random();
        nb = borneInf+random.nextInt(borneSup-borneInf);
        if(nb==1){
            orientation = "vertical";
        } else {
            orientation = "horizontal";
        }

        return orientation;
    }

    private void GenerateCuirrasse(boolean user){
        String orientation = RandOrientation();
        int[] coord = RandCoord(orientation,7);
        cuirasse = new Cuirasse(coord[0], coord[1], orientation,user,1);
    }
    private void GenerateCroiseur(boolean user){
        String orientation = RandOrientation();
        int[] coord = RandCoord(orientation,5);
        croiseur = new Croiseur(coord[0], coord[1], orientation, user,1);
        orientation = RandOrientation();
        coord = RandCoord(orientation,5);
        croiseur1 = new Croiseur(coord[0], coord[1], orientation,user,2);
    }

    private void GenerateDestroyer(boolean user){
        String orientation = RandOrientation();
        int[] coord = RandCoord(orientation,3);
        destroyer = new Destroyer(coord[0], coord[1], orientation,user,1);

        orientation = RandOrientation();
        coord = RandCoord(orientation,3);
        destroyer1 = new Destroyer(coord[0], coord[1], orientation,user,2);

        orientation = RandOrientation();
        coord = RandCoord(orientation,3);
        destroyer2 = new Destroyer(coord[0], coord[1], orientation,user,3);

    }

    private void GenerateSous_Marin(boolean user){
        String orientation = RandOrientation();
        int[] coord = RandCoord(orientation,1);
        Sous_Marin = new Sous_Marin(coord[0], coord[1], orientation,user,1);

        orientation = RandOrientation();
        coord = RandCoord(orientation,1);
        Sous_Marin1 = new Sous_Marin(coord[0], coord[1], orientation,user,2);

        orientation = RandOrientation();
        coord = RandCoord(orientation,1);
        Sous_Marin2 = new Sous_Marin(coord[0], coord[1], orientation,user,3);

        orientation = RandOrientation();
        coord = RandCoord(orientation,1);
        Sous_Marin3 = new Sous_Marin(coord[0], coord[1], orientation,user,4);
    }

    private void IncrementCoord(){
        if (Objects.equals(orientation, "vertical")) {
            if (direction){
                //debug
                System.out.println("y = "+y+" --> y = "+(y-1));
                y-=1;
            }else {
                //debug
                System.out.println("y = "+y+" --> y = "+(y+1));
                y+=1;
            }

        }
        if (Objects.equals(orientation, "horizontal")) {
            if (direction){
                //debug
                System.out.println("x = "+x+" --> x = "+(x+1));
                x+=1;
            }else {
                //debug
                System.out.println("x = "+x+" --> x = "+(x-1));
                x-=1;
            }
        }
    }

    private void ResetCoord(String orientation,boolean direction){
        if (Objects.equals(orientation, "vertical")) {
            if (direction){
                y+=1;
            }else {
                y-=1;
            }
        }
        if (Objects.equals(orientation, "horizontal")) {
            if (direction){
                x+=1;
            }else {
                x-=1;
            }
        }
    }

    public boolean CheckImpact( int x,int y) {

        int xtir;
        int ytir;

        System.out.println();
        //initialize grid
        if (y+pTire > yMax){
            ytir = yMax;
        } else{
            ytir = y+pTire;
        }
        if (x+pTire > xMax){
            xtir = xMax;
        } else{
            xtir = x+pTire;
        }

        for(int outerLoopValue = y; outerLoopValue<ytir;outerLoopValue++)
        {
            // grille USER
            for(int innerLoopValue = x; innerLoopValue<xtir;innerLoopValue++)
            {
                if (IsBoat(innerLoopValue,outerLoopValue)){
                    //Add impact on boat
                    System.out.println("Impact Confirmed");
                    if (Objects.equals(GridCPU.grid[innerLoopValue][outerLoopValue], "|U1") & !IsCuirasseAlreadyDMG(innerLoopValue,outerLoopValue)){
                        Grid.AddTireImpact(innerLoopValue,outerLoopValue,2);
                    } else{
                        Grid.AddTireImpact(innerLoopValue,outerLoopValue,1);
                    }
                }else {
                    //Add impact in water
                    Grid.AddTireImpact(innerLoopValue,outerLoopValue,0);
                }
            }
        }
        //Plateau.TireBoat(tireB);
        return false;
    }
    /*public boolean CheckImpactCPU( int x,int y) {

        for (int i = x; i < (x + pTire); i++) {
            for(int j=y;j<(y+pTire);j++){
                tireB[i][j] = "|XX";
            }
        }
        //initialize grid
        for(int outerLoopValue = 0; outerLoopValue<y;outerLoopValue++)
        {
            // grille USER
            for(int innerLoopValue = 0; innerLoopValue<(x/2);innerLoopValue++)
            {
                if (IsBoat(outerLoopValue,innerLoopValue) & IsRocket(outerLoopValue,innerLoopValue)){
                    //Add impact on boat
                    Grid.AddTireImpact(outerLoopValue,innerLoopValue,true);
                }else if (IsRocket(outerLoopValue,innerLoopValue)){
                    //Add impact in water
                    Grid.AddTireImpact(outerLoopValue,innerLoopValue,false);
                }

            }
        }
        //Plateau.TireBoat(tireB);
        return false;
    }*/

    private boolean IsCuirasseAlreadyDMG(int x,int y){
        return Objects.equals(Grid.grid[x + 17][y], "\033[32m|U1\033[0m");
    }

    private boolean IsBoat(int x,int y){
        /*
        System.out.println("Checking impact");
        System.out.println("GridCPU["+x+"]["+y+"]= "+GridCPU.grid[x][y]);
        */
        return !Objects.equals(GridCPU.grid[x][y], "|__");
    }

    private boolean IsRocket(int x,int y){
        return Objects.equals(tireB[x][y], "|XX");
    }


    public void checkAllboatLife(){
        Sous_Marin.checkBoatLife();
        Sous_Marin2.checkBoatLife();
        Sous_Marin2.checkBoatLife();
        Sous_Marin3.checkBoatLife();
        destroyer.checkBoatLife();
        destroyer1.checkBoatLife();
        destroyer2.checkBoatLife();
        croiseur.checkBoatLife();
        croiseur1.checkBoatLife();
        cuirasse.checkBoatLife();
    }
    protected void checkBoatLife(){
        String[][] grid = Grid.getGrid();
        int count = 0;
        for (int x=0; x < xMax;x++){
            for (int y=0; y < yMax;y++){
                if (Objects.equals(grid[x][y], pattern)){
                    count++;
                }
            }
        }
        IsDMG =  (count == boatHp);
    }

    private void clearBoat(){
        System.out.println("orientation = "+orientation);
        System.out.println("direction = "+direction);
        if (Objects.equals(orientation, "horizontale")){
            if (direction){
                //debug
                System.out.println("x = "+x);
                System.out.println("y = "+y);
                System.out.println("Grid.grid["+(x-1)+"]["+y+"] = '|__'");
                Grid.grid[x-1][y] = "\033[36m|__\033[0m";
            }
            else {
                System.out.println("x = "+x);
                System.out.println("y = "+y);
                Grid.grid[x+taille][y] = "\033[36m|__\033[0m";
                System.out.println("Grid.grid["+(tempx+taille)+"]["+y+"] = '|__'");
            }
        } else {
            if (direction){
                System.out.println("x = "+x);
                System.out.println("y = "+y);
                Grid.grid[x][tempy+taille] = "\033[36m|__\033[0m";
                System.out.println("Grid.grid["+x+"]["+(tempy+taille-1)+"] = '|__'");
            }
            else {
                System.out.println("x = "+x);
                System.out.println("y = "+y);
                Grid.grid[x][tempy] = "\033[36m|__\033[0m";
                System.out.println("Grid.grid["+x+"]["+tempy+"] = '|__'");
            }
        }
    }

    public void PrintGrid(){
        Screen.Nom_Grille(Grid.getX());
        Screen.PrintHeader(Grid.getX());
        Screen.PrintGrid(Grid.getGrid(), Grid.getX(), Grid.getY());
    }
    private void PrintGridCPU(){
        Screen.Nom_Grille(GridCPU.getX());
        Screen.PrintHeader(GridCPU.getX());
        Screen.PrintGrid(GridCPU.getGrid(), GridCPU.getX(), GridCPU.getY());
    }

    public String getOrientation() {
        return orientation;
    }


}

