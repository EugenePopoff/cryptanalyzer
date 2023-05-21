package com.javarush.cryptanalyzer.popov.processes;

import com.javarush.cryptanalyzer.popov.constants.CryptoAlphabet;

import static com.javarush.cryptanalyzer.popov.constants.TextConstants.MESSAGE_CANNOT_BE_NULL;


public class Encrypt {
    public static String encrypt(String message, int key) {
        // Проверка, что сообщение не равно null
        if (message == null) {
            throw new IllegalArgumentException(MESSAGE_CANNOT_BE_NULL);
        }

        // Создание пустой строки для хранения зашифрованного сообщения
        StringBuilder encrypted = new StringBuilder();

        // Начало цикла for, который перебирает каждый символ в исходном сообщении
        for (int i = 0; i < message.length(); i++) {
            // Получение символа из исходного сообщения с помощью метода charAt()
            char c = message.charAt(i);

            // Проверка, является ли символ буквой алфавита, которую нужно зашифровать
            int index = CryptoAlphabet.ALPHABET.indexOf(c);
            if (index == -1) {
                // Символ не найден в алфавите, добавляем его в зашифрованную строку без изменений
                encrypted.append(c);
            } else {
                // Сдвигаем символ на key позиций в алфавите
                int shiftedIndex = (index + key) % CryptoAlphabet.ALPHABET.length();
                char shiftedChar = CryptoAlphabet.ALPHABET.charAt(shiftedIndex);

                // Добавляем зашифрованный символ к строке encrypted
                encrypted.append(shiftedChar);
            }
        }
        // Возврат строки с зашифрованным сообщением
        return encrypted.toString();
    }
}