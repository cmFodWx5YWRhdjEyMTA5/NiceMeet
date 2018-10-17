package com.crater.juanfran.nicemeet.ui.Register.Presenter;

import com.crater.juanfran.nicemeet.ui.Register.Contrats.RegisterContract;
import com.crater.juanfran.nicemeet.ui.Register.Interactor.RegisterInteractor;

import java.util.ArrayList;

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
    public void getTags() {
        interactor.getTags();
    }

    @Override
    public void getNationLangs() {
        interactor.getNationLangs();
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
    public void onFirebaseError(Exception e) {
        view.onFirebaseError(e);
    }

    @Override
    public void onPasswordDifferent() {
        view.onPasswordDifferent();
    }

    @Override
    public void setTags(String[] tags) {
        view.setTags(tags);
    }

    @Override
    public void setNationLangs(String[] countries, String[] langs) {
        view.setNationLangs(countries,langs);
    }
}
