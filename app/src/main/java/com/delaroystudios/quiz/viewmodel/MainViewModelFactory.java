package com.delaroystudios.quiz.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.delaroystudios.quiz.data.QuestionsRepository;

public class MainViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final QuestionsRepository questionRepository;

    public MainViewModelFactory(QuestionsRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //noinspection unchecked
        return (T) new MainViewModel(questionRepository);
    }
}