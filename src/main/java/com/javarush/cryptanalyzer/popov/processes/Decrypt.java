package com.javarush.cryptanalyzer.popov.processes;

import com.javarush.cryptanalyzer.popov.constants.CryptoAlphabet;

import static com.javarush.cryptanalyzer.popov.constants.TextConstants.MESSAGE_CANNOT_BE_NULL;


public class Decrypt {
    public static String decrypt(String encryptedMessage, int key) {
        if (encryptedMessage == null) {
            throw new IllegalArgumentException(MESSAGE_CANNOT_BE_NULL);
        }
        // Создание пустой строки для хранения расшифрованного сообщения
        StringBuilder decryptedMessage = new StringBuilder();

        // Начало цикла for, который перебирает каждый символ в зашифрованном сообщении
        for (int i = 0; i < encryptedMessage.length(); i++) {
            // Получение символа из зашифрованного сообщения с помощью метода charAt()
            char character = encryptedMessage.charAt(i);

            // Проверка, является ли символ буквой алфавита, который нужно расшифровать
            if (CryptoAlphabet.ALPHABET.indexOf(character) != -1) {
                // Получение текущего индекса символа в алфавите
                int currentIndex = CryptoAlphabet.ALPHABET.indexOf(character);

                // Вычисление нового индекса символа после расшифровки
                int newIndex = (currentIndex - key) % CryptoAlphabet.ALPHABET.length();

                // Проверка, необходимо ли выполнить обход алфавита при расшифровке
                if (newIndex < 0) {
                    newIndex += CryptoAlphabet.ALPHABET.length();
                }

                // Получение расшифрованного символа и добавление его к строке decryptedMessage
                decryptedMessage.append(CryptoAlphabet.ALPHABET.charAt(newIndex));
            } else {
                // Добавление нерасшифрованного символа к строке decryptedMessage, если символ не является буквой алфавита
                decryptedMessage.append(character);
            }
        }
        // Возврат строки с расшифрованным сообщением
        return decryptedMessage.toString();
    }
}