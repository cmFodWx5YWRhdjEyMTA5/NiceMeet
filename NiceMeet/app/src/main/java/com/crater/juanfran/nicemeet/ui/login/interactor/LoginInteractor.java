package com.crater.juanfran.nicemeet.ui.login.interactor;

import com.crater.juanfran.nicemeet.utils.ErrorsClass;
import com.crater.juanfran.nicemeet.utils.ValidatorsClass;
import com.crater.juanfran.nicemeet.utils.api.FirebaseAuthClass;
import com.crater.juanfran.nicemeet.ui.login.contract.LoginContract;

public class LoginInteractor implements LoginContract.interactor, FirebaseAuthClass.FbSignInListener {

    private final LoginInteractorListener listener;

    public LoginInteractor(LoginInteractorListener listener) {
        this.listener=listener;
    }

    @Override
    public void SignIn(String email, String password) {
        listener.onStartProgress();
        if(ValidatorsClass.validateEmail(email)) {
            if(!password.isEmpty()){
                FirebaseAuthClass.loginWithEmail(email, password, this);
            }else{
                listener.onError(ErrorsClass.PASSWORDISEMPTY);
            }
        }else {
            listener.onError(ErrorsClass.EMAILNOTVALID);
        }
    }

    @Override
    public void onError(Exception e) {
        listener.onErrorFirebase(e.getMessage());
    }


    @Override
    public void onSignIn() {
        listener.onAccess();
    }

    public interface LoginInteractorListener
    {
        void onError(int codError);
        void onErrorFirebase(String error);
        void onAccess();

        void onStartProgress();
    }
}
