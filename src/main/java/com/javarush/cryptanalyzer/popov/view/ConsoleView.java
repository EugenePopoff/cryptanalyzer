package com.javarush.cryptanalyzer.popov.view;


import com.javarush.cryptanalyzer.popov.entity.Result;
import com.javarush.cryptanalyzer.popov.input_variables.EncryptionKey;
import com.javarush.cryptanalyzer.popov.input_variables.InputFileName;
import com.javarush.cryptanalyzer.popov.input_variables.OperationType;
import com.javarush.cryptanalyzer.popov.input_variables.OutputFileName;

import java.util.Scanner;

import static com.javarush.cryptanalyzer.popov.constants.ApplicationCompletionConstants.EXCEPTION;
import static com.javarush.cryptanalyzer.popov.constants.ApplicationCompletionConstants.SUCCESS;
import static com.javarush.cryptanalyzer.popov.constants.TextConstants.CONTINUE_MESSAGE;


public class ConsoleView implements View {
    private final Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String[] getParameters() {
        String operationType = OperationType.getOperationType(scanner);
        String encryptionKey = EncryptionKey.getEncryptionKey(scanner, operationType);
        String inputFile = InputFileName.getInputFileName(scanner, operationType);
        String outputFile = OutputFileName.getOutputFileName(scanner, operationType);
        return new String[]{operationType, encryptionKey, inputFile, outputFile};
    }

    @Override
    public boolean getContinuation() {
        System.out.print(CONTINUE_MESSAGE);
        String input = scanner.nextLine().trim().toLowerCase();
        return input.startsWith("y");
    }

    @Override
    public void printResult(Result result) {
        switch (result.getResultCode()) {
            case OK -> System.out.println(SUCCESS);
            case ERROR -> System.out.println(EXCEPTION + result.getApplicationException().getMessage());
        }
    }
}