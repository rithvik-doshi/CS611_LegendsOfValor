import java.io.FileNotFoundException;

public abstract class Game {
    public abstract void start() throws Exception;

    abstract void makeHeroes() throws Exception;

    public abstract boolean checkGameOver();

    public abstract void printInstructions();

    public static void gameMenuAndStart() throws FileNotFoundException {
        do {
            System.out.println("Welcome to the Nintendo 42069! Select a game to play: ");
            String option = GameEngine.getOption(new String[]{"LMH_Game", "LegendsOfValor"});
            if (option.equals("LMH_Game")) {
                LMH_Game game = new LMH_Game();
                game.start();
            } else if (option.equals("LegendsOfValor")) {
//            LegendsOfValor game = new LegendsOfValor();
//            game.start();
                return;
            }
            System.out.println("Do you want to play another game? (Y/N)");
        } while (GameEngine.getOption(new String[]{"Y", "N"}).equals("Y"));
    }

}
