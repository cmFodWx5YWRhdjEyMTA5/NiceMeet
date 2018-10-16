package com.crater.juanfran.nicemeet.ui.Register.Interactor;

import com.crater.juanfran.nicemeet.ui.Register.Contrats.RegisterContract;
import com.crater.juanfran.nicemeet.utils.api.FirebaseAuthClass;
import com.crater.juanfran.nicemeet.utils.ValidatorsClass;

import java.util.Arrays;

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
    public void getTags() {
        //Acesso a Api o servidor local, depende de como vea la cosa
        String[] tags = new String[]{"Music","Art","Cinematography","Design","Humor","Healt","Politics","Cooking","Reading","Photography","Coding","Travel","Gaming","Tech","Fantasy","Sci-Fi","Illustration","News","Philosophy","Manga/Anime","Writing","Science","Animation","Language","Nature","Vegan","Space","Feminism","Religion","LGBT"};
        Arrays.sort(tags);
        listener.setTags(tags);
    }

    @Override
    public void onError(Exception e) {
        listener.onFirebaseError(e);
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
        void onFirebaseError(Exception e);
        void onPasswordDifferent();

        void setTags(String[] tags);
    }
}
