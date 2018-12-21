package com.delaroystudios.quiz.network;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DataServiceGenerator_ProvideApiServiceFactory implements Factory<Service> {
  private final DataServiceGenerator module;

  public DataServiceGenerator_ProvideApiServiceFactory(DataServiceGenerator module) {
    this.module = module;
  }

  @Override
  public Service get() {
    return Preconditions.checkNotNull(
        module.provideApiService(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static DataServiceGenerator_ProvideApiServiceFactory create(DataServiceGenerator module) {
    return new DataServiceGenerator_ProvideApiServiceFactory(module);
  }

  public static Service proxyProvideApiService(DataServiceGenerator instance) {
    return Preconditions.checkNotNull(
        instance.provideApiService(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
