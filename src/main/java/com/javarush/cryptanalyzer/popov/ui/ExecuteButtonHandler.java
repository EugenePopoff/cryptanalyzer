package com.javarush.cryptanalyzer.popov.ui;

import com.javarush.cryptanalyzer.popov.exception.FileReadingException;
import com.javarush.cryptanalyzer.popov.processes.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Objects;

import static com.javarush.cryptanalyzer.popov.constants.TextConstants.CRACKED_MESSAGE;
import static com.javarush.cryptanalyzer.popov.constants.TextConstants.RANDOM_KEY_MSG;
import static com.javarush.cryptanalyzer.popov.constants.TextConstantsDesktop.*;

public class ExecuteButtonHandler implements EventHandler<ActionEvent> {
    private final CheckBox checkBox1;
    private final CheckBox checkBox2;
    private final CheckBox checkBox3;
    private final CheckBox defaultKeyCheckBox;
    private final CheckBox defaultInputNameCheckBox;
    private final CheckBox defaultOutputNameCheckBox;
    private final TextField keyTextField;
    private final TextField inputFileTextField;
    private final TextField outputFileTextField;
    private final TextArea textArea;
    static String key;
    static String inputFile;
    static String outputFile;

    public ExecuteButtonHandler(CheckBox checkBox1, CheckBox checkBox2, CheckBox checkBox3,
                                CheckBox defaultKeyCheckBox, CheckBox defaultInputNameCheckBox,
                                CheckBox defaultOutputNameCheckBox, TextField keyTextField,
                                TextField inputFileTextField, TextField outputFileTextField, TextArea textArea) {
        this.checkBox1 = checkBox1;
        this.checkBox2 = checkBox2;
        this.checkBox3 = checkBox3;
        this.defaultKeyCheckBox = defaultKeyCheckBox;
        this.defaultInputNameCheckBox = defaultInputNameCheckBox;
        this.defaultOutputNameCheckBox = defaultOutputNameCheckBox;
        this.keyTextField = keyTextField;
        this.inputFileTextField = inputFileTextField;
        this.outputFileTextField = outputFileTextField;
        this.textArea = textArea;
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            if (checkBox1.isSelected()) {
                textArea.clear();
                // Код для выбранного режима зашифровки
                textArea.appendText(ENCRYPTION_MODE_SELECTED);
                //ввод ключа
                if (defaultKeyCheckBox.isSelected()) {
                    textArea.appendText(" \n");
                    key = String.valueOf((int) (Math.random() * 1000));
                    textArea.appendText(RANDOM_KEY_MSG + key);
                    textArea.appendText(" \n");
                } else {
                    key = keyTextField.getText();
                }
                //ввод input файла
                if (defaultInputNameCheckBox.isSelected()) {
                    inputFile = "input.txt";
                } else {
                    inputFile = inputFileTextField.getText();
                }
                // ввод output файла
                if (defaultOutputNameCheckBox.isSelected()) {
                    outputFile = "encoded.txt";
                } else {
                    outputFile = outputFileTextField.getText();
                }
                String message = FileUtils.readFile(inputFile);
                textArea.appendText(TEXT_FOR_ENCRYPTION);
                textArea.appendText(" \n");
                textArea.appendText(message);
                String encrypted = Encrypt.encrypt(Objects.requireNonNull(FileUtils.readFile(inputFile)), Integer.parseInt(key));
                textArea.appendText(ENCRYPTED_TEXT);
                textArea.appendText(" \n");
                textArea.appendText(encrypted);
                WriteToFile.write(outputFile, encrypted);

            } else if (checkBox2.isSelected()) {
                textArea.clear();
                textArea.appendText(DECRYPTION_MODE_SELECTED);
                //ввод ключа
                if (defaultKeyCheckBox.isSelected()) {
                    textArea.appendText(" \n");
                    key = String.valueOf((int) (Math.random() * 1000));
                    textArea.appendText(RANDOM_KEY_MSG + key);
                    textArea.appendText(" \n");
                } else {
                    key = keyTextField.getText();
                }
                //ввод input файла
                if (defaultInputNameCheckBox.isSelected()) {
                    inputFile = "encoded.txt";
                } else {
                    inputFile = inputFileTextField.getText();
                }
                // ввод output файла
                if (defaultOutputNameCheckBox.isSelected()) {
                    outputFile = "output.txt";
                } else {
                    outputFile = outputFileTextField.getText();
                }
                String message = FileUtils.readFile(inputFile);
                textArea.appendText(TEXT_FOR_DECRYPTION);
                textArea.appendText(" \n");
                textArea.appendText(message);
                String decrypted = Decrypt.decrypt(Objects.requireNonNull(FileUtils.readFile(inputFile)), Integer.parseInt(key));
                textArea.appendText(DECRYPTED_TEXT);
                textArea.appendText(" \n");
                textArea.appendText(decrypted);
                WriteToFile.write(outputFile, decrypted);
            } else if (checkBox3.isSelected()) {
                textArea.clear();
                textArea.appendText(BRUTE_FORCE_MODE_SELECTED);
                if (defaultInputNameCheckBox.isSelected()) {
                    inputFile = "encoded.txt";
                } else {
                    inputFile = inputFileTextField.getText();
                }
                if (defaultOutputNameCheckBox.isSelected()) {
                    outputFile = "output.txt";
                } else {
                    outputFile = outputFileTextField.getText();
                }
                String message = FileUtils.readFile(inputFile);
                textArea.appendText(TEXT_FOR_DECRYPTION);
                textArea.appendText(" \n");
                textArea.appendText(message);
                int bruteForceKey = BrForce.bruteforce(message);
                textArea.appendText(CRACKED_MESSAGE);
                textArea.appendText("\nKey number:" + bruteForceKey);
                textArea.appendText(" \n");
                String decrypted = Decrypt.decrypt(Objects.requireNonNull(FileUtils.readFile(inputFile)), bruteForceKey);
                textArea.appendText(DECRYPTED_TEXT + decrypted);
                WriteToFile.write(outputFile, decrypted);
            }
        } catch (NumberFormatException e) {
            // Обработка исключения NumberFormatException
            System.err.println(INVALID_NUMBER_FORMAT);
            e.printStackTrace();
            // Prompt the user to enter a valid key again
            keyTextField.clear(); // Clear the content of keyTextField
            keyTextField.requestFocus(); // Set focus on keyTextField for user input
            textArea.appendText(ENTER_VALID_KEY);
        } catch (FileReadingException e) {
            textArea.appendText(ENTER_VALID_FILE_NAME);
            throw new RuntimeException(e);
        }
    }
}