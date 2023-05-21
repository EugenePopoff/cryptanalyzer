package com.javarush.cryptanalyzer.popov.processes;


import com.javarush.cryptanalyzer.popov.exception.FileReadingException;

import java.io.*;

public class FileUtils {


    // Метод для чтения содержимого файла по заданному пути
    public static String readFile(String filePath) throws FileReadingException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        boolean fileExists = false;

        while (!fileExists) {
            try {
                br = new BufferedReader(new FileReader(filePath));
                fileExists = true;
            } catch (FileNotFoundException e) {
                throw new FileReadingException("File not found", e);
            }
        }
        try {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new FileReadingException("Error reading file", e);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                throw new FileReadingException("Error closing file reader", e);
            }
        }
        return sb.toString();
    }
}
