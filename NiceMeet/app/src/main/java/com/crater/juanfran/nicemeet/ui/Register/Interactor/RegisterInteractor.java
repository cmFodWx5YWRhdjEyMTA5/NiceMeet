package com.crater.juanfran.nicemeet.ui.Register.Interactor;

import com.crater.juanfran.nicemeet.ui.Register.Contrats.RegisterContract;
import com.crater.juanfran.nicemeet.utils.api.FirebaseAuthClass;
import com.crater.juanfran.nicemeet.utils.ValidatorsClass;

public class RegisterInteractor implements RegisterContract.Interactor, FirebaseAuthClass.FbSignUpListener {
    RegisterListener listener;
    public RegisterInteractor(RegisterListener listener) {
        this.listener=listener;
    }

    @Override
    public void signIn( final String password,final String passwordAgain, final String email) {
        if(password.equals(passwordAgain)) {

            if (password.isEmpty()) {

                listener.onPasswordEmptyError();

            } else if (email.isEmpty()) {

                listener.onEmailEmptyError();

            } else if (password.length() < 6) {

                listener.onPasswordError();

            } else if (!ValidatorsClass.validateEmail(email)) {

                listener.onEmailError();

            } else {

                FirebaseAuthClass.SignUpWithEmail(email,password,this);

            }
        }else {
            listener.onPasswordDifferent();
        }
    }

    @Override
    public void onError() {
        listener.onFirebaseError();
    }

    @Override
    public void onSignUp() {
        listener.onSuccess();
    }

    public interface RegisterListener
    {
        void onSuccess();
        void onPasswordEmptyError();
        void onEmailEmptyError();
        void onPasswordError();
        void onEmailError();
        void onFirebaseError();
        void onPasswordDifferent();
    }
}
