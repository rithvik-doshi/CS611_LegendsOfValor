import java.util.*;

/**
 * This class contains the map upon which LOV is played
 */
public class LOV_Map extends Map{
    /**
     * Stores the locations of the legends on the map
     */
    public HashMap<Legend, int[]> legendLocations = new HashMap<>();

    /**
     * Constructor
     */
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

    /**
     * Places the heroes on the map on initialization
     * @param heroes the list of heroes to place
     */
    @Override
    public void heroesInitialPlace(DataList<Hero> heroes) {
        assert heroes.size() <= 3;
        for (Hero hero : heroes){
            int[] location = new int[2];
            location[0] = 7;
            location[1] = heroes.indexOf(hero) * 3;
            hero.setStartingLocation(location.clone());
            if (matrix[location[0]][location[1]].tryAccess(hero)){
                legendLocations.put(hero, location);
            }
        }
    }

    /**
     * Places the monsters on the map on initialization
     * @param monsters the list of monsters to place
     */
    public void monstersInitialPlace(DataList<Monster> monsters) {
        assert monsters.size() <= 3;
        for (Monster monster : monsters){
            int[] location = new int[2];
            location[1] = monsters.indexOf(monster) * 3 + 1;
            placeMonster(monster, location);
        }
    }

    /**
     * Adds a monster to the map
     * @param monster the monster to add
     * @param nexusIndex the index of the nexus to add the monster to
     * @return true if the monster was successfully added
     */
    public boolean addMonsterToNexus(Monster monster, int nexusIndex){
        int[] location = new int[2];
        location[0] = 0;
        location[1] = nexusIndex * 3 + 1;
        return placeMonster(monster, location);
    }

    /**
     * Places a monster on the map
     * @param monster the monster to place
     * @param location the location to place the monster at
     * @return true if the monster was successfully placed
     */
    private boolean placeMonster(Monster monster, int[] location) {
        if (matrix[location[0]][location[1]].tryAccess(monster)){
            legendLocations.put(monster, location);
            return true;
        } else {
            System.out.println("Failed to place " + monster.name + " at " + Arrays.toString(location));
            return false;
        }
    }

    /**
     * Gets list of heroes and monsters' locations
     * @return the list of heroes and monsters' locations as a string
     */
    private String getLocations(){
        StringBuilder locations = new StringBuilder();
        locations.append(Color.color(Color.bgBlue, "Heroes:")).append("\n");
        for (Legend legend : legendLocations.keySet().stream().filter(legend -> legend instanceof Hero).toArray(Legend[]::new)){
            String appendStr = legend.name + " (" + legend.type.substring(0, legend.type.length() - 1) + ") @ " + Arrays.toString(legendLocations.get(legend)) + "\n";
            locations.append(Color.color(Color.blue, appendStr));
        }
        locations.append("\n").append(Color.color(Color.bgRed, "Monsters:")).append("\n");
        for (Legend legend : legendLocations.keySet().stream().filter(legend -> legend instanceof Monster).toArray(Legend[]::new)){
            String appendStr = legend.name + " (" + legend.type.substring(0, legend.type.length() - 1) + ") @ " + Arrays.toString(legendLocations.get(legend)) + "\n";
            locations.append(Color.color(Color.red, appendStr));
        }
        return locations.toString();
    }

    /**
     * Gets the monster at a location
     * @param location the location to get the monster at
     * @return the monster at the location
     */
    public Monster getMonsterAt(int[] location){
        for (Legend legend : legendLocations.keySet()){
            if (Arrays.equals(legendLocations.get(legend), location) && legend instanceof Monster){
                return (Monster) legend;
            }
        }
        return null;
    }

    /**
     * Gets the hero at a location
     * @param location the location to get the hero at
     * @return the hero at the location
     */
    public Hero getHeroAt(int[] location){
        for (Legend legend : legendLocations.keySet()){
            if (Arrays.equals(legendLocations.get(legend), location) && legend instanceof Hero){
                return (Hero) legend;
            }
        }
        return null;
    }

    /**
     * Checks if a location contains a monster
     * @param location the location to check
     * @return true if the location contains a monster
     */
    public boolean containsMonster(int[] location){
        for (Legend legend : legendLocations.keySet()){
            if (Arrays.equals(legendLocations.get(legend), location) && legend instanceof Monster){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a location contains a hero
     * @param location the location to check
     * @return true if the location contains a hero
     */
    public boolean containsHero(int[] location){
        for (Legend legend : legendLocations.keySet()){
            if (Arrays.equals(legendLocations.get(legend), location) && legend instanceof Hero){
                return true;
            }
        }
        return false;
    }

    /**
     * Method to move a legend
     * @param legend the legend to move
     * @param control the control to move the legend
     * @return true if the legend was successfully moved
     */
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

    /**
     * Place a legend in a new location
     * @param legend the legend to place
     * @param location the location to place the legend at
     * @param newrow the new row to place the legend at
     * @param newcol the new column to place the legend at
     * @return true if the legend was successfully placed
     */
    private boolean placeLegend(Legend legend, int[] location, int newrow, int newcol) {
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

    /**
     * Checks if a location is in the list of possible moves
     * @param possibleMoves the list of possible moves
     * @param ints the location to check
     * @return true if the location is in the list of possible moves
     */
    private boolean containsLocation(ArrayList<int[]> possibleMoves, int[] ints) {
        for (int[] possibleMove : possibleMoves) {
            if (Arrays.equals(possibleMove, ints)) return true;
        }
        return false;
    }

    /**
     * Gets the possible moves for a legend
     * @param legend the legend to get the possible moves for
     * @param location the location of the legend
     * @return the list of possible moves
     */
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

    /**
     * Checks if a location is in the bounds of the map
     * @param location the location to check
     * @return true if the location is in the bounds of the map
     */
    public boolean locationInBounds(int[] location){
        return location[0] >= 0 && location[0] < R && location[1] >= 0 && location[1] < C;
    }

    /**
     * String representation of the map
     * @return the string representation of the map with hero locations for easy understanding
     */
    @Override
    public String toString() {
        return getLocations() + "\n" + super.toString(true);
    }

    /**
     * Teleports a hero to a new location
     * @param legend the hero to teleport
     * @return true if the hero was successfully teleported
     */
    public boolean teleportHero(Hero legend) {
        int[] location = legendLocations.get(legend);
        ArrayList<int[]> possibleTeleports = getPossibleTeleports(legend, location);
        if (possibleTeleports.size() == 0) return false;
        System.out.println("Choose a location to teleport to:");
        int option = GameEngine.getIntOption(possibleTeleports.stream().map(Arrays::toString).toArray(String[]::new));
        int newrow = possibleTeleports.get(option)[0], newcol = possibleTeleports.get(option)[1];
        return placeLegend(legend, location, newrow, newcol);
    }

    /**
     * Gets the possible teleport locations for a hero
     * @param legend the hero to get the possible teleport locations for
     * @param location the location of the hero
     * @return the list of possible teleport locations
     */
    private ArrayList<int[]> getPossibleTeleports(Hero legend, int[] location) {
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
            removeDuplicates(out);
            ensureInDifferentLane(location, out);
        }
        return out;
    }

    /**
     * Make sure that the teleport locations are in a different lane than the hero
     * @param location the location of the hero
     * @param out the list of possible teleport locations after removing invalid options
     */
    private static void ensureInDifferentLane(int[] location, ArrayList<int[]> out) {
        for (int i = 0; i < out.size(); i++) {
            if (out.get(i)[1] / 3 == location[1] / 3) {
                out.remove(i);
                i--;
            }
        }
    }

    /**
     * Removes duplicate locations from the list of possible teleport locations
     * @param out the list of possible teleport locations
     */
    private static void removeDuplicates(ArrayList<int[]> out) {
        if (out.size() > 1) {
            for (int i = 0; i < out.size(); i++) {
                for (int j = i + 1; j < out.size(); j++) {
                    if (Arrays.equals(out.get(i), out.get(j))) {
                        out.remove(j);
                        j--;
                    }
                }
            }
        }
    }

    /**
     * Recalls a hero to their nexus
     * @param hero the hero to recall
     * @return true if the hero was successfully recalled
     */
    public boolean recallHero(Hero hero) {
        int[] homeLocation  = hero.getStartingLocation();
        boolean validPlace = placeLegend(hero, legendLocations.get(hero), homeLocation[0], homeLocation[1]);
        return validPlace || placeLegend(hero, legendLocations.get(hero), homeLocation[0], homeLocation[1] + 1);
    }
}
