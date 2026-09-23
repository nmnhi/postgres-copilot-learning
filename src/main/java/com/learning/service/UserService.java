package com.learning.service;

import com.learning.entity.User;
import com.learning.repository.UserRepository;
import java.util.List;
import java.util.Optional;

public class UserService {

  private final UserRepository repository = new UserRepository();

  public void create(User user) {
    if (!user.getEmail().endsWith("@gmail.com")) {
      throw new RuntimeException("Invalid email");
    }
    repository.save(user);
  }

  public List<User> getAllUsers() {
    return repository.findAll();
  }

  public void updateUser(User user) {
    repository.update(user);
  }

  public void deleteUserById(int id) {
    repository.deleteById(id);
  }

  public Optional<User> getUSerById(int id) {
    return repository.findById(id);
  }

  public Optional<User> getUserByEmail(String email) {
    return repository.findByEmail(email);
  }
}
