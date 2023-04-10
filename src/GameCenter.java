
import java.io.FileNotFoundException;
import java.util.*;

/**
 * GameCenter class to instantiate and run Legends-related games
 */
public class GameCenter {
    protected LMH_Game lmh_game;
    protected LOV_Game lov_game;

    public GameCenter() {
    }

    public void playLMHGame() throws FileNotFoundException {
        lmh_game.start();
    }

    public void playLOVGame() throws FileNotFoundException {
        lov_game.start();
    }

    public void GamePrompter() {
        System.out.println(ArtMessages.getWelcomeToGameCenter());
        System.out.println("Welcome to the Game Center! What game would you like to play?");
        String printInst = GameEngine.getOption(new String[]{"LMH", "LOV"});

        if (printInst.equals("LMH")) {
            try {
                lmh_game = new LMH_Game();
                playLMHGame();
                SessionLoop();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else if (printInst.equals("LOV")) {
            try {
                lov_game = new LOV_Game();
                playLOVGame();
                SessionLoop();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Invalid input. Please try again.");
            GamePrompter();
        }
    }

    /**
     * A Method to allow the user to switch between games
     */
    public void SessionLoop() {
        System.out.println("Do you want to play another game? (Y/N)");
        String printInst = GameEngine.getOption(new String[]{"Y", "N"});
        if (printInst.equals("Y")) {
            GamePrompter();
        }
        else if (printInst.equals("N")) {
            System.out.println("Thank you for playing!");
        }
        else {
            System.out.println("Invalid input. Please try again.");
            SessionLoop();
        }
    }

    public static void main (String[] args) throws FileNotFoundException {
        GameCenter gameCenter = new GameCenter();
        gameCenter.GamePrompter();
    }

}
