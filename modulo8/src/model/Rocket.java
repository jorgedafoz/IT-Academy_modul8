package model;

import controller.PropellerAccelerateThread;
import controller.PropellerBreakThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;
import java.util.List;

public class Rocket {

    protected String code;
    protected List<Propeller> propellers = new ArrayList<Propeller>();
    protected List<Thread> threadSpeed = new ArrayList<Thread>();
    protected List<Thread> threadBreake = new ArrayList<Thread>();
    private Lock menuPanel = new ReentrantLock();
    private Condition powerOrderExecuted;

    //constructor
    public Rocket(String code, List<Propeller> propellers) {
        this.code=code;
        this.propellers=propellers;
        powerOrderExecuted = menuPanel.newCondition();
    }

    //setters & getters
    public String getCode() {
        return code;
    }

    public List<Propeller> getPropellers() {
        return propellers;
    }

    public List<Thread> getThreadSpeed(){
        return threadSpeed;
    }

    public List<Thread> getThreadBreak(){
        return threadBreake;
    }

    public static Rocket createRocket1() {

        List<Propeller> propellersRocket1 = new ArrayList<Propeller>();
        Propeller rock1_Prop1 = new Propeller(10);
        propellersRocket1.add(rock1_Prop1);
        Propeller rock1_Prop2 = new Propeller(30);
        propellersRocket1.add(rock1_Prop2);
        Propeller rock1_Prop3 = new Propeller(80);
        propellersRocket1.add(rock1_Prop3);

        Rocket rocket1 = new Rocket("32WESSDS",propellersRocket1);
        return rocket1;
    }

    public static Rocket createRocket2() {

        List<Propeller> propellersRocket2 = new ArrayList<Propeller>();
        Propeller rock2_Prop1 = new Propeller(30);
        propellersRocket2.add(rock2_Prop1);
        Propeller rock2_Prop2 = new Propeller(40);
        propellersRocket2.add(rock2_Prop2);
        Propeller rock2_Prop3 = new Propeller(50);
        propellersRocket2.add(rock2_Prop3);
        Propeller rock2_Prop4 = new Propeller(50);
        propellersRocket2.add(rock2_Prop4);
        Propeller rock2_Prop5 = new Propeller(30);
        propellersRocket2.add(rock2_Prop5);
        Propeller rock2_Prop6 = new Propeller(10);
        propellersRocket2.add(rock2_Prop6);

        Rocket rocket2 = new Rocket("LDSFJA32",propellersRocket2);
        return rocket2;
    }

    public void accelerate() {

        for(int i=0; i<this.getThreadBreak().size(); i++) {
            this.getThreadBreak().get(i).interrupt();
        }
        for(Propeller p: this.propellers) {
            Runnable r = new PropellerAccelerateThread(p);
            Thread t = new Thread(r);
            t.start();
            this.getThreadSpeed().add(t);
            System.out.println("Propeller of " + p.getMaxPower() + " maximal power: started");
            System.out.println("Threads in control: " + this.getThreadSpeed());
        }

    }

    public void breakPower() {

        for(int i=0; i<this.getThreadSpeed().size(); i++) {
            this.getThreadSpeed().get(i).interrupt();
            System.out.println(this.getThreadSpeed().get(i).getName() + " interrupted: "
                             + this.getThreadSpeed().get(i).isInterrupted());
        }
        for(Propeller p: this.propellers) {
            Runnable r = new PropellerBreakThread(p);
            Thread t = new Thread(r);
            t.start();
            this.getThreadBreak().add(t);
        }

    }

    public String rocketData() {
        String rocketData = this.getCode() + ": ";

        for(int i = 0; i < this.getPropellers().size(); i++) {
            if(i==this.getPropellers().size()-1) {
                rocketData += this.getPropellers().get(i).getActualPower() + ".";
            }else {
                rocketData += this.getPropellers().get(i).getActualPower() + ",";
            }
        }
        return rocketData;
    }

}
