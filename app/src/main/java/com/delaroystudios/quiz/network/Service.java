package com.delaroystudios.quiz.network;

import com.delaroystudios.quiz.QuestionsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by delaroy on 4/30/18.
 */

public interface Service {

    @GET("json/questions.json")
    Call<List<QuestionsModel>> getQuestions();

}
