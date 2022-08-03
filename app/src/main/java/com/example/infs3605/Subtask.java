package com.example.infs3605;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Subtask {
    @SerializedName("taskId")
    @Expose
    private int taskId;

    @SerializedName("subtaskId")
    @Expose
    private int subtaskId;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("completed")
    @Expose
    private boolean completed;

    public Subtask() {

    }

    public Subtask(int taskId, int subtaskId, String name, boolean completed) {
        this.taskId = taskId;
        this.subtaskId = subtaskId;
        this.name = name;
        this.completed = completed;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getSubtaskId() {
        return subtaskId;
    }

    public void setSubtaskId(int subtaskId) {
        this.subtaskId = subtaskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
