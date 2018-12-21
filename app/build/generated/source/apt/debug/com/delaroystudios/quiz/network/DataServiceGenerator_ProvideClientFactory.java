package com.delaroystudios.quiz.network;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import okhttp3.OkHttpClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DataServiceGenerator_ProvideClientFactory implements Factory<OkHttpClient> {
  private final DataServiceGenerator module;

  public DataServiceGenerator_ProvideClientFactory(DataServiceGenerator module) {
    this.module = module;
  }

  @Override
  public OkHttpClient get() {
    return Preconditions.checkNotNull(
        module.provideClient(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static DataServiceGenerator_ProvideClientFactory create(DataServiceGenerator module) {
    return new DataServiceGenerator_ProvideClientFactory(module);
  }

  public static OkHttpClient proxyProvideClient(DataServiceGenerator instance) {
    return Preconditions.checkNotNull(
        instance.provideClient(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
