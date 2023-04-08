import java.io.FileNotFoundException;

public abstract class Map {

    /**
     * Dimension of square map
     */
    final int R, C;

    /**
     * The matrix of cells on a map
     */
    public final Space[][] matrix;

    protected Map(int n) {
        R = C = n;
        matrix = new Space[this.R][this.C];
    }

    public abstract void heroesInitialPlace(DataList<Hero> heroes) throws FileNotFoundException;

    /**
     * String representation of a map
     * @return a string
     */
    public String toString() {
        StringBuilder outstring = new StringBuilder();
        for (Space[] row : matrix) {
            for (int i = 0; i < R; i++){
                outstring.append("+---");
            }
            outstring.append("+\n");
            for (Space cell : row) {
                outstring.append("| ").append(cell.toString()).append(" ");
            }
            outstring.append("|\n");
        }
        for (int i = 0; i < R; i++){
            outstring.append("+---");
        }
        outstring.append("+");
        return outstring.toString();
    }

}
