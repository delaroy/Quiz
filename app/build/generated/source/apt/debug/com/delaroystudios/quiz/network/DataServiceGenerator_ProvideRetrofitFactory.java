package com.delaroystudios.quiz.network;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DataServiceGenerator_ProvideRetrofitFactory implements Factory<Retrofit> {
  private final DataServiceGenerator module;

  private final Provider<String> baseURLProvider;

  private final Provider<OkHttpClient> clientProvider;

  public DataServiceGenerator_ProvideRetrofitFactory(
      DataServiceGenerator module,
      Provider<String> baseURLProvider,
      Provider<OkHttpClient> clientProvider) {
    this.module = module;
    this.baseURLProvider = baseURLProvider;
    this.clientProvider = clientProvider;
  }

  @Override
  public Retrofit get() {
    return Preconditions.checkNotNull(
        module.provideRetrofit(baseURLProvider.get(), clientProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static DataServiceGenerator_ProvideRetrofitFactory create(
      DataServiceGenerator module,
      Provider<String> baseURLProvider,
      Provider<OkHttpClient> clientProvider) {
    return new DataServiceGenerator_ProvideRetrofitFactory(module, baseURLProvider, clientProvider);
  }

  public static Retrofit proxyProvideRetrofit(
      DataServiceGenerator instance, String baseURL, OkHttpClient client) {
    return Preconditions.checkNotNull(
        instance.provideRetrofit(baseURL, client),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
