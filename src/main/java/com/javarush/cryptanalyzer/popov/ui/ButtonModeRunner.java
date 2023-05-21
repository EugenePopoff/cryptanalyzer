package com.javarush.cryptanalyzer.popov.ui;

import com.javarush.cryptanalyzer.popov.exception.FileReadingException;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;


public class ButtonModeRunner {
    public static void runButtonMode(Stage primaryStage) throws IOException, FileReadingException {

        AnchorPane root = new AnchorPane();
        AnchorPane innerPane1 = new AnchorPane();
        innerPane1.setPrefHeight(398.0);
        innerPane1.setPrefWidth(399.0);
        AnchorPane.setBottomAnchor(innerPane1, 0.0);
        AnchorPane.setLeftAnchor(innerPane1, 0.0);
        AnchorPane.setRightAnchor(innerPane1, 260.0);
        AnchorPane.setTopAnchor(innerPane1, 20.0);

        TextArea textArea = new TextArea();
        textArea.setLayoutX(24.0);
        textArea.setLayoutY(4.0);
        textArea.setPrefHeight(200.0);
        textArea.setPrefWidth(200.0);
        textArea.setFont(new Font(15.0));
        AnchorPane.setBottomAnchor(textArea, 30.0);
        AnchorPane.setLeftAnchor(textArea, 10.0);
        AnchorPane.setRightAnchor(textArea, 20.0);
        AnchorPane.setTopAnchor(textArea, 5.0);
        innerPane1.getChildren().add(textArea);

        AnchorPane innerPane2 = new AnchorPane();
        innerPane2.setLayoutX(340.0);
        innerPane2.setLayoutY(15.0);
        innerPane2.setPrefHeight(380.0);
        innerPane2.setPrefWidth(243.0);
        AnchorPane.setBottomAnchor(innerPane2, 5.0);
        AnchorPane.setRightAnchor(innerPane2, 17.0);
        AnchorPane.setTopAnchor(innerPane2, 15.0);

        CheckBox checkBox1 = new CheckBox();
        checkBox1.setLayoutX(9.0);
        checkBox1.setLayoutY(22.0);
        checkBox1.setMnemonicParsing(false);
        checkBox1.setText("Зашифровать");
        checkBox1.setFont(new Font(15.0));
        checkBox1.setSelected(false); // Установка флага selected в true
        innerPane2.getChildren().add(checkBox1);
        checkBox1.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("Выбран режим шифрования");
            }
        });

        CheckBox checkBox2 = new CheckBox();
        checkBox2.setLayoutX(9.0);
        checkBox2.setLayoutY(55.0);
        checkBox2.setMnemonicParsing(false);
        checkBox2.setText("Разшифровать");
        checkBox2.setFont(new Font(15.0));
        checkBox2.setSelected(false); // Установка флага selected в true
        innerPane2.getChildren().add(checkBox2);
        checkBox2.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("Выбран режим расшифрования");
            }
        });

        CheckBox checkBox3 = new CheckBox();
        checkBox3.setLayoutX(9.0);
        checkBox3.setLayoutY(88.0);
        checkBox3.setMnemonicParsing(false);
        checkBox3.setText("Brute Force");
        checkBox3.setFont(new Font(15.0));
        checkBox3.setSelected(false); // Установка флага selected в true
        innerPane2.getChildren().add(checkBox3);
        checkBox3.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("Выбран режим Brute Force");
            }
        });

        TextField keyTextField = new TextField();
        keyTextField.setLayoutX(6.0);
        keyTextField.setLayoutY(123.0);
        keyTextField.setPrefHeight(26.0);
        keyTextField.setPrefWidth(147.0);
        keyTextField.setPromptText("input key");
        keyTextField.setFont(Font.font("Arial Bold", 14.0));
        innerPane2.getChildren().add(keyTextField);


        TextField inputFileTextField = new TextField();
        inputFileTextField.setLayoutX(6.0);
        inputFileTextField.setLayoutY(156.0);
        inputFileTextField.setPrefHeight(29.0);
        inputFileTextField.setPrefWidth(147.0);
        inputFileTextField.setPromptText("input name file ");
        inputFileTextField.setFont(Font.font("Arial Bold", 12.0));
        innerPane2.getChildren().add(inputFileTextField);


        CheckBox defaultInputNameCheckBox = new CheckBox();
        defaultInputNameCheckBox.setLayoutX(156.0);
        defaultInputNameCheckBox.setLayoutY(157.0);
        defaultInputNameCheckBox.setMnemonicParsing(false);
        defaultInputNameCheckBox.setPrefHeight(26.0);
        defaultInputNameCheckBox.setPrefWidth(86.0);
        defaultInputNameCheckBox.setText("Default name");
        defaultInputNameCheckBox.setFont(new Font(10.0));
        defaultInputNameCheckBox.setSelected(false); // Установка флага selected в true
        AnchorPane.setRightAnchor(defaultInputNameCheckBox, 0.0);
        innerPane2.getChildren().add(defaultInputNameCheckBox);
        defaultInputNameCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                // Checkbox is selected
                String defaultInputName = "default_file_name.txt"; // Set your default input file name here
                inputFileTextField.setText(defaultInputName);
                inputFileTextField.setDisable(true);
            } else {
                // Checkbox is deselected
                inputFileTextField.setText("");
                inputFileTextField.setDisable(false);
            }
        });

        CheckBox defaultKeyCheckBox = new CheckBox();
        defaultKeyCheckBox.setLayoutX(157.0);
        defaultKeyCheckBox.setLayoutY(121.0);
        defaultKeyCheckBox.setMnemonicParsing(false);
        defaultKeyCheckBox.setPrefHeight(26.0);
        defaultKeyCheckBox.setPrefWidth(86.0);
        defaultKeyCheckBox.setText("Default key");
        defaultKeyCheckBox.setFont(new Font(10.0));
        defaultKeyCheckBox.setSelected(false); // Установка флага selected в true
        AnchorPane.setRightAnchor(defaultKeyCheckBox, 0.0);
        innerPane2.getChildren().add(defaultKeyCheckBox);
        defaultKeyCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                // Checkbox is selected
                String defaultInputName = "generation mode"; // Set your default input file name here
                keyTextField.setText(defaultInputName);
                keyTextField.setDisable(true);
            } else {
                // Checkbox is deselected
                keyTextField.setText("");
                keyTextField.setDisable(false);
            }
        });

        TextField outputFileTextField = new TextField();
        outputFileTextField.setLayoutX(6.0);
        outputFileTextField.setLayoutY(188.0);
        outputFileTextField.setPrefHeight(29.0);
        outputFileTextField.setPrefWidth(147.0);
        outputFileTextField.setPromptText("output name file ");
        outputFileTextField.setFont(Font.font("Arial Bold", 12.0));
        innerPane2.getChildren().add(outputFileTextField);

        CheckBox defaultOutputNameCheckBox = new CheckBox();
        defaultOutputNameCheckBox.setLayoutX(156.0);
        defaultOutputNameCheckBox.setLayoutY(188.0);
        defaultOutputNameCheckBox.setMnemonicParsing(false);
        defaultOutputNameCheckBox.setPrefHeight(26.0);
        defaultOutputNameCheckBox.setPrefWidth(86.0);
        defaultOutputNameCheckBox.setText("Default name");
        defaultOutputNameCheckBox.setFont(new Font(10.0));
        defaultOutputNameCheckBox.setSelected(false); // Установка флага selected в true
        AnchorPane.setRightAnchor(defaultOutputNameCheckBox, 0.0);
        innerPane2.getChildren().add(defaultOutputNameCheckBox);
        defaultOutputNameCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                // Checkbox is selected
                String defaultOutputName = "default_file_name.txt"; // Set your default input file name here
                outputFileTextField.setText(defaultOutputName);
                outputFileTextField.setDisable(true);
            } else {
                // Checkbox is deselected
                outputFileTextField.setText("");
                outputFileTextField.setDisable(false);
            }
        });


        Button executeButton = new Button();
        executeButton.setLayoutX(6.0);
        executeButton.setLayoutY(225.0);
        executeButton.setPrefHeight(37.0);
        executeButton.setPrefWidth(147.0);
        executeButton.setText("Выполнить");
        executeButton.setFont(new Font(17.0));
        innerPane2.getChildren().add(executeButton);


        // вызов метода Управления программой
        ExecuteButtonHandler buttonHandler = new ExecuteButtonHandler(checkBox1, checkBox2, checkBox3,
                defaultKeyCheckBox, defaultInputNameCheckBox, defaultOutputNameCheckBox,
                keyTextField, inputFileTextField, outputFileTextField, textArea);
        executeButton.setOnAction(buttonHandler);


        root.getChildren().addAll(innerPane1, innerPane2);

        Scene scene = new Scene(root, 1200, 1000);
        primaryStage.setScene(scene);
        primaryStage.show();

        checkBox1.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) { // Если чекбокс "Зашифровать" выбран
                checkBox2.setSelected(false); // Снять выбор с чекбокса "Расшифровать"
                checkBox3.setSelected(false); // Снять выбор с чекбокса "Brute Force"
                checkBox2.setDisable(true); // Заблокировать чекбокс "Расшифровать"
                checkBox3.setDisable(true); // Заблокировать чекбокс "Brute Force"
            } else { // Если чекбокс "Зашифровать" не выбран
                checkBox2.setDisable(false); // Разблокировать чекбокс "Расшифровать"
                checkBox3.setDisable(false); // Разблокировать чекбокс "Brute Force"
            }
        });

        checkBox2.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) { // Если чекбокс "Расшифровать" выбран
                checkBox1.setSelected(false); // Снять выбор с чекбокса "Зашифровать"
                checkBox3.setSelected(false); // Снять выбор с чекбокса "Brute Force"
                defaultKeyCheckBox.setSelected(false);
                defaultKeyCheckBox.setDisable(true);
                checkBox1.setDisable(true); // Заблокировать чекбокс "Зашифровать"
                checkBox3.setDisable(true); // Заблокировать чекбокс "Brute Force"
                defaultKeyCheckBox.setDisable(true);
            } else { // Если чекбокс "Расшифровать" не выбран
                checkBox1.setDisable(false); // Разблокировать чекбокс "Зашифровать"
                checkBox3.setDisable(false); // Разблокировать чекбокс "Brute Force"
                defaultKeyCheckBox.setDisable(false);
            }
        });

        checkBox3.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) { // Если чекбокс "Brute Force" выбран
                checkBox1.setSelected(false); // Снять выбор с чекбокса "Зашифровать"
                checkBox2.setSelected(false); // Снять выбор с чекбокса "Расшифровать"
                keyTextField.setDisable(false);
                defaultKeyCheckBox.setDisable(false);
                checkBox1.setDisable(true); // Заблокировать чекбокс "Зашифровать"
                checkBox2.setDisable(true); // Заблокировать чекбокс "Расшифровать"
                keyTextField.clear();
                keyTextField.setDisable(true);
                defaultKeyCheckBox.setDisable(true);
            } else { // Если чекбокс "Brute Force" не выбран
                checkBox1.setDisable(false);// Разблокировать чекбокс "Зашифровать"
                checkBox2.setDisable(false); // Разблокировать чекбокс "Расшифровать"
                keyTextField.setDisable(false);
                defaultKeyCheckBox.setDisable(false);
            }
        });
    }
}