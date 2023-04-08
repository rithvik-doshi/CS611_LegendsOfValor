import java.io.FileNotFoundException;
import java.util.ArrayList;

public class LOV_Game extends Game implements UsesHeroes{

    private final LOV_Map LOVMap;

    static final int maxHeroes = 3;

    private final DataList<Hero> heroes = new DataList<>(maxHeroes);

    private DataList<Monster> monsters = new DataList<>();

    public LOV_Game() throws FileNotFoundException {
        System.out.println("Welcome to Legends of Valor! Do you want to see the instructions? (Y/N)");
        String printInst = GameEngine.getOption(new String[]{"Y", "N"});
        if (printInst.equals("Y")) printInstructions();
        System.out.println("Select a map to play on: ");
        while (true){
            System.out.println("Generating map...");
            LOV_Map tempLOVMap = new LOV_Map();
            System.out.println(tempLOVMap);
            System.out.println("Confirm this map? (1 for Yes, 2 for No)");
            String input = GameEngine.getOption(new String[]{"Y", "N"});
            if (input.equals("Y")) {
                this.LOVMap = tempLOVMap;
                break;
            }
        }
        makeHeroes();
    }

    @Override
    public void start() throws FileNotFoundException {

    }

    @Override
    void makeHeroes() throws FileNotFoundException {
        String[] heroClasses = {"Paladins", "Sorcerers", "Warriors"};
        DataLoader.dl.printInnerMaps(heroClasses);
        for (int i = 0; i < maxHeroes; i++){
            System.out.println("Hero " + (i + 1) + ", choose your class and hero!");
            String classOption = GameEngine.getOption(heroClasses);
            String heroOption = GameEngine.getOption(DataLoader.dl.getInnerMapKeys(classOption));
            System.out.println("You have chosen: " + heroOption);
            DataMap<String, String> heroData = DataLoader.dl.getInnerMap(classOption, heroOption);
            // ArrayList of objects that contains heroOption, heroData and classOption to be passed to addHero
            addHero(new Hero(heroOption, heroData, classOption));
        }
        LOVMap.heroesInitialPlace(heroes);
    }

    @Override
    public boolean checkGameOver() {
        return false;
    }

    @Override
    public void printInstructions() {

    }

    @Override
    public void addHero(Hero hero) {
        heroes.add(hero);
    }
}
