package com.crater.juanfran.nicemeet.Main.Fragments.swipe;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crater.juanfran.nicemeet.R;
import com.crater.juanfran.nicemeet.model.User;

import java.util.ArrayList;
import java.util.List;

import link.fls.swipestack.SwipeStack;


public class SwipeFragment extends Fragment implements SwipeStack.SwipeStackListener {

    private SwipeFragmentInteractionListener mListener;
    private ArrayList<User> mData;

    public SwipeFragment() {

    }

    public static SwipeFragment newInstance() {
        SwipeFragment fragment = new SwipeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mData=new ArrayList<>();
        mData.add(new User());
        mData.add(new User());
        mData.add(new User());
        mData.add(new User());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_swipe, container, false);
        SwipeStack swipeStack = (SwipeStack) view.findViewById(R.id.swipeStack);
        swipeStack.setAdapter(new CardStackAdapter(mData,(Context) mListener));
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SwipeFragmentInteractionListener) {
            mListener = (SwipeFragmentInteractionListener) context;
        } else {
//
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onViewSwipedToLeft(int position) {

    }

    @Override
    public void onViewSwipedToRight(int position) {
        mListener.onSwipe(mData.get(position).getUid());
    }

    @Override
    public void onStackEmpty() {

    }

    public interface SwipeFragmentInteractionListener {
        void onSwipe(String uid);
        void onClickProfile(String uid);
    }
}
