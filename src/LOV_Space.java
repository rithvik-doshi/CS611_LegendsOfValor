public abstract class LOV_Space extends Space implements LOV_Accessible{

    protected Hero hero;
    protected Monster monster;

    /**
     * Constructor for Space
     *
     * @param symbol Symbol of the space
     */
    public LOV_Space(char symbol) {
        super(symbol);
    }

    @Override
    public void markVisited() {
        visited = true;
    }

    public boolean hasHero(){
        return hero != null;
    }

    public boolean hasMonster(){
        return monster != null;
    }

    @Override
    public boolean tryAccess(Legend legend) {
        return holdLegend(legend);
    }

    @Override
    public boolean tryAccess(DataList<Hero> heroes) {
        return false;
    }

    /**
     * Method to hold legends in a space
     *
     * @param legend List of heroes to be held.
     */
    @Override
    public boolean holdLegend(Legend legend) {
        if (legend instanceof Hero){
            if (hero != null){
                return false;
            }
            hero = (Hero) legend;
            return true;
        } else if (legend instanceof Monster){
            if (monster != null){
                return false;
            }
            monster = (Monster) legend;
            return true;
        }
        else return false;
    }

    /**
     * Removes a legend from the space
     *
     * @param legend to remove
     */
    @Override
    public void removeLegend(Legend legend) {
        if (legend instanceof Hero){
            hero = null;
        } else if (legend instanceof Monster){
            monster = null;
        }
    }
}
