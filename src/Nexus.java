public class Nexus extends LOV_Space {
    public Nexus() {
        super('N');
    }

    @Override
    public void markVisited() {
        visited = true;
    }
    @Override
    public String spaceSpecificString() {
        return Color.color(Color.brightRed, (getSymbol() + ""));
    }

}
