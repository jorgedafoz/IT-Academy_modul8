package model;

import controller.PropellerAccelerateThread;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener{

    private JLabel labelRocket1, labelRocket2;
    private JButton button1, button2, button3, button4, button5;
    //constructor
    public Window() {
        super();
        windowSettup();
        buttonSettup();
        //ButtonLayer b = new ButtonLayer();
        //add(b);
       // add(new ButtonLayer());
    }

    private void windowSettup() {
        this.setTitle("Rockets");
        this.setSize(700, 450);
        this.setLocationRelativeTo(null);
        //this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void buttonSettup() {
        //creating labels && buttons
        labelRocket1 = new JLabel("Rocket 1");
        labelRocket2 = new JLabel("Rocket 2");
        button1 = new JButton("Accelerate");
        button2 = new JButton("Break");
        button3 = new JButton("Accelerate");
        button4 = new JButton("Break");
        button5 = new JButton("Show rockets data");

        //setting their size
        labelRocket1.setBounds(50, 10, 500, 250);
        labelRocket2.setBounds(500, 10, 500, 250);
        button1.setBounds(100, 370, 100, 50);
        button1.addActionListener(this);
        button2.setBounds(210, 370, 100, 50);
        button2.addActionListener(this);
        button3.setBounds(450, 370, 100, 50);
        button3.addActionListener(this);
        button4.setBounds(560, 370, 100, 50);
        button4.addActionListener(this);
        button5.setBounds(330, 270, 100, 100);
        button5.addActionListener(this);

        //adding them to the window
        this.add(labelRocket1);
        this.add(labelRocket2);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(button5);
    }

    //create both rockets using class Rocket methods
    Rocket rocket1 = Rocket.createRocket1();
    Rocket rocket2 = Rocket.createRocket2();

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button1) {
            rocket1.accelerate();
        }
        if (e.getSource()==button2) {
            rocket1.breakPower();
        }
        if (e.getSource()==button3) {
            rocket2.accelerate();
        }
        if (e.getSource()==button4) {
            rocket2.breakPower();
        }
        if(e.getSource()==button5) {
            labelRocket1.setText(rocket1.rocketData() + rocket1.getThreadSpeed());
            labelRocket2.setText(rocket2.rocketData() + rocket2.getThreadSpeed());
            System.out.println(rocket1.getThreadSpeed());
            System.out.println(rocket2.getThreadSpeed());
        }
    }

}
