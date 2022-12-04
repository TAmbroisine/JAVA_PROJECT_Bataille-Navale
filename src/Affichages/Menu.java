package Affichages;

import Affichages.Affichage;
import Navires.Navire;

import java.util.Objects;
import java.util.Scanner;
// Création du menu
public class Menu extends Affichage
{
    static Scanner userReader;

    public Menu()
    {
        userReader = new Scanner(System.in);
    }
    public Boolean print()
    {
        int choix1, choix2;
        boolean check = false;
        boolean lanceGame = true;
        boolean boolean_error = false;
        System.out.println("--------------------------------------------------------------------");
        System.out.println("                 BIENVENUE DANS LA BATAILLE NAVALE");
        System.out.println("--------------------------------------------------------------------");
        do {
            PrintMenu();
            switch (choix1 = userReader.nextInt()) {
                case 1:
                    check = false;

                    return(lanceGame);

                case 2:
                    check = false;
                    //Pour charger une partie test
                    break;

                case 3:
                    check = true;
                    //Pour afficher les aides
                    do {
                        // [1] : Affiche les règle
                        // [2] : Affiche les touches
                        System.out.println("[1] REGLES");
                        System.out.println("[2] COMMANDES");
                        System.out.println("[9] QUITTER");
                        switch (choix2 = userReader.nextInt()) {
                            case 1:
                                //règle du jeu
                                PrintRegle();
                                break;
                            case 2:
                                //touches du jeu
                                System.out.println("--------------------------------------------------------------------");
                                System.out.println("                  BIENVENUE DANS LES COMMANDES");
                                System.out.println("--------------------------------------------------------------------");
                                break;
                            case 9:
                                break;
                            default:
                                System.out.println("resaisissez un chiffre entre 1, 2 ou 9");
                        }
                        //System.out.println(choix);
                    } while (choix2 != 9 | choix2 ==1 | choix2 ==2 );
                    break;
                case 9:
                    check = false;
                    //Pour quitter la partie
                    System.out.println("cls");
                    System.out.println("Vous avez quitté la partie");
                    break;
                default:
                    check =true;
                    System.out.println("ERREUR : saisir [1] [2] [3] [9]");


            }
        }while (check);
        return(boolean_error);
    }
    private static void PrintRegle()
    {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("                   BIENVENUE DANS LES REGLES");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("\n" +
                "En début de jeu les navires sont positionnés aléatoirement sur la grille, Votre but est de détruire tous les navires adverses ! \n" +
                "Petites particularitées : \n"+
                "LES BATEAUX NAVIGUE PENDANT LA PARTIE \n" +
                "\n"+
                "Pour TIRER : \n"+
                "LE PREMIER TIR D UN DESTROYER DEVOILE UN CARRE DE 4x4 A PARTIR DU COIN EN HAUT A GAUCHE \n "+
                "SEUL LE SOUS MARIN PEUt TOUCHER ET COULER LE SOUS MARIN ADVERSE \n " +
                "POUR COULER UN NAVIRE, IL FAUT AVOIR TOUCHER TOUTES LES CASES QU’IL OCCUPE \n" +
                "UN CUIRASSE EST PLUS RESISTANT QU UN SIMPLE DESTROYER \n" +
                "DES QUE LE NAVIRES EST COULE, LE NAVIRE ADVERSE DISPARAIT ET LA CASE TOUCHE SAFFICHE \n"+
                "");
    }

    private static void PrintMenu()
    {

        System.out.println("");
        System.out.println("[1] Nouvelle partie");
        System.out.println("[2] Charger partie");
        System.out.println("[3] AIDES");
        System.out.println("[9] QUITTER");
        System.out.println("");
    }

}
