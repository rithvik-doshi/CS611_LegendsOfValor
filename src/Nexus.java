public class Nexus extends Space implements Accessible {
    private DataList<Hero> heroes;
    public Nexus() {
        super('N');
    }
    @Override
    public void holdHeroes(DataList<Hero> heroes) {
        this.heroes = heroes;
        markVisited();
    }
    @Override
    public void leaveHeroes() {
        heroes = null;
    }
    @Override
    public void markVisited() {
        visited = true;
    }
    @Override
    public boolean tryAccess(DataList<Hero> heroes) {
        holdHeroes(heroes);
        System.out.println(Color.color(Color.bgBrightRed, "NEXUS!"));
        return true;
    }
    @Override
    public String toString() {
        return (heroes != null) ? Color.color(Color.bgRed , "N") : Color.color(Color.bgBrightRed, (getSymbol() + ""));
    }
}
