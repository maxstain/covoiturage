package org.example;

import org.example.Controllers.UserController;
import org.example.DAO.User;

public class Main {

    private static final UserController _userController = new UserController();

    public static void main(String[] args) {
        User user = new User(_userController.getSize()+1, "Doe", "John", 25);
        _userController.ajout(user);
        _userController.afficher();
        user.setAge(30);
        _userController.modifier(user);
        _userController.afficher();
        _userController.truncate();
    }
}