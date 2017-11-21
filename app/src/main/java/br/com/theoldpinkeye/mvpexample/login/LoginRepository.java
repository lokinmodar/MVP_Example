package br.com.theoldpinkeye.mvpexample.login;

/**
 * Created by Just Us on 20/11/2017.
 */

public interface LoginRepository {

    User getUser();
    void saveUser(User user);

}
