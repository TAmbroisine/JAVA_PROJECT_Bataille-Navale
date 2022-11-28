abstract class Navire implements I_Navire {

    //protected Affichage.Grid1 Plateau = new Affichage.Grid1();
    //No need for Deplacement to be abstract because it works the same for Every ship
    //Pas besoin pour Deplacement d'être abstrait car il fonctionne de la même manière pour tout les bateaux
    public void Deplacement (){

    }
    abstract public void Tir (int x, int y);

    public void positionnement(String orientation, int y, int x, int taille, String[][] bateau) {
        if (CheckSpace(orientation,y,x,taille)) {
            if (orientation == "vertical") {
                for (int i = y; i < (y + taille); i++) {
                    bateau[x][i] = "|##";
                }
            }
            if (orientation == "horizontal") {
                for (int i = x; i < (x + taille); i++) {
                    bateau[i][y] = "|##";
                }
            }
            Plateau.AddBoat(bateau);
        }
    }

    private boolean CheckSpace(String orientation, int y, int x, int taille){
        if (orientation == "vertical") {
            for (int i = y; i < (y + taille); i++) {
                if (Plateau.grid[x][i] == "|##") {
                    return false;
                }
            }
        }
        else if (orientation == "horizontal") {
            for (int i = x; i < (x + taille); i++) {
                if (Plateau.grid[i][y] == "|##"){
                    return false;
                }
            }
        }
        return true;
    }

}

