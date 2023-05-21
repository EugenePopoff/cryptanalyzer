package com.javarush.cryptanalyzer.popov.controller;

import com.javarush.cryptanalyzer.popov.view.View;

public class MainController {

    private View view;

    public MainController(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }
}