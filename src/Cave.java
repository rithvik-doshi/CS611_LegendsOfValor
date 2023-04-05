import javax.print.attribute.Attribute;

/**
 * Cave spaces increase hero agility
 */

public class Cave extends Space implements Accessible, AttributeAffectable {
    private DataList<Hero> heroes;
    public Cave() {
        super('C');
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
        System.out.println(Color.color(Color.bgBrightCyan, "CAVE!"));
        return true;
    }

    /**
     * Caves increase hero agility by 10%
     * @param heroes
     */
    @Override
    public void increaseAttribute(DataList<Hero> heroes) {
        for (Hero h: heroes) {
            int currentAgility = h.getAgility();
            h.setAgility((int) (currentAgility * 1.1));
        }
    }

    @Override
    public String toString() {
        return (heroes != null) ? Color.color(Color.bgCyan , "C") : Color.color(Color.bgBrightCyan, (getSymbol() + ""));
    }
}
