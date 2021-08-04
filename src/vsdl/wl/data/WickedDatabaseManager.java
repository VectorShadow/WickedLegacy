package vsdl.wl.data;

import vsdl.wrepo.manager.AbstractDatabaseManager;

public class WickedDatabaseManager extends AbstractDatabaseManager {

    private static final String NODE = "0.0.0.0";
    private static final int PORT = 9042;

    @Override
    protected String getNode() {
        return NODE;
    }

    @Override
    protected int getPort() {
        return PORT;
    }

    public void startup() {
        super.startup();
        query(Data.CREATE_KEYSPACE_USER);
        query(Data.CREATE_TABLE_USER_LOGON);
        //todo - create tables
        //todo - other startup?
    }
}
