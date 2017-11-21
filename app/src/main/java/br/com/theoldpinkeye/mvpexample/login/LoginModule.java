package br.com.theoldpinkeye.mvpexample.login;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Just Us on 20/11/2017.
 */
@Module
public class LoginModule {
    @Provides
    public LoginActivityMVP.Presenter provideLoginActivityPresenter(LoginActivityMVP.Model model){
        return new LoginActivityPresenter(model);
    }

    @Provides
    public LoginActivityMVP.Model providesLoginActivityModel(LoginRepository repository){
    return new LoginModel(repository);
    }

    @Provides
    public LoginRepository provideLoginRepository(){
        return new MemoryRepository();
    }
}
