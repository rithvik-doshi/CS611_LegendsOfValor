/**
 * Plain spaces have no special attributes
 */

public class Plain extends Space implements LOV_Accessible {
    private Hero hero;
    private Monster monster;

    public Plain() {
        super('P');
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

    @Override
    public String toString() {
        return (hero != null || monster != null) ? Color.color(Color.yellow , "P") : Color.color(Color.yellow, (getSymbol() + ""));
    }

    /**
     * Holds a legend in the space
     *
     * @param legend to hold
     */
    @Override
    public void holdLegend(Legend legend) {

    }

    /**
     * Removes a legend from the space
     *
     * @param legend to remove
     */
    @Override
    public void removeLegend(Legend legend) {

    }
}
