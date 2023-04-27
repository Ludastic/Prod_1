package com.example.prod;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Task.class}, version = 1)
public abstract class TaskDB extends RoomDatabase {
    private static TaskDB instance;
    public abstract TaskDao taskDao();

    public static synchronized TaskDB getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    TaskDB.class, "task_database").build();
        }
        return instance;
    }
}
