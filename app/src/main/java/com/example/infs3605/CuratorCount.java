package com.example.infs3605;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName ="CuratorCount")
public class CuratorCount {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int countId;
    @ColumnInfo(name = "CuratorName")
    private String curatorName;
    @ColumnInfo(name = "Count")
    private int count;
    @ColumnInfo(name = "NewCount")
    private int newCount;
    @ColumnInfo(name = "ProjectName")
    private String projectName;


    public CuratorCount(String curatorName, int count, int newCount, String projectName) {
        this.curatorName = curatorName;
        this.count = count;
        this.projectName = projectName;
        this.newCount = newCount;
    }

    public int getCountId() {
        return countId;
    }

    public void setCountId(int countId) {
        this.countId = countId;
    }

    public String getCuratorName() {
        return curatorName;
    }

    public void setCuratorName(String curatorName) {
        this.curatorName = curatorName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getNewCount() {
        return newCount;
    }

    public void setNewCount(int newCount) {
        this.newCount = newCount;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}