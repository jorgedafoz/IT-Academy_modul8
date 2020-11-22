package controller;

import model.Propeller;
import model.Rocket;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PropellerAccelerateThread extends Thread {

    private Propeller propeller;

    public PropellerAccelerateThread(Propeller propeller) {
        this.propeller = propeller;
    }

    @Override
    public void run() {
        while (propeller.getActualPower() < propeller.getMaxPower()) {
            propeller.setActualPower(propeller.getActualPower()+1);
            System.out.println(this.getName() + " increasing power to " + propeller.getActualPower());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                //e.printStackTrace();
            }
        }
    }
}
