package com.javarush.cryptanalyzer.popov.repository;

import com.javarush.cryptanalyzer.popov.services.*;


public enum FunctionCode {
   ENCODE(new Encode()), DECODE(new Decode()), BRUTEFORCE(new BruteForce());

    private Function function;

    FunctionCode(Function function) {
        this.function = function;
    }

    public Function getFunction() {
        return function;
    }
}
