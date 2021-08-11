package vsdl.wl.character;

import vsdl.wl.wom.WickedObjectModel;

/**
 * Defines the stats, abilities, temporary conditions, and all other relevant data for a character(player or NPC).
 */
public class CharacterSheet extends WickedObjectModel {

    //builder constructor - set all fields with builder methods from DB
    CharacterSheet() {}

    //archetype constructor - set all fields based on archetype
    public CharacterSheet(CharacterArchetype characterArchetype) {
        //todo
    }

    public static CharacterSheetBuilder builder() {
        return new CharacterSheetBuilder();
    }
}
