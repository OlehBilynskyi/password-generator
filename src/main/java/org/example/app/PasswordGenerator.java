package org.example.app;
//Імпортуємо клас для генерації випадкових чисел

import java.security.SecureRandom;

public class PasswordGenerator {

    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    // Верхній регістр (генерується з нижнього)
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();

    private static final String NUMBER = "0123456789";

    private static final String OTHER_CHAR = "!@#$%^&*()_+-=[]?";
    // Об'єднуємо все в один рядок
    private static final String PASSWORD_ALLOW_BASE = CHAR_LOWER + CHAR_UPPER + NUMBER + OTHER_CHAR;
    // SecureRandom забезпечує кращу випадковість, ніж Math.random
    private static final SecureRandom RANDOM = new SecureRandom();

    // Метод, який генерує пароль певної довжини
    public static String generatePassword(int length) {
        // Якщо довжина < 1, кидаємо помилку
        if (length < 1) {
            throw new IllegalArgumentException("Довжина поля має бути більша 0");
        }
        // Створюємо StringBuilder для збереження символів пароля
        StringBuilder password = new StringBuilder(length);
// Додаємо по одному випадковому символу
        for (int i = 0; i < length; i++) {
            int randomCharIndex = RANDOM.nextInt(PASSWORD_ALLOW_BASE.length());
            char randomChar = PASSWORD_ALLOW_BASE.charAt(randomCharIndex);
            password.append(randomChar);
        }
        // Повертаємо згенерований пароль
        return password.toString();
    }
    
}
