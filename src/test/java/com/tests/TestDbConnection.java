package com.tests;

import database_connection.Connect;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class TestDbConnection {
    @Test
    public void testDbConnection() throws SQLException {
        Assert.assertFalse(Connect.createDbConnection().isClosed());
    }

}
