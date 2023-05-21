package com.javarush.cryptanalyzer.popov.processes;


public class TextUtils {
    // метод подсчитывает количество запятых и пробелов между словами на кириллице в заданном тексте
    public static int countLetterCommaSpace(String text) {
        int count = 0;
        // проходим по всем символам текста, кроме двух последних, так как мы проверяем два символа за раз
        for (int i = 0; i < text.length() - 2; i++) {
            // проверяем, являются ли текущий символ и следующий символ запятой и пробелом соответственно
            if (text.charAt(i) == ',' && text.charAt(i + 1) == ' ') {
                // получаем предыдущий символ, чтобы проверить, является ли он кириллической буквой
                char prevChar = text.charAt(i - 1);
                // проверяем, принадлежит ли предыдущий символ к блоку символов Unicode кириллицы
                if (Character.UnicodeBlock.of(prevChar) == Character.UnicodeBlock.CYRILLIC) {
                    // если да, то увеличиваем счетчик
                    count++;
                }
            }
        }
        // возвращаем количество найденных совпадений
        return count;
    }
}