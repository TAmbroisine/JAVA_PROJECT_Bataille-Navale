import java.util.Scanner;
// Création du projet
public class Menu
{
    public static void print()
    {

        System.out.println("Bienvenue dans la battaille navale");
        System.out.println("");
        System.out.println("Pour jouer une nouvelle partie : tapez 1");
        System.out.println("Pour charger une partie : tapez 2");
        System.out.println("Pour afficher les aides : tapez 3");
        System.out.println("Pour quitter le jeu : tapez 4 ");

        Scanner userReader = new Scanner(System.in);

        int selecteur = userReader.nextInt();

        switch (selecteur)
        {
            case 1 :
                Affichage.Grid1 CPUGrid = new Affichage.Grid1();
                Affichage.Grid1 PGrid = new Affichage.Grid1();
                PGrid.Nom_Grille();
                PGrid.PrintGrid();


                break;
            case 2 :
                break;
            case 3 :
                break;
            case 4 :
                System.out.println("cls");
                System.out.println("Vous avez quitté la partie");
                break;
            default :
                System.out.println("veuillez ressaisir une valeur entre 1 et 4");

        }



    }

}
