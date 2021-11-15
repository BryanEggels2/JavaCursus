package Javatraining.Main;

import Javatraining.Calculator.Calculator;

import javax.swing.*;

public class GUIWrapper {
    public static JFrame CreateGui(Programs choice){
        switch (choice){
            case CALCULATOR:
                return Calculator.createGUI();
            case POKEMON:
                //TODO
                return null;
            case TICTACTOE:
                //TODO
                return null;
            default:
                //TODO check if can be solved differently.
                return null;
        }
    }
}
