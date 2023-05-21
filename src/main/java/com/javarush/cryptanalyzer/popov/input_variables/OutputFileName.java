package com.javarush.cryptanalyzer.popov.input_variables;

import java.util.Scanner;

import static com.javarush.cryptanalyzer.popov.constants.TextConstants.*;

public class OutputFileName {
    public static String getOutputFileName(Scanner scanner, String operationType) {
        String outputFileDefault = DEFAULT_OUTPUT_FILE_ENCRYPTED;
        while (!operationType.equals("3")) {
            if (operationType.equals("2")) {
                outputFileDefault = DEFAULT_OUTPUT_FILE_DECRYPTED;
            }
            System.out.printf(OUTPUT_FILE_PROMPT, outputFileDefault);
            String outputFile = scanner.nextLine().trim();
            if (outputFile.isEmpty()) {
                outputFile = outputFileDefault;
            }
            return outputFile;
        }
        return outputFileDefault;
    }
}