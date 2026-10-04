package com.learning.dto;

public class CreateUserRequest {

  private String fullName;
  private String email;

  // Getter

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  // Setter

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "CreateUserRequest{" +
        "fullName='" + fullName + '\'' +
        ", email='" + email + '\'' +
        '}';
  }
}
