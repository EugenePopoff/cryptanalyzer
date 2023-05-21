package com.javarush.cryptanalyzer.popov.processes;


import static com.javarush.cryptanalyzer.popov.constants.TextConstants.CRACKED_MESSAGE;

public class BrForce {
    public static int bruteforce(String message) {
        String decrypted = "";
        int maxCount = 0;
        int maxKey = 0;
        System.out.println(CRACKED_MESSAGE);
        for (int key = 1; key <= 100; key++) {
            decrypted = Decrypt.decrypt(message, key);
            int count = TextUtils.countLetterCommaSpace(decrypted);
            //System.out.println("Ключ " + key + ": комбинация из буквы, запятой и пробела встречается " + count + " раз(а)");
            if (count > maxCount) {
                maxCount = count;
                maxKey = key;
            }
        }
        //System.out.println("Максимальное количество комбинаций из буквы, запятой и пробела: " + maxCount);
        System.out.println("Key number: " + maxKey);
        return maxKey;
    }
}