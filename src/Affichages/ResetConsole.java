package Affichages;
import java.io.IOException;

import java.io.IOException;

/**
 * Création de la classe ResetConsole.
 */
public class ResetConsole {
    /**
     * Permet de reset, pour cela on suprimme l'historique du console
     */
    static public void FullClear()
    {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
