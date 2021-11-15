package Javatraining.Main;

import javax.swing.*;

public class Main {

    public static void main(String... args) {
        JFrame application = GUIWrapper.CreateGui(Programs.CALCULATOR);
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        application.setVisible(true);
    }

}
