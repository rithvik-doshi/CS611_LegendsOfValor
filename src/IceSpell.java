/**
 * IceSpells reduce target damage
 */
public class IceSpell extends Spell{

    /**
     * Constructor for IceSpell
     * @param name name of the spell
     * @param itemData data of the spell
     */
    public IceSpell(String name, DataMap<String, String> itemData) {
        super(name, itemData);
        this.type = "Ice";
    }

    /**
     * Returns the name of the spell effect
     * @return the name of the spell effect
     */
    @Override
    public String getSpellEffectName() {
        return "damage";
    }
}
