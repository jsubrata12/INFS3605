package com.example.infs3605;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "CuratorProjectStatus")
public class CuratorProjectStatus {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int curatorStatusId;
    @ColumnInfo(name = "CuratorName")
    private String curatorName;
    @ColumnInfo(name = "ProjectName")
    private String projectName;
    @ColumnInfo(name = "ProjectStatus")
    private String projectStatus;

    public CuratorProjectStatus(String curatorName, String projectName, String projectStatus) {
        this.curatorName = curatorName;
        this.projectName = projectName;
        this.projectStatus = projectStatus;
    }

    public int getCuratorStatusId() {
        return curatorStatusId;
    }

    public void setCuratorStatusId(int curatorStatusId) {
        this.curatorStatusId = curatorStatusId;
    }

    public String getCuratorName() {
        return curatorName;
    }

    public void setCuratorName(String curatorName) {
        this.curatorName = curatorName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }
}