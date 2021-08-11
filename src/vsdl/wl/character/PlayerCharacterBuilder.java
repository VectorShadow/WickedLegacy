package vsdl.wl.character;

import vsdl.wl.wom.WOMBuilder;

public class PlayerCharacterBuilder extends WOMBuilder {
    private final PlayerCharacter playerCharacter;

    PlayerCharacterBuilder() {
        playerCharacter = new PlayerCharacter();
        playerCharacter.setUserName("");
        playerCharacter.setCharacterName("");
        playerCharacter.setCharacterSheet(new CharacterSheet());
        //todo - all defaults here
    }

    public PlayerCharacterBuilder setUserName(String userName) {
        playerCharacter.setUserName(userName);
        return this;
    }

    public PlayerCharacterBuilder setCharacterName(String characterName) {
        playerCharacter.setCharacterName(characterName);
        return this;
    }

    public PlayerCharacterBuilder setCharacterSheet(CharacterSheet characterSheet) {
        playerCharacter.setCharacterSheet(characterSheet);
        return this;
    }

    @Override
    public PlayerCharacter build() {
        return playerCharacter;
    }
}
