package pairmatching;

import pairmatching.controller.MainController;

public class Application {
    public static void main(String[] args) {
        try {
            MainController mainController = new MainController();
            mainController.run();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
