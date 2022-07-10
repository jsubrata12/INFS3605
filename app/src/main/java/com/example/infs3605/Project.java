package com.example.infs3605;

import java.util.ArrayList;

public class Project {
    private String projectName;
    private String projectDate;
    private String projectDescription;
    private String projectImage;
    private boolean projectFunded;

    public Project(String projectName) {
    }

    public String getProjectName() {
        return projectName;
    }

    public Project setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    public String getProjectDate() {
        return projectDate;
    }

    public Project setProjectDate(String projectDate) {
        this.projectDate = projectDate;
        return this;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public Project setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
        return this;
    }

    public String getProjectImage() {
        return projectImage;
    }

    public Project setProjectImage(String projectImage) {
        this.projectImage = projectImage;
        return this;
    }

    public boolean isProjectFunded() {
        return projectFunded;
    }

    public Project setProjectFunded(boolean projectFunded) {
        this.projectFunded = projectFunded;
        return this;
    }

    public static ArrayList<Project> getProjects() {
        ArrayList<Project> projects = new ArrayList<>();

        projects.add(new Project("Test"));

        projects.add(new Project("Test1"));

        return projects;
    }
}
