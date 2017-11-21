package br.com.theoldpinkeye.mvpexample.login;

import android.support.annotation.Nullable;

/**
 * Created by Just Us on 20/11/2017.
 */

public class LoginActivityPresenter implements LoginActivityMVP.Presenter {
    @Nullable
    private LoginActivityMVP.View view;
    private LoginActivityMVP.Model model;

    public LoginActivityPresenter(LoginActivityMVP.Model model) {
        this.model = model;
    }

    public void setView(LoginActivityMVP.View view) {
        this.view = view;
    }

    @Override
    public void loginButtonClicked() {
        if (view != null){
            if (view.getFirstName().trim().equals("") || view.getLastName().trim().equals("")){
                view.showInputError();
            } else {
                model.createUser(view.getFirstName(), view.getLastName());
                view.showUserSavedMessage();
            }
        }

    }

    @Override
    public void getCurrentUser() {
        User user = model.getUser();
        if (user == null){
            if (view != null){
                view.showUserNotAvailable();
            }
        } else {
            if (view != null) {
                view.setFirstName(user.getFirstName());
                view.setLastName(user.getLastName());
            }
        }

    }
}
