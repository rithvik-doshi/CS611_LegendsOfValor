public class Paladin extends Hero{

    public Paladin(String name, DataMap<String, String> heroData, String classType) {
        super(name, heroData, classType);
        // Paladins are favored on strength and dexterity
        this.strength *= (attrBuff);
        this.dexterity *= (attrBuff);
    }
}
