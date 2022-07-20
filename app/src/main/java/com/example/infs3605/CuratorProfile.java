package com.example.infs3605;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName ="CuratorProfile")
public class CuratorProfile {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int curatorId;
    @ColumnInfo(name = "CuratorName")
    private String curatorName;
    @ColumnInfo(name = "CuratorEmail")
    private String email;
    @ColumnInfo(name = "CuratorLocation")
    private String location;
    @ColumnInfo(name = "CuratorDesc")
    private String description;
    @ColumnInfo(name = "CuratorOrg")
    private String organisation;
    @ColumnInfo(name = "SDG1")
    private boolean sdg1;
    @ColumnInfo(name = "SDG2")
    private boolean sdg2;
    @ColumnInfo(name = "SDG3")
    private boolean sdg3;
    @ColumnInfo(name = "SDG4")
    private boolean sdg4;
    @ColumnInfo(name = "SDG5")
    private boolean sdg5;
    @ColumnInfo(name = "SDG6")
    private boolean sdg6;
    @ColumnInfo(name = "SDG7")
    private boolean sdg7;
    @ColumnInfo(name = "SDG8")
    private boolean sdg8;
    @ColumnInfo(name = "SDG9")
    private boolean sdg9;
    @ColumnInfo(name = "SDG10")
    private boolean sdg10;
    @ColumnInfo(name = "SDG11")
    private boolean sdg11;
    @ColumnInfo(name = "SDG12")
    private boolean sdg12;
    @ColumnInfo(name = "SDG13")
    private boolean sdg13;
    @ColumnInfo(name = "SDG14")
    private boolean sdg14;
    @ColumnInfo(name = "SDG15")
    private boolean sdg15;
    @ColumnInfo(name = "SDG16")
    private boolean sdg16;
    @ColumnInfo(name = "SDG17")
    private boolean sdg17;

    public CuratorProfile(String curatorName, String email, String location, String description, String organisation, boolean sdg1, boolean sdg2, boolean sdg3, boolean sdg4, boolean sdg5, boolean sdg6, boolean sdg7, boolean sdg8, boolean sdg9, boolean sdg10, boolean sdg11, boolean sdg12, boolean sdg13, boolean sdg14, boolean sdg15, boolean sdg16, boolean sdg17) {
        this.curatorName = curatorName;
        this.email = email;
        this.location = location;
        this.description = description;
        this.organisation = organisation;
        this.sdg1 = sdg1;
        this.sdg2 = sdg2;
        this.sdg3 = sdg3;
        this.sdg4 = sdg4;
        this.sdg5 = sdg5;
        this.sdg6 = sdg6;
        this.sdg7 = sdg7;
        this.sdg8 = sdg8;
        this.sdg9 = sdg9;
        this.sdg10 = sdg10;
        this.sdg11 = sdg11;
        this.sdg12 = sdg12;
        this.sdg13 = sdg13;
        this.sdg14 = sdg14;
        this.sdg15 = sdg15;
        this.sdg16 = sdg16;
        this.sdg17 = sdg17;
    }

    public CuratorProfile(){

    }
    public int getCuratorId() {
        return curatorId;
    }

    public void setCuratorId(@NonNull int curatorId) {
        this.curatorId = curatorId;
    }

    public String getCuratorName() {
        return curatorName;
    }

    public void setCuratorName(String curatorName) {
        this.curatorName = curatorName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public boolean isSdg1() {
        return sdg1;
    }

    public void setSdg1(boolean sdg1) {
        this.sdg1 = sdg1;
    }

    public boolean isSdg2() {
        return sdg2;
    }

    public void setSdg2(boolean sdg2) {
        this.sdg2 = sdg2;
    }

    public boolean isSdg3() {
        return sdg3;
    }

    public void setSdg3(boolean sdg3) {
        this.sdg3 = sdg3;
    }

    public boolean isSdg4() {
        return sdg4;
    }

    public void setSdg4(boolean sdg4) {
        this.sdg4 = sdg4;
    }

    public boolean isSdg5() {
        return sdg5;
    }

    public void setSdg5(boolean sdg5) {
        this.sdg5 = sdg5;
    }

    public boolean isSdg6() {
        return sdg6;
    }

    public void setSdg6(boolean sdg6) {
        this.sdg6 = sdg6;
    }

    public boolean isSdg7() {
        return sdg7;
    }

    public void setSdg7(boolean sdg7) {
        this.sdg7 = sdg7;
    }

    public boolean isSdg8() {
        return sdg8;
    }

    public void setSdg8(boolean sdg8) {
        this.sdg8 = sdg8;
    }

    public boolean isSdg9() {
        return sdg9;
    }

    public void setSdg9(boolean sdg9) {
        this.sdg9 = sdg9;
    }

    public boolean isSdg10() {
        return sdg10;
    }

    public void setSdg10(boolean sdg10) {
        this.sdg10 = sdg10;
    }

    public boolean isSdg11() {
        return sdg11;
    }

    public void setSdg11(boolean sdg11) {
        this.sdg11 = sdg11;
    }

    public boolean isSdg12() {
        return sdg12;
    }

    public void setSdg12(boolean sdg12) {
        this.sdg12 = sdg12;
    }

    public boolean isSdg13() {
        return sdg13;
    }

    public void setSdg13(boolean sdg13) {
        this.sdg13 = sdg13;
    }

    public boolean isSdg14() {
        return sdg14;
    }

    public void setSdg14(boolean sdg14) {
        this.sdg14 = sdg14;
    }

    public boolean isSdg15() {
        return sdg15;
    }

    public void setSdg15(boolean sdg15) {
        this.sdg15 = sdg15;
    }

    public boolean isSdg16() {
        return sdg16;
    }

    public void setSdg16(boolean sdg16) {
        this.sdg16 = sdg16;
    }

    public boolean isSdg17() {
        return sdg17;
    }

    public void setSdg17(boolean sdg17) {
        this.sdg17 = sdg17;
    }

    public static ArrayList<CuratorProfile> getCuratorProfile() {
        ArrayList<CuratorProfile> curatorProfiles = new ArrayList<>();
        curatorProfiles.add(new CuratorProfile("Anorah Test", "sample@sample.com",
                "Sydney", "Not Available", "Not Available", false, false,
                false, false, false, false, false, false, true,
                false, true, false, true, true, true, true, false));
        curatorProfiles.add(new CuratorProfile("Josephine Sample", "sample2@sample.com", "Sydney", "Josephine Sample opens the line of " +
                "communication between clients, customers, and businesses to get projects done.", "Free Lance Consultant",
                false, false, false, false, false, true, false, false, true,
                false, true, true, true, true, true, true, false));
        return curatorProfiles;
    }

    // Get an individual BadgeStatus from a name parameter
    public static CuratorProfile getCuratorProfile(String name){
        ArrayList<CuratorProfile> curatorProfiles = CuratorProfile.getCuratorProfile();
        for(CuratorProfile curatorProfile: curatorProfiles){
            if(curatorProfile.getCuratorName().equals(name)){
                return curatorProfile;
            }
        }
        return null;
    }
}

