package com.example.infs3605;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {CuratorCount.class}, exportSchema = true, version = 1)
public abstract class CuratorCountDatabase extends RoomDatabase{
        public abstract CuratorCountDao curatorCountDao();

        private static com.example.infs3605.CuratorCountDatabase curatorCountDatabase;

        public static com.example.infs3605.CuratorCountDatabase getInstance(Context context) {
            if (null == curatorCountDatabase) {
                curatorCountDatabase = Room.databaseBuilder(context, com.example.infs3605.CuratorCountDatabase.class, "CuratorCountDatabase").build();
            }
            return curatorCountDatabase;
        }
    }

