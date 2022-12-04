package Global;

import Affichages.Affichage;
import Grid.Grid;

public interface Model {

    Grid Grid = new Grid();
    Grid GridCPU = new Grid();

    Affichage Screen = new Affichage();
}
