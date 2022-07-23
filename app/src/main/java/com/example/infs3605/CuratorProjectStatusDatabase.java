package com.example.infs3605;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {CuratorProjectStatus.class}, exportSchema = true, version = 1)
public abstract class CuratorProjectStatusDatabase extends RoomDatabase {
    public abstract CuratorProjectStatusDao curatorProjectStatusDao();

    private static com.example.infs3605.CuratorProjectStatusDatabase curatorProjectStatusDatabase;

    public static com.example.infs3605.CuratorProjectStatusDatabase getInstance(Context context) {
        if (null == curatorProjectStatusDatabase) {
            curatorProjectStatusDatabase = Room.databaseBuilder(context, com.example.infs3605.CuratorProjectStatusDatabase.class, "CuratorProjectStatusDatabase").build();
        }
        return curatorProjectStatusDatabase;
    }
}
