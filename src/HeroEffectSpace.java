/**
 * HeroEffectSpace is a space that affects the hero's attributes
 */
public abstract class HeroEffectSpace extends LOV_Space implements AttributeAffectable {

    /**
     * Base stat of hero that is currently in the space
     */
    protected int currHeroBaseStat;

    /**
     * Constructor for Space
     */
    public HeroEffectSpace(char symbol) {
        super(symbol);
    }

    /**
     * Method to hold a legend in a space
     * @param legend legend to be held.
     * This can be extended to allow monsters to get attribute buffs
     */
    @Override
    public boolean holdLegend(Legend legend) {
        if (super.holdLegend(legend)){
            if (hero != null) increaseAttribute();
            return true;
        }
        return false;
    }

    /**
     * Method to let a legend leave a space
     * @param legend legend to be let out.
     */
    @Override
    public void removeLegend(Legend legend) {
        if (hero != null) decreaseAttribute();
        super.removeLegend(legend);
    }

}
