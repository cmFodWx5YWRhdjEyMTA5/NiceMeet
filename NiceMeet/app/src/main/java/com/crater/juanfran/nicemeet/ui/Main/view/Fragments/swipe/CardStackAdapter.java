package com.crater.juanfran.nicemeet.ui.Main.view.Fragments.swipe;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.crater.juanfran.nicemeet.R;
import com.crater.juanfran.nicemeet.db.model.User;
import com.crater.juanfran.nicemeet.ui.Main.view.MainActivity;
import com.crater.juanfran.nicemeet.ui.profile.ProfileActivity;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CardStackAdapter extends BaseAdapter {

    private List<User> listUsers;
    private Context context;
    AdapterListener listener;

    public CardStackAdapter(List<User> listUsers, Context context,AdapterListener listener)
    {
        this.listUsers=listUsers;
        this.context=context;
        this.listener= listener;
    }
    @Override
    public int getCount() {
        return listUsers.size();
    }

    @Override
    public Object getItem(int position) {
        return listUsers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public String getItemUid(int position)
    {
        return ((User)getItem(position)).getUid();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        convertView = ((Activity)context).getLayoutInflater().inflate(R.layout.card, parent, false);
        TextView textViewCard = (TextView) convertView.findViewById(R.id.textViewCard);
        ImageButton profile = convertView.findViewById(R.id.btnProfile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            listener.onProfile(listUsers.get(position));
            }
        });
        textViewCard.setText((CharSequence) listUsers.get(position).getUid());
        return convertView;
    }
    public interface AdapterListener
    {
        void onProfile(User user);
    }

}
