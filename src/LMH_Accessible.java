/**
 * Interface for objects that can be accessed by heroes.
 */
public interface LMH_Accessible extends Accessible {
    /**
     * Method to hold heroes in the space.
     * @param heroes List of heroes to be held.
     */
    void holdHeroes(DataList<Hero> heroes);

    /**
     * Method to remove heroes from the space.
     */
    void leaveHeroes();

}
