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
}
