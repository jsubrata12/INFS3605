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
    @ColumnInfo(name = "Count")
    private int count;
    @ColumnInfo(name = "CountCurators")
    private String cc;
    @ColumnInfo(name = "NewCount")
    private int newCount;
    @ColumnInfo(name = "DesignThinking")
    private boolean designThinking;
    @ColumnInfo(name = "Technology")
    private boolean technology;
    @ColumnInfo(name = "UserExperience")
    private boolean userExperience;
    @ColumnInfo(name = "ProjectManagement")
    private boolean projectManagement;
    @ColumnInfo(name = "Design")
    private boolean design;
    @ColumnInfo(name = "Research")
    private boolean research;
    @ColumnInfo(name = "RiskAssessment")
    private boolean riskAssessment;
    @ColumnInfo(name = "Strategy")
    private boolean strategy;
    @ColumnInfo(name = "Analysis")
    private boolean analysis;
    @ColumnInfo(name = "KnowledgeManagement")
    private boolean knowledgeManagement;
    @ColumnInfo(name = "Innovation")
    private boolean innovation;
    @ColumnInfo(name = "Image")
    private String image;

    public CuratorProfile(String curatorName, String email, String location, String description, String organisation, boolean sdg1, boolean sdg2, boolean sdg3, boolean sdg4, boolean sdg5, boolean sdg6, boolean sdg7, boolean sdg8, boolean sdg9, boolean sdg10, boolean sdg11, boolean sdg12, boolean sdg13, boolean sdg14, boolean sdg15, boolean sdg16, boolean sdg17, boolean designThinking, boolean technology, boolean userExperience, boolean projectManagement, boolean design, boolean research, boolean riskAssessment, boolean strategy, boolean analysis, boolean knowledgeManagement, boolean innovation, String image) {
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
        this.designThinking = designThinking;
        this.technology = technology;
        this.userExperience = userExperience;
        this.projectManagement = projectManagement;
        this.design = design;
        this.research = research;
        this.riskAssessment = riskAssessment;
        this.strategy = strategy;
        this.analysis = analysis;
        this.knowledgeManagement = knowledgeManagement;
        this.innovation = innovation;
        this.image = image;
    }

    public CuratorProfile(){
    }

    public CuratorProfile(String curatorName){
        this.curatorName = curatorName;
    }

    public CuratorProfile(String curatorName, int count){
        this.curatorName = curatorName;
        this.count = count;
    }
    public CuratorProfile(int count){
        this.count = count;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public int getNewCount() {
        return newCount;
    }

    public void setNewCount(int newCount) {
        this.newCount = newCount;
    }

    public boolean isDesignThinking() {
        return designThinking;
    }

    public void setDesignThinking(boolean designThinking) {
        this.designThinking = designThinking;
    }

    public boolean isTechnology() {
        return technology;
    }

    public void setTechnology(boolean technology) {
        this.technology = technology;
    }

    public boolean isUserExperience() {
        return userExperience;
    }

    public void setUserExperience(boolean userExperience) {
        this.userExperience = userExperience;
    }

    public boolean isProjectManagement() {
        return projectManagement;
    }

    public void setProjectManagement(boolean projectManagement) {
        this.projectManagement = projectManagement;
    }

    public boolean isDesign() {
        return design;
    }

    public void setDesign(boolean design) {
        this.design = design;
    }

    public boolean isResearch() {
        return research;
    }

    public void setResearch(boolean research) {
        this.research = research;
    }

    public boolean isRiskAssessment() {
        return riskAssessment;
    }

    public void setRiskAssessment(boolean riskAssessment) {
        this.riskAssessment = riskAssessment;
    }

    public boolean isStrategy() {
        return strategy;
    }

    public void setStrategy(boolean strategy) {
        this.strategy = strategy;

    }

    public boolean isAnalysis() {
        return analysis;
    }

    public void setAnalysis(boolean analysis) {
        this.analysis = analysis;
    }

    public boolean isKnowledgeManagement() {
        return knowledgeManagement;
    }

    public void setKnowledgeManagement(boolean knowledgeManagement) {
        this.knowledgeManagement = knowledgeManagement;
    }

    public boolean isInnovation() {
        return innovation;
    }

    public void setInnovation(boolean innovation) {
        this.innovation = innovation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static ArrayList<CuratorProfile> getCuratorProfile() {
        ArrayList<CuratorProfile> curatorProfiles = new ArrayList<>();

        curatorProfiles.add(new CuratorProfile("Anorah Test", "sample@sample.com",
                "Sydney", "Anorah Test opens the line of communication between clients, customers, and businesses to get projects done.", "Not Available", false, false,
                false, false, false, false, false, false, true,
                true, true, false, true, true, true, true, false, true, true, true, true, true,
                false, false, false, false, false, false, "drawable/curator1"));
        curatorProfiles.add(new CuratorProfile("Josephine Sample", "sample2@sample.com", "Sydney", "Josephine Sample opens the line of " +
                "communication between clients, customers, and businesses to get projects done.", "Free Lance Consultant",
                false, false, false, false, false, true, false, false, true,
                false, true, true, true, true, true, true, false, true, false, true, true, true, true, true,
                true, true, true, true, "drawable/curator2"));
        curatorProfiles.add(new CuratorProfile("Zara Wild", "zara@sample.com", "Sydney", "Zara Wild opens the line of " +
                "communication between clients, customers, and businesses to get projects done.", "HSBC",
                false, false, false, false, false, true, false, false, false,
                false, true, false, false, false, false, false, false, false, false, true, true, true, false,
                false, false, false, false, false, "drawable/curator3"));
        curatorProfiles.add(new CuratorProfile("Phone Sample", "phone@sample.com", "Sydney", "Phone Sample opens the line of " +
                "communication between clients, customers, and businesses to get projects done.", "Free Lance Consultant",
                false, false, false, false, false, false, false, false, true,
                false, false, false, true, true, false, true, false, true, false, false, false, false, true, true,
                false, false, false, false, "drawable/curator4"));
        curatorProfiles.add(new CuratorProfile("Danniella Compton", "sample4@sample.com", "Wollongong", "Danniella Compton opens the line of" +
                " communication between clients, customers, and businesses to get projects done.", "HSBC", false, false, false,
                false, false, false, false, false, false, false, false, false, true, true, true, false, true, true, false, false, false, false, true, true,
                false, false, false, false, "drawable/curator5"));
        curatorProfiles.add(new CuratorProfile("Elize Traynor", "sample5@sample.com", "Melbourne", "Elize Traynor opens the line of communication between clients, customers, and businesses to get projects done ", "HSBC", false, true, false, true, true, false,
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
        false, false, true, true, true, true, true, "drawable/curator6"));
        curatorProfiles.add(new CuratorProfile("Lilianna Steadman", "sample6@sample.com", "Brisbane", "Lilianna Steadman opens the line of communication between clients, customers, and businesses to get projects done", "Free Lance Consultant", false,
                false, false, false, false, false, false, true, true, true, false, false, false, false,
                false, false, false, true, false, false, false, false, true, false, false, false, false, true, "drawable/curator1"));
        curatorProfiles.add(new CuratorProfile("Marcus Dowling", "sample8@sample.com", "Canberra", "Marcus Dowling opens the line of communication between clients, customers, and businesses to get projects done", "HSBC", false, false, false,
                false, false, false, false, false, false, false, false, false, true, true, true, false, false, true, false,
        true, false, true, true, false, false, false, true, true, "drawable/curator7"));
        curatorProfiles.add(new CuratorProfile("Gail Gallagher", "sample9@sample.com", "Darwin", "Gail Gallagher opens the line of communication between clients, customers, and businesses to get projects done", "Free Lance Consultant", false, false,
                false, false, false, false, false, false, false, false, false, true, false, false, false, true,
                true, false, true, false, true, false, true, true, false, true, false, false, "drawable/curator8"));
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

