package com.javarush.cryptanalyzer.popov.services;


import com.javarush.cryptanalyzer.popov.entity.Result;
import com.javarush.cryptanalyzer.popov.exception.FileReadingException;
import com.javarush.cryptanalyzer.popov.processes.FileUtils;
import com.javarush.cryptanalyzer.popov.repository.ResultCode;
import com.javarush.cryptanalyzer.popov.processes.Encrypt;
import com.javarush.cryptanalyzer.popov.processes.WriteToFile;

import java.util.Objects;

import static com.javarush.cryptanalyzer.popov.constants.TextConstantsDesktop.ENCRYPTED_TEXT;
import static com.javarush.cryptanalyzer.popov.constants.TextConstantsDesktop.TEXT_FOR_ENCRYPTION;


public class Encode implements Function {
    @Override
    public Result execute(String[] args) throws FileReadingException {

        String key = args[1];
        String inputFile = args[2];
        String outputFile = args[3];
        String message = FileUtils.readFile(inputFile);
        System.out.println(TEXT_FOR_ENCRYPTION);
        System.out.println(message); // Вывод сообщение с исходным текстом
        String encrypted = Encrypt.encrypt(Objects.requireNonNull(FileUtils.readFile(inputFile)), Integer.parseInt(key));
        System.out.println(ENCRYPTED_TEXT);
        System.out.println(encrypted);
        WriteToFile.write(outputFile, encrypted);

        return new Result(ResultCode.OK);
    }
}