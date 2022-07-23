package com.example.infs3605;

import java.util.ArrayList;

public class Project {
    private String projectName;
    private boolean sdg1;
    private boolean sdg2;
    private boolean sdg3;
    private boolean sdg4;
    private boolean sdg5;
    private boolean sdg6;
    private boolean sdg7;
    private boolean sdg8;
    private boolean sdg9;
    private boolean sdg10;
    private boolean sdg11;
    private boolean sdg12;
    private boolean sdg13;
    private boolean sdg14;
    private boolean sdg15;
    private boolean sdg16;
    private boolean sdg17;

    public Project(String projectName, boolean sdg1, boolean sdg2, boolean sdg3, boolean sdg4,
                   boolean sdg5, boolean sdg6, boolean sdg7, boolean sdg8, boolean sdg9,
                   boolean sdg10, boolean sdg11, boolean sdg12, boolean sdg13, boolean sdg14,
                   boolean sdg15, boolean sdg16, boolean sdg17) {
        this.projectName = projectName;
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

    public Project() {

    }

    public String getProjectName() {
        return projectName;
    }

    public Project setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    public boolean isSdg1() {
        return sdg1;
    }

    public Project setSdg1(boolean sdg1) {
        this.sdg1 = sdg1;
        return this;
    }

    public boolean isSdg2() {
        return sdg2;
    }

    public Project setSdg2(boolean sdg2) {
        this.sdg2 = sdg2;
        return this;
    }

    public boolean isSdg3() {
        return sdg3;
    }

    public Project setSdg3(boolean sdg3) {
        this.sdg3 = sdg3;
        return this;
    }

    public boolean isSdg4() {
        return sdg4;
    }

    public Project setSdg4(boolean sdg4) {
        this.sdg4 = sdg4;
        return this;
    }

    public boolean isSdg5() {
        return sdg5;
    }

    public Project setSdg5(boolean sdg5) {
        this.sdg5 = sdg5;
        return this;
    }

    public boolean isSdg6() {
        return sdg6;
    }

    public Project setSdg6(boolean sdg6) {
        this.sdg6 = sdg6;
        return this;
    }

    public boolean isSdg7() {
        return sdg7;
    }

    public Project setSdg7(boolean sdg7) {
        this.sdg7 = sdg7;
        return this;
    }

    public boolean isSdg8() {
        return sdg8;
    }

    public Project setSdg8(boolean sdg8) {
        this.sdg8 = sdg8;
        return this;
    }

    public boolean isSdg9() {
        return sdg9;
    }

    public Project setSdg9(boolean sdg9) {
        this.sdg9 = sdg9;
        return this;
    }

    public boolean isSdg10() {
        return sdg10;
    }

    public Project setSdg10(boolean sdg10) {
        this.sdg10 = sdg10;
        return this;
    }

    public boolean isSdg11() {
        return sdg11;
    }

    public Project setSdg11(boolean sdg11) {
        this.sdg11 = sdg11;
        return this;
    }

    public boolean isSdg12() {
        return sdg12;
    }

    public Project setSdg12(boolean sdg12) {
        this.sdg12 = sdg12;
        return this;
    }

    public boolean isSdg13() {
        return sdg13;
    }

    public Project setSdg13(boolean sdg13) {
        this.sdg13 = sdg13;
        return this;
    }

    public boolean isSdg14() {
        return sdg14;
    }

    public Project setSdg14(boolean sdg14) {
        this.sdg14 = sdg14;
        return this;
    }

    public boolean isSdg15() {
        return sdg15;
    }

    public Project setSdg15(boolean sdg15) {
        this.sdg15 = sdg15;
        return this;
    }

    public boolean isSdg16() {
        return sdg16;
    }

    public Project setSdg16(boolean sdg16) {
        this.sdg16 = sdg16;
        return this;
    }

    public boolean isSdg17() {
        return sdg17;
    }

    public Project setSdg17(boolean sdg17) {
        this.sdg17 = sdg17;
        return this;
    }

    public static ArrayList<Project> getProject(){
        ArrayList<Project> projects = new ArrayList<>();
       // projects.add(new Project("The Great Fashion Decarbonisation Opportunity", true));
     //   projects.add(new Project("Innovate to Regenerate", true));
    //    projects.add(new Project("Cities of Tomorrow"));
          projects.add(new Project("Bushfire Regeneration Challenge", false, false,
                  true, false, false, false, false, false,
                  true, true, true, true, true, true, true, false, true));
          projects.add(new Project("Sustainability Advantage Impact Challenge", true, true,
                  true, true, true, true, true, true, true,
                  true, true, true, true, true, true, true, true));
          projects.add(new Project("Innovate for Wildlife & People Challenge", true, true, false,false, true,
                  false, false, false, false, true, false, false, false, true, true, false, true));

        return projects;
    }

    public static Project getProject(String name){
        ArrayList<Project> projects = Project.getProject();
        for(Project project: projects){
            if(project.getProjectName().equals(name)){
                return project;
            }
        }
        return null;
    }

}
