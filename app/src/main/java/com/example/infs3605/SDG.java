package com.example.infs3605;

import java.util.ArrayList;

public class SDG {
    private String sdgName;

    public SDG(String sdgName) {
        this.sdgName = sdgName;
    }

    public SDG() {

    }

    public String getSdgName() {
        return sdgName;
    }

    public SDG setSdgName(String sdgName) {
        this.sdgName = sdgName;
        return this;
    }

    public static ArrayList<SDG> getSDG(){
        ArrayList<SDG> sdgs = new ArrayList<>();
        sdgs.add(new SDG("No Poverty"));
        sdgs.add(new SDG("Zero Hunger"));
        sdgs.add(new SDG("Good Health and Well-being"));
        sdgs.add(new SDG("Quality Education"));
        sdgs.add(new SDG("Gender Equality"));
        sdgs.add(new SDG("Clean Water and Sanitation"));
        sdgs.add(new SDG("Affordable and Clean Energy"));
        sdgs.add(new SDG("Decent Work and Economic Growth"));
        sdgs.add(new SDG("Industry, Innovation and Infrastructure"));
        sdgs.add(new SDG("Reduced Inequalities"));
        sdgs.add(new SDG("Sustainable Cities and Communities"));
        sdgs.add(new SDG("Responsible Consumption and Production"));
        sdgs.add(new SDG("Climate Action"));
        sdgs.add(new SDG("Life Below Water"));
        sdgs.add(new SDG("Life on Land"));
        sdgs.add(new SDG("Peace, Justice and Strong Institutions"));
        sdgs.add(new SDG("Partnerships for the Goals"));

        return sdgs;
    }

    public static SDG getSDG(String name){
        ArrayList<SDG> sdgs = SDG.getSDG();
        for(SDG sdg: sdgs){
            if(sdg.getSdgName().equals(name)){
                return sdg;
            }
        }
        return null;
    }

}

