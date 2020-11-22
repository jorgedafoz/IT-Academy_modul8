package view;

import model.Propeller;
import model.Rocket;

import java.util.ArrayList;
import java.util.List;

public class MainFase1 {
    public static void main(String[] args) {

        List<Propeller> propellersRocket1 = new ArrayList<Propeller>();
        List<Propeller> propellersRocket2 = new ArrayList<Propeller>();

        //create rockets and add propellers
        Propeller rock1_Prop1 = new Propeller();
        propellersRocket1.add(rock1_Prop1);
        Propeller rock1_Prop2 = new Propeller();
        propellersRocket1.add(rock1_Prop2);
        Propeller rock1_Prop3 = new Propeller();
        propellersRocket1.add(rock1_Prop3);

        Rocket rocket1 = new Rocket("X",propellersRocket1);

        Propeller rock2_Prop1 = new Propeller();
        propellersRocket2.add(rock2_Prop1);
        Propeller rock2_Prop2 = new Propeller();
        propellersRocket2.add(rock2_Prop2);
        Propeller rock2_Prop3 = new Propeller();
        propellersRocket2.add(rock2_Prop3);
        Propeller rock2_Prop4 = new Propeller();
        propellersRocket2.add(rock2_Prop4);
        Propeller rock2_Prop5 = new Propeller();
        propellersRocket2.add(rock2_Prop5);
        Propeller rock2_Prop6 = new Propeller();
        propellersRocket2.add(rock2_Prop6);

        Rocket rocket2 = new Rocket("LDSFJA32",propellersRocket2);

        //print result
        System.out.println("Rocket 1:\n code: " + rocket1.getCode() + "\n Propellers: " + rocket1.getPropellers().size());
        System.out.println("Rocket 2:\n code: " + rocket2.getCode() + "\n Propellers: " + rocket2.getPropellers().size());

    }
}
