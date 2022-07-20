package com.example.infs3605;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface CuratorProfileDao {
    @Query("SELECT CuratorName FROM CuratorProfile WHERE SDG11 = 1")
    boolean getSDG11();

    @Query("SELECT * FROM CuratorProfile WHERE SDG11 = 1")
    List<CuratorProfile> getCuratorProfileList();

}
