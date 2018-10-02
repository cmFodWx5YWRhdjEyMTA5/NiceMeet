package com.crater.juanfran.nicemeet.api;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.crater.juanfran.nicemeet.login.view.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.support.constraint.Constraints.TAG;

public class FirebaseAuthClass {

    private static FirebaseAuth mAuth;

    public static void SignUpWithEmail(String email, String password, final FirebaseAuthClass.FbListener listener) {
        mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            listener.onSignUp();
                        } else {
                            listener.onError();
                        }

                        // ...
                    }
                });
    }

    public static void loginWithEmail(String email, String password, final FirebaseAuthClass.FbListener listener) {
        mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            listener.onSignIn();
                        } else {
                            listener.onError();
                        }
                    }
                });
    }

    public interface FbListener {
        void onError();//TODO Asignar una lista de errores para enviar por el listener
        void onSignUp();
        void onSignIn();
    }
}
