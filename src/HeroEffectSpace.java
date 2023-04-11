public abstract class HeroEffectSpace extends LOV_Space implements AttributeAffectable {

    /**
     * Constructor for Space
     */

    protected int currHeroBaseStat;

    public HeroEffectSpace(char symbol) {
        super(symbol);
    }

    @Override
    public boolean holdLegend(Legend legend) {
        if (super.holdLegend(legend)){
            if (hero != null) increaseAttribute();
            return true;
        }
        return false;
    }

    @Override
    public void removeLegend(Legend legend) {
        if (hero != null) decreaseAttribute();
        super.removeLegend(legend);
    }

}
