package Javatraining.Calculator;

import javax.swing.*;
import java.awt.*;

public class Calculator {
    public static String Calculate(String input, String input2, String modifier) {
        try{
            switch(modifier){
                case "+":
                    return Integer.toString(Integer.parseInt(input) + Integer.parseInt(input2));
                case "-":
                    return Integer.toString(Integer.parseInt(input) - Integer.parseInt(input2));
                case "x":
                    return Integer.toString(Integer.parseInt(input) * Integer.parseInt(input2));
                case "/":
                    return Integer.toString(Integer.parseInt(input) / Integer.parseInt(input2));
                default:
                    return "Impossible";
            }
        }
        catch (NumberFormatException ex){
            return "Please use valid integer numbers for input";
        }
    }
    public static JFrame createGUI() {
        //First textbox
        JTextField input = new JTextField();
        input.setPreferredSize(new Dimension(300, 40));

        //Second textbox
        JTextField input2 = new JTextField();
        input2.setPreferredSize(new Dimension(400, 40));

        //This button is to generate the answer
        JButton convertButton = new JButton("Convert");

        //Outcome label
        JLabel output = new JLabel();
        output.setPreferredSize(new Dimension(300, 40));

        //Dropdown menu
        String[] modifiers = {"-", "+", "x", "/"};
        JComboBox modifierChoice = new JComboBox(modifiers);
        modifierChoice.setPreferredSize(new Dimension(350, 40));

        //This is the event that gets triggered every time the button gets pressed.
        convertButton.addActionListener(event -> {
            output.setText(Calculator.Calculate(input.getText(), input2.getText(), (String)modifierChoice.getItemAt(modifierChoice.getSelectedIndex())));
        });

        JFrame gui = new JFrame("Calculator");
        gui.setLayout(new FlowLayout());
        gui.add(input);
        gui.add(input2);
        gui.add(convertButton);
        gui.add(output);
        gui.add(modifierChoice);
        gui.pack();
        gui.setLocationRelativeTo(null); // Centering the screen

        return gui;
    }
}
