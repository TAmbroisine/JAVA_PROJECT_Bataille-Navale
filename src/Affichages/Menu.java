package Affichages;

import Affichages.Affichage;
import Navires.Navire;

import java.util.Scanner;
// Création du menu
public class Menu extends Affichage
{
    static Scanner userReader;

    Menu()
    {
        userReader = new Scanner(System.in);
    }
    public void print()
    {
        int choix1, choix2;

        do {
            PrintMenu();
            switch (choix1 = userReader.nextInt()) {
                case 1:
                    //Pour jouer une nouvelle partie
                    Affichage.Grid1 CPUGrid = new Affichage.Grid1();
                    Affichage.Grid1 PGrid = new Affichage.Grid1();
                    Navire navire = new Navire();
                    navire.SpawnBoat(true);
                    //PGrid.PrintGrid();
                    break;
                case 2:
                    //Pour charger une partie test
                    break;
                case 3:
                    //Pour afficher les aides
                    do {
                        // [1] : Affiche les règle
                        // [2] : Affiche les touches
                        System.out.println("Pour afficher les règles : tapez 1");
                        System.out.println("Pour afficher les touches : tapez 2");
                        System.out.println("Pour sortir du menu : tapez 9");
                        switch (choix2 = userReader.nextInt()) {
                            case 1:
                                //règle du jeu
                                PrintRegle();
                                break;
                            case 2:
                                //touches du jeu
                                System.out.println("Bienvenue dans les touches : \n" +
                                        "\n" +
                                        "");
                                break;
                            case 9:
                                break;
                            default:
                                System.out.println("resaisissez un chiffre entre 1, 2 ou 9");
                        }
                        //System.out.println(choix);
                    } while (choix2 != 9);
                    break;
                case 9:
                    //Pour quitter la partie
                    System.out.println("cls");
                    System.out.println("Vous avez quitté la partie");
                    break;
                default:
                    System.out.println("veuillez ressaisir une valeur entre 1, 2, 3 et 9");

            }
        }while (choix1!= 9);
    }
    private static void PrintRegle()
    {
        System.out.println("Bienvenue dans les règles : \n"+
                "\n" +
                "En début de jeu les navires sont positionnés aléatoirement sur la grille, Votre but est de détruire tous les navires adverses ! \n" +
                "Petites particularitées : \n"+
                "LES BATEAUX NAVIGUE PENDANT LA PARTIE \n" +
                "\n"+
                "Pour TIRER : \n"+
                "LE PREMIER TIR DUN DESTROYER DEVOILE UN CARRE DE 4x4 A PARTIR DU COIN HAUT ET GAUCHE \n "+
                "SEUL LE SOUS MARIN PEUt TOUCHER ET COULER LE SOUS MARIN ADVERSE \n " +
                "POUR COULER UN NAVIRE, IL FAUT AVOIR TOUCHER TOUTES LES CASES QU’IL OCCUPE \n" +
                "UN CUIRASSE EST PLUS RESISTANT QU’UN SIMPLE DESTROYER \n" +
                "DES QUE LE NAVIRES EST COULE, LE NAVIRE ADVERSE DISPARAIT ET LA CASE TOUCHE SAFFICHE \n"+
                "");
    }

    private static void PrintMenu()
    {
        System.out.println("Bienvenue dans la battaille navale");
        System.out.println("");
        System.out.println("Pour jouer une nouvelle partie : tapez 1");
        System.out.println("Pour charger une partie : tapez 2");
        System.out.println("Pour afficher les aides : tapez 3");
        System.out.println("Pour quitter le jeu : tapez 9 ");
    }

}
