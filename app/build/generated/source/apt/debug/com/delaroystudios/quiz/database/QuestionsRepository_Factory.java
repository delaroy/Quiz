package com.delaroystudios.quiz.database;

import com.delaroystudios.quiz.api.QuizApi;
import com.delaroystudios.quiz.data.QuestionsRepository;
import com.delaroystudios.quiz.data.database.QuestionsDao;

import dagger.internal.Factory;
import java.util.concurrent.Executor;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class QuestionsRepository_Factory implements Factory<QuestionsRepository> {
  private final Provider<QuizApi> apiProvider;

  private final Provider<QuestionsDao> daoProvider;

  private final Provider<Executor> executorProvider;

  public QuestionsRepository_Factory(
      Provider<QuizApi> apiProvider,
      Provider<QuestionsDao> daoProvider,
      Provider<Executor> executorProvider) {
    this.apiProvider = apiProvider;
    this.daoProvider = daoProvider;
    this.executorProvider = executorProvider;
  }

  @Override
  public QuestionsRepository get() {
    return new QuestionsRepository(apiProvider.get(), daoProvider.get(), executorProvider.get());
  }

  public static QuestionsRepository_Factory create(
      Provider<QuizApi> apiProvider,
      Provider<QuestionsDao> daoProvider,
      Provider<Executor> executorProvider) {
    return new QuestionsRepository_Factory(apiProvider, daoProvider, executorProvider);
  }
}
