package vsdl.wl.wom;

//todo - Use this to generate proper queries from server rather than doing inappropriate work in db
//todo - Escalate root creation to Server as well, and remove security dependencies from db
public class UserLogonWOM extends WickedObjectModel {
    private final String USERNAME;
    private final String SALT;
    private final String HASHED_PASSWORD;

    public UserLogonWOM(String username, String salt, String hashedPassword) {
        USERNAME= username;
        SALT = salt;
        HASHED_PASSWORD = hashedPassword;
    }

    public String getUsername() {
        return USERNAME;
    }

    public String getSalt() {
        return SALT;
    }

    public String getHashedPassword() {
        return HASHED_PASSWORD;
    }
}
