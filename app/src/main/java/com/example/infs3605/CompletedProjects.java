package com.example.infs3605;

import java.util.ArrayList;

public class CompletedProjects {
    private String projectName;

    public CompletedProjects(String projectName) {
        this.projectName = projectName;
    }

    public CompletedProjects(){

    }

    public String getProjectName() {
        return projectName;
    }

    public CompletedProjects setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }
    public static ArrayList<CompletedProjects> getCompletedProjects(){
        ArrayList<CompletedProjects> completedProjects = new ArrayList<>();
        completedProjects.add(new CompletedProjects("Test"));

        return completedProjects;
    }

    public static CompletedProjects getCompletedProjects(String name){
        ArrayList<CompletedProjects> completedProjects = CompletedProjects.getCompletedProjects();
        for(CompletedProjects cp: completedProjects){
            if(cp.getProjectName().equals(name)){
                return cp;
            }
        }
        return null;
    }

}


