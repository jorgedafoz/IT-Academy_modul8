package view;

import controller.InputControl;
import model.Rocket;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.*;

public class MainFase3 {
    public static void main(String[] args) throws Exception{

        Rocket rocket1 = Rocket.createRocket1();
        Rocket rocket2 = Rocket.createRocket2();
        
        boolean exitSpaceProgram = false;

        do {
            int option = 0;
            try {
                option = Integer.parseInt(JOptionPane.showInputDialog(
                        "Please, choose one option: " +
                                "\n1. Accelerate both rockets." +
                                "\n2. Break both rockets." +
                                "\n3. Show both rockets information." +
                                "\n4. Abort mission."));

            } catch (Exception e) {
                System.out.println("Oops!");
            }
            switch (option) {
                case 1:
                    rocket1.accelerate();
                    rocket2.accelerate();
                    break;
                case 2:
                    rocket1.breakPower();
                    rocket2.breakPower();
                    break;
                case 3:
                    System.out.println(rocket1.rocketData());
                    System.out.println(rocket2.rocketData());
                    break;
                case 4:
                    System.out.println("Mission aborted!");
                    exitSpaceProgram = true;
                    break;
                default:
                    System.out.println("Incorrect input or invalid option, please try again.");
            }
        } while (!exitSpaceProgram);
    }
}
