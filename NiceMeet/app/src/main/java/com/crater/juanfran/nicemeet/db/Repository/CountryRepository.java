package com.crater.juanfran.nicemeet.db.Repository;

import com.crater.juanfran.nicemeet.db.Dao.CountryDao;
import com.crater.juanfran.nicemeet.db.model.Country;

import java.util.ArrayList;

public class CountryRepository {
    private ArrayList<Country> Countrys;
    private CountryDao dao;

    private static CountryRepository repository;

    static {
        repository = new CountryRepository();
    }


    private CountryRepository() {
        this.Countrys = new ArrayList<>();
        dao= new CountryDao();
    }

    public static CountryRepository getInstance() {

        if (repository == null)

            repository = new CountryRepository();

        return repository;

    }

    public ArrayList<String> getCountrys()
    {
        Countrys=dao.loadAll();
        ArrayList<String> CountryString = new ArrayList<>();
        for (int i=0;i<Countrys.size();i++)
            CountryString.add(Countrys.get(i).getName());
        return CountryString;
    }
}
