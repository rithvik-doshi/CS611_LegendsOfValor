public interface LOV_Accessible extends Accessible{
    /**
     * Holds a legend in the space
     *
     * @param legend to hold
     * @return true if the legend was held, false if the space is already occupied
     */
    boolean holdLegend(Legend legend);

    /**
     * Removes a legend from the space
     * @param legend to remove
     */
    void removeLegend(Legend legend);

}
