/**
 * Plain spaces have no special attributes
 */

public class Plain extends LOV_Space {

    public Plain() {
        super('P');
    }

    @Override
    public void markVisited() {
        visited = true;
    }

    @Override
    public String spaceSpecificString() {
        return Color.color(Color.yellow, (getSymbol() + ""));
    }


}
