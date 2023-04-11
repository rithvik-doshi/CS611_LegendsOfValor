public class Spirit extends Monster {
    public Spirit(String name, DataMap<String, String> monsterData, String monsterType, int heroMaxLevel) {
        super(name, monsterData, monsterType, heroMaxLevel);
        // Spirits get a dodge boost
        this.dodge *= (attrBuff);
    }
}
