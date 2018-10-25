package com.crater.juanfran.nicemeet.ui.Register.Interactor;

import com.crater.juanfran.nicemeet.db.Repository.LangRepository;
import com.crater.juanfran.nicemeet.db.Repository.TagRepository;
import com.crater.juanfran.nicemeet.db.model.User;
import com.crater.juanfran.nicemeet.ui.Register.Contrats.RegisterContract;
import com.crater.juanfran.nicemeet.utils.api.FirebaseAuthClass;
import com.crater.juanfran.nicemeet.utils.ValidatorsClass;

import java.util.ArrayList;

public class RegisterInteractor implements RegisterContract.Interactor, FirebaseAuthClass.FbSignUpListener {
    RegisterListener listener;
    public RegisterInteractor(RegisterListener listener) {
        this.listener=listener;
    }

    @Override
    public void getTags() {
       ArrayList<String> tags= TagRepository.getInstance().getTags();
        String [] tagsArray = tags.toArray(new String[tags.size()]);
        listener.setTags(tagsArray);
    }

    @Override
    public void saveUser(User usuarioRegistrando) {
        listener.onSuccess();
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
