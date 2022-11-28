public interface I_Navire {

    Affichage.Grid1 Plateau = new Affichage.Grid1();

    void positionnement(String orientation, int y, int x, int taille, String[][] bateau);

}
