package com.delaroystudios.quiz.di.module;

import android.app.Application;
import com.delaroystudios.quiz.data.database.QuestionsDao;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaoModule_ProvideQuestionsDaoFactory implements Factory<QuestionsDao> {
  private final DaoModule module;

  private final Provider<Application> appProvider;

  public DaoModule_ProvideQuestionsDaoFactory(DaoModule module, Provider<Application> appProvider) {
    this.module = module;
    this.appProvider = appProvider;
  }

  @Override
  public QuestionsDao get() {
    return Preconditions.checkNotNull(
        module.provideQuestionsDao(appProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static DaoModule_ProvideQuestionsDaoFactory create(
      DaoModule module, Provider<Application> appProvider) {
    return new DaoModule_ProvideQuestionsDaoFactory(module, appProvider);
  }

  public static QuestionsDao proxyProvideQuestionsDao(DaoModule instance, Application app) {
    return Preconditions.checkNotNull(
        instance.provideQuestionsDao(app),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
