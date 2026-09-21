package com.learning.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DbConnection {

	private static final String URL = "jdbc:postgresql://localhost:5432/shop_db";

	private static final String USER = "postgres";

	private static final String PASSWORD = "postgres";

	private DbConnection() {
		throw new UnsupportedOperationException("Utility class");
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}