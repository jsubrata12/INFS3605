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

@Entity(tableName = "Tasks")
public class Task {
    private static ArrayList<Task> tasks;
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int taskId;

    @ColumnInfo(name = "TaskName")
    private String name;

    @ColumnInfo(name = "DueDate")
    private LocalDate dueDate;

    @ColumnInfo(name = "DateCreated")
    private LocalDate dateCreated;

    @ColumnInfo(name = "TaskDescription")
    private String description;

    @ColumnInfo(name = "Completed")
    private boolean completed;

    @ColumnInfo(name = "SubTasks")
    private ArrayList<String> subtasks;

    private int idCount = 0;

    public Task(String name, LocalDate dueDate, LocalDate dateCreated, String description) {
        this.taskId = idCount++;
        this.name = name;
        this.dueDate = dueDate;
        this.dateCreated = dateCreated;
        this.description = description;
        this.completed = false;
        this.subtasks = new ArrayList<>();
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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
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

    public ArrayList<String> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(ArrayList<String> subtasks) {
        this.subtasks = subtasks;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getDueFromNow() {
        Long days = ChronoUnit.DAYS.between(LocalDate.now(),dueDate);
        return "Due in " + days + " day(s)";
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static ArrayList<Task> getTasks() {
//        ArrayList<Task> tasks = new ArrayList<>();
        tasks = new ArrayList<>();
        Task task1 = new Task("Follow up with Jenny on project", LocalDate.parse("2022-08-22"),
                LocalDate.parse("2022-07-01"),"Follow up and discuss details of the project");
        task1.getSubtasks().add("Email Jenny");
        task1.getSubtasks().add("Book meeting with Jenny");
        tasks.add(task1);

        Task task2 = new Task("Complete xyz", LocalDate.parse("2022-08-30"),
                LocalDate.parse("2022-06-21"),"Complete tasks from project and discuss with manager");
        task2.getSubtasks().add("Complete Task xyz");
        task2.getSubtasks().add("Complete Task abc");
        task2.getSubtasks().add("Schedule meeting with manager");
        tasks.add(task2);

        Task task3 = new Task("Run report with this month's metrics", LocalDate.parse("2022-08-15"),
                LocalDate.parse("2022-06-30"),"Run report for Tom");
        task3.getSubtasks().add("Run report");
        task3.getSubtasks().add("Email Tom");
        tasks.add(task3);

        Task task4 = new Task("Create team dashboard", LocalDate.parse("2022-08-02"),
                LocalDate.parse("2022-07-15"),"Create a team dashboard and share with Sam and Amy.");
        task4.getSubtasks().add("Create dashboard with xyz metrics");
        task4.getSubtasks().add("Share dashboard with Sam and Amy");
        task4.getSubtasks().add("Get feedback from Sam and Amy");
        tasks.add(task4);
        return tasks;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static ArrayList<Task> addTask(Task task) {
        ArrayList<Task> updatedTasks = getTasks();
        updatedTasks.add(task);
        return updatedTasks;

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static Task findTask(String taskId) {
        System.out.println(Integer.parseInt(taskId));
        for (Task task : getTasks()) {
            if (task.getTaskId() == Integer.parseInt(taskId)) {
                return task;
            }
        }

        return null;
    }
}
