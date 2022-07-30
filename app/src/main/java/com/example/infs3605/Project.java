package com.example.infs3605;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Project {
    private String projectName;
    private String desc;
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
    private LocalDate websiteLive;
    private LocalDate eoiStart;
    private LocalDate eoiEnd;
    private LocalDate fullAppStart;
    private LocalDate fullAppEnd;
    private LocalDate reviewStart;
    private LocalDate reviewEnd;
    private LocalDate curationStart;
    private LocalDate curationEnd;
    private LocalDate projectListStart;
    private LocalDate fundingStart;

    public Project(String projectName, String desc, boolean sdg1, boolean sdg2, boolean sdg3, boolean sdg4,
                   boolean sdg5, boolean sdg6, boolean sdg7, boolean sdg8, boolean sdg9, boolean sdg10,
                   boolean sdg11, boolean sdg12, boolean sdg13, boolean sdg14, boolean sdg15, boolean sdg16,
                   boolean sdg17, LocalDate websiteLive, LocalDate eoiStart, LocalDate eoiEnd, LocalDate fullAppStart,
                   LocalDate fullAppEnd, LocalDate reviewStart, LocalDate reviewEnd, LocalDate curationStart,
                   LocalDate curationEnd, LocalDate projectListStart, LocalDate fundingStart) {
        this.projectName = projectName;
        this.desc = desc;
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
        this.websiteLive = websiteLive;
        this.eoiStart = eoiStart;
        this.eoiEnd = eoiEnd;
        this.fullAppStart = fullAppStart;
        this.fullAppEnd = fullAppEnd;
        this.reviewStart = reviewStart;
        this.reviewEnd = reviewEnd;
        this.curationStart = curationStart;
        this.curationEnd = curationEnd;
        this.projectListStart = projectListStart;
        this.fundingStart = fundingStart;
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

    public String getDesc() {
        return desc;
    }

    public Project setDesc(String desc) {
        this.desc = desc;
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

    public LocalDate getWebsiteLive() {
        return websiteLive;
    }

    public Project setWebsiteLive(LocalDate websiteLive) {
        this.websiteLive = websiteLive;
        return this;
    }

    public LocalDate getEoiStart() {
        return eoiStart;
    }

    public Project setEoiStart(LocalDate eoiStart) {
        this.eoiStart = eoiStart;
        return this;
    }

    public LocalDate getEoiEnd() {
        return eoiEnd;
    }

    public Project setEoiEnd(LocalDate eoiEnd) {
        this.eoiEnd = eoiEnd;
        return this;
    }

    public LocalDate getFullAppStart() {
        return fullAppStart;
    }

    public Project setFullAppStart(LocalDate fullAppStart) {
        this.fullAppStart = fullAppStart;
        return this;
    }

    public LocalDate getFullAppEnd() {
        return fullAppEnd;
    }

    public Project setFullAppEnd(LocalDate fullAppEnd) {
        this.fullAppEnd = fullAppEnd;
        return this;
    }

    public LocalDate getReviewStart() {
        return reviewStart;
    }

    public Project setReviewStart(LocalDate reviewStart) {
        this.reviewStart = reviewStart;
        return this;
    }

    public LocalDate getReviewEnd() {
        return reviewEnd;
    }

    public Project setReviewEnd(LocalDate reviewEnd) {
        this.reviewEnd = reviewEnd;
        return this;
    }

    public LocalDate getCurationStart() {
        return curationStart;
    }

    public Project setCurationStart(LocalDate curationStart) {
        this.curationStart = curationStart;
        return this;
    }

    public LocalDate getCurationEnd() {
        return curationEnd;
    }

    public Project setCurationEnd(LocalDate curationEnd) {
        this.curationEnd = curationEnd;
        return this;
    }

    public LocalDate getProjectListStart() {
        return projectListStart;
    }

    public Project setProjectListStart(LocalDate projectListStart) {
        this.projectListStart = projectListStart;
        return this;
    }

    public LocalDate getFundingStart() {
        return fundingStart;
    }

    public Project setFundingStart(LocalDate fundingStart) {
        this.fundingStart = fundingStart;
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static ArrayList<Project> getProject()  {
        ArrayList<Project> projects = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        // projects.add(new Project("The Great Fashion Decarbonisation Opportunity", true));
     //   projects.add(new Project("Innovate to Regenerate", true));
    //    projects.add(new Project("Cities of Tomorrow"));
        projects.add(new Project("Bushfire Regeneration Challenge", "In 2019-20 " +
                "Australia experienced the most catastrophic bushfire season in the country’s history, " +
                "and the impacts will be felt for years to come. " +
                "Up to 19 million hectares were burnt, with 12.6 million hectares primarily forest " +
                "and bushland. 1 billion animals perished, 34 human lives were lost and around 2,700 " +
                "homes destroyed. " +
                "Now, we aim to uncover innovative nature-based solutions to enhance the recovery, " +
                "regeneration and resilience of landscapes and threatened species. " +
                "We look for solutions that enable and incentivise landholders and communities to " +
                "own and drive regeneration outcomes. Solutions should cover at least one of these areas: " +
                "fire risk management, regenerative land use, species recovery and building ecological, " +
                "economic and social resilience to climate change.", false, false,
                true, false, false, false, false, false,
                true, true, true, true, true, true, true, false, true, LocalDate.parse("2020-10-12"),
                LocalDate.parse("2020-10-26"), LocalDate.parse("2020-11-08"), LocalDate.parse("2020-10-26"),
                LocalDate.parse("2020-11-22"), LocalDate.parse("2020-11-23"), LocalDate.parse("2020-12-06"),
                LocalDate.parse("2020-12-07"), LocalDate.parse("2020-12-20"), LocalDate.parse("2020-12-21"), LocalDate.parse("2021-02-21")));
          //projects.add(new Project("Sustainability Advantage Impact Challenge", "Placeholder", true, true,
             //    true, true, true, true, true, true, true,
             //    true, true, true, true, true, true, true, true));
          //projects.add(new Project("Innovate for Wildlife & People Challenge", "Placeholder", true, true, false,false, true,
                  //false, false, false, false, true, false, false, false, true, true, false, true));

        return projects;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static Project getProject(String name){
        ArrayList<Project> projects = null;
        projects = Project.getProject();
        for(Project project: projects){
            if(project.getProjectName().equals(name)){
                return project;
            }
        }
        return null;
    }

}
