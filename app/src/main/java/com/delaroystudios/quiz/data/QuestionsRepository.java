package com.delaroystudios.quiz.data;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.delaroystudios.quiz.AppExecutors;
import com.delaroystudios.quiz.data.database.entity.Questions;
import com.delaroystudios.quiz.data.database.QuestionsDao;
import com.delaroystudios.quiz.data.network.QuestionNetworkDataSource;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * Created by delaroy on 4/30/18.
 */


public class QuestionsRepository {
    private static final String LOG_TAG = QuestionsRepository.class.getSimpleName();

    private QuestionsDao mUserDao;
    private QuestionNetworkDataSource mNetworkDataSource;

    // For Singleton instantiation
    private static final Object LOCK = new Object();
    private static QuestionsRepository sInstance;

    public QuestionsRepository(QuestionsDao questionsDao, QuestionNetworkDataSource networkDataSource, AppExecutors
            executors) {
        this.mUserDao = questionsDao;
        this.mNetworkDataSource = networkDataSource;

        // As long as the repository exists, observe the network LiveData.
        // If that LiveData changes, update the database.
        mNetworkDataSource.getUserList().observeForever(users -> {
            executors.diskIO().execute(() -> {

                Log.d(LOG_TAG, "user table is updating");
                mUserDao.updateAll(users);
            });
        });
    }

    public static QuestionsRepository getInstance(QuestionsDao questionsDao, QuestionNetworkDataSource
            networkDataSource, AppExecutors executors) {
        Log.d(LOG_TAG, "Getting the repository");
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = new QuestionsRepository(questionsDao, networkDataSource, executors);
                Log.d(LOG_TAG, "Made new repository");
            }
        }
        return sInstance;
    }

    public LiveData<List<Questions>> getQuestions() {
        return mUserDao.getAllQuestions();
    }

    public void postServiceRequest() {
        mNetworkDataSource.fetchData();
    }

}