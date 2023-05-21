package com.javarush.cryptanalyzer.popov;

import com.javarush.cryptanalyzer.popov.ui.ButtonModeRunner;
import com.javarush.cryptanalyzer.popov.view.*;
import com.javarush.cryptanalyzer.popov.app.MyApplication;
import com.javarush.cryptanalyzer.popov.controller.MainController;
import com.javarush.cryptanalyzer.popov.entity.Result;
import com.javarush.cryptanalyzer.popov.exception.FileReadingException;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;
import java.util.List;


public class Entrypoint extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        List<String> choices = Arrays.asList("Консольный режим", "Десктопный режим");
        // Создание диалогового окна выбора режима
        ChoiceDialog<String> dialog = new ChoiceDialog<>(choices.get(0), choices);
        dialog.setTitle("Выбор режима");
        dialog.setHeaderText(null);
        dialog.setContentText("Выберите режим работы:");
        // Отображение диалогового окна и ожидание выбора пользователя
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(selectedMode -> {
            if (selectedMode.equals(choices.get(0))) {
                // Запуск в консольном режиме
                try {
                    runConsoleMode();
                } catch (IOException | FileReadingException e) {
                    throw new RuntimeException(e);
                }
            } else if (selectedMode.equals(choices.get(1))) {
                // Запуск в режиме с кнопками
                try {

                    ButtonModeRunner.runButtonMode(primaryStage);

                } catch (IOException | FileReadingException e) {
                    throw new RuntimeException(e);
                }

            }
        });
    }

    private void runConsoleMode() throws IOException, FileReadingException {
        System.out.println("Запущен консольный режим");

        View view = new ConsoleView();
        MainController mainController = new MainController(view);
        MyApplication application = new MyApplication(mainController);
        do {
            Result result = application.run();
            application.printResult(result);
        } while (mainController.getView().getContinuation());
    }
}