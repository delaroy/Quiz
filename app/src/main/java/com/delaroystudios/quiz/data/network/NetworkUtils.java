package com.delaroystudios.quiz.data.network;

import android.util.Log;

import com.delaroystudios.quiz.data.database.entity.Questions;
import com.delaroystudios.quiz.data.network.pojo.QuestionsModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkUtils {

    private static final String LOG_TAG = NetworkUtils.class.getSimpleName();
    private static final String BASE_URL = "http://unitypuzzlegame.com/";

    private static Retrofit getRetrofit() {
        return new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory
                .create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
    }

    public static Disposable getDataFromService(DisposableObserver<List<QuestionsModel>> observer) {
        Log.d(LOG_TAG, "Getting data from the server");
        try {
            RestApi service = getRetrofit().create(RestApi.class);
            Observable<List<QuestionsModel>> observable = service.getQuestions();

            return observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(observer);

        } catch (Exception e) {
            Log.d(LOG_TAG, "Getting data process has been failed. ", e);
        }
        return null;
    }


    public static List<Questions> convertToUserList(List<QuestionsModel> serviceResponse) {
        List<Questions> questionsList = new ArrayList<>();

        Log.d(LOG_TAG, "Converting the response.");
        try {
            for (QuestionsModel data : serviceResponse) {
                Questions questions = new Questions();
                questions.setQuestion(data.getQuestion());
                questions.setAnswer(data.getAnswer());
                questions.setOptA(data.getOptA());
                questions.setOptB(data.getOptB());
                questions.setOptC(data.getOptC());

                questionsList.add(questions);
            }
        } catch (Exception e) {
            Log.d(LOG_TAG, "Converting the response process has been failed. ", e);
        }

        return questionsList;
    }

}
