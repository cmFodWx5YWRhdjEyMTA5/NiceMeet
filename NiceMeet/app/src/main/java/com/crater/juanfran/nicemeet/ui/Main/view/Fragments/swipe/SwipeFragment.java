package com.crater.juanfran.nicemeet.ui.Main.view.Fragments.swipe;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crater.juanfran.nicemeet.R;
import com.crater.juanfran.nicemeet.db.model.User;

import java.util.ArrayList;

import link.fls.swipestack.SwipeStack;


public class SwipeFragment extends Fragment implements SwipeStack.SwipeStackListener {

    private SwipeFragmentInteractionListener mListener;
    private ArrayList<User> mData;
    CardStackAdapter cardStackAdapter;

    public SwipeFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mData=new ArrayList<>();
        mData.add(new User());
        mData.add(new User());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        cardStackAdapter=new CardStackAdapter(mData,(Context) mListener);
        View view = inflater.inflate(R.layout.fragment_swipe, container, false);
        SwipeStack swipeStack = (SwipeStack) view.findViewById(R.id.swipeStack);
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

    }

    @Override
    public void onViewSwipedToRight(int position) {
        mListener.onSwipe(mData.get(position).getUid());
    }

    @Override
    public void onStackEmpty() {
        mData.add(new User());
        mData.add(new User());
        cardStackAdapter.notifyDataSetChanged();
    }

    public interface SwipeFragmentInteractionListener {
        void onSwipe(String uid);
        void onClickProfile(User user);
    }
}
