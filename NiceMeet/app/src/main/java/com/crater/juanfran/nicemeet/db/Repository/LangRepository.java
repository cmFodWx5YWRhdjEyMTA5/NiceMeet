package com.crater.juanfran.nicemeet.db.Repository;


import com.crater.juanfran.nicemeet.db.Dao.LangDao;
import com.crater.juanfran.nicemeet.db.model.Lang;

import java.util.ArrayList;

public class LangRepository {

        private ArrayList<Lang> langs;
        private LangDao dao;

        private static LangRepository repository;

        static {
            repository = new LangRepository();
        }


        private LangRepository() {
            this.langs = new ArrayList<>();
            dao= new LangDao();
        }

        public static LangRepository getInstance() {

            if (repository == null)

                repository = new LangRepository();

            return repository;

        }

        public ArrayList<String> getLangs()
        {
            langs=dao.loadAll();
            ArrayList<String> LangString = new ArrayList<>();
            for (int i=0;i<langs.size();i++)
                LangString.add(langs.get(i).get_name());
            return LangString;
        }
}
