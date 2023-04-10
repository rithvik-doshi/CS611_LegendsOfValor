
import java.io.FileNotFoundException;

/**
 * GameCenter class to instantiate and run Legends-related games
 */
public class GameCenter {

    public static void GamePrompter() throws FileNotFoundException {
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
            System.out.println("Do you want to play another game? (1 for Y, 2 for N)");
        } while (GameEngine.getOption(new String[]{"Y", "N"}).equals("Y"));
        System.out.println("Thanks for playing! Goodbye!");
    }

}
