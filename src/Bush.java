/**
 * Bush spaces increase hero dexterity
 */
public class Bush extends HeroEffectSpace{
    public Bush() {
        super('B');
    }

    /**
     * Bushes increase hero dexterity by 10%
     */
    @Override
    public void increaseAttribute() {
        currHeroBaseStat = hero.getDexterity();
        hero.setDexterity((int) (currHeroBaseStat * 1.1));
        System.out.println(hero.name + "'s dexterity increased to " + hero.getDexterity());
    }

    /**
     * Bushes decrease hero dexterity to normal
     */
    @Override
    public void decreaseAttribute() {
        hero.setDexterity(currHeroBaseStat);
        System.out.println(hero.name + "'s dexterity decreased to normal");
    }

    /**
     * String representation of Bush
     * @return String representation of Bush
     */
    @Override
    public String spaceSpecificString() {
        return Color.color(Color.green, (getSymbol() + ""));
    }


    /**
     * Method to try to access a space
     */
    @Override
    public void markVisited() {
        visited = true;
    }
}
