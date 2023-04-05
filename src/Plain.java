/**
 * Plain spaces have no special attributes
 */

public class Plain extends Space implements Accessible {
    private DataList<Hero> heroes;
    public Plain() {
        super('P');
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
        System.out.println(Color.color(Color.bgBrightWhite, "PLAIN!"));
        return true;
    }

    @Override
    public String toString() {
        return (heroes != null) ? Color.color(Color.bgWhite , "P") : Color.color(Color.bgBrightWhite, (getSymbol() + ""));
    }
}
