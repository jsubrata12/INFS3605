package com.example.infs3605;

import android.net.ipsec.ike.SaProposal;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Solutions {
    String projectName;
    String solutionName;
    String desc;
    String needsList;
    boolean designThinking;
    boolean technology;
    boolean userExperience;
    boolean projectManagement;
    boolean design;
    boolean research;
    boolean riskAssessment;
    boolean strategy;
    boolean analysis;
    boolean knowledgeManagement;
    boolean innovation;


    public Solutions(String projectName, String solutionName, String desc, boolean designThinking, boolean technology, boolean userExperience, boolean projectManagement, boolean design, boolean research, boolean riskAssessment, boolean strategy, boolean analysis, boolean knowledgeManagement, boolean innovation, String needsList) {
        this.projectName = projectName;
        this.solutionName = solutionName;
        this.desc = desc;
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
        this.needsList = needsList;
    }
    public Solutions(){

    }

    public Solutions(String solutionName){
        this.solutionName = solutionName;
    }

    public Solutions(String solutionName, String desc, String needsList) {
        this.solutionName = solutionName;
        this.desc = desc;
        this.needsList = needsList;
    }

    public String getProjectName() {
        return projectName;
    }

    public Solutions setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    public String getSolutionName() {
        return solutionName;
    }

    public Solutions setSolutionName(String solutionName) {
        this.solutionName = solutionName;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public Solutions setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public boolean isDesignThinking() {
        return designThinking;
    }

    public Solutions setDesignThinking(boolean designThinking) {
        this.designThinking = designThinking;
        return this;
    }

    public boolean isTechnology() {
        return technology;
    }

    public Solutions setTechnology(boolean technology) {
        this.technology = technology;
        return this;
    }

    public boolean isUserExperience() {
        return userExperience;
    }

    public Solutions setUserExperience(boolean userExperience) {
        this.userExperience = userExperience;
        return this;
    }

    public boolean isProjectManagement() {
        return projectManagement;
    }

    public Solutions setProjectManagement(boolean projectManagement) {
        this.projectManagement = projectManagement;
        return this;
    }

    public boolean isDesign() {
        return design;
    }

    public Solutions setDesign(boolean design) {
        this.design = design;
        return this;
    }

    public boolean isResearch() {
        return research;
    }

    public Solutions setResearch(boolean research) {
        this.research = research;
        return this;
    }

    public boolean isRiskAssessment() {
        return riskAssessment;
    }

    public Solutions setRiskAssessment(boolean riskAssessment) {
        this.riskAssessment = riskAssessment;
        return this;
    }

    public boolean isStrategy() {
        return strategy;
    }

    public Solutions setStrategy(boolean strategy) {
        this.strategy = strategy;
        return this;
    }

    public boolean isAnalysis() {
        return analysis;
    }

    public Solutions setAnalysis(boolean analysis) {
        this.analysis = analysis;
        return this;
    }

    public boolean isKnowledgeManagement() {
        return knowledgeManagement;
    }

    public Solutions setKnowledgeManagement(boolean knowledgeManagement) {
        this.knowledgeManagement = knowledgeManagement;
        return this;
    }

    public boolean isInnovation() {
        return innovation;
    }

    public Solutions setInnovation(boolean innovation) {
        this.innovation = innovation;
        return this;
    }

    public String getNeedsList() {
        return needsList;
    }

    public Solutions setNeedsList(String needsList) {
        this.needsList = needsList;
        return this;
    }

    public static ArrayList<Solutions> getSolution() {
        ArrayList<Solutions> solution = new ArrayList<>();
        solution.add(new Solutions("The Great Fashion Decarbonisation Opportunity",
                "Fashion Reduction", "Fashion Reduction is a local business that sources sustainable fibres",
                false, true, false, false, false, false, false,
                false, false, false, true, "Technology, Innovation"));
        solution.add(new Solutions("The Great Fashion Decarbonisation Opportunity",
                "Sustainable Rodeo", "Sustainable Rodeo is a start-up that aims to work alongside clothing manufacturers to reduce their energy consumption by up to 40%",
                false, true, false, false, true, true, false,
                true, false, true, true, "Technology, Design, Research, Strategy, Knowledge Management, Innovation"));

        return solution;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static Solutions getSolution(String name){
        ArrayList<Solutions> solutions = Solutions.getSolution();
        for(Solutions s: solutions){
            if(s.getSolutionName().equals(name)){
                return s;
            }
        }
        return null;
    }

}
