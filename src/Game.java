import java.io.FileNotFoundException;

public abstract class Game {
    public abstract void start() throws Exception;

    abstract void makeHeroes() throws Exception;

    public abstract boolean checkGameOver();

    public abstract void printInstructions();

    public static void gameMenuAndStart() throws FileNotFoundException {
        do {
            System.out.println(ArtMessages.getWelcomeToGameCenter());
            System.out.println("Which game would you like to play? \n");
            String option = GameEngine.getOption(new String[]{"Legends of Monsters and Heroes", "Legends Of Valor"});
            if (option.equals("Legends of Monsters and Heroes")) {
                LMH_Game game = new LMH_Game();
                game.start();
            } else if (option.equals("Legends Of Valor")) {
                LOV_Game game = new LOV_Game();
                game.start();
            }
            System.out.println("Do you want to play another game? (Y/N)");
        } while (GameEngine.getOption(new String[]{"Y", "N"}).equals("Y"));
    }

}
