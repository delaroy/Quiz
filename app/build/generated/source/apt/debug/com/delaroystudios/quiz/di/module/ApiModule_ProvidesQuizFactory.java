package com.delaroystudios.quiz.di.module;

import com.delaroystudios.quiz.api.QuizApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiModule_ProvidesQuizFactory implements Factory<QuizApi> {
  private final ApiModule module;

  private final Provider<Retrofit> retrofitProvider;

  public ApiModule_ProvidesQuizFactory(ApiModule module, Provider<Retrofit> retrofitProvider) {
    this.module = module;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public QuizApi get() {
    return Preconditions.checkNotNull(
        module.providesQuiz(retrofitProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ApiModule_ProvidesQuizFactory create(
      ApiModule module, Provider<Retrofit> retrofitProvider) {
    return new ApiModule_ProvidesQuizFactory(module, retrofitProvider);
  }

  public static QuizApi proxyProvidesQuiz(ApiModule instance, Retrofit retrofit) {
    return Preconditions.checkNotNull(
        instance.providesQuiz(retrofit),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
