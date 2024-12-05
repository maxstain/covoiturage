package org.example.Utils;

public class PasswordHash {
    public static String hashPassword(String mdp) {
        return mdp.hashCode() + "";
    }

    public static boolean checkPassword(String mdp, String hashedMdp) {
        return hashedMdp.equals(hashPassword(mdp));
    }
}
