package model;

public class Propeller {

    public int actualPower;
    public int maxPower;


    //constructors
    public Propeller(int maxPower) {
        this.maxPower=maxPower;
        this.actualPower=0;
    }

    public Propeller() {}

    //getters & setters
    public int getActualPower() {
        return actualPower;
    }

    public int getMaxPower() {
        return maxPower;
    }

    public int setActualPower(int actualPower) {
        this.actualPower = actualPower;
        return actualPower;
    }

    public void setMaxPower(int maxPower) {
        this.maxPower = maxPower;
    }
}
