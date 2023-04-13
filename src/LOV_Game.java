import java.util.Arrays;

/**
 * Legends of Valor game class that holds everything pertaining to the game.
 */
public class LOV_Game extends Game implements UsesHeroes{

    /**
     * LOV_Map of the game.
     */
    private final LOV_Map LOVMap;

    /**
     * Maximum number of heroes allowed in the game.
     */
    static final int maxHeroes = 3;

    /**
     * List of heroes in the game.
     */
    private final DataList<Hero> heroes = new DataList<>(maxHeroes);

    /**
     * List of monsters in the game.
     */
    private final DataList<Monster> monsters = new DataList<>();

    /**
     * When a multiple of 8, monsters will spawn.
     */
    private int monsterSpawnRate = 0;

    /**
     * Constructor for the LOV_Game class.
     */
    public LOV_Game() {
        System.out.println(Color.magenta + ArtMessages.getWelcomeToLOV() + Color.reset);
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
    }

    /**
     * Initializes the monsters in the game.
     */
    private void initMonsters() {
        int maxLevel = getMaxLevel(heroes);
        for (int i = 0; i < maxHeroes; i++) {
            monsters.add(Monster.monsterCreator(maxLevel));
        }
    }

    /**
     * Gets the maximum level among all the heroes.
     * @param legends List of legends.
     * @return Maximum level among all the heroes.
     */
    private int getMaxLevel(DataList<? extends Legend> legends){
        int maxLevel = 0;
        for (Legend legend : legends){
            if (legend.getLevel() > maxLevel){
                maxLevel = legend.getLevel();
            }
        }
        return maxLevel;
    }

