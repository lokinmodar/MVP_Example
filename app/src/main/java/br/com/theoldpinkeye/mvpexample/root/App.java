package br.com.theoldpinkeye.mvpexample.root;

import android.app.Application;

import br.com.theoldpinkeye.mvpexample.login.LoginModule;

/**
 * Created by Just Us on 20/11/2017.
 */

public class App extends Application{
    private ApplicationComponent component;

    @Override
    public void onCreate(){
        super.onCreate();
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .loginModule(new LoginModule())
                .build();
    }
    public ApplicationComponent getComponent(){
        return component;
    }
}
