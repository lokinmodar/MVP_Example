package br.com.theoldpinkeye.mvpexample;


import org.junit.Before;
import org.junit.Test;

import br.com.theoldpinkeye.mvpexample.login.LoginActivityMVP;
import br.com.theoldpinkeye.mvpexample.login.LoginActivityPresenter;
import br.com.theoldpinkeye.mvpexample.login.User;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by Just Us on 21/11/2017.
 */

public class PresenterTest {
    LoginActivityMVP.Model mockLoginModel;
    LoginActivityMVP.View mockView;
    LoginActivityPresenter presenter;
    User user;

    @Before
    public void setup(){

        mockLoginModel = mock(LoginActivityMVP.Model.class);

        user = new User("Ru", "Paul");

        //when(mockLoginModel.getUser()).thenReturn(user);

        mockView = mock(LoginActivityMVP.View.class);

        presenter = new LoginActivityPresenter(mockLoginModel);

        presenter.setView(mockView);

    }

    @Test
    public void noInteractionWithView(){
        when(mockLoginModel.getUser()).thenReturn(user);
        presenter.getCurrentUser();
        verifyZeroInteractions(mockView);

    }

    @Test
    public void loadTheUserFromTheRepositoryWhenValidUserIsPresent(){
        when(mockLoginModel.getUser()).thenReturn(user);
        presenter.getCurrentUser();

        //verify model interactions
        verify(mockLoginModel, times(1)).getUser();

        //verify view interactions
        verify(mockView, times(1)).setFirstName("Ru");
        verify(mockView, times(1)).setLastName("Paul");
        verify(mockView, never()).showUserNotAvailable();
    }

    @Test
    public void loadTheUserFromTheRepositoryWhenValidUserIsNull(){
        when(mockLoginModel.getUser()).thenReturn(null);
        presenter.getCurrentUser();

        //verify model interactions
        verify(mockLoginModel, times(1)).getUser();

        //verify view interactions
        verify(mockView, never()).setFirstName("Ru");
        verify(mockView, never()).setLastName("Paul");
        verify(mockView, times(1)).showUserNotAvailable();
    }

    @Test
    public void shouldCreateErrorMessageIfFieldsAreEmpty(){

        //Set up the view mock
        when(mockView.getFirstName()).thenReturn(""); // empty string
        presenter.saveUser();

        verify(mockView, times(1)).getFirstName();
        verify(mockView, never()).getLastName();
        verify(mockView, times(1)).showInputError();

        //Now tell mockView to return a value for the first name and empty last name
        when(mockView.getFirstName()).thenReturn("Maria");
        when(mockView.getLastName()).thenReturn("");

        presenter.saveUser();

        verify(mockView, times(2)).getFirstName();
        verify(mockView, times(1)).getLastName();
        verify(mockView, times(2)).showInputError();
    }

    @Test
    public void shouldBeAbleToSaveAValidUser(){
        when(mockView.getFirstName()).thenReturn("Dana");
        when(mockView.getLastName()).thenReturn("Scully");

        presenter.saveUser();

        //Called two more times in the saveUser call
        verify(mockView, times(2)).getFirstName();
        verify(mockView, times(2)).getLastName();

        //Make sure the repository saved the user
        verify(mockLoginModel, times(1)).createUser("Dana", "Scully");

        //Make sure the view showed the user saved message
        verify(mockView, times(1)).showUserSavedMessage();


    }

}
