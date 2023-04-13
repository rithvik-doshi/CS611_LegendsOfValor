/**
 * Sorcerer class of heroes favors agility and dexterity
 */
public class Sorcerer extends Hero {

    /**
     * Constructor for Sorcerer
     * @param name Name of the hero
     * @param heroData Data of the hero
     * @param classType Class of the hero
     */
    public Sorcerer(String name, DataMap<String, String> heroData, String classType) {
        super(name, heroData, classType);
        // Sorcerers are favored on agility and dexterity
        this.agility *= (attrBuff);
        this.dexterity *= (attrBuff);
    }
}
