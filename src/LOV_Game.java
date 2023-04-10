public class LOV_Game extends Game implements UsesHeroes{

    private final LOV_Map LOVMap;

    static final int maxHeroes = 3;

    private final DataList<Hero> heroes = new DataList<>(maxHeroes);

    private DataList<Monster> monsters = new DataList<>();

    public LOV_Game() {
        // NOTE: should we separate this from the constructor and make it a method? call it initLOVGame()?
        System.out.println(ArtMessages.getWelcomeToLOV());
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
        initMonsters();
        LOVMap.heroesInitialPlace(heroes);
        LOVMap.monstersInitialPlace(monsters);
        LOVMap.printLocations();
//        put heroes, monsters in the right places
    }

    private void initMonsters() {
        int maxLevel = getMaxLevel(heroes);
        for (int i = 0; i < maxHeroes; i++) {
            monsters.add(Monster.monsterCreator(maxLevel));
        }
    }

    private void addMonster(){
        int maxLevel = getMaxLevel(heroes);
        monsters.add(Monster.monsterCreator(maxLevel));
    }

    private int getMaxLevel(DataList<? extends Legend> legends){
        int maxLevel = 0;
        for (Legend legend : legends){
            if (legend.getLevel() > maxLevel){
                maxLevel = legend.getLevel();
            }
        }
        return maxLevel;
    }

    @Override
    public void start() {
        while (true) {
            if (checkGameOver()){
//                Check who won
//                Print game status
//                Exit game
                System.exit(0);
            }
            for (Hero hero: heroes){
/**             If hero is dead respawn at nexus
                Determine hero's next move from choice of:
                - Move (if move is not possible, choose another option) (WASD)
                - Teleport (if teleport is not possible, choose another option) (T)
                - Recall (teleport to spawn nexus) (R)
                - Attack (only one monster should be affected even if multiple monsters are in range) (Z)
                - Change Weapon or Armor (E)
                - Use Potion (P)
                - Cast Spell (X)
                - If on nexus, M for market
                - Print any information (does not consume turn) (I)
 */
                System.out.println(this.LOVMap);
                System.out.println("Player " + hero.name + "'s turn: ");
                int[] location = LOVMap.legendLocations.get(hero);
                char control;
                boolean validMove = true;
                do {
                    while ((control = GameEngine.LOV_getPlayerControl(LOVMap.matrix[location[0]][location[1]].getSymbol())) == 'I') {
                        GameEngine.printInfo(heroes, monsters);
                        System.out.println(this.LOVMap);
                        System.out.println("Player " + hero.name + "'s turn: ");
                    }
                    if (control == 'Q') {
                        System.out.println("Exiting game...");
                        System.exit(0);
                    } else if (control == 'T') {
                        System.out.println("Teleporting...");
                    } else if (control == 'R') {
                        System.out.println("Recalling...");
                    } else if (control == 'Z') {
                        System.out.println("Attacking...");
                    } else if (control == 'E') {
                        System.out.println("Changing equipment...");
                    } else if (control == 'P') {
                        System.out.println("Using potion...");
                    } else if (control == 'X') {
                        System.out.println("Casting spell...");
                    } else if (control == 'M' && LOVMap.matrix[location[0]][location[1]].getSymbol() == 'N') {
                        Market market = new Market();
                        System.out.println("Entering market...");
                        market.oneGoToMarket(hero);
                    } else {
                        if (!(validMove = LOVMap.moveLegend(hero, control))) {
                            System.out.println("You cannot access this space.");
                        }
                    }
                } while (!validMove);

            }
            System.out.println("Monsters' turns!");
//            Filter dead monsters from list
            for (Monster monster: monsters) {
/**
 *              If monster is in range to attack a hero, attack. Else move forward
 */
                System.out.println(monster.name + "'s turn: ");
                boolean success = LOVMap.moveLegend(monster, 'S');
                if (success){
                    System.out.println(monster.name + " moved forward!");
                }
            }
//            Every 8 turns, add three monsters to the map

//            Exit for debugging purposes
            System.out.println(this.LOVMap);
            System.out.println("Exit?");
            if (GameEngine.getOption(new String[]{"Y", "N"}).equals("Y")){
                System.exit(0);
            }
        }
    }

    @Override
    void makeHeroes() {
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

    /**
     * TODO:
     *
     */

    @Override
    public boolean checkGameOver() {
//        If a monster or hero reaches the opponent's nexus, return true
        return false;
    }

    @Override
    public void printInstructions() {
        GameEngine.printFile("src/data/LOV_instructions.md");
    }

    @Override
    public void addHero(Hero hero) {
        heroes.add(hero);
    }
}
