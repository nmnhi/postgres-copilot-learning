package com.learning;

import com.learning.entity.User;
import com.learning.repository.UserRepository;

public class App {

    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        User user = new User("Nguyen Minh A", "a@gmail.com.vn");

        UserRepository repository = new UserRepository();

        repository.save(user);
    }
}
