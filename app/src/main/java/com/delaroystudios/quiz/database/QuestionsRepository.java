package com.delaroystudios.quiz.database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

/**
 * Created by delaroy on 4/30/18.
 */


public class QuestionsRepository {

    private QuestionsDao mQuestionsDao;
    private LiveData<List<Questions>> mAllQuestions;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    public QuestionsRepository(Application application) {
        QuestionsRoomDatabase db = QuestionsRoomDatabase.getDatabase(application);
        mQuestionsDao = db.wordDao();
        mAllQuestions = mQuestionsDao.getAllQuestions();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public  LiveData<List<Questions>> getmAllQuestions() {
        return mAllQuestions;
    }

    // You must call this on a non-UI thread or your app will crash.
    // Like this, Room ensures that you're not doing any long running operations on the main
    // thread, blocking the UI.
    public void insert (Questions word) {
        new insertAsyncTask(mQuestionsDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Questions, Void, Void> {

        private QuestionsDao mAsyncTaskDao;

        insertAsyncTask(QuestionsDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Questions... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
