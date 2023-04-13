/**
 * FireSpells reduce target defense
 */
public class FireSpell extends Spell {
    public FireSpell(String name, DataMap<String, String> itemData) {
        super(name, itemData);
        this.type = "Fire";
    }

    @Override
    public String getSpellEffectName() {
        return "defense";
    }
}
