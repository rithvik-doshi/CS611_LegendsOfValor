import java.io.FileNotFoundException;

/**
 * This class is the main class of the game. It handles the game logic and the
 * game loop.
 */
public class LMH_Game extends Game implements UsesHeroes{
    /**
     * LMH_Map of the game.
     */
    private final LMH_Map LMHMap;

    /**
     * List of heroes in the game.
     */
    private DataList<Hero> heroes;

    /**
     * Maximum number of heroes allowed in the game.
     */
    static final int maxHeroes = 3;

    /**
     * Constructor for the LMH_Game class.
     */
    public LMH_Game() {

        System.out.println(Color.cyan + ArtMessages.getWelcomeToMH() + Color.reset);
        System.out.println("Welcome to Legends: Heroes and Monsters! Do you want to see the instructions? (Y/N)");
        String printInst = GameEngine.getOption(new String[]{"Y", "N"});
        if (printInst.equals("Y")) printInstructions();

        System.out.println("Select a map to play on: ");
        while (true){
            System.out.println("Generating map...");
            LMH_Map tempLMHMap = new LMH_Map(8);
            System.out.println(tempLMHMap);
            System.out.println("Confirm this map? (1 for Yes, 2 for No)");
            String input = GameEngine.getOption(new String[]{"Y", "N"});
            if (input.equals("Y")) {
                this.LMHMap = tempLMHMap;
                break;
            }
        }
        this.heroes = new DataList<>(maxHeroes);
        makeHeroes();
    }

    /**
     * Adds a hero to the list of heroes.
     * @param hero Hero to be added.
     */
    public void addHero(Hero hero){
        heroes.add(hero);
    }

    /**
     * Allows users to create heroes.
     */
    void makeHeroes() {
        System.out.println("Choose the number of heroes to embark on a quest");
        int num = GameEngine.getInt(1, maxHeroes);
        String[] heroClasses = {"Paladins", "Sorcerers", "Warriors"};
        DataLoader.dl.printInnerMaps(heroClasses);
        for (int i = 0; i < num; i++){
            System.out.println("Hero " + (i + 1) + ", choose your class and hero!");
            String classOption = GameEngine.getOption(heroClasses);
            String heroOption = GameEngine.getOption(DataLoader.dl.getInnerMapKeys(classOption));
            System.out.println("You have chosen: " + heroOption);
            DataMap<String, String> heroData = DataLoader.dl.getInnerMap(classOption, heroOption);
            this.addHero(new Hero(heroOption, heroData, classOption));
        }
        LMHMap.heroesInitialPlace(heroes);
    }

    /**
     * Handles the game loop.
     */
    public void start() {
        while (true) {

            if (checkGameOver()) {
                System.out.println(Color.color(Color.red, "All heroes are dead. Game over!"));
                return;
            }
            System.out.println(this.LMHMap);
            char control = GameEngine.LMH_getControl(LMHMap.getSpace().getSymbol());
            if (control == 'Q') {
                System.out.println(Color.color(Color.bold, "Thanks for playing!"));
                return;
            }
            if (control == 'I') {
                System.out.println(Color.color(Color.bgBrightWhite, "Hero Information:"));
                System.out.println(heroes);
            }
            if (control == 'M') {
                Space currentSpace = LMHMap.getSpace();
                if (currentSpace.getSymbol() == 'M') {
                    Market market = (Market) currentSpace;
                    this.heroes = market.goToMarket(heroes);
                } else {
                    System.out.println("You are not in a market.");
                }
            }
            if (control == 'W' || control == 'A' || control == 'S' || control == 'D') {
                if (!LMHMap.moveHeroes(heroes, control)) {
                    System.out.println(Color.color(Color.bgBlack, "You cannot access this space"));
                }
            }
        }
    }

    /**
     * Checks if the game is over.
     * @return True if the game is over, false otherwise.
     */
    public boolean checkGameOver(){
        for (Hero hero : heroes){
            if (hero.getStatus() == LegendStatus.ALIVE){
                return false;
            }
        }
        return true;
    }

    /**
     * Prints the instructions of the game from LMH_instructions.md
     */
    @Override
    public void printInstructions() {

        GameEngine.printFile("src/data/LMH_instructions.md");

    }
}
