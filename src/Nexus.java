public class Nexus extends LOV_Space {
    public Nexus() {
        super('N');
    }

    @Override
    public void markVisited() {
        visited = true;
    }

    @Override
    public String toString() {
        return (hero != null || monster != null) ? Color.color(Color.bgRed , "N") : Color.color(Color.brightRed, (getSymbol() + ""));
    }

}
