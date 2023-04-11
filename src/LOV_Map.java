import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LOV_Map extends Map{
    public HashMap<Legend, int[]> legendLocations = new HashMap<>();
    public HashMap<Hero, int[]> initialHeroLocations = new HashMap<>();
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
            hero.setStartingLocation(location.clone());
            if (matrix[location[0]][location[1]].tryAccess(hero)){
                System.out.println("Placed " + hero.name + " at " + Arrays.toString(location));
                legendLocations.put(hero, location);
            }
        }
    }

    public void monstersInitialPlace(DataList<Monster> monsters) {
        assert monsters.size() <= 3;
        for (Monster monster : monsters){
            int[] location = new int[2];
            location[1] = monsters.indexOf(monster) * 3 + 1;
            placeMonster(monster, location);
        }
    }

    public boolean addMonsterToNexus(Monster monster, int nexusIndex){
        int[] location = new int[2];
        location[0] = 0;
        location[1] = nexusIndex * 3 + 1;
        return placeMonster(monster, location);
    }

    private boolean placeMonster(Monster monster, int[] location) {
        if (matrix[location[0]][location[1]].tryAccess(monster)){
            System.out.println("Placed " + monster.name + " at " + Arrays.toString(location));
            legendLocations.put(monster, location);
            return true;
        } else {
            System.out.println("Failed to place " + monster.name + " at " + Arrays.toString(location));
            return false;
        }
    }

    public void printLocations(){
        System.out.println(getLocations());
    }

    private String getLocations(){
        StringBuilder locations = new StringBuilder();
        locations.append("Heroes: \n");
        for (Legend legend : legendLocations.keySet().stream().filter(legend -> legend instanceof Hero).toArray(Legend[]::new)){
            String appendStr = legend.name + " (" + legend.type.substring(0, legend.type.length() - 1) + ") @ " + Arrays.toString(legendLocations.get(legend)) + "\n";
            locations.append(appendStr);
        }
        locations.append("\nMonsters: \n");
        for (Legend legend : legendLocations.keySet().stream().filter(legend -> legend instanceof Monster).toArray(Legend[]::new)){
            String appendStr = legend.name + " (" + legend.type.substring(0, legend.type.length() - 1) + ") @ " + Arrays.toString(legendLocations.get(legend)) + "\n";
            locations.append(appendStr);
        }
        return locations.toString();
    }

    public Legend getLegendAt(int[] location){
        for (Legend legend : legendLocations.keySet()){
            if (Arrays.equals(legendLocations.get(legend), location)){
                return legend;
            }
        }
        return null;
    }

    public Monster getMonsterAt(int[] location){
        for (Legend legend : legendLocations.keySet()){
            if (Arrays.equals(legendLocations.get(legend), location) && legend instanceof Monster){
                return (Monster) legend;
            }
        }
        return null;
    }

    public Hero getHeroAt(int[] location){
        for (Legend legend : legendLocations.keySet()){
            if (Arrays.equals(legendLocations.get(legend), location) && legend instanceof Hero){
                return (Hero) legend;
            }
        }
        return null;
    }

    public boolean containsMonster(int[] location){
        for (Legend legend : legendLocations.keySet()){
            if (Arrays.equals(legendLocations.get(legend), location) && legend instanceof Monster){
                return true;
            }
        }
        return false;
    }

    public boolean containsHero(int[] location){
        for (Legend legend : legendLocations.keySet()){
            if (Arrays.equals(legendLocations.get(legend), location) && legend instanceof Hero){
                return true;
            }
        }
        return false;
    }

    public boolean moveLegend(Legend legend, char control) {
        int[] location = legendLocations.get(legend);
        int newrow = location[0], newcol = location[1];

        ArrayList<int[]> possibleMoves = getPossibleMoves(legend, location);

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

        if (!locationInBounds(new int[]{newrow, newcol})) return false;
        if (!containsLocation(possibleMoves, new int[]{newrow, newcol})){
            return false;
        }

        return placeLegend(legend, location, newrow, newcol);
    }

    private boolean placeLegend(Legend legend, int[] location, int newrow, int newcol) {
//        check newrow and newcol are in bounds:
        if (!locationInBounds(new int[]{newrow, newcol})) return false;
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

    private boolean containsLocation(ArrayList<int[]> possibleMoves, int[] ints) {
        for (int[] possibleMove : possibleMoves) {
            if (Arrays.equals(possibleMove, ints)) return true;
        }
        return false;
    }

    private ArrayList<int[]> getPossibleMoves(Legend legend, int[] location) {

        ArrayList<int[]> out = new ArrayList<>();

        int[] TM = {location[0] - 1, location[1]},
                ML = {location[0], location[1] - 1},
                MR = {location[0], location[1] + 1},
                C = {location[0], location[1]},
                BM = {location[0] + 1, location[1]};
        int[] side;
        if (locationInBounds(ML) && (matrix[ML[0]][ML[1]] instanceof LOV_Space)){
            side = ML;
        } else side = MR;

        LOV_Space sideSpace, centerSpace;
        sideSpace = (LOV_Space) matrix[side[0]][side[1]];
        centerSpace = (LOV_Space) matrix[C[0]][C[1]];

        if (legend instanceof Hero){
            LOV_Space topSpace = (LOV_Space) matrix[TM[0]][TM[1]];
            if (!sideSpace.hasHero()){
                out.add(side);
            }
            if (!sideSpace.hasMonster() && !centerSpace.hasMonster() && !topSpace.hasHero()) {
                out.add(TM);
            }
            out.add(BM);
        } else if (legend instanceof Monster){
            LOV_Space bottomSpace = (LOV_Space) matrix[BM[0]][BM[1]];
            if (!sideSpace.hasMonster()){
                out.add(side);
            }
            if (!sideSpace.hasHero() && !centerSpace.hasHero() && !bottomSpace.hasMonster()) {
                out.add(BM);
            }
            out.add(TM);
        }

        return out;
    }

    public boolean locationInBounds(int[] location){
        return location[0] >= 0 && location[0] < R && location[1] >= 0 && location[1] < C;
    }

    @Override
    public String toString() {
        return super.toString(true) + "\n" + getLocations();
    }


    public boolean teleportHero(Hero legend) {
        int[] location = legendLocations.get(legend);
        ArrayList<int[]> possibleTeleports = getPossibleTeleports(legend);
        if (possibleTeleports.size() == 0) return false;
        System.out.println("Choose a location to teleport to:");
        int option = GameEngine.getIntOption(possibleTeleports.stream().map(Arrays::toString).toArray(String[]::new));
        int newrow = possibleTeleports.get(option)[0], newcol = possibleTeleports.get(option)[1];
        return placeLegend(legend, location, newrow, newcol);
    }

    private ArrayList<int[]> getPossibleTeleports(Hero legend) {
        ArrayList<int[]> out = new ArrayList<>();
        ArrayList<int[]> heroLocations = new ArrayList<>();
        for (Hero hero : legendLocations.keySet().stream().filter(legnd -> (legnd instanceof Hero)).toArray(Hero[]::new)){
            if (!hero.equals(legend)){
                heroLocations.add(legendLocations.get(hero));
            }
        }
        for (int[] locs : heroLocations) {
            int[] ML = {locs[0], locs[1] - 1},
                    MR = {locs[0], locs[1] + 1},
                    BM = {locs[0] + 1, locs[1]};
            int[] side;
            if (locationInBounds(ML) && (matrix[ML[0]][ML[1]] instanceof LOV_Space)){
                side = ML;
            } else side = MR;
            LOV_Space sideSpace = (LOV_Space) matrix[side[0]][side[1]];
            if (!sideSpace.hasHero()) {
                out.add(side);
            }
            if (locationInBounds(BM) && !((LOV_Space) matrix[BM[0]][BM[1]]).hasHero()) {
                out.add(BM);
            }
        }
        return out;
    }

    public boolean recallHero(Hero hero) {
        int[] homeLocation  = hero.getStartingLocation();
//        System.out.println(hero + " " + Arrays.toString(legendLocations.get(hero)) + " " + homeLocation[0] + " " + homeLocation[1]);
//        int [] homeLocation = new int[]{-1, -1};
        return placeLegend(hero, legendLocations.get(hero), homeLocation[0], homeLocation[1]);
    }
}
