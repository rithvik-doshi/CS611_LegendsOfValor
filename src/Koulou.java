/**
 * Koulou spaces increase hero strength
 */

public class Koulou extends LOV_Space implements AttributeAffectable {

    /**
     * Constructor for Space
     */
    public Koulou() {
        super('K');
    }

    @Override
    public void markVisited() {
        visited = true;
    }

    /**
     * Koulous increase hero strength by 10%
     */
    @Override
    public void increaseAttribute() {
        int currentStrength = hero.getStrength();
        hero.setStrength((int) (currentStrength * 1.1));
        System.out.println("Hero strength increased to " + hero.getAgility());
    }

    @Override
    public void decreaseAttribute() {
        int currentStrength = hero.getStrength();
        hero.setStrength((int) (currentStrength / 1.1));
        System.out.println("Hero strength decreased to normal");
    }

    @Override
    public String toString() {
        return (hero != null || monster != null) ? Color.color(Color.bgBlue , "K") : Color.color(Color.blue, (getSymbol() + ""));
    }


}
