package com.crater.juanfran.nicemeet.utils.api;

import android.net.Uri;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FirebaseAuthClass {

    private static FirebaseAuth mAuth;

    public static void ResetEmail(String email, final FbResetEmailListener listener)
    {   mAuth =  FirebaseAuth.getInstance();
        mAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                        listener.onSucces();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                listener.onError(e);
            }
        });
    }


    public static void SignUpWithEmail(String email, String password, final FirebaseAuthClass.FbSignUpListener listener) {
        mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            listener.onSignUp();
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                listener.onError(e);
            }
        });
    }

    public static void loginWithEmail(String email, String password, final FirebaseAuthClass.FbSignInListener listener) {
        mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            listener.onSignIn();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                listener.onError(e);
            }
        });
    }

    public interface FbResetEmailListener
    {
        void onSucces();
        void onError(Exception e);
    }
    public interface FbSignInListener {
        void onError(Exception e);
        void onSignIn();
    }
    public interface FbSignUpListener {
        void onError(Exception e);
        void onSignUp();
    }

}
