/**
 * Bush spaces increase hero dexterity
 */

public class Bush extends Space implements LOV_Accessible, AttributeAffectable{
    private Hero hero;
    private Monster monster;
    public Bush() {
        super('B');
    }

    /**
     * Holds a legend in the space
     * @param legend to hold
     */
    @Override
    public void holdLegend(Legend legend) {

    }

    /**
     * Removes a legend from the space
     * @param legend to remove
     */
    @Override
    public void removeLegend(Legend legend) {

    }

    @Override
    public void markVisited() {
        visited = true;
    }

    @Override
    public boolean tryAccess(DataList<Hero> heroes) {
        return false;
    }

    @Override
    public boolean tryAccess(Legend legend) {
        return false;
    }

    /**
     * Bushes increase hero dexterity by 10%
     */
    @Override
    public void increaseAttribute() {
        int currentDexterity = hero.getDexterity();
        hero.setDexterity((int) (currentDexterity * 1.1));
    }

    @Override
    public String toString() {
        return (hero != null || monster != null) ? Color.color(Color.green , "B") : Color.color(Color.green, (getSymbol() + ""));
    }


}
