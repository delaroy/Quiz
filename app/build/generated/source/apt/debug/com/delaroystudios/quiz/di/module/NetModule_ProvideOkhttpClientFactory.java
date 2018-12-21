package com.delaroystudios.quiz.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NetModule_ProvideOkhttpClientFactory implements Factory<OkHttpClient> {
  private final NetModule module;

  private final Provider<Cache> cacheProvider;

  private final Provider<Interceptor> interceptorProvider;

  public NetModule_ProvideOkhttpClientFactory(
      NetModule module, Provider<Cache> cacheProvider, Provider<Interceptor> interceptorProvider) {
    this.module = module;
    this.cacheProvider = cacheProvider;
    this.interceptorProvider = interceptorProvider;
  }

  @Override
  public OkHttpClient get() {
    return Preconditions.checkNotNull(
        module.provideOkhttpClient(cacheProvider.get(), interceptorProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static NetModule_ProvideOkhttpClientFactory create(
      NetModule module, Provider<Cache> cacheProvider, Provider<Interceptor> interceptorProvider) {
    return new NetModule_ProvideOkhttpClientFactory(module, cacheProvider, interceptorProvider);
  }

  public static OkHttpClient proxyProvideOkhttpClient(
      NetModule instance, Cache cache, Interceptor interceptor) {
    return Preconditions.checkNotNull(
        instance.provideOkhttpClient(cache, interceptor),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
