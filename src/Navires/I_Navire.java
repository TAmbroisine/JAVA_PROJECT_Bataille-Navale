package Navires;


import Affichages.Affichage;

public interface I_Navire {

    Affichage.Grid1 Plateau = new Affichage.Grid1();
    Affichage.Grid1 PlateauCPU = new Affichage.Grid1();

    boolean positionnement(String orientation, int y, int x, int taille,String pattern);
    boolean positionnementCPU(String orientation, int y, int x, int taille,String pattern);

}
