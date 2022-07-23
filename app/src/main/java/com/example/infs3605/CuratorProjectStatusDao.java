package com.example.infs3605;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface CuratorProjectStatusDao {
    @Query("SELECT * FROM CuratorProjectStatus WHERE CuratorName == :name AND ProjectStatus == :status")
    List<CuratorProjectStatus> getStatus(String name, String status);

    @Query("SELECT * FROM CuratorProjectStatus")
    List<CuratorProjectStatus> getAll();

    @Query("UPDATE CuratorProjectStatus SET ProjectStatus = :status WHERE CuratorName = :name AND ProjectName = :projName")
    void setStatus(String status, String name, String projName);
}
