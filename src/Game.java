public abstract class Game {
    public abstract void start() throws Exception;

    abstract void makeHeroes() throws Exception;

    public abstract boolean checkGameOver();

    public abstract void printInstructions();

}
