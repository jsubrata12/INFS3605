package com.example.infs3605;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {SDG.class}, exportSchema = true, version = 1)
public abstract class SDGDatabase extends RoomDatabase {
    public abstract SDGDao sdgDao();

    private static com.example.infs3605.SDGDatabase sdgDB;

    public static com.example.infs3605.SDGDatabase getInstance(Context context) {
        if (null == sdgDB) {
            sdgDB = Room.databaseBuilder(context, com.example.infs3605.SDGDatabase.class, "SDGDatabase").build();
        }
        return sdgDB;
    }
}
