package vsdl.wl.data;

public interface DataProvider {
    void queryAccount(String username, String hashedPassword);
    void createAccount(String username, String hashedPassword);
    String getSalt(String username);
    String getHash(String username);
    //todo
}
