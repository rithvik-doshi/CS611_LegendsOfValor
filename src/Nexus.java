/**
 * Nexus space is the home space for Monsters and Heroes
 */
public class Nexus extends LOV_Space {

    /**
     * Constructor for Nexus
     */
    public Nexus() {
        super('N');
    }

    /**
     * Marks a space as visited
     */
    @Override
    public void markVisited() {
        visited = true;
    }

    /**
     * Returns the string representation of the space
     * @return String representation of the space
     */
    @Override
    public String spaceSpecificString() {
        return Color.color(Color.brightRed, (getSymbol() + ""));
    }

}
