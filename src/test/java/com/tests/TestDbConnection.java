package com.tests;

import database_connection.manager.DBManager;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class TestDbConnection {
    @Test
    public void testDbConnection() throws SQLException {
        Assert.assertFalse(DBManager.createDbConnection().isClosed());
    }

}
