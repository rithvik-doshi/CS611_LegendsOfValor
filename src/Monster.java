/**
 * Type of legend that attacks heroes
 */
public class Monster extends Legend{
    /**
     * Attribute buff for monster type
     */
    protected static final double attrBuff = 1.2;

    /**
     * Damage, defense, and dodge of monster
     */
    protected int damage, defense, dodge;

    /**
     * Constructor for Monster
     * @param name Name of monster
     * @param monsterData Data for monster
     * @param monsterType Type of monster
     * @param heroMaxLevel Maximum level of heroes
     */
    public Monster(String name, DataMap<String, String> monsterData, String monsterType, int heroMaxLevel){
        super(name, Integer.parseInt(monsterData.get("level")), monsterType);
        int selfLevel = Integer.parseInt(monsterData.get("level"));
        setLevel(heroMaxLevel*getLevel()/selfLevel);
        this.damage = Integer.parseInt(monsterData.get("damage"))*heroMaxLevel/selfLevel;
        this.defense = Integer.parseInt(monsterData.get("defense"))*heroMaxLevel/selfLevel;
        this.dodge = Integer.parseInt(monsterData.get("dodge chance"))*heroMaxLevel/selfLevel;
    }

    /**
     * Create a monster based on heroes' max level
     * @param maxLevel Maximum level of heroes
     * @return Monster created
     */
    public static Monster monsterCreator(int maxLevel) {
        String[] monsterTypes = {"Dragons", "Exoskeletons", "Spirits"};
        String typeChoice = GameEngine.makeRandomChoice(monsterTypes);
        String monsterChoice = GameEngine.makeRandomChoice(DataLoader.dl.getInnerMapKeys(typeChoice));
        DataMap<String, String> monsterData = DataLoader.dl.getInnerMap(typeChoice, monsterChoice);

        switch (typeChoice) {
            case "Dragons":
                return new Dragon(monsterChoice, monsterData, typeChoice, maxLevel);
            case "Exoskeletons":
                return new Exoskeleton(monsterChoice, monsterData, typeChoice, maxLevel);
            default:
                return new Spirit(monsterChoice, monsterData, typeChoice, maxLevel);
        }
    }

    /**
     * String representation of monster
     * @return String representation
     */
    @Override
    public String toString() {
        return super.stringify(
                "Damage: " + damage + "\n" +
                "Defense: " + defense + "\n" +
                "Dodge: " + dodge + "\n"
        );
    }

    /**
     * Take damage from an adversary
     * @param damage the initial damage to be taken from the adversary
     * @return the damage taken
     */
    public int takeDamage(int damage) {
        return super.takeDamage(dodge, damage, defense);
    }

    /**
     * Attack a hero
     * @param heroes List of heroes
     * @return List of heroes
     */
    public DataList<Hero> attackHero(DataList<Hero> heroes) {
        String[] heroOptions = GameEngine.getLegendsAlive(heroes);
        String heroName = GameEngine.makeRandomChoice(heroOptions);
        int index = GameEngine.legendIndexByName(heroes, heroName);
        int damageDealt = heroes.get(index).takeDamage((int) (damage * 0.05));
        System.out.println(name + " dealt " + damageDealt + " damage to " + heroes.get(index).name + "!");
        if (heroes.get(index).getStatus() == LegendStatus.DEAD) {
            System.out.println(heroes.get(index).name + " has been defeated!");
        }
        return heroes;
    }

    /**
     * Attack a hero in lane
     * @param hero Hero to be attacked
     * @return Hero attacked
     */
    public Hero attackHeroInLane(Hero hero) {
        int damageDealt = hero.takeDamage((int) (damage * 0.005));
        System.out.println(name + " dealt " + damageDealt + " damage to " + hero.name + "!");
        if (hero.getStatus() == LegendStatus.DEAD) {
            System.out.println(hero.name + " has been defeated!");
        }
        return hero;
    }

    /**
     * Apply effect of spell
     * @param spell Spell to be applied
     * @return Effect of spell
     */
    public int applyEffect(Spell spell) {
        switch (spell.getSpellType()) {
            case "Fire":
                return defense = (int) (defense - defense*0.20);
            case "Ice":
                return damage = (int) (damage - damage *0.20);
            case "Lightning":
                return dodge = (int) (dodge - dodge*0.20);
            default:
                return 0;
        }
    }
}
