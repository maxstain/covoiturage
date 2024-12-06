package org.example;

import org.example.Controllers.UserController;
import org.example.DAO.User;
import org.example.Utils.PasswordHash;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Main {

    private static final UserController _userController = new UserController();

    public static void main(String[] args) {
        User user = null;
        try {
            user = new User(_userController.getSize() + 1,
                    "Chabchoub",
                    "Firas",
                    25,
                    "firaschabchoub@gmail.com",
                    PasswordHash.hashPassword("123456"),
                    "Admin"
            );
            _userController.truncate();
            _userController.ajout(user);
            _userController.afficher();
            user.setAge(30);
            _userController.modifier(user);
            _userController.afficher();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            System.out.println(e.getMessage());
        }
    }
}