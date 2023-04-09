/**
 * Cave spaces increase hero agility
 */

public class Cave extends LOV_Space implements AttributeAffectable {
    public Cave() {
        super('C');
    }

    @Override
    public void markVisited() {
        visited = true;
    }

    /**
     * Caves increase hero agility by 10%
     */
    @Override
    public void increaseAttribute() {
        int currentAgility = hero.getAgility();
        hero.setAgility((int) (currentAgility * 1.1));
        System.out.println("Hero agility increased to " + hero.getAgility());
    }

    @Override
    public void decreaseAttribute() {
        int currentAgility = hero.getAgility();
        hero.setAgility((int) (currentAgility / 1.1));
        System.out.println("Hero agility decreased to normal");
    }

    @Override
    public String toString() {
        return (hero != null || monster != null) ? Color.color(Color.bgMagenta , "C") : Color.color(Color.magenta, (getSymbol() + ""));
    }

}
