package com.crater.juanfran.nicemeet.ui.Main.view.Fragments.swipe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crater.juanfran.nicemeet.R;
import com.crater.juanfran.nicemeet.db.model.User;
import com.crater.juanfran.nicemeet.ui.profile.ProfileActivity;

import java.util.ArrayList;

import link.fls.swipestack.SwipeStack;


public class SwipeFragment extends Fragment implements SwipeStack.SwipeStackListener, CardStackAdapter.AdapterListener {

    private SwipeFragmentInteractionListener mListener;
    private ArrayList<User> mData;
    CardStackAdapter cardStackAdapter;
    SwipeStack swipeStack;
    public SwipeFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mData=new ArrayList<>();
        mData.add(new User("aa","aa","aa","aa",null,"aa",0,"aa",0,"aa",0));
        mData.add(new User("aa","aa","aa","aa",null,"aa",0,"aa",0,"aa",0));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        cardStackAdapter=new CardStackAdapter(mData,(Context) mListener,this);
        View view = inflater.inflate(R.layout.fragment_swipe, container, false);
        swipeStack = (SwipeStack) view.findViewById(R.id.swipeStack);
        swipeStack.setAdapter(cardStackAdapter);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (SwipeFragmentInteractionListener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onViewSwipedToLeft(int position) {
        mListener.onNotSwipe(mData.get(position).getUid());
    }

    @Override
    public void onViewSwipedToRight(int position) {
        mListener.onSwipe(mData.get(position).getUid());
    }

    @Override
    public void onStackEmpty() {
    }

    @Override
    public void onProfile(User user) {
       mListener.onClickProfile(user);
    }

    @Override
    public void onLike(String uid) {
        mListener.onSwipe(uid);
        swipeStack.swipeTopViewToRight();
    }

    @Override
    public void onDisLike(String uid) {
        mListener.onNotSwipe(uid);
        swipeStack.swipeTopViewToLeft();
    }

    public interface SwipeFragmentInteractionListener {
        void onSwipe(String uid);
        void onClickProfile(User user);

        void onNotSwipe(String uid);
    }
}
