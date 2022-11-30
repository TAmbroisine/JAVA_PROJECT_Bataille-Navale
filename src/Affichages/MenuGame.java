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
                } else if (choix == 2)
                {
                    check = true;
                }else
                {
                    System.out.println("ERREUR : Saisir [1] ou [2]");
                }
            }while (check = false);
        }
}
