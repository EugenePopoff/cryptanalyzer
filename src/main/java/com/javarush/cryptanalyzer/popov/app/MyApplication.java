package com.javarush.cryptanalyzer.popov.app;

import com.javarush.cryptanalyzer.popov.controller.MainController;
import com.javarush.cryptanalyzer.popov.entity.Result;
import com.javarush.cryptanalyzer.popov.exception.FileReadingException;
import com.javarush.cryptanalyzer.popov.repository.FunctionCode;
import com.javarush.cryptanalyzer.popov.services.Function;

import java.io.IOException;

import static com.javarush.cryptanalyzer.popov.constants.FunctionCodeConstants.*;



public class MyApplication {
    private final MainController mainController;

    public MyApplication(MainController mainController) {
        this.mainController = mainController;
    }

    public Result run() throws IOException, FileReadingException {
        String[] parameters = mainController.getView().getParameters();
        String mode = parameters[0];
        Function function = getFunction(mode);
        return function.execute(parameters);
    }

    private Function getFunction(String mode) {
        return switch (mode) {
            case "1" -> FunctionCode.valueOf(ENCODE).getFunction();
            case "2" -> FunctionCode.valueOf(DECODE).getFunction();
            case "3" -> FunctionCode.valueOf(BRUTEFORCE).getFunction();
            default -> throw new IllegalArgumentException("Неподдерживаемый режим: " + mode);
        };
    }

    public void printResult(Result result) {
        mainController.getView().printResult(result);
    }
}

