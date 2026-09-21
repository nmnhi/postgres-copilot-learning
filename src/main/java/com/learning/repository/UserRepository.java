package com.learning.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.learning.entity.User;
import com.learning.util.DbConnection;

public class UserRepository {
	@SuppressWarnings("CallToPrintStackTrace")
	public void save(User user) {
		String sql = """
				INSERT INTO users(full_name, email)
				VALUES(?, ?)
				""";

		try (
				Connection connection = DbConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setString(1, user.getFullName());
			statement.setString(2, user.getEmail());

			int rows = statement.executeUpdate();

			System.out.println(rows + " row inserted");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
