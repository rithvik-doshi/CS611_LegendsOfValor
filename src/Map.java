import java.io.FileNotFoundException;

/**
 * Abstract class for any maps used in the games.
 */
public abstract class Map {

    /**
     * Dimension of square map
     */
    final int R, C;

    /**
     * The matrix of cells on a map
     */
    public final Space[][] matrix;

    /**
     * Constructor for the Map class.
     * @param n Dimension of square map
     */
    protected Map(int n) {
        R = C = n;
        matrix = new Space[this.R][this.C];
    }

    /**
     * Places the heroes on the map initially
     * @param heroes the list of heroes
     * @throws FileNotFoundException if the file is not found
     */
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

    /**
     * String representation of a map with cell numbers
     * @param cellNums whether to include cell numbers
     * @return a string
     */
    public String toString(boolean cellNums) {
        StringBuilder outstring = new StringBuilder();
        int rowNum = 0, colNum = 0;
        for (Space[] row : matrix) {
            outstring.append("\t");
            for (int i = 0; i < R; i++){
                outstring.append("+---");
            }
            outstring.append("+\n");
            outstring.append(" ").append(rowNum++).append("\t");
            for (Space cell : row) {
                outstring.append("| ").append(cell.toString()).append(" ");
            }
            outstring.append("|\n");
        }
        outstring.append("\t");
        for (int i = 0; i < R; i++){
            outstring.append("+---");
        }
        outstring.append("+\n\t");
        for (int i = 0; i < R; i++){
            outstring.append("  ").append(colNum++).append(" ");
        }
        return outstring.toString();
    }

}
