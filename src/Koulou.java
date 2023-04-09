/**
 * Koulou spaces increase hero strength
 */

public class Koulou extends Space implements LOV_Accessible, AttributeAffectable {
    private Hero hero;
    private Monster monster;
    public Koulou() {
        super('K');
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
     * Koulous increase hero strength by 10%
     */
    @Override
    public void increaseAttribute() {
        int currentStrength = hero.getStrength();
        hero.setStrength((int) (currentStrength * 1.1));
    }

    @Override
    public String toString() {
        return (hero != null || monster != null) ? Color.color(Color.blue , "K") : Color.color(Color.blue, (getSymbol() + ""));
    }


}
