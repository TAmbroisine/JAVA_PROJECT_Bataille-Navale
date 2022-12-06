package Navires;

import Global.Model;
import Grid.Grid;


import java.util.Objects;
import java.util.Random;

public class Navire implements Model {

    //No need for Deplacement to be abstract because it works the same for Every ship
    //Pas besoin pour Deplacement d'être abstrait car il fonctionne de la même manière pour tout les bateaux
    int x,y,taille,pTire,Pv,shipnumb;
    boolean direction;
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


    }

    /**
     * Move the boat to the given coordonates
     * @return
     */
    public boolean Deplacement(boolean direction){
        this.direction = direction;
        IncrementCoord();
        return AddMoveToGrid();
    }

    /**
     * Try to execute move and register
     * @return boolean reprensenting the possibility of the move
     */
    private boolean AddMoveToGrid(){
        if (Objects.equals(orientation, "vertical")) {
            if (x <= 0 | (x+taille) > Grid.x/2){
                if (!positionnement(false)){
                    ResetCoord(orientation,direction);
                    return false;
                }
            }
        }
        if (Objects.equals(orientation, "horizontal")) {
            if (y <= 0 | (y+taille) > Grid.y){
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
            bateau[x][y] = "|0" + shipnumb;
            if (Objects.equals(orientation, "vertical")) {
                for (int i = y+1; i < (y + taille); i++) {
                    bateau[x][i] = pattern;
                }
            }
            if (Objects.equals(orientation, "horizontal")) {
                for (int i = x+1; i < (x + taille); i++) {
                    bateau[i][y] = pattern;
                }
            }
            Grid.AddBoat(bateau);
            return true;
        }
        else if (init){
            orientation = RandOrientation();
            int[] coord = RandCoord(orientation,taille);
            x = coord[0];
            y = coord[1];
            positionnement(true);
        }
        return false;
    }

    public boolean positionnementCPU(boolean init) {
        if (CheckSpace(orientation,y,x,taille)) {
            bateau[x][y] = "|0" + shipnumb;
            if (Objects.equals(orientation, "vertical")) {
                for (int i = y+1; i < (y + taille); i++) {
                    bateau[x][i] = pattern;
                }
            }
            if (Objects.equals(orientation, "horizontal")) {
                for (int i = x+1; i < (x + taille); i++) {
                    bateau[i][y] = pattern;
                }
            }
            GridCPU.AddBoat(bateau);
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
                if (!Objects.equals(Grid.grid[x][i], "|__")) {
                    return false;
                }
            }
        }
        else if (Objects.equals(orientation, "horizontal")) {
            for (int i = x; i < (x + taille); i++) {
                if (!Objects.equals(Grid.grid[i][y], "|__")){
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
                y-=1;
            }else {
                y+=1;
            }

        }
        if (Objects.equals(orientation, "horizontal")) {
            if (direction){
                x-=1;
            }else {
                x+=1;
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

        for (int i = y; i < (y + pTire); i++) {
            for(int j=x;j<(x+pTire);j++){
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
    }
    public boolean CheckImpactCPU( int x,int y) {

        for (int i = y; i < (y + pTire); i++) {
            for(int j=x;j<(x+pTire);j++){
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
    }

    private boolean IsBoat(int x,int y){
        return Objects.equals(GridCPU.grid[x][y], "|##");
    }

    private boolean IsRocket(int x,int y){
        return Objects.equals(tireB[x][y], "|XX");
    }

    private void PrintGrid(){
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

