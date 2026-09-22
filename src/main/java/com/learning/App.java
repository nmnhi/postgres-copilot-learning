package com.learning;

import java.util.List;

import com.learning.entity.User;
import com.learning.repository.UserRepository;

public class App {

    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        UserRepository repository = new UserRepository();
        // User user = new User("Nguyen Minh A", "ab@gmail.com.vn");
        // repository.save(user);

        List<User> users = repository.findAll();
        users.forEach(System.out::println);

        User user = new User(
                9,
                "Nguyen Van B Updated 1",
                "updated@gmail.com");
        repository.update(user);

        List<User> users1 = repository.findAll();
        users1.forEach(System.out::println);
    }
}
