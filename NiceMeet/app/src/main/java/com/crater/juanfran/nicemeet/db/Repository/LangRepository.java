package com.crater.juanfran.nicemeet.db.Repository;

import com.crater.juanfran.nicemeet.db.Contract.MyContrats;
import com.crater.juanfran.nicemeet.db.Dao.LangDao;
import com.crater.juanfran.nicemeet.db.model.Lang;
import com.crater.juanfran.nicemeet.utils.ThisApplication;
import com.crater.juanfran.nicemeet.utils.prefs.AppPreferencesHelper;

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

        public ArrayList<Lang> getProjects()
        {
            langs=dao.loadAll();
            return langs;
        }
}