    /**
     * Main game loop of the game.
     * Each hero takes a turn. If a monster dies during a turn they are taken out of the game.
     * Then the monsters take a turn. If a hero dies during a turn they are recalled to their nexus on the start of the next turn.
     */
    @Override
    public void start() {
        while (true) {
            for (Hero hero: heroes){
                int idx = heroes.indexOf(hero) + 1;
                if (checkGameOver()){
                    return;
                }
                int[] location = LOVMap.legendLocations.get(hero);
                char control;
                boolean validMove = false;
                do {
                    System.out.println(this.LOVMap);
                    printHeroOut(hero, idx);
                    while ((control = GameEngine.LOV_getPlayerControl(LOVMap.matrix[location[0]][location[1]].getSymbol())) == 'I') {
                        GameEngine.printInfo(heroes, monsters);
                        System.out.println(this.LOVMap);
                        printHeroOut(hero, idx);
                    }
                    switch (control) {
                        case 'Q':
                            System.out.println("Exiting game...");
                            return;
                        case 'T':
                            System.out.println("Teleporting...");
                            if (!(validMove = LOVMap.teleportHero(hero))) {
                                System.out.println("You cannot teleport. Check the board for valid moves and try again.");
                            }
                            break;
                        case 'R':
                            System.out.println("Recalling...");
                            if (!(validMove = LOVMap.recallHero(hero))) {
                                System.out.println("You cannot recall because your nexus is occupied!");
                            }
                            break;
                        case 'Z':
                            if (monsterInRange(hero)) {
                                System.out.println("Attacking...");

                                int[] monsterLaneLocation = getMonsterLaneLocation(hero);
                                Monster monsterInLane = LOVMap.getMonsterAt(monsterLaneLocation);
                                hero.attackMonsterInLane(monsterInLane);
                                validMove = true;

                                checkMonsterDeath(hero, monsterLaneLocation, monsterInLane);
                            }
                            break;
                            case 'E':
                                System.out.println("Changing equipment...");
                                System.out.println("What would you like to equip?");
                                String equipOption = GameEngine.getOption(new String[]{"Weapon", "Armor"});
                                if (equipOption.equals("Weapon")) {
                                    validMove = hero.equipWeapon();
                                } else {
                                    validMove = hero.equipArmor();
                                }
                                break;
                            case 'P':
                                int changeAttr;
                                if ((changeAttr = hero.usePotion()) > 0) {
                                    for (Hero healed : heroes) {
                                        healed.setHp(healed.getHp() + changeAttr);
                                        System.out.println(Color.color(Color.bgGreen, healed.name + " healed by " + changeAttr + " health!"));
                                    }
                                    validMove = true;
                                } else if (changeAttr == 0) {
                                    validMove = true;
                                }
                                break;
                            case 'X':
                                if (monsterInRange(hero)) {
                                    System.out.println("Casting spell...");
                                    int[] monsterLaneLocation = getMonsterLaneLocation(hero);
                                    Monster monsterInLane = LOVMap.getMonsterAt(monsterLaneLocation);
                                    validMove = hero.castSpellOnOneMonster(monsterInLane);

                                    checkMonsterDeath(hero, monsterLaneLocation, monsterInLane);
                                }
                                break;
                            case 'M':
                                if (LOVMap.matrix[location[0]][location[1]].getSymbol() == 'N') {
                                    Market market = new Market();
                                    System.out.println("Entering market...");
                                    market.oneGoToMarket(hero);
                                }
                                break;
                            case 'F':
                                validMove = true;
                                break;
                            default:
                                if (!(validMove = LOVMap.moveLegend(hero, control))) {
                                    System.out.println("You cannot access this space.");
                                }
                                break;
                            }
                } while (!validMove);

            }
            System.out.println("\n" + Color.red + "Monsters' turns!" + Color.reset);

            for (Monster monster: monsters) {
                if (checkGameOver()){
                    return;
                }

                if (heroInRange(monster)){
                    System.out.println("\n" + monster.name + " is attacking!");
                    int[] heroLocation = getHeroLaneLocation(monster);
                    Hero heroInLane = LOVMap.getHeroAt(heroLocation);
                    monster.attackHeroInLane(heroInLane);
                } else {
                    System.out.println(monster.name + "'s turn: ");
                    if (LOVMap.moveLegend(monster, 'S')){
                        System.out.println(monster.name + " moved forward!\n");
                    } else if (LOVMap.moveLegend(monster, 'A')){
                        System.out.println(monster.name + " moved to the left!\n");
                    } else if (LOVMap.moveLegend(monster, 'D')){
                        System.out.println(monster.name + " moved to the right!\n");
                    } else {
                        System.out.println(monster.name + " could not move!\n");
                    }
                }
            }
            // after every iteration, heroes regain 10% of their HP and Mana
            for (Hero h: heroes) {
                h.setHp(h.getHp() + (h.getHp() / 10));
                h.setMp(h.getMp() + (h.getMp() / 10));
            }

            // Every 8 turns, add three monsters to the map
            if (++monsterSpawnRate % 8 == 0){
                System.out.println("Spawning new monsters!");
                for (int i = 0; i < 3; i++){
                    Monster monster = Monster.monsterCreator(getMaxLevel(heroes));
                    if (LOVMap.addMonsterToNexus(monster, i)){
                        monsters.add(monster);
                    }
                }
            }
        }
    }

    /**
     * Checks whether a monster is dead. If it is, remove it from the map and remove it from the list of monsters.
     * @param hero the hero that killed the monster
     * @param monsterLaneLocation the location of the monster
     * @param monsterInLane the monster that is in the lane
     */
    private void checkMonsterDeath(Hero hero, int[] monsterLaneLocation, Monster monsterInLane) {
        if (monsterInLane.getStatus() == LegendStatus.DEAD) {
            System.out.println(Color.red + monsterInLane.name + " has been slain!" + Color.reset);
            ((LOV_Space) LOVMap.matrix[monsterLaneLocation[0]][monsterLaneLocation[1]]).removeLegend(monsterInLane);
            monsters.remove(monsterInLane);
            LOVMap.legendLocations.remove(monsterInLane);

            // if the hero slays the monster, reward the hero with money and EXP
            hero.setHp(hero.getLevel() * 100);
            hero.setMoney(hero.getMoney() + (hero.getLevel() * 100));
            hero.addExp(hero.getExp() + (hero.getLevel() * 2));
            // if hero gains enough exp, level up
            if (hero.getExp() >= hero.getExpBound()) {
                hero.setLevel(hero.getLevel() + 1);
                // reset exp to 0
                hero.setExp(0);
            }
        }
    }

    /**
     * Prints out the hero's name, location.
     * @param hero the hero
     * @param idx the index of the hero
     */
    private void printHeroOut(Hero hero, int idx) {
        System.out.println(Color.blue + "(P" + idx + ") Player " + hero.name + " @ " + Arrays.toString(LOVMap.legendLocations.get(hero)) + " --> your turn: " + Color.reset);
    }

