package controller;

import javax.swing.*;

public class InputControl {
    public static int inputCheck(int userOption) {

        while (userOption < 5 || userOption > 0) {
            userOption = Integer.parseInt(JOptionPane.showInputDialog(
                    "Please, choose one option. " +
                            "\n1. Accelerate both rockets." +
                            "\n2. Break both rockets." +
                            "\n3. Show both rockets information." +
                            "\n4. Abort mission."));
        }
        return userOption;
    }
}
