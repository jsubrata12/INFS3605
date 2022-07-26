package com.example.infs3605;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface CuratorCountDao {

        @Query("SELECT * FROM CuratorCount")
        List<CuratorCount> getAll();

        @Query("SELECT * FROM CuratorCount WHERE CuratorName == :user")
        List<CuratorCount> getUser(String user);

        @Query("SELECT * FROM CuratorCount WHERE CuratorName == :user AND ProjectName == :projName")
        List<CuratorCount> getUserCount(String user, String projName);

        @Query("UPDATE CuratorCount SET Count = :count + :newCount WHERE CuratorName = :name AND ProjectName = :projName")
        void setCount(String name, int count, int newCount, String projName);

    @Query("UPDATE CuratorCount SET Count = :count WHERE CuratorName = :name AND ProjectName = :projName")
    void set(String name, int count, String projName);

        @Insert
        void insertCount(CuratorCount cp);

        @Transaction
        default void insertOrUpdate(CuratorCount cp) {
            List<CuratorCount> curatorProfileList  = getUserCount(cp.getCuratorName(), cp.getProjectName());
            if (curatorProfileList.isEmpty())
                insertCount(cp);
            else
                setCount(cp.getCuratorName(), cp.getCount(), cp.getNewCount(), cp.getProjectName());
        }

    @Transaction
    default void insertOrNo(CuratorCount cp) {
        List<CuratorCount> curatorProfileList  = getUserCount(cp.getCuratorName(), cp.getProjectName());
        if (curatorProfileList.isEmpty()) {
            insertCount(cp);

        }
    }
    }
