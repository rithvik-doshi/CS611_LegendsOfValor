public class Sorcerer extends Hero {
    public Sorcerer(String name, DataMap<String, String> heroData, String classType) {
        super(name, heroData, classType);
        // Sorcerers are favored on agility and dexterity
        this.agility *= (attrBuff);
        this.dexterity *= (attrBuff);
    }
}
