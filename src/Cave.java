/**
 * Cave spaces increase hero agility
 */
public class Cave extends HeroEffectSpace {

    /**
     * Constructor for Cave
     */
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

    /**
     * Caves decrease hero agility to normal
     */
    @Override
    public void decreaseAttribute() {
        hero.setAgility(currHeroBaseStat);
        System.out.println(hero.name + "'s agility decreased to normal");
    }

    /**
     * String representation of Cave
     * @return String representation of Cave
     */
    @Override
    public String spaceSpecificString() {
        return Color.color(Color.magenta, (getSymbol() + ""));
    }

    /**
     * Method to try to access a space
     */
    @Override
    public void markVisited() {
        visited = true;
    }
}
