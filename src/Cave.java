/**
 * Cave spaces increase hero agility
 */

public class Cave extends Space implements LOV_Accessible, AttributeAffectable {
    private Hero hero;
    private Monster monster;
    public Cave() {
        super('C');
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
     * Caves increase hero agility by 10%
     */
    @Override
    public void increaseAttribute() {
        int currentAgility = hero.getAgility();
        hero.setAgility((int) (currentAgility * 1.1));
    }

    @Override
    public String toString() {
        return (hero != null || monster != null) ? Color.color(Color.magenta , "C") : Color.color(Color.magenta, (getSymbol() + ""));
    }

}
