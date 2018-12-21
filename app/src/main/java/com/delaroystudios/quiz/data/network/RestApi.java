package com.delaroystudios.quiz.data.network;

import com.delaroystudios.quiz.data.database.entity.Questions;
import com.delaroystudios.quiz.data.network.pojo.QuestionsModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApi {

    @GET("json/questions.json")
    Observable<List<QuestionsModel>> getQuestions();
}
