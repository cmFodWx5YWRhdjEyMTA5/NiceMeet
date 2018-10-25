package com.crater.juanfran.nicemeet.ui.Register.View.fragments.NationLang;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.crater.juanfran.nicemeet.R;
import com.crater.juanfran.nicemeet.db.model.User;
import com.mukesh.countrypicker.Country;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;


public class NationLangRegisterFragment extends Fragment {
    private OnNatioLangRegisterListener mListener;
    User usuarioRegistrando;
    EditText edtNation;
    TextView textContinua;
    private ListView lv;
    private CustomAdapter customAdapter;
    private Set<String> languages= new HashSet<String>();
    private ArrayList<Language> languagesList=new ArrayList<>();
    private ArrayList<String> languagesArrayList=new ArrayList<>();
    private boolean nationElegida=false;

    public NationLangRegisterFragment()
    {

    }

    public static Fragment newInstance(User usuarioRegistrando) {
        NationLangRegisterFragment fragment = new NationLangRegisterFragment();
        Bundle args = new Bundle();
        args.putParcelable("user",usuarioRegistrando);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usuarioRegistrando= getArguments().getParcelable("user");
        for (Locale locale:Locale.getAvailableLocales()) {
            languages.add(locale.getDisplayLanguage(Locale.ENGLISH).split("\\(")[0]);
        }
        List< String > list = new ArrayList< String >( languages );
        Collections.sort( list );
        for(String name: list) {
            if(usuarioRegistrando.getLanguages().contains(name))
            {
                languagesList.add(new Language(true, name));
            }else{
                languagesList.add(new Language(false,name));
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register_nala, container, false);
        edtNation=v.findViewById(R.id.edtNation);
        if(!usuarioRegistrando.getNation().isEmpty()) {
            edtNation.setText(usuarioRegistrando.getNation());
            nationElegida=true;
        }
        textContinua=v.findViewById(R.id.txtContinua);
        textContinua.setText(getResources().getString(R.string.almostthere)+" "+usuarioRegistrando.getName());
        edtNation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.openDialogNL();
            }
        });
        lv = v.findViewById(R.id.lv);
       customAdapter = new CustomAdapter((Context) mListener,languagesList);
        lv.setAdapter(customAdapter);

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnNatioLangRegisterListener) {
            mListener = (OnNatioLangRegisterListener) context;
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
    public void onPause() {
        super.onPause();
        languagesArrayList.clear();
        for (int i = 0; i < CustomAdapter.modelArrayList.size(); i++){
            if(CustomAdapter.modelArrayList.get(i).getSelected()) {
               languagesArrayList.add(CustomAdapter.modelArrayList.get(i).getName());
            }
        }
     mListener.saveNL(languagesArrayList,usuarioRegistrando.getNation());
    }

    public void saveCountry(Country country) {
        usuarioRegistrando.setNation(country.getName());
        edtNation.setText(country.getName());
        nationElegida=true;
    }

    public boolean dataCorrect() {
        if(nationElegida) {
            for (int i = 0; i < CustomAdapter.modelArrayList.size(); i++) {
                if (CustomAdapter.modelArrayList.get(i).getSelected()) {
                    return true;
                }
            }
        }
        return false;
    }

    public interface OnNatioLangRegisterListener {
        void saveNL(ArrayList<String> langs, String nati);
        void openDialogNL();
    }

    public class Language {

        private boolean isSelected;
        private String name;

        public Language(boolean isSelected, String name) {
            this.isSelected = isSelected;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean getSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }
    }

}
