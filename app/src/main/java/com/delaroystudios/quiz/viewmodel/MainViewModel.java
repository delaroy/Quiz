package com.delaroystudios.quiz.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.delaroystudios.quiz.data.QuestionsRepository;
import com.delaroystudios.quiz.data.database.entity.Questions;

import java.util.List;

public class MainViewModel extends ViewModel {

    private final QuestionsRepository mRepository;
    private final LiveData<List<Questions>> mQuestions;

    public MainViewModel(QuestionsRepository mRepository) {
        this.mRepository = mRepository;
        this.mQuestions = mRepository.getQuestions();
    }

    public LiveData<List<Questions>> getmQuestions() {
        return mQuestions;
    }

    public void postRequest() {
        mRepository.postServiceRequest();
    }
}
