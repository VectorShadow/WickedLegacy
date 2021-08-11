package vsdl.wl.character;

import vsdl.wl.wom.WickedObjectModel;

public class PlayerCharacter extends WickedObjectModel {

    private String userName;

    private String characterName;

    private CharacterSheet characterSheet;

    PlayerCharacter() {}

    public static PlayerCharacterBuilder builder() {
        return new PlayerCharacterBuilder();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public CharacterSheet getCharacterSheet() {
        return characterSheet;
    }

    public void setCharacterSheet(CharacterSheet characterSheet) {
        this.characterSheet = characterSheet;
    }
}
