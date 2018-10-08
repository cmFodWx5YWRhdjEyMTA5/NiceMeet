package com.crater.juanfran.nicemeet.ui.Main.view.Fragments.swipe;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.crater.juanfran.nicemeet.R;
import com.crater.juanfran.nicemeet.db.model.User;

import java.util.List;

public class CardStackAdapter extends BaseAdapter {

    private List<User> listUsers;
    private Context context;

    public CardStackAdapter(List<User> listUsers, Context context)
    {
        this.listUsers=listUsers;
        this.context=context;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = ((Activity)context).getLayoutInflater().inflate(R.layout.card, parent, false);
        TextView textViewCard = (TextView) convertView.findViewById(R.id.textViewCard);
        textViewCard.setText((CharSequence) listUsers.get(position).getUid());
        return convertView;
    }
}
