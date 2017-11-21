package br.com.theoldpinkeye.mvpexample.login;

/**
 * Created by Just Us on 20/11/2017.
 */

public interface LoginActivityMVP {
    interface View {
        String getFirstName();
        String getLastName();

        void showUserNotAvailable();
        void showInputError();
        void showUserSavedMessage();

        void setFirstName(String fname); //para que a view consiga usar esses valores em controles
        void setLastName(String lname);



    }
    interface Presenter {
        void setView(LoginActivityMVP.View view);
        void loginButtonClicked();
        void getCurrentUser();

    }
    interface Model {
        void createUser(String fname, String lname);

        User getUser();


    }
}
