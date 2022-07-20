package com.example.infs3605;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {CuratorProfile.class}, exportSchema = true, version = 1)
public abstract class CuratorProfileDatabase extends RoomDatabase {
    public abstract CuratorProfileDao curatorProfileDao();

    private static com.example.infs3605.CuratorProfileDatabase curatorProfileDB;

    public static com.example.infs3605.CuratorProfileDatabase getInstance(Context context) {
        if (null == curatorProfileDB) {
            curatorProfileDB = Room.databaseBuilder(context, com.example.infs3605.CuratorProfileDatabase.class, "CuratorProfileDatabase").build();
        }
        return curatorProfileDB;
    }
}
