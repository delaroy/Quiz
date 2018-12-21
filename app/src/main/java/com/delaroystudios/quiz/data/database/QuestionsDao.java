package com.delaroystudios.quiz.data.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;

import com.delaroystudios.quiz.data.database.entity.Questions;

import java.util.List;

/**
 * Created by delaroy on 4/30/18.
 */

@Dao
public abstract class QuestionsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract void bulkInsert(List<Questions> questions);

    @Query("DELETE FROM questions")
    abstract void deleteAll();

    @Query("Select * FROM questions")
    public abstract LiveData<List<Questions>> getAllQuestions();

    @Transaction
    public void updateAll(List<Questions> questions) {
        deleteAll();
        bulkInsert(questions);
    }
}
