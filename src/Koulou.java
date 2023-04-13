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

    /**
     * Koulous decrease hero strength to normal
     */
    @Override
    public void decreaseAttribute() {
        hero.setStrength(currHeroBaseStat);
        System.out.println(hero.name + "'s strength decreased to normal");
    }

    /**
     * Returns the name of the space
     * @return the name of the space
     */
    @Override
    public String spaceSpecificString() {
        return Color.color(Color.blue, (getSymbol() + ""));
    }


    /**
     * Method to try to access a space
     */
    @Override
    public void markVisited() {
        visited = true;
    }
}
