package com.crater.juanfran.nicemeet.ui.Register.View.fragments.Tags;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.crater.juanfran.nicemeet.R;
import com.crater.juanfran.nicemeet.db.model.User;
import com.crater.juanfran.nicemeet.ui.Register.View.RegisterActivity;
import com.crater.juanfran.nicemeet.utils.CustomView;

import java.util.ArrayList;
import java.util.List;


public class LastRegisterFragment extends Fragment {

    private OnTagsRegisterListener mListener;
    private String[] tags;
    private ArrayList<String> selectedTags;
    private GridView gridView;

    public LastRegisterFragment()
    {
        
    }

    public static Fragment newInstance(User usuarioRegistrando,String[] tags) {
        LastRegisterFragment fragment = new LastRegisterFragment();
        Bundle args = new Bundle();
        args.putStringArray("tags",tags);
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tags=getArguments().getStringArray("tags");
        selectedTags = new ArrayList<String>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register_tags, container, false);
        gridView = (GridView) v.findViewById(R.id.gridTags);
        fillTags(tags);
        return v;
    }
    private void fillTags(final String[] tags)
    {
        this.tags=tags;
        final CustomAdapter adapter = new CustomAdapter((tags));
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                int selectedIndex = adapter.selectedPositions.indexOf(position);
                if (selectedIndex > -1) {
                    adapter.selectedPositions.remove(selectedIndex);
                    ((CustomView)v).display(false);
                    selectedTags.remove(tags[position]);
                } else {
                    adapter.selectedPositions.add(position);
                    ((CustomView)v).display(true);
                    selectedTags.add(tags[position]);
                }

            }
        });
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnTagsRegisterListener) {
            mListener = (OnTagsRegisterListener) context;
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
    public void onDestroy() {
        mListener.saveTags(selectedTags);
        super.onDestroy();

    }

    public interface OnTagsRegisterListener {
        void saveTags(ArrayList<String> tags);
    }


    public class CustomAdapter extends BaseAdapter {
        private String[] strings;
        public List<Integer> selectedPositions = new ArrayList<>();

        public CustomAdapter(String[] strings) {
            this.strings = strings;
        }

        @Override
        public int getCount() {
            return strings.length;
        }

        @Override
        public Object getItem(int position) {
            return strings[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            CustomView customView = (convertView == null) ? new CustomView((Context) mListener) : (CustomView) convertView;
            customView.display(strings[position], selectedPositions.contains(position));
            return customView;
        }
    }
}
