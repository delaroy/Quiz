package com.delaroystudios.quiz.di;

import android.app.Application;
import android.content.Context;
import com.delaroystudios.quiz.data.network.pojo.QuestionsViewModel;
import com.delaroystudios.quiz.QuestionsViewModel_MembersInjector;
import com.delaroystudios.quiz.api.QuizApi;
import com.delaroystudios.quiz.data.database.QuestionsDao;
import com.delaroystudios.quiz.data.QuestionsRepository;
import com.delaroystudios.quiz.di.module.ApiModule;
import com.delaroystudios.quiz.di.module.ApiModule_ProvidesQuizFactory;
import com.delaroystudios.quiz.di.module.AppModule;
import com.delaroystudios.quiz.di.module.AppModule_ProvideApplicationFactory;
import com.delaroystudios.quiz.di.module.DaoModule;
import com.delaroystudios.quiz.di.module.DaoModule_ProvideQuestionsDaoFactory;
import com.delaroystudios.quiz.di.module.NetModule;
import com.delaroystudios.quiz.di.module.NetModule_ProvideGsonFactory;
import com.delaroystudios.quiz.di.module.NetModule_ProvideHttpCacheFactory;
import com.delaroystudios.quiz.di.module.NetModule_ProvideInterceptorFactory;
import com.delaroystudios.quiz.di.module.NetModule_ProvideOkhttpClientFactory;
import com.delaroystudios.quiz.di.module.NetModule_ProvideRetrofitFactory;
import com.delaroystudios.quiz.di.module.RepositoryModule;
import com.delaroystudios.quiz.di.module.RepositoryModule_ProvideExecutorFactory;
import com.google.gson.Gson;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import java.util.concurrent.Executor;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerAppComponent implements AppComponent {
  private Provider<Gson> provideGsonProvider;

  private Provider<Application> provideApplicationProvider;

  private Provider<Cache> provideHttpCacheProvider;

  private Provider<Interceptor> provideInterceptorProvider;

  private Provider<OkHttpClient> provideOkhttpClientProvider;

  private Provider<Retrofit> provideRetrofitProvider;

  private Provider<QuizApi> providesQuizProvider;

  private Provider<QuestionsDao> provideQuestionsDaoProvider;

  private Provider<Executor> provideExecutorProvider;

  private DaggerAppComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  private QuestionsRepository getQuestionsRepository() {
    return new QuestionsRepository(
        providesQuizProvider.get(),
        provideQuestionsDaoProvider.get(),
        provideExecutorProvider.get());
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.provideGsonProvider =
        DoubleCheck.provider(NetModule_ProvideGsonFactory.create(builder.netModule));
    this.provideApplicationProvider =
        DoubleCheck.provider(AppModule_ProvideApplicationFactory.create(builder.appModule));
    this.provideHttpCacheProvider =
        DoubleCheck.provider(
            NetModule_ProvideHttpCacheFactory.create(
                builder.netModule, provideApplicationProvider));
    this.provideInterceptorProvider =
        DoubleCheck.provider(NetModule_ProvideInterceptorFactory.create(builder.netModule));
    this.provideOkhttpClientProvider =
        DoubleCheck.provider(
            NetModule_ProvideOkhttpClientFactory.create(
                builder.netModule, provideHttpCacheProvider, provideInterceptorProvider));
    this.provideRetrofitProvider =
        DoubleCheck.provider(
            NetModule_ProvideRetrofitFactory.create(
                builder.netModule, provideGsonProvider, provideOkhttpClientProvider));
    this.providesQuizProvider =
        DoubleCheck.provider(
            ApiModule_ProvidesQuizFactory.create(builder.apiModule, provideRetrofitProvider));
    this.provideQuestionsDaoProvider =
        DoubleCheck.provider(
            DaoModule_ProvideQuestionsDaoFactory.create(
                builder.daoModule, provideApplicationProvider));
    this.provideExecutorProvider =
        DoubleCheck.provider(
            RepositoryModule_ProvideExecutorFactory.create(builder.repositoryModule));
  }

  @Override
  public void inject(QuestionsViewModel viewModelModule) {
    injectQuestionsViewModel(viewModelModule);
  }

  @Override
  public void inject(Context content) {}

  private QuestionsViewModel injectQuestionsViewModel(QuestionsViewModel instance) {
    QuestionsViewModel_MembersInjector.injectSetRepository(instance, getQuestionsRepository());
    return instance;
  }

  public static final class Builder {
    private NetModule netModule;

    private AppModule appModule;

    private ApiModule apiModule;

    private DaoModule daoModule;

    private RepositoryModule repositoryModule;

    private Builder() {}

    public AppComponent build() {
      if (netModule == null) {
        throw new IllegalStateException(NetModule.class.getCanonicalName() + " must be set");
      }
      if (appModule == null) {
        throw new IllegalStateException(AppModule.class.getCanonicalName() + " must be set");
      }
      if (apiModule == null) {
        this.apiModule = new ApiModule();
      }
      if (daoModule == null) {
        this.daoModule = new DaoModule();
      }
      if (repositoryModule == null) {
        this.repositoryModule = new RepositoryModule();
      }
      return new DaggerAppComponent(this);
    }

    public Builder appModule(AppModule appModule) {
      this.appModule = Preconditions.checkNotNull(appModule);
      return this;
    }

    public Builder netModule(NetModule netModule) {
      this.netModule = Preconditions.checkNotNull(netModule);
      return this;
    }

    public Builder repositoryModule(RepositoryModule repositoryModule) {
      this.repositoryModule = Preconditions.checkNotNull(repositoryModule);
      return this;
    }

    public Builder apiModule(ApiModule apiModule) {
      this.apiModule = Preconditions.checkNotNull(apiModule);
      return this;
    }

    public Builder daoModule(DaoModule daoModule) {
      this.daoModule = Preconditions.checkNotNull(daoModule);
      return this;
    }
  }
}
