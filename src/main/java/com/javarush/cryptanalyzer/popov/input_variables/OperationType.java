package com.javarush.cryptanalyzer.popov.input_variables;

import java.util.Scanner;

import static com.javarush.cryptanalyzer.popov.constants.TextConstants.ENTER_OPERATION_TYPE;
import static com.javarush.cryptanalyzer.popov.constants.TextConstants.INVALID_OPERATION_TYPE;

public class OperationType {
    public static String getOperationType(Scanner scanner) {
        while (true) {
            // Запросить у пользователя тип операции
            System.out.print(ENTER_OPERATION_TYPE);
            String operationType = scanner.nextLine().trim().toLowerCase();
            if (operationType.equals("1")
                    || operationType.equals("2")
                    || operationType.equals("3")) {
                return operationType;
            }
            System.out.println(INVALID_OPERATION_TYPE);
        }
    }
}