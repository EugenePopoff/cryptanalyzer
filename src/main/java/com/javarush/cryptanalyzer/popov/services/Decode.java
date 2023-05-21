package com.javarush.cryptanalyzer.popov.services;

import com.javarush.cryptanalyzer.popov.entity.Result;
import com.javarush.cryptanalyzer.popov.exception.FileReadingException;
import com.javarush.cryptanalyzer.popov.processes.FileUtils;
import com.javarush.cryptanalyzer.popov.processes.Decrypt;
import com.javarush.cryptanalyzer.popov.processes.WriteToFile;
import com.javarush.cryptanalyzer.popov.repository.ResultCode;

import java.util.Objects;

import static com.javarush.cryptanalyzer.popov.constants.TextConstantsDesktop.DECRYPTED_TEXT;
import static com.javarush.cryptanalyzer.popov.constants.TextConstantsDesktop.TEXT_FOR_DECRYPTION;

public class Decode implements Function {

    @Override
    public Result execute(String[] args) throws FileReadingException {

        String key = args[1];
        String inputFile = args[2];
        String outputFile = args[3];
        String message = FileUtils.readFile(inputFile);
        System.out.println(TEXT_FOR_DECRYPTION);
        System.out.println(message); // Вывод сообщение с исходным текстом
        String decrypted = Decrypt.decrypt(Objects.requireNonNull(message), Integer.parseInt(key));
        System.out.println(DECRYPTED_TEXT);
        System.out.println(decrypted);

        WriteToFile.write(outputFile, decrypted);

        return new Result(ResultCode.OK);
    }
}