package com.javarush.cryptanalyzer.popov.view;


import com.javarush.cryptanalyzer.popov.entity.Result;

public interface View {
    String[] getParameters();

    void printResult(Result result);

    boolean getContinuation();
}