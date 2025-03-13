package Gui;

import SQL.InitStorage;
import javafx.application.Application;

public class Main {
    public static void main(String[] args) {
        initStorage();
        Application.launch(StartVindue.class);
    }

    private static void initStorage() {
        InitStorage.initPerson();
        InitStorage.initPortfolio();
    }
}
