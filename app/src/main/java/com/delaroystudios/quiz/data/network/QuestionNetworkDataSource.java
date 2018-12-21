package com.delaroystudios.quiz.data.network;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.delaroystudios.quiz.AppExecutors;
import com.delaroystudios.quiz.data.database.entity.Questions;
import com.delaroystudios.quiz.data.network.pojo.QuestionsModel;

import java.util.List;

import io.reactivex.observers.DisposableObserver;

public class QuestionNetworkDataSource {

    private static final String LOG_TAG = QuestionNetworkDataSource.class.getSimpleName();

    // For Singleton instantiation
    private static QuestionNetworkDataSource sInstance;
    private static final Object LOCK = new Object();

    private AppExecutors mAppExecutors;
    private final MutableLiveData<List<Questions>> mDownloadedData;

    public QuestionNetworkDataSource(AppExecutors mAppExecutors) {
        this.mAppExecutors = mAppExecutors;
        this.mDownloadedData = new MutableLiveData<>();
    }

    public static QuestionNetworkDataSource getInstance(AppExecutors executors) {
        Log.d(LOG_TAG, "Getting the network data source");
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = new QuestionNetworkDataSource(executors);
                Log.d(LOG_TAG, "Made new network data source");
            }
        }
        return sInstance;
    }

    public void fetchData() {
        mAppExecutors.networkIO().execute(() -> {
            try {
                NetworkUtils.getDataFromService(new DisposableObserver<List<QuestionsModel>>() {

                            @Override
                            public void onNext(List<QuestionsModel> serviceResponse) {
                                setUserList(NetworkUtils.convertToUserList(serviceResponse));
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e(LOG_TAG, "Getting data process has been failed.", e);
                            }

                            @Override
                            public void onComplete() {

                            }
                        });

            } catch (Exception ex) {
                Log.e(LOG_TAG, "Getting data process has been failed.", ex);
            }
        });
    }


    private void setUserList(List<Questions> userList){
        mDownloadedData.postValue(userList);
    }

    public LiveData<List<Questions>> getUserList(){
        return mDownloadedData;
    }

}
