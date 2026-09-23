package com.learning;

import com.learning.entity.User;
import com.learning.service.UserService;

public class App {

  public static void main(String[] args) {
    UserService service = new UserService();
    //User user = new User(1, "Nguyen Minh A", "ab@gmail.com.vn");
    //service.create(user);

    //List<User> users = service.getAllUsers();
    //users.forEach(System.out::println);

    // User user = new User(
    // 10,
    // "Nguyen Van B",
    // "updated10@gmail.com");

    // repository.update(user);

    // List<User> users1 = repository.findAll();
    // users1.forEach(System.out::println);

    //service.deleteUserById(11);
    //List<User> users1 = service.getAllUsers();
    //users1.forEach(System.out::println);

    User user = service.getUSerById(8);
    System.out.println(user);

    User user1 = service.getUserByEmail("nmnhi@tma.com.vn");
    System.out.println(user1);
  }
}
