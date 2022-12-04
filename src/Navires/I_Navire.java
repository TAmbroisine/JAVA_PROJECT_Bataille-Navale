package Navires;


import Affichages.Affichage;
import Grid.Grid;

public interface I_Navire {

    Grid Plateau = new Grid();
    Grid PlateauCPU = new Grid();

    boolean positionnement(String orientation, int y, int x, int taille,String pattern, boolean init);
    boolean positionnementCPU(String orientation, int y, int x, int taille, String pattern, boolean init);

}
