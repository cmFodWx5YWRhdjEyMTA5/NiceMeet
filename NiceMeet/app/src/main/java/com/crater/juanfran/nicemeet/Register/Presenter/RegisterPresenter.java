package com.crater.juanfran.nicemeet.Register.Presenter;

import com.crater.juanfran.nicemeet.Register.Contrats.RegisterContract;
import com.crater.juanfran.nicemeet.Register.Interactor.RegisterInteractor;

public class RegisterPresenter implements RegisterContract.Presenter ,RegisterInteractor.RegisterListener{

    RegisterContract.Interactor interactor;
    RegisterContract.View view;

    public RegisterPresenter(RegisterContract.View view) {
        this.interactor = new RegisterInteractor(this);
        this.view=view;
    }

    @Override
    public void validateCredentials( String password,String passwordAgain, String email) {
        interactor.signIn(password,passwordAgain,email);
    }

    @Override
    public void onSuccess() {
        view.onSuccess();
    }
    @Override
    public void onPasswordEmptyError() {
        view.onPasswordEmptyError();
    }

    @Override
    public void onEmailEmptyError() {
        view.onEmailEmptyError();
    }

    @Override
    public void onPasswordError() {
        view.onPasswordError();
    }

    @Override
    public void onEmailError() {
        view.onEmailError();
    }

    @Override
    public void onFirebaseError() {
        view.onFirebaseError();
    }

    @Override
    public void onPasswordDifferent() {
        view.onPasswordDifferent();
    }
}