    /**
     * Makes the heroes for the game
     */
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

            switch (classOption) {
                case "Paladins":
                    addHero(new Paladin(heroOption, heroData, classOption));
                    break;
                case "Sorcerers":
                    addHero(new Sorcerer(heroOption, heroData, classOption));
                    break;
                default:
                    addHero(new Warrior(heroOption, heroData, classOption));
                    break;
            }
        }
    }

    /**
     * Checks if the game is over. If it is, print out the winner.
     * @return true if the game is over, false otherwise
     */
    @Override
    public boolean checkGameOver() {
        for (Legend legend: LOVMap.legendLocations.keySet()){
            if (legend instanceof Hero){
                if (LOVMap.legendLocations.get(legend)[0] == 0){
                    System.out.println("Heroes win!");
                    System.out.println(LOVMap);
                    return true;
                }
            } else if (legend instanceof Monster){
                if (LOVMap.legendLocations.get(legend)[0] == 7){
                    System.out.println("Monsters win!");
                    System.out.println(LOVMap);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Prints out the instructions for the game
     */
    @Override
    public void printInstructions() {
        GameEngine.printFile("src/data/LOV_instructions.md");
    }

    /**
     * Adds a hero to the list of heroes
     * @param hero the hero to be added
     */
    @Override
    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    /**
     * Checks if there is a monster in range of the hero
     * @param hero the hero
     * @return true if there is a monster in range, false otherwise
     */
    public boolean monsterInRange(Hero hero){
        int[] heroLocation = LOVMap.legendLocations.get(hero);

        // check 360 degrees around the hero location to find the monster, return true if found
        int[][] directions = { {0,0}, {-1,0}, {0,-1}, {0,1}, {1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1} };
        for (int[] direction: directions){
            int[] newLocation = {heroLocation[0], heroLocation[1]};

            newLocation[0] += direction[0];
            newLocation[1] += direction[1];
            if (LOVMap.containsMonster(newLocation)){
                return true;
            }
        }

        System.out.println("No monster found in range");
        return false;
    }

    /**
     * Checks if there is a hero in range of the monster
     * @param monster the monster
     * @return true if there is a hero in range, false otherwise
     */
    public boolean heroInRange(Monster monster) {
        int[] monsterLocation = LOVMap.legendLocations.get(monster);
        // check 360 degrees around the hero location to find the monster, return true if found
        int[][] directions = { {0,0}, {-1,0}, {0,-1}, {0,1}, {1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1} };
        for (int[] direction: directions){
            int[] newLocation = {monsterLocation[0], monsterLocation[1]};
            newLocation[0] += direction[0];
            newLocation[1] += direction[1];
            if (LOVMap.containsHero(newLocation)){
                return true;
            }
        }
        System.out.println("No hero found in range!");
        return false;
    }

    /**
     * Gets the location of the monster in the same lane as the hero
     * @param hero the hero
     * @return the location of the monster in the same lane as the hero
     */
    public int[] getMonsterLaneLocation(Hero hero){
        int[] heroLocation = LOVMap.legendLocations.get(hero);

        // check 360 degrees around the hero location to find the monster, return true if found
        int[][] directions = { {0,0}, {-1,0}, {0,-1}, {0,1}, {1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1} };
        for (int[] direction: directions){
            int[] newLocation = {heroLocation[0], heroLocation[1]};

            newLocation[0] += direction[0];
            newLocation[1] += direction[1];
            if (LOVMap.containsMonster(newLocation)){
                return newLocation;
            }
        }
        return null;
    }

    /**
     * Gets the location of the hero in the same lane as the monster
     * @param monster the monster
     * @return the location of the hero in the same lane as the monster
     */
    public int[] getHeroLaneLocation(Monster monster){
        int[] monsterLocation = LOVMap.legendLocations.get(monster);

        // check 360 degrees around the hero location to find the monster, return true if found
        int[][] directions = { {0,0}, {-1,0}, {0,-1}, {0,1}, {1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1} };
        for (int[] direction: directions){
            int[] newLocation = {monsterLocation[0], monsterLocation[1]};

            newLocation[0] += direction[0];
            newLocation[1] += direction[1];
            if (LOVMap.containsHero(newLocation)){
                return newLocation;
            }
        }
        return null;
    }
}
