
public class LV_Map extends Map {
    public int row, col;
    public LV_Map(int N) {
        super(N);
        row = matrix.length - 1;
        col = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == 2 || j == 5) {
                    matrix[i][j] = new Inaccessible();
                    continue;
                }
                if (i == 0 || i == matrix.length - 1) {
                    matrix[i][j] = new Nexus();
                    continue;
                }
                double rand = Math.random();
                if (rand < 0.2) {
                    matrix[i][j] = new Inaccessible();
                } else if (rand < 0.4) {
                    matrix[i][j] = new Plain();
                } else if (rand < 0.6) {
                    matrix[i][j] = new Cave();
                } else if (rand < 0.8) {
                    matrix[i][j] = new Koulou();
                }
                else {
                    matrix[i][j] = new Bush();
                }
            }
        }
    }
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
