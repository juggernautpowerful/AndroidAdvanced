package com.nechaev.loftcoin;

import android.app.Application;
import android.content.Context;

import com.nechaev.loftcoin.data.DataModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(
    modules = {
          AppModule.class
        , DataModule.class
    }
)
abstract class AppComponent implements  BaseComponent {

    @Component.Builder
    static abstract class Builder {
        @BindsInstance
        abstract Builder application(Application app);

        abstract AppComponent build();
    }

}
