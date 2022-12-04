package Affichages;
import java.util.Scanner;

public class MenuGame
{
    static Scanner userReader;
    public void ingame ()
        {
            int choix;
            boolean check = false;
            choix = userReader.nextInt();
            System.out.println("CHOISIR TIRER OU DEPLACER\n"+
                    "[1] : TIRER\n"+
                    "[2] : DEPLACER");
            do
            {
                if (choix == 1)
                {
                    check = true;
                    // apelle les méthodes qui TIRE
                } else if (choix == 2)
                {
                    // apelle les méthodes qui DEPLACE
                    check = true;
                }else
                {
                    System.out.println("ERREUR : Saisir [1] ou [2]");
                }
            }while (!check);
        }
}
