package com.crater.juanfran.nicemeet.ui.Main.view.Fragments.chat;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.crater.juanfran.nicemeet.R;
import com.crater.juanfran.nicemeet.db.model.Conversation;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MychatRecyclerViewAdapter extends RecyclerView.Adapter<MychatRecyclerViewAdapter.ViewHolder> {

    private final List<Conversation> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MychatRecyclerViewAdapter(List<Conversation> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_chat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.name.setText(mValues.get(position).getNameReciever());
      //  holder.lastMessage.setText(mValues.get(position).getListMessageData().get(mValues.size()-1).text);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView name;
        public final TextView lastMessage;
        public final CircleImageView imageView;
        public Conversation mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            name = (TextView) view.findViewById(R.id.name);
            lastMessage = (TextView) view.findViewById(R.id.lastMessage);
            imageView=view.findViewById(R.id.profile_image);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Conversation mItem);
    }
}
