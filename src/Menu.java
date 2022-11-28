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

        PrintMenu();


        switch (userReader.nextInt())
        {
            case 1 :
                //Pour jouer une nouvelle partie
                Affichage.Grid1 CPUGrid = new Affichage.Grid1();
                Affichage.Grid1 PGrid = new Affichage.Grid1();
                PGrid.PrintGrid();
                break;
            case 2 :
                //Pour charger une partie
                break;
            case 3 :
                //Pour afficher les aides
                System.out.println("Pour afficher les règles : tapez 1");
                System.out.println("Pour afficher les touches : tapez 2");
                System.out.println("Pour sortir du menu : tapez Un autre chiffre ");
                do
                {
                    switch (userReader.nextInt())
                    {
                        case 1 :
                            //règle du jeu
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
                                    "DES QUE LE NAVIRES EST COULE, LE NAVIRE ADVERSE DISPARAIT ET LA CASE TOUCHE SAFFICHE");
                            break;
                        case 2 :
                            //touches du jeu
                            System.out.println("Bienvenue dans les touches : \n"+
                                    "\n" +
                                    "");
                            break;
                        default :
                            System.out.println("saisissez un chiffre autre que 1 ou 2 pour sortir");
 // [1] : Affiche les règle
 // [2] : Affiche les touches
                    }
                }while (userReader.nextInt() == 2 | userReader.nextInt() == 1 );
                break;
            case 4 :
                //Pour quitter la partie
                System.out.println("cls");
                System.out.println("Vous avez quitté la partie");
                break;
            default :
                System.out.println("veuillez ressaisir une valeur entre 1 et 4");

        }
    }

    private static void PrintMenu(){
        System.out.println("Bienvenue dans la battaille navale");
        System.out.println("");
        System.out.println("Pour jouer une nouvelle partie : tapez 1");
        System.out.println("Pour charger une partie : tapez 2");
        System.out.println("Pour afficher les aides : tapez 3");
        System.out.println("Pour quitter le jeu : tapez 4 ");
    }

}
