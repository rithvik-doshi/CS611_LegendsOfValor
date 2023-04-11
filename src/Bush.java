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

    @Override
    public void decreaseAttribute() {
        hero.setDexterity(currHeroBaseStat);
        System.out.println(hero.name + "'s dexterity decreased to normal");
    }

    @Override
    public String toString() {
        return (hero != null || monster != null) ? Color.color(Color.bgGreen , "B") : Color.color(Color.green, (getSymbol() + ""));
    }


}
