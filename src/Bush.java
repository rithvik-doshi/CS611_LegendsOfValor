/**
 * Bush spaces increase hero dexterity
 */

public class Bush extends Space implements Accessible, AttributeAffectable{
    private DataList<Hero> heroes;
    public Bush() {
        super('B');
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
        System.out.println(Color.color(Color.bgBrightGreen, "BUSH!"));
        return true;
    }

    /**
     * Bushes increase hero dexterity by 10%
     * @param heroes
     */
    @Override
    public void increaseAttribute(DataList<Hero> heroes) {
        for (Hero h: heroes) {
            int currentDexterity = h.getDexterity();
            h.setDexterity((int) (currentDexterity * 1.1));
        }
    }

    @Override
    public String toString() {
        return (heroes != null) ? Color.color(Color.green , "B") : Color.color(Color.green, (getSymbol() + ""));
    }
}
