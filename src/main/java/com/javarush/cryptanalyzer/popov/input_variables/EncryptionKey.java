package com.javarush.cryptanalyzer.popov.input_variables;

import java.util.Scanner;

import static com.javarush.cryptanalyzer.popov.constants.TextConstants.*;

public class EncryptionKey {
    public static String getEncryptionKey(Scanner scanner, String operationType) {
        String encryptionKey = null;
        while (true) {
            if (operationType.equals("3")) {
                break;
            } else if (operationType.equals("2")) {
                System.out.print(ENTER_KEY_DECRYPT);
            } else {
                System.out.print(ENTER_KEY_PROMPT);
            }
            encryptionKey = scanner.nextLine().trim();
            if (encryptionKey.isEmpty() && !operationType.equals("2")) {

                encryptionKey = String.valueOf((int) (Math.random() * 100000));
                System.out.println(RANDOM_KEY_MSG + encryptionKey);
                break;
            } else if (!encryptionKey.matches("\\d+")) {
                System.out.println(INVALID_KEY_MSG);
            } else {
                break;
            }
        }
        return encryptionKey;
    }
}