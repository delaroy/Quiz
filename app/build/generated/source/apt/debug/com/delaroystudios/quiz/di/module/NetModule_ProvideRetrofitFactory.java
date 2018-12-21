package com.delaroystudios.quiz.di.module;

import com.google.gson.Gson;
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
public final class NetModule_ProvideRetrofitFactory implements Factory<Retrofit> {
  private final NetModule module;

  private final Provider<Gson> gsonProvider;

  private final Provider<OkHttpClient> okHttpClientProvider;

  public NetModule_ProvideRetrofitFactory(
      NetModule module, Provider<Gson> gsonProvider, Provider<OkHttpClient> okHttpClientProvider) {
    this.module = module;
    this.gsonProvider = gsonProvider;
    this.okHttpClientProvider = okHttpClientProvider;
  }

  @Override
  public Retrofit get() {
    return Preconditions.checkNotNull(
        module.provideRetrofit(gsonProvider.get(), okHttpClientProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static NetModule_ProvideRetrofitFactory create(
      NetModule module, Provider<Gson> gsonProvider, Provider<OkHttpClient> okHttpClientProvider) {
    return new NetModule_ProvideRetrofitFactory(module, gsonProvider, okHttpClientProvider);
  }

  public static Retrofit proxyProvideRetrofit(
      NetModule instance, Gson gson, OkHttpClient okHttpClient) {
    return Preconditions.checkNotNull(
        instance.provideRetrofit(gson, okHttpClient),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
