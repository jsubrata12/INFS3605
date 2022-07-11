package com.example.infs3605;

import java.util.ArrayList;

public class Project {
    private String projectName;

    public Project(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }

    public Project setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    public static ArrayList<Project> getProject(){
        ArrayList<Project> projects = new ArrayList<>();
        projects.add(new Project("Test"));

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
