public class Exoskeleton extends Monster {
    public Exoskeleton(String name, DataMap<String, String> monsterData, String monsterType, int heroMaxLevel) {
        super(name, monsterData, monsterType, heroMaxLevel);
        // Exoskeletons get a defense boost
        this.defense *= (attrBuff);
    }
}
