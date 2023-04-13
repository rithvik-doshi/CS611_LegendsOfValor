/**
 * Spirit monster that favors dodge
 */
public class Spirit extends Monster {

    /**
     * Constructor for Spirit
     * @param name Name of monster
     * @param monsterData Data for monster
     * @param monsterType Type of monster
     * @param heroMaxLevel Maximum level of heroes
     */
    public Spirit(String name, DataMap<String, String> monsterData, String monsterType, int heroMaxLevel) {
        super(name, monsterData, monsterType, heroMaxLevel);
        // Spirits get a dodge boost
        this.dodge *= (attrBuff);
    }
}
