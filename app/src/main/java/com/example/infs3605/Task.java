package com.example.infs3605;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import com.google.firebase.database.Exclude;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "Tasks")
public class Task {
    static ArrayList<Task> tasks = new ArrayList<>();

    @SerializedName("taskId")
    @Expose
    private int taskId;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("dueDate")
    @Expose
    private String dueDate;

    @SerializedName("dateCreated")
    @Expose
    private String dateCreated;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("completed")
    @Expose
    private boolean completed;

    public Task(int id, String name, String dueDate, String dateCreated, String description) {
        this.taskId = id;
        this.name = name;
        this.dueDate = dueDate;
        this.dateCreated = dateCreated;
        this.description = description;
        this.completed = false;
    }

    public Task() {

    }


    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
//
//    @Exclude
//    public ArrayList<String> getSubtasks() {
//        return subtasks;
//    }
//
//    @Exclude
//    public void setSubtasks(ArrayList<String> subtasks) {
//        this.subtasks = subtasks;
//    }
//
    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getDueFromNow() {
        Long days = ChronoUnit.DAYS.between(LocalDate.now(),LocalDate.parse(dueDate));
        return "Due in " + days + " day(s)";
    }
//
//    @Exclude
//    @RequiresApi(api = Build.VERSION_CODES.O)
//    public static void initialiseTaskList() {
////        ArrayList<Task> tasks = new ArrayList<>();
//        Task task1 = new Task(0,"Follow up with Jenny on project", LocalDate.parse("2022-08-22"),
//                LocalDate.parse("2022-07-01"),"Follow up and discuss details of the project");
//        task1.getSubtasks().add("Email Jenny");
//        task1.getSubtasks().add("Book meeting with Jenny");
//        tasks.add(task1);
//
//        Task task2 = new Task(1,"Complete xyz", LocalDate.parse("2022-08-30"),
//                LocalDate.parse("2022-06-21"),"Complete tasks from project and discuss with manager");
//        task2.getSubtasks().add("Complete Task xyz");
//        task2.getSubtasks().add("Complete Task abc");
//        task2.getSubtasks().add("Schedule meeting with manager");
//        tasks.add(task2);
//
//        Task task3 = new Task(2,"Run report with this month's metrics", LocalDate.parse("2022-08-15"),
//                LocalDate.parse("2022-06-30"),"Run report for Tom");
//        task3.getSubtasks().add("Run report");
//        task3.getSubtasks().add("Email Tom");
//        tasks.add(task3);
//
//        Task task4 = new Task(3,"Create team dashboard", LocalDate.parse("2022-08-02"),
//                LocalDate.parse("2022-07-15"),"Create a team dashboard and share with Sam and Amy.");
//        task4.getSubtasks().add("Create dashboard with xyz metrics");
//        task4.getSubtasks().add("Share dashboard with Sam and Amy");
//        task4.getSubtasks().add("Get feedback from Sam and Amy");
//        tasks.add(task4);
//    }
//
//    @Exclude
//    @RequiresApi(api = Build.VERSION_CODES.O)
//    public static void addTask(Task task) {
//        tasks.add(task);
//    }
//
//    @Exclude
//    public static ArrayList<Task> getTasks() {
//        return tasks;
//    }
//
//    @Exclude
//    @RequiresApi(api = Build.VERSION_CODES.O)
//    public static Task findTask(String taskId) {
//        System.out.println(Integer.parseInt(taskId));
//        for (Task task : getTasks()) {
//            if (task.getTaskId() == Integer.parseInt(taskId)) {
//                return task;
//            }
//        }
//
//        return null;
//    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Task)) {
            return false;
        }
        Task task = (Task) obj;

        return task.getTaskId() == this.getTaskId();
    }
}
