package com.javarush.cryptanalyzer.popov.services;

import com.javarush.cryptanalyzer.popov.entity.Result;
import com.javarush.cryptanalyzer.popov.exception.FileReadingException;

import java.io.IOException;

public interface Function {
    Result execute(String[] parameters) throws IOException, FileReadingException;
}