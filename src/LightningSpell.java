/**
 * LightningSpells reduce target dodge
 */
public class LightningSpell extends Spell {

    /**
     * Constructor for LightningSpell
     * @param name name of the spell
     * @param itemData data of the spell
     */
    public LightningSpell(String name, DataMap<String, String> itemData) {
        super(name, itemData);
        this.type = "Lightning";
    }

    /**
     * Returns the name of the spell effect
     * @return the name of the spell effect
     */
    @Override
    public String getSpellEffectName() {
        return "dodge";
    }
}
