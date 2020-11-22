package view;

import model.Propeller;
import model.Rocket;

import java.util.ArrayList;
import java.util.List;

public class MainFase2 {
    public static void main(String[] args) {
        List<Propeller> propellersRocket1 = new ArrayList<Propeller>();
        List<Propeller> propellersRocket2 = new ArrayList<Propeller>();

        //create rockets and add propellers
        Propeller rock1_Prop1 = new Propeller(10);
        propellersRocket1.add(rock1_Prop1);
        Propeller rock1_Prop2 = new Propeller(30);
        propellersRocket1.add(rock1_Prop2);
        Propeller rock1_Prop3 = new Propeller(80);
        propellersRocket1.add(rock1_Prop3);

        Rocket rocket1 = new Rocket("32WESSDS",propellersRocket1);

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

        //print result
        String rocketSumary = rocket1.getCode() + ": ";

        for(int i=0; i<rocket1.getPropellers().size(); i++) {
                rocketSumary += rocket1.getPropellers().get(i).getMaxPower() + ".";
        }
        rocketSumary += "\n" + rocket2.getCode() + ": ";

        for(int i=0; i<rocket2.getPropellers().size(); i++) {
                rocketSumary += rocket2.getPropellers().get(i).getMaxPower() + ".";
        }

        System.out.println(rocketSumary);

    }
}
