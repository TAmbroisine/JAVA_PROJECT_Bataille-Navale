import java.util.Objects;
import java.util.Random;

public class Navire implements I_Navire {

    //No need for Deplacement to be abstract because it works the same for Every ship
    //Pas besoin pour Deplacement d'être abstrait car il fonctionne de la même manière pour tout les bateaux


    public void Deplacement (String orientation, int y, int x,int taille,String[][] bateau){
        if (Objects.equals(orientation, "vertical")) {
            if (x <= 0 | (x+taille) > Plateau.x/2){
                positionnement(orientation, y, x,taille, bateau);
            }
        }
        if (Objects.equals(orientation, "horizontal")) {
            if (y <= 0 | (y+taille) > Plateau.y){
                positionnement(orientation, y, x,taille, bateau);
            }
        }
    }
    abstract public void Tir (int x, int y);

    public boolean positionnement(String orientation, int y, int x, int taille, String[][] bateau) {
        if (CheckSpace(orientation,y,x,taille)) {
            if (Objects.equals(orientation, "vertical")) {
                for (int i = y; i < (y + taille); i++) {
                    bateau[x][i] = "|##";
                }
            }
            if (Objects.equals(orientation, "horizontal")) {
                for (int i = x; i < (x + taille); i++) {
                    bateau[i][y] = "|##";
                }
            }
            Plateau.AddBoat(bateau);
            return true;
        }
        else{
            return false;
        }
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

    public void SpawnBoat(){
        // Chaque joueur possède une flotte de 10 navires : 1 cuirassé, 2 croiseurs, 3 destroyers et 4 sous-marins

        String orientation;
        int[] coord;
        // cuirassé = #######
        orientation = RandOrientation();
        coord = RandCoord(orientation,7);
        Cuirasse cuirasse = new Cuirasse(coord[0], coord[1], orientation);

        // croiseur = #####
        orientation = RandOrientation();
        coord = RandCoord(orientation,5);
        Croiseur croiseur = new Croiseur(coord[0], coord[1], orientation);

        orientation = RandOrientation();
        coord = RandCoord(orientation,5);
        Croiseur croiseur1 = new Croiseur(coord[0], coord[1], orientation);

        // destroyers = ###
        orientation = RandOrientation();
        coord = RandCoord(orientation,3);
        Destroyer destroyers = new Destroyer(coord[0], coord[1], orientation);

        orientation = RandOrientation();
        coord = RandCoord(orientation,3);
        Destroyer destroyers1 = new Destroyer(coord[0], coord[1], orientation);

        orientation = RandOrientation();
        coord = RandCoord(orientation,3);
        Destroyer destroyers2 = new Destroyer(coord[0], coord[1], orientation);

        // sous-marins = #

        orientation = RandOrientation();
        coord = RandCoord(orientation,1);
        Sous_Marin Sous_Marin = new Sous_Marin(coord[0], coord[1], orientation);

        orientation = RandOrientation();
        coord = RandCoord(orientation,1);
        Sous_Marin Sous_Marin1 = new Sous_Marin(coord[0], coord[1], orientation);

        orientation = RandOrientation();
        coord = RandCoord(orientation,1);
        Sous_Marin Sous_Marin2 = new Sous_Marin(coord[0], coord[1], orientation);

        orientation = RandOrientation();
        coord = RandCoord(orientation,1);
        Sous_Marin Sous_Marin3 = new Sous_Marin(coord[0], coord[1], orientation);

        Plateau.PrintGrid();



    }

    public int[] RandCoord(String orientation, int taille){
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
    public String RandOrientation(){
        String orientation="";
        int borneInf= 1;
        int borneSup= 3;
        int nb;
        Random random= new Random();
        nb = borneInf+random.nextInt(borneSup-borneInf);
        if(nb==1){
            orientation = "vertical";
        } else if (nb==2) {
            orientation = "horizontal";
        }

        return orientation;
    }


}

