package com.javarush.cryptanalyzer.popov.entity;

import com.javarush.cryptanalyzer.popov.exception.ApplicationException;
import com.javarush.cryptanalyzer.popov.repository.ResultCode;

public class Result {
    private final ResultCode resultCode;

    private ApplicationException applicationException;

    public Result(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public ApplicationException getApplicationException() {
        return applicationException;
    }
}