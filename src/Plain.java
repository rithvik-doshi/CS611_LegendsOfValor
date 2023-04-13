/**
 * Plain spaces have no special attributes
 */

public class Plain extends LOV_Space {

    /**
     * Constructor for Plain
     */
    public Plain() {
        super('P');
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
        return Color.color(Color.yellow, (getSymbol() + ""));
    }


}
