/**
 * A space that cannot be accessed by anyone.
 */
public class Inaccessible extends Space{

    /**
     * Creates a new inaccessible space.
     */
    public Inaccessible(){
        super('X');
    }

    /**
     * Returns false, as this space cannot be accessed.
     * @param heroes The heroes to check.
     * @return False.
     */
    @Override
    public boolean tryAccess(DataList<Hero> heroes) {
        return false;
    }

    /**
     * Returns false, as this space cannot be accessed.
     * @param legend The legend to check.
     * @return False.
     */
    @Override
    public boolean tryAccess(Legend legend) {
        return false;
    }
}
