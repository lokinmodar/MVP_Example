package br.com.theoldpinkeye.mvpexample.root;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Just Us on 20/11/2017.
 */
@Module
public class ApplicationModule {

    private Application application;
    public ApplicationModule(Application application){
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideContent(){
        return application;
    }
}
