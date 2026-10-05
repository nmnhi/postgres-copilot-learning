package com.learning.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.learning.entity.User;
import com.learning.exception.EmailAlreadyExistsException;
import com.learning.exception.InvalidEmailException;
import com.learning.exception.UserNotFoundException;
import com.learning.repository.UserRepository;

public class UserService {

  private static final Logger logger = LoggerFactory.getLogger(UserService.class);
  private final UserRepository repository = new UserRepository();

  public void create(User user) {
    logger.info("Create user with {}", user.getEmail());

    if (user.getEmail() == null || user.getEmail().isBlank()) {
      throw new RuntimeException("Email is required");
    }

    if (!user.getEmail().endsWith("@gmail.com")) {
      throw new InvalidEmailException(
          "Email " + user.getEmail() + " is invalid, the email should end with @gmail.com");
    }

    Optional<User> existingUser = repository.findByEmail(user.getEmail());
    if (existingUser.isPresent()) {
      throw new EmailAlreadyExistsException("Email " + user.getEmail() + " already exist");
    }

    repository.save(user);
    logger.info("Create new user successfully");
  }

  public List<User> getAllUsers() {
    return repository.findAll();
  }

  public void updateUser(User user) {
    Optional<User> existingUser = repository.findById(user.getId());

    if (existingUser.isEmpty()) {
      logger.error("User not found with id {}", user.getId());
      throw new UserNotFoundException("User with id " + user.getId() + " not found");
    }

    repository.update(user);
    logger.info("Update user with id {} successfully", user.getId());
  }

  public void deleteUserById(int id) {
    Optional<User> user = repository.findById(id);

    if (user.isEmpty()) {
      logger.error("User not found with id {}", id);
      throw new UserNotFoundException("User with id " + id + " not found");
    }

    repository.deleteById(id);
    logger.info("Delete user with userId {} successfully", id);
  }

  public Optional<User> getUSerById(int id) {
    return repository.findById(id);
  }

  public Optional<User> getUserByEmail(String email) {
    return repository.findByEmail(email);
  }
}
