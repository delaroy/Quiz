package com.delaroystudios.quiz.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.concurrent.Executor;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RepositoryModule_ProvideExecutorFactory implements Factory<Executor> {
  private final RepositoryModule module;

  public RepositoryModule_ProvideExecutorFactory(RepositoryModule module) {
    this.module = module;
  }

  @Override
  public Executor get() {
    return Preconditions.checkNotNull(
        module.provideExecutor(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static RepositoryModule_ProvideExecutorFactory create(RepositoryModule module) {
    return new RepositoryModule_ProvideExecutorFactory(module);
  }

  public static Executor proxyProvideExecutor(RepositoryModule instance) {
    return Preconditions.checkNotNull(
        instance.provideExecutor(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
