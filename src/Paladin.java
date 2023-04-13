/**
 * Paladin class of heroes favors strength and dexterity
 */
public class Paladin extends Hero{

    /**
     * Constructor for Paladin
     * @param name Name of the hero
     * @param heroData Data of the hero
     * @param classType Class of the hero
     */
    public Paladin(String name, DataMap<String, String> heroData, String classType) {
        super(name, heroData, classType);
        // Paladins are favored on strength and dexterity
        this.strength *= (attrBuff);
        this.dexterity *= (attrBuff);
    }
}
