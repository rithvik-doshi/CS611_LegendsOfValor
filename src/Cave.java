/**
 * Cave spaces increase hero agility
 */

public class Cave extends HeroEffectSpace {
    public Cave() {
        super('C');
    }

    /**
     * Caves increase hero agility by 10%
     */
    @Override
    public void increaseAttribute() {
        currHeroBaseStat = hero.getAgility();
        hero.setAgility((int) (currHeroBaseStat * 1.1));
        System.out.println(hero.name + "'s agility increased to " + hero.getAgility());
    }

    @Override
    public void decreaseAttribute() {
        hero.setAgility(currHeroBaseStat);
        System.out.println(hero.name + "'s agility decreased to normal");
    }

    @Override
    public String spaceSpecificString() {
        return Color.color(Color.magenta, (getSymbol() + ""));
    }

}
