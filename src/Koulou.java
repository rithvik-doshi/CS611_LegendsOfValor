/**
 * Koulou spaces increase hero strength
 */

public class Koulou extends HeroEffectSpace {

    /**
     * Constructor for Space
     */
    public Koulou() {
        super('K');
    }

    /**
     * Koulous increase hero strength by 10%
     */
    @Override
    public void increaseAttribute() {
        currHeroBaseStat = hero.getStrength();
        hero.setStrength((int) (currHeroBaseStat * 1.1));
        System.out.println(hero.name + "'s strength increased to " + hero.getAgility());
    }

    @Override
    public void decreaseAttribute() {
        hero.setStrength(currHeroBaseStat);
        System.out.println(hero.name + "'s strength decreased to normal");
    }

    @Override
    public String toString() {
        return (hero != null || monster != null) ? Color.color(Color.bgBlue , "K") : Color.color(Color.blue, (getSymbol() + ""));
    }


}
