/**
 * Koulou spaces increase hero strength
 */

public class Koulou extends Space implements Accessible, AttributeAffectable {
    private DataList<Hero> heroes;
    public Koulou() {
        super('K');
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
        System.out.println(Color.color(Color.bgBrightBlue, "KOULOU!"));
        return true;
    }

    /**
     * Koulous increase hero strength by 10%
     * @param heroes
     */
    public void increaseAttribute(DataList<Hero> heroes) {
        for (Hero h: heroes) {
            int currentStrength = h.getStrength();
            h.setStrength((int) (currentStrength * 1.1));
        }
    }

    @Override
    public String toString() {
        return (heroes != null) ? Color.color(Color.bgBlue , "K") : Color.color(Color.bgBrightBlue, (getSymbol() + ""));
    }
}
