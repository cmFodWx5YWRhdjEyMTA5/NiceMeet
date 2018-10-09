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
    public static MyFirebaseUser AccessUserInfo()
    {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
           MyFirebaseUser myuser= new MyFirebaseUser();
           myuser.setName(user.getDisplayName());
           myuser.setEmail(user.getEmail());
           myuser.setPhotoUrl(user.getPhotoUrl());
           myuser.setEmailVerified(user.isEmailVerified());
           myuser.setUid(user.getUid());
            return myuser;
        }
        return null;

    }
    static class MyFirebaseUser
    {
        String name;
        String email;
        Uri photoUrl;
        boolean emailVerified;
        String uid;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Uri getPhotoUrl() {
            return photoUrl;
        }

        public void setPhotoUrl(Uri photoUrl) {
            this.photoUrl = photoUrl;
        }

        public boolean isEmailVerified() {
            return emailVerified;
        }

        public void setEmailVerified(boolean emailVerified) {
            this.emailVerified = emailVerified;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }
    }
}