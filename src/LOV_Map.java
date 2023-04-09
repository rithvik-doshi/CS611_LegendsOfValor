import java.io.FileNotFoundException;

public class LOV_Map extends Map{
    public int row, col;
    protected LOV_Map() {
        super(8);
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
                if (rand < 0.4) {
                    matrix[i][j] = new Plain();
                } else if (rand < 0.6) {
                    matrix[i][j] = new Cave();
                } else if (rand < 0.8) {
                    matrix[i][j] = new Koulou();
                } else {
                    matrix[i][j] = new Bush();
                }
            }

        }
    }

    @Override
    public void heroesInitialPlace(DataList<Hero> heroes) throws FileNotFoundException {

    }

    public void monstersInitialPlace(DataList<Monster> monsters) throws FileNotFoundException {

    }

}
