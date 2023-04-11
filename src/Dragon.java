public class Dragon extends Monster {
    public Dragon(String name, DataMap<String, String> monsterData, String monsterType, int heroMaxLevel) {
        super(name, monsterData, monsterType, heroMaxLevel);
        // Dragons get a damage boost
        this.damage *= (attrBuff);
    }
}
