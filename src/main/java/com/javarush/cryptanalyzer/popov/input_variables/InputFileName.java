package com.javarush.cryptanalyzer.popov.input_variables;

import java.io.File;
import java.util.Scanner;

import static com.javarush.cryptanalyzer.popov.constants.TextConstants.*;

public class InputFileName {
    public static String getInputFileName(Scanner scanner, String operationType) {
        String inputFileDefault = INPUT_FILE_DEFAULT;
        if (operationType.equals("2")) {
            inputFileDefault = ENCODED_FILE_DEFAULT;
        } else if (operationType.equals("3")) {
            inputFileDefault = "encoded.txt";
        }
        System.out.printf(INPUT_FILE_PROMPT_FORMAT, inputFileDefault);
        String inputFile = scanner.nextLine().trim();
        if (inputFile.isEmpty()) {
            inputFile = inputFileDefault;
        } else {
            File file = new File(inputFile);
            while (!file.exists() || file.isDirectory()) {
                if (inputFile.isEmpty()) {
                    inputFile = inputFileDefault;
                    break;
                }
                System.out.printf(INVALID_FILE_PROMPT_FORMAT, inputFile);
                inputFile = scanner.nextLine().trim();
                file = new File(inputFile);
            }
        }
        return inputFile;
    }
}