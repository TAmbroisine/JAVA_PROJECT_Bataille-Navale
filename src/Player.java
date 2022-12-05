import Grid.Grid;
import Navires.Navire;

public class Player {
    private Grid board;  // Game board for this player
    public Navire navires;
    private int numShips;  // Number of remaining ships for this player

    // Constructor to create a player with a given game board
    public Player() {
        board = new Grid();
        navires = new Navire();
        numShips = 10;  // Initialize the number of ships to 5 (this can be changed)
    }

    // Method to allow the player to guess coordinates
    /*public boolean guess(int x, int y) {
        return board.checkGuess(x, y);  // Check the guess with the game board
    }*/

    // Method to check whether the player has any remaining ships
    public boolean hasShips() {
        return numShips > 0;  // Return true if the number of remaining ships is greater than 0
    }

    // Method to decrement the number of remaining ships for this player
    public void ShipAmmount() {
        numShips--;  // Decrement the number of remaining ships
    }
}
