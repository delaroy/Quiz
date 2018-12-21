package com.delaroystudios.quiz.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;

import com.delaroystudios.quiz.data.database.entity.Questions;

/**
 * Created by delaroy on 4/30/18.
 */

@Database(entities = {Questions.class}, version = 1, exportSchema = false)
public abstract class QuestionsRoomDatabase extends RoomDatabase {

    private static final String LOG_TAG = QuestionsRoomDatabase.class.getSimpleName();
    private static final String DATABASE_NAME = "user_table";

    // For Singleton instantiation
    private static final Object LOCK = new Object();
    private static QuestionsRoomDatabase mInstance;

    public static QuestionsRoomDatabase getInstance(Context context) {
        Log.d(LOG_TAG, "Getting " + DATABASE_NAME + " database");

        if (mInstance == null) {
            synchronized (LOCK) {
                mInstance = Room.databaseBuilder(context, QuestionsRoomDatabase.class, DATABASE_NAME).build();
                Log.d(LOG_TAG, DATABASE_NAME + " database has been created.");
            }
        }
        return mInstance;
    }

    // The associated DAOs for the database
    public abstract QuestionsDao userDao();

}