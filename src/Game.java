/**
 * This is the abstract class for the game. It contains the methods that are common to all games.
 */
public abstract class Game {
    /**
     * GameEngine object that handles the game loop.
     * @throws Exception If an error occurs.
     */
    public abstract void start() throws Exception;

    /**
     * Method that handles the game loop.
     * @throws Exception If an error occurs.
     */
    abstract void makeHeroes() throws Exception;

    /**
     * Method that checks whether the game is over
     */
    public abstract boolean checkGameOver();

    /**
     * Method that prints the instructions of the game
     */
    public abstract void printInstructions();

}
