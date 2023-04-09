import java.io.FileNotFoundException;

/**
 * LMH_Map Class
 */
public class LMH_Map extends Map{

    public int row, col;

    /**
     * Constructor
     * @param N map size
     */
    public LMH_Map(int N) {
        super(N);
        row = matrix.length - 1;
        col = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == matrix.length - 1 && j == 0) {
                    matrix[i][j] = new Market();
                    continue;
                }
                double rand = Math.random();
                if (rand < 0.2) {
                    matrix[i][j] = new Inaccessible();
                } else if (rand < 0.4) {
                    matrix[i][j] = new Market();
                } else {
                    matrix[i][j] = new Common();
                }
            }
        }
    }



    /**
     * Moves the heroes on the map
     * @param heroes the list of heroes
     * @param control the control character
     * @return true if the move was successful
     */
    public boolean moveHeroes(DataList<Hero> heroes, char control) {
        int newrow = row, newcol = col;
        switch (control){
            case 'W':
                newrow--;
                break;
            case 'A':
                newcol--;
                break;
            case 'S':
                newrow++;
                break;
            case 'D':
                newcol++;
                break;
        }
        if (newrow < 0 || newrow >= R || newcol < 0 || newcol >= C){
            return false;
        }
        if (matrix[newrow][newcol].tryAccess(heroes)){
            LMH_Accessible currentSpace = (LMH_Accessible) matrix[row][col];
            currentSpace.leaveHeroes();
            row = newrow;
            col = newcol;
            return true;
        }
        return false;
    }

    /**
     * Places the heroes on the map at the start of the game
     * @param heroes the list of heroes
     */
    public void heroesInitialPlace(DataList<Hero> heroes) {
        matrix[row][col].tryAccess(heroes);
    }

    /**
     * Gets the current space
     * @return the current space
     */
    public Space getSpace() {
        return matrix[row][col];
    }
}
