package Affichages;
import java.io.IOException;

import java.io.IOException;

public class ResetConsole {
    static public void FullClear()
    {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
