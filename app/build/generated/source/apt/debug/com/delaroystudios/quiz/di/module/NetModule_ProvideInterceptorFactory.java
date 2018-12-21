package com.delaroystudios.quiz.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import okhttp3.Interceptor;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NetModule_ProvideInterceptorFactory implements Factory<Interceptor> {
  private final NetModule module;

  public NetModule_ProvideInterceptorFactory(NetModule module) {
    this.module = module;
  }

  @Override
  public Interceptor get() {
    return Preconditions.checkNotNull(
        module.provideInterceptor(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static NetModule_ProvideInterceptorFactory create(NetModule module) {
    return new NetModule_ProvideInterceptorFactory(module);
  }

  public static Interceptor proxyProvideInterceptor(NetModule instance) {
    return Preconditions.checkNotNull(
        instance.provideInterceptor(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
