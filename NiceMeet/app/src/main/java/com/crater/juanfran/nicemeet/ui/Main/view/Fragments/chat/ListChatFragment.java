package com.crater.juanfran.nicemeet.ui.Main.view.Fragments.chat;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crater.juanfran.nicemeet.R;
import com.crater.juanfran.nicemeet.db.model.Conversation;
import com.crater.juanfran.nicemeet.db.model.Message;

import java.util.ArrayList;

import static android.widget.GridLayout.HORIZONTAL;

public class ListChatFragment extends Fragment implements MychatRecyclerViewAdapter.OnListFragmentInteractionListener{

    private OnListChatInteractionListener mListener;
    ArrayList<Conversation> conversations;
    public ListChatFragment() {

    }

    public static ListChatFragment newInstance(ArrayList<Conversation> conversations) {
        ListChatFragment fragment = new ListChatFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList("conversations", conversations);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            conversations = getArguments().getParcelableArrayList("conversations");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_chat_list,container,false);
        RecyclerView list= view.findViewById(R.id.list);
        DividerItemDecoration itemDecor = new DividerItemDecoration((Context) mListener, HORIZONTAL);
        list.addItemDecoration(itemDecor);
        ArrayList<Conversation> conversations=new ArrayList<Conversation>();
        Conversation conversation = new Conversation();
        conversation.getListMessageData().add(new Message());
        conversations.add(conversation);
        MychatRecyclerViewAdapter adapter= new MychatRecyclerViewAdapter(conversations,this);
        list.setAdapter(adapter);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListChatInteractionListener) {
            mListener = (OnListChatInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onListFragmentInteraction(Conversation mItem) {
        mListener.onItemClickInteraction(mItem.getUidReciever());
    }

    public interface OnListChatInteractionListener {
        void onItemClickInteraction(String uid);
    }
}
