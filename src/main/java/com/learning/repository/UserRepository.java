package com.learning.repository;

import com.learning.entity.User;
import com.learning.util.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

  @SuppressWarnings("CallToPrintStackTrace")
  public List<User> findAll() {
    List<User> users = new ArrayList<>();

    String sql = """
        SELECT id,
        	full_name,
        	email
        FROM users;
        """;

    try (Connection connection = DbConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery()) {
      while (rs.next()) {
        User user = new User();

        user.setId(rs.getInt("id"));
        user.setFullName(rs.getString("full_name"));
        user.setEmail(rs.getString("email"));

        users.add(user);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return users;
  }

  @SuppressWarnings("CallToPrintStackTrace")
  public void update(User user) {
    String sql = """
        UPDATE users
        SET full_name = ?,
        		email = ?
        WHERE id = ?
        """;

    try (Connection connection = DbConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setString(1, user.getFullName());
      statement.setString(2, user.getEmail());
      statement.setInt(3, user.getId());

      int rows = statement.executeUpdate();
      System.out.println(
          rows + " row updated");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @SuppressWarnings("CallToPrintStackTrace")
  public void deleteById(int id) {
    String sql = """
        DELETE FROM users
        WHERE id = ?
        """;

    try (Connection connection = DbConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setInt(1, id);

      int rows = statement.executeUpdate();
      System.out.println(rows + " row deleted");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @SuppressWarnings("CallToPrintStackTrace")
  public Optional<User> findById(int id) {
    String sql = """
        SELECT id, full_name, email
        FROM users
        WHERE id = ?
        """;

    try (Connection connection = DbConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)
    ) {
      statement.setInt(1, id);
      ResultSet result = statement.executeQuery();

      if (result.next()) {
        User user = new User();

        user.setId(result.getInt("id"));
        user.setFullName(result.getString("full_name"));
        user.setEmail(result.getString("email"));

        return Optional.of(user);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return Optional.empty();
  }

  @SuppressWarnings("CallToPrintStackTrace")
  public Optional<User> findByEmail(String email) {
    String sql = """
        SELECT id, full_name, email
        FROM users
        WHERE email = ?
        """;

    try (Connection connection = DbConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)
    ) {
      statement.setString(1, email);

      ResultSet res = statement.executeQuery();

      if (res.next()) {
        User user = new User();
        user.setId(res.getInt("id"));
        user.setFullName(res.getString("full_name"));
        user.setEmail(res.getString("email"));

        return Optional.of(user);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return Optional.empty();
  }
}
