package vsdl.wl.character;

import vsdl.wl.wom.WOMBuilder;

public class CharacterSheetBuilder extends WOMBuilder {

    private final CharacterSheet characterSheet;

    CharacterSheetBuilder() {
        characterSheet = new CharacterSheet();
    }

    @Override
    public CharacterSheet build() {
        return characterSheet;
    }
}
