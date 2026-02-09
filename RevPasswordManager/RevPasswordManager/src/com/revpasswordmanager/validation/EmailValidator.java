package com.revpasswordmanager.validation;

public class EmailValidator {

    // Simple & accepted email regex for projects
    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public static boolean isValid(String email) {
        if (email == null) return false;
        return email.matches(EMAIL_REGEX);
    }
}
