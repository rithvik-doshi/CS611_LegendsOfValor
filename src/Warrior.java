public class Warrior extends Hero {
    public Warrior(String name, DataMap<String, String> heroData, String classType) {
        super(name, heroData, classType);
        // Warriors are favored on strength and agility
        this.strength *= (attrBuff);
        this.agility *= (attrBuff);
    }
}
