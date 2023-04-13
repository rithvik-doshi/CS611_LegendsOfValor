/**
 * Warrior class of heroes favor strength and agility
 */
public class Warrior extends Hero {

    /**
     * Constructor for Warrior
     * @param name Name of the hero
     * @param heroData Data of the hero
     * @param classType Class of the hero
     */
    public Warrior(String name, DataMap<String, String> heroData, String classType) {
        super(name, heroData, classType);
        // Warriors are favored on strength and agility
        this.strength *= (attrBuff);
        this.agility *= (attrBuff);
    }
}
