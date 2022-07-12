package com.example.infs3605;

import java.util.ArrayList;

public class SDG {
    private String SDGName;
    private String SDGDescription;
    private String SDGPoints;

    public SDG(String SDGName, String SDGDescription, String SDGPoints) {
        this.SDGName = SDGName;
        this.SDGDescription = SDGDescription;
        this.SDGPoints = SDGPoints;
    }

    public String getSDGName() {
        return SDGName;
    }

    public SDG setSDGName(String SDGName) {
        this.SDGName = SDGName;
        return this;
    }

    public String getSDGDescription() {
        return SDGDescription;
    }

    public SDG setSDGDescription(String SDGDescription) {
        this.SDGDescription = SDGDescription;
        return this;
    }

    public String getSDGPoints() {
        return SDGPoints;
    }

    public SDG setSDGPoints(String SDGPoints) {
        this.SDGPoints = SDGPoints;
        return this;
    }

    public static ArrayList<SDG> getSDG(){
        ArrayList<SDG> sdgs = new ArrayList<>();
        sdgs.add(new SDG("Test", "Test", "10"));

        return sdgs;
    }

    public static SDG getSDG(String name){
        ArrayList<SDG> sdgs = SDG.getSDG();
        for(SDG sdg: sdgs){
            if(sdg.getSDGName().equals(name)){
                return sdg;
            }
        }
        return null;
    }

}
