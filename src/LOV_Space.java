/**
 * Class to represent a space in the game of LOV
 */
public abstract class LOV_Space extends Space implements LOV_Accessible{

    /**
     * Space for one hero
     */
    protected Hero hero;
    /**
     * Space for one monster
     */
    protected Monster monster;

    /**
     * Constructor for Space
     * @param symbol Symbol of the space
     */
    public LOV_Space(char symbol) {
        super(symbol);
    }

    /**
     * Checks if the space has a hero
     * @return true if the space has a hero
     */
    public boolean hasHero(){
        return hero != null;
    }

    /**
     * Checks if the space has a monster
     * @return true if the space has a monster
     */
    public boolean hasMonster(){
        return monster != null;
    }

    /**
     * Legend entry point to access a space
     * @param legend Legend to access the space
     * @return true if the legend can access the space
     */
    @Override
    public boolean tryAccess(Legend legend) {
        return holdLegend(legend);
    }

    /**
     * Method to hold heroes in the space
     * @param heroes List of heroes to be held.
     */
    @Override
    public boolean tryAccess(DataList<Hero> heroes) {
        return false;
    }

    /**
     * Method to hold legends in a space
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
     * @param legend to remove
     */
    @Override
    public void removeLegend(Legend legend) {
        if (legend instanceof Hero){
            hero = null;
        } else {
            monster = null;
        }
    }

    /**
     * String representation method for the space
     * @return
     */
    @Override
    public String toString() {
        return (hasHero() && hasMonster()) ? Color.color(Color.bgMagenta, getSymbol() + "") :
                (hasHero()) ? Color.color(Color.bgBlue, (getSymbol() + "")) :
                        (hasMonster()) ? Color.color(Color.bgRed, (getSymbol() + "")) : spaceSpecificString();
    }

    /**
     * Space specific string representation
     * @return String representation of the space
     */
    public abstract String spaceSpecificString();
}
