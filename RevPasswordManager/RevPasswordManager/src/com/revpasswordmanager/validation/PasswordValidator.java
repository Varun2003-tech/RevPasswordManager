package com.revpasswordmanager.validation;

public class PasswordValidator {

    public static boolean isStrong(String password) {

        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else if ("@#$%!".indexOf(ch) >= 0) hasSpecial = true;
            else if (Character.isWhitespace(ch)) return false;
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }
}
