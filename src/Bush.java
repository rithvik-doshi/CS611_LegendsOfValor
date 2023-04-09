/**
 * Bush spaces increase hero dexterity
 */

public class Bush extends LOV_Space implements AttributeAffectable{
    public Bush() {
        super('B');
    }

    @Override
    public void markVisited() {
        visited = true;
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
    public void decreaseAttribute() {
        int currentDexterity = hero.getDexterity();
        hero.setDexterity((int) (currentDexterity / 1.1));
    }

    @Override
    public String toString() {
        return (hero != null || monster != null) ? Color.color(Color.bgGreen , "B") : Color.color(Color.green, (getSymbol() + ""));
    }


}
