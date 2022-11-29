import java.sql.SQLOutput;
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
        int choix1, choix2, choix3;

        do {

            PrintMenu();
            switch (choix1 = userReader.nextInt()) {
                case 1:
                    //Pour jouer une nouvelle partie
                    Affichage.Grid1 CPUGrid = new Affichage.Grid1();
                    Affichage.Grid1 PGrid = new Affichage.Grid1();
                    Navire navire = new Navire();
                    navire.SpawnBoat();
                    //PGrid.PrintGrid();
                    do
                    {
                        System.out.println("");
                        System.out.println("[9] Quitter");
                        choix3 = userReader.nextInt();
                    }while ( choix3 != 9);

                    break;
                case 2:
                    //Pour charger une partie test
                    break;
                case 3:
                    //Pour afficher les aides

                    do {
                        System.err.println("----------------------------------------------------------------");
                        System.err.println("                        MENU AIDE");
                        System.err.println("----------------------------------------------------------------");
                        // [1] : Affiche les règle
                        // [2] : Affiche les touches
                        System.out.println("[1] : Regles");
                        System.out.println("[2] : Commmandes");
                        System.out.println("[9] : Quitter");
                        switch (choix2 = userReader.nextInt()) {
                            case 1:
                                //règle du jeu
                                PrintRegle();
                                userReader.next();
                                break;
                            case 2:
                                //touches du jeu
                                PrintCommand();
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
    private static void PrintCommand()
    {
        System.err.println("----------------------------------------------------------------");
        System.err.println("                       COMMANDE DU JEU");
        System.err.println("----------------------------------------------------------------");
    }
    private static void PrintRegle()
    {
        System.err.println("----------------------------------------------------------------");
        System.err.println("                       REGLES DU JEU");
        System.err.println("----------------------------------------------------------------");
        System.out.println("En début de jeu les navires sont positionnés aléatoirement sur la grille, Votre but est de détruire tous les navires adverses ! \n" +
                "\n"+
                "Petites particularitées : \n"+
                "LES BATEAUX NAVIGUE PENDANT LA PARTIE \n" +
                "\n"+
                "POUR TIRER : \n"+
                "\n"+
                "- LE PREMIER TIR D UN DESTROYER DEVOILE UN CARRE DE 4x4 A PARTIR DU COIN EN HAUT A GAUCHE \n"+
                "- SEUL LE SOUS MARIN PEUt TOUCHER ET COULER LE SOUS MARIN ADVERSE \n" +
                "- POUR COULER UN NAVIRE, IL FAUT AVOIR TOUCHER TOUTES LES CASES QU’IL OCCUPE \n" +
                "- UN CUIRASSE EST PLUS RESISTANT QU UN SIMPLE DESTROYER \n" +
                "- DES QUE LE NAVIRES EST COULE, LE NAVIRE ADVERSE DISPARAIT ET LA CASE TOUCHE SAFFICHE \n"+
                "");
    }

    private static void PrintMenu()
    {
        System.err.println("----------------------------------------------------------------");
        System.err.println("                       MENU PRINCIPAL");
        System.err.println("----------------------------------------------------------------");
        System.out.println("");
        System.out.println("[1] : Nouvelle partie");
        System.out.println("[2] : Charger une partie");
        System.out.println("[3] : Aides");
        System.out.println("[9] : Quitter");
    }

}
