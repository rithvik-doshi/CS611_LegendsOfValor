/**
 * Exoskeleton type monster that gets a defense boost
 */
public class Exoskeleton extends Monster {
    /**
     * Constructor for Exoskeleton
     * @param name name of the monster
     * @param monsterData data of the monster
     * @param monsterType type of the monster
     * @param heroMaxLevel max level of the hero
     */
    public Exoskeleton(String name, DataMap<String, String> monsterData, String monsterType, int heroMaxLevel) {
        super(name, monsterData, monsterType, heroMaxLevel);
        this.defense *= (attrBuff);
    }
}
