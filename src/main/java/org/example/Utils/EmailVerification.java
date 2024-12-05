package org.example.Utils;

public class EmailVerification {

    public static boolean isValid(String email) {
        return email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
    }
}
