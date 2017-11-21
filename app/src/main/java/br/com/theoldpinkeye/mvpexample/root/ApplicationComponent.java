package br.com.theoldpinkeye.mvpexample.root;

import javax.inject.Singleton;

import br.com.theoldpinkeye.mvpexample.login.LoginActivity;
import br.com.theoldpinkeye.mvpexample.login.LoginModule;
import dagger.Component;

/**
 * Created by Just Us on 20/11/2017.
 */
@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class})
public interface ApplicationComponent {
    void inject (LoginActivity target);
}
