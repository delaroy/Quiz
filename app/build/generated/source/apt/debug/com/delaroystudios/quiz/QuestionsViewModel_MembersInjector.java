package com.delaroystudios.quiz;

import com.delaroystudios.quiz.data.QuestionsRepository;
import com.delaroystudios.quiz.data.network.pojo.QuestionsViewModel;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class QuestionsViewModel_MembersInjector
    implements MembersInjector<QuestionsViewModel> {
  private final Provider<QuestionsRepository> repositoryProvider;

  public QuestionsViewModel_MembersInjector(Provider<QuestionsRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  public static MembersInjector<QuestionsViewModel> create(
      Provider<QuestionsRepository> repositoryProvider) {
    return new QuestionsViewModel_MembersInjector(repositoryProvider);
  }

  @Override
  public void injectMembers(QuestionsViewModel instance) {
    injectSetRepository(instance, repositoryProvider.get());
  }

  public static void injectSetRepository(
      QuestionsViewModel instance, QuestionsRepository repository) {
    instance.setRepository(repository);
  }
}
