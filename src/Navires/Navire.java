package Navires;

import java.util.Objects;
import java.util.Random;

public class Navire implements I_Navire {

    //No need for Deplacement to be abstract because it works the same for Every ship
    //Pas besoin pour Deplacement d'être abstrait car il fonctionne de la même manière pour tout les bateaux
    int x,y,taille, shipnumb;
    boolean direction;
    String orientation,pattern;
    String[][] bateau,tireB;
    Cuirasse cuirasse;
    Croiseur croiseur,croiseur1;
    Destroyer destroyer,destroyer1,destroyer2;
    Sous_Marin Sous_Marin,Sous_Marin1,Sous_Marin2,Sous_Marin3;

    public Navire(){
        x = 0;
        y = 0;
        direction = false;
        orientation = "";
        bateau = new String[Plateau.x/2][Plateau.y] ;
        pattern = "";

    }



    public boolean Deplacement(String orientation, int y, int x, int taille, String[][] bateau, boolean direction,String pattern){
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.orientation = orientation;
        this.bateau = bateau;
        this.pattern = pattern;
        IncrementCoord();
        return AddMoveToGrid();
    }

    private boolean AddMoveToGrid(){
        if (Objects.equals(orientation, "vertical")) {
            if (x <= 0 | (x+taille) > Plateau.x/2){
                if (!positionnement(orientation, y, x,taille, pattern,false)){
                    ResetCoord(orientation,direction);
                    return false;
                }
            }
        }
        if (Objects.equals(orientation, "horizontal")) {
            if (y <= 0 | (y+taille) > Plateau.y){
                if (!positionnement(orientation, y, x,taille, pattern,false)){
                    ResetCoord(orientation,direction);
                    return false;
                }
            }
        }
        return true;
    }

    //abstract public void Tir (int x, int y);

    public boolean positionnement(String orientation, int y, int x, int taille, String pattern, boolean init) {
        if (CheckSpace(orientation,y,x,taille)) {
            shipnumb++;
            if (Objects.equals(orientation, "vertical")) {
                bateau[x][y]= "|"+ shipnumb;
                for (int i = y+1; i < (y + taille); i++) {
                    bateau[x][i] = pattern;
                }
            }
            if (Objects.equals(orientation, "horizontal")) {
                for (int i = x+1; i < (x + taille); i++) {
                    bateau[i][y] = pattern;
                }
            }
            Plateau.AddBoat(bateau);
            return true;
        }
        else if (init){
            orientation = RandOrientation();
            int[] coord = RandCoord(orientation,taille);
            positionnement(orientation, y, x, taille, pattern,true);
        }
        return false;
    }

    public boolean positionnementCPU(String orientation, int y, int x, int taille, String pattern, boolean init) {
        if (CheckSpace(orientation,y,x,taille)) {
            shipnumb++;
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
            PlateauCPU.AddBoat(bateau);
            return true;
        }
        else if (init){
            orientation = RandOrientation();
            int[] coord = RandCoord(orientation,taille);
            positionnementCPU(orientation, y, x, taille, pattern,init);
        }
        return false;
    }

    private boolean CheckSpace(String orientation, int y, int x, int taille){
        if (Objects.equals(orientation, "vertical")) {
            for (int i = y; i < (y + taille); i++) {
                if (Objects.equals(Plateau.grid[x][i], "|##")) {
                    return false;
                }
            }
        }
        else if (Objects.equals(orientation, "horizontal")) {
            for (int i = x; i < (x + taille); i++) {
                if (Objects.equals(Plateau.grid[i][y], "|##")){
                    return false;
                }
            }
        }
        return true;
    }

    public void SpawnBoat(boolean user) throws Exception {
        // Chaque joueur possède une flotte de 10 navires : 1 cuirassé, 2 croiseurs, 3 destroyers et 4 sous-marins
        shipnumb = 0;
        GenerateCroiseur(user);
        shipnumb = 0;
        GenerateDestroyer(user);
        shipnumb = 0;
        GenerateCuirrasse(user);
        shipnumb = 0;
        GenerateSous_Marin(user);
        if(user){
            Plateau.PrintGrid();
        }else {
            PlateauCPU.PrintGrid();
        }

    }

    private int[] RandCoord(String orientation, int taille){
        int borneInf= 0;
        int borneSup= Plateau.y;
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
        cuirasse = new Cuirasse(coord[0], coord[1], orientation,user);
    }
    private void GenerateCroiseur(boolean user) throws Exception {
        String orientation = RandOrientation();
        int[] coord = RandCoord(orientation,5);
        try {
            croiseur = new Croiseur(coord[0], coord[1], orientation, user);
        } catch ( Exception e){

        }

        orientation = RandOrientation();
        coord = RandCoord(orientation,5);
        croiseur1 = new Croiseur(coord[0], coord[1], orientation,user);
    }

    private void GenerateDestroyer(boolean user){
        String orientation = RandOrientation();
        int[] coord = RandCoord(orientation,3);
        destroyer = new Destroyer(coord[0], coord[1], orientation,user);

        orientation = RandOrientation();
        coord = RandCoord(orientation,3);
        destroyer1 = new Destroyer(coord[0], coord[1], orientation,user);

        orientation = RandOrientation();
        coord = RandCoord(orientation,3);
        destroyer2 = new Destroyer(coord[0], coord[1], orientation,user);
    }

    private void GenerateSous_Marin(boolean user){
        String orientation = RandOrientation();
        int[] coord = RandCoord(orientation,1);
        Sous_Marin = new Sous_Marin(coord[0], coord[1], orientation,user);

        orientation = RandOrientation();
        coord = RandCoord(orientation,1);
        Sous_Marin1 = new Sous_Marin(coord[0], coord[1], orientation,user);

        orientation = RandOrientation();
        coord = RandCoord(orientation,1);
        Sous_Marin2 = new Sous_Marin(coord[0], coord[1], orientation,user);

        orientation = RandOrientation();
        coord = RandCoord(orientation,1);
        Sous_Marin3 = new Sous_Marin(coord[0], coord[1], orientation,user);
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

    public boolean CheckImpact(int y, int x, int pTire) {

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
                    return true;
                }
            }
        }
        //Plateau.TireBoat(tireB);
        return false;
    }

    private boolean IsBoat(int x,int y){
        return Objects.equals(PlateauCPU.grid[x][y], "|##");
    }

    private boolean IsRocket(int x,int y){
        return Objects.equals(tireB[x][y], "|XX");
    }
}

