import java.util.Arrays;
import java.util.HashMap;

public class LOV_Map extends Map{
    public HashMap<Legend, int[]> legendLocations = new HashMap<>();
    protected LOV_Map() {
        super(8);
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
    public void heroesInitialPlace(DataList<Hero> heroes) {
        assert heroes.size() <= 3;
        for (Hero hero : heroes){
            int[] location = new int[2];
            location[0] = 7;
            location[1] = heroes.indexOf(hero) * 3;
            legendLocations.put(hero, location);
            if (matrix[location[0]][location[1]].tryAccess(hero)){
                System.out.println("Placed " + hero.name + " at " + Arrays.toString(location));
            }
        }
    }

    public void monstersInitialPlace(DataList<Monster> monsters) {
        assert monsters.size() <= 3;
        for (Monster monster : monsters){
            int[] location = new int[2];
            location[1] = monsters.indexOf(monster) * 3 + 1;
            legendLocations.put(monster, location);
            if (matrix[location[0]][location[1]].tryAccess(monster)){
                System.out.println("Placed " + monster.name + " at " + Arrays.toString(location));
            }
        }
    }

    public void printLocations(){
        System.out.println(getLocations());
    }

    private String getLocations(){
        StringBuilder locations = new StringBuilder();
        for (Legend legend : legendLocations.keySet()){
            String appendStr = legend.name + " (" + legend.type.substring(0, legend.type.length() - 1) + ") @ " + Arrays.toString(legendLocations.get(legend)) + "\n";
            locations.append(appendStr);
        }
        return locations.toString();
    }

    public boolean moveLegend(Legend legend, char control) {
        int[] location = legendLocations.get(legend);
        int newrow = location[0], newcol = location[1];
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
        if (matrix[newrow][newcol].tryAccess(legend) && matrix[location[0]][location[1]] instanceof LOV_Accessible){
            ((LOV_Accessible) matrix[location[0]][location[1]]).removeLegend(legend);
            location[0] = newrow;
            location[1] = newcol;
            legendLocations.put(legend, location);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString(true) + "\n" + getLocations();
    }
}
