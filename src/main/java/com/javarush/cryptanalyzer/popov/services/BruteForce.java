package com.javarush.cryptanalyzer.popov.services;

import com.javarush.cryptanalyzer.popov.entity.Result;
import com.javarush.cryptanalyzer.popov.exception.FileReadingException;
import com.javarush.cryptanalyzer.popov.processes.*;
import com.javarush.cryptanalyzer.popov.repository.ResultCode;

import java.util.Objects;

import static com.javarush.cryptanalyzer.popov.constants.TextConstantsDesktop.DECRYPTED_TEXT;
import static com.javarush.cryptanalyzer.popov.constants.TextConstantsDesktop.TEXT_FOR_DECRYPTION;


public class BruteForce implements Function {
    @Override
    public Result execute(String[] args) throws FileReadingException {

        String inputFile = args[2];
        String outputFile = args[3];
        String message = FileUtils.readFile(inputFile);
        System.out.println(TEXT_FOR_DECRYPTION);
        System.out.println(message); // Вывод сообщение с исходным текстом
        //String bruteForce = String.valueOf(BrForce.bruteforce(message));
        int bruteForceKey = BrForce.bruteforce(message);
        String decrypted = Decrypt.decrypt(Objects.requireNonNull(FileUtils.readFile(inputFile)), bruteForceKey);
        System.out.println(DECRYPTED_TEXT + decrypted);
        WriteToFile.write(outputFile, decrypted);

        return new Result(ResultCode.OK);
    }
}