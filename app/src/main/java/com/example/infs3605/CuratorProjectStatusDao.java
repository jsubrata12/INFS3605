package com.example.infs3605;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface CuratorProjectStatusDao {
    @Query("SELECT * FROM CuratorProjectStatus WHERE CuratorName == :name AND ProjectName == :projName")
    List<CuratorProjectStatus> getStatus(String name, String projName);

    @Query("SELECT * FROM CuratorProjectStatus")
    List<CuratorProjectStatus> getAll();

    @Query("SELECT * FROM CuratorProjectStatus WHERE CuratorName == :user")
    List<CuratorProjectStatus> getUser(String user);

    @Query("UPDATE CuratorProjectStatus SET ProjectStatus = :status WHERE CuratorName = :name AND ProjectName = :projName")
    void setStatus(String status, String name, String projName);

    @Query("SELECT EXISTS(SELECT * FROM CuratorProjectStatus WHERE ProjectStatus = :status AND CuratorName = :name AND ProjectName = :projName)")
    Boolean isRowIsExist(String name, String projName, String status);


    @Insert
    void insertStatus(CuratorProjectStatus cps);

    @Transaction
    default void insertOrUpdate(CuratorProjectStatus cps) {
        List<CuratorProjectStatus> curatorProjectStatuses  = getStatus(cps.getCuratorName(), cps.getProjectName());
        if (curatorProjectStatuses.isEmpty())
            insertStatus(cps);
        else
            setStatus(cps.getProjectStatus(), cps.getCuratorName(), cps.getProjectName());
    }
}
