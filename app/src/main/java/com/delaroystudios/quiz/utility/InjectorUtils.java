package com.delaroystudios.quiz.utility;

import android.content.Context;

import com.delaroystudios.quiz.AppExecutors;
import com.delaroystudios.quiz.data.QuestionsRepository;
import com.delaroystudios.quiz.data.database.QuestionsDao;
import com.delaroystudios.quiz.data.database.QuestionsRoomDatabase;
import com.delaroystudios.quiz.data.network.QuestionNetworkDataSource;
import com.delaroystudios.quiz.viewmodel.MainViewModelFactory;

public class InjectorUtils {

    public static QuestionsRepository getRepository(Context context) {
        // Get all we need
        QuestionsDao userDao = QuestionsRoomDatabase.getInstance(context).userDao();
        AppExecutors executors = AppExecutors.getInstance();
        QuestionNetworkDataSource networkDataSource = QuestionNetworkDataSource.getInstance(executors);

        return QuestionsRepository.getInstance(userDao, networkDataSource, executors);
    }

    public static MainViewModelFactory getMainViewModelFactory(Context context){
        QuestionsRepository repository = getRepository(context);
        return new MainViewModelFactory(repository);
    }

}
