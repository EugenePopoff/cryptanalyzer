package com.javarush.cryptanalyzer.popov.processes;


import com.javarush.cryptanalyzer.popov.constants.TextConstants;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    // Метод для записи зашифрованного контента в файл
    // Принимает название файла (fileName) и контент (content)
    public static void write(String fileName, String content) {
        // Используем try-with-resources для автоматического закрытия BufferedWriter после использования
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            // Записываем контент в файл
            bw.write(content);
            // Выводим сообщение об успешной записи
            //System.out.println(TextConstants.SUCCESSFUL_RECORDING_ENCRYPTED);
        }
        // Обрабатываем исключение IOException, если возникнет ошибка записи
        catch (IOException e) {
            // Выводим сообщение об ошибке записи и передаем сообщение об ошибке
            System.err.println(TextConstants.ERROR_WRITING + e.getMessage());
            e.printStackTrace();
        }
    }
}