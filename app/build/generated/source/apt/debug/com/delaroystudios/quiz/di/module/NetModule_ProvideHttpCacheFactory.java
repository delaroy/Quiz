package com.delaroystudios.quiz.di.module;

import android.app.Application;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.Cache;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NetModule_ProvideHttpCacheFactory implements Factory<Cache> {
  private final NetModule module;

  private final Provider<Application> applicationProvider;

  public NetModule_ProvideHttpCacheFactory(
      NetModule module, Provider<Application> applicationProvider) {
    this.module = module;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public Cache get() {
    return Preconditions.checkNotNull(
        module.provideHttpCache(applicationProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static NetModule_ProvideHttpCacheFactory create(
      NetModule module, Provider<Application> applicationProvider) {
    return new NetModule_ProvideHttpCacheFactory(module, applicationProvider);
  }

  public static Cache proxyProvideHttpCache(NetModule instance, Application application) {
    return Preconditions.checkNotNull(
        instance.provideHttpCache(application),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
