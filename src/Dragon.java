/**
 * Dragon type monster that gets a damage boost
 */
public class Dragon extends Monster {
    /**
     * Constructor for Dragon
     * @param name name of the monster
     * @param monsterData data of the monster
     * @param monsterType type of the monster
     * @param heroMaxLevel max level of the hero
     */
    public Dragon(String name, DataMap<String, String> monsterData, String monsterType, int heroMaxLevel) {
        super(name, monsterData, monsterType, heroMaxLevel);
        this.damage *= (attrBuff);
    }
}
