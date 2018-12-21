package com.delaroystudios.quiz.di.module;

import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NetModule_ProvideGsonFactory implements Factory<Gson> {
  private final NetModule module;

  public NetModule_ProvideGsonFactory(NetModule module) {
    this.module = module;
  }

  @Override
  public Gson get() {
    return Preconditions.checkNotNull(
        module.provideGson(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static NetModule_ProvideGsonFactory create(NetModule module) {
    return new NetModule_ProvideGsonFactory(module);
  }

  public static Gson proxyProvideGson(NetModule instance) {
    return Preconditions.checkNotNull(
        instance.provideGson(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
