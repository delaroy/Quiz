package com.delaroystudios.quiz;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.delaroystudios.quiz.database.Questions;
import com.delaroystudios.quiz.database.QuestionsRepository;

import java.util.Collections;
import java.util.List;

/**
 * Created by delaroy on 4/30/18.
 */

public class QuestionsViewModel extends AndroidViewModel {

    private QuestionsRepository mRepository;
    // Using LiveData and caching what getAlphabetizedWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    private LiveData<List<Questions>> mAllQuestions;

    public QuestionsViewModel (Application application) {
        super(application);
        mRepository = new QuestionsRepository(application);
        mAllQuestions = mRepository.getmAllQuestions();
    }

    LiveData<List<Questions>> getAllQuestions() { return mAllQuestions; }

    public void insert(Questions word) { mRepository.insert(word); }
}