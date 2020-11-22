package controller;

import model.Propeller;

import java.text.RuleBasedCollator;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PropellerBreakThread extends Thread {

    private Propeller propeller;

    public PropellerBreakThread(Propeller propeller) {
       this.propeller = propeller;
    }

    @Override
    public void run() {
        while (propeller.getActualPower() > 0) {
            propeller.setActualPower(propeller.getActualPower()-1);
            System.out.println(this.getName() + " decreasing power to " + propeller.getActualPower());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
