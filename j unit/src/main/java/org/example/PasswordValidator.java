package com.example;

public class PasswordValidator {
    public boolean validate(String password) {
        if (password.length() < 8) {
            return false;
        }
        if (!password.chars().anyMatch(Character::isUpperCase)) {
            return false;
        }
        if (!password.chars().anyMatch(Character::isDigit)) {
            return false;
        }
        return true;
    }
}

