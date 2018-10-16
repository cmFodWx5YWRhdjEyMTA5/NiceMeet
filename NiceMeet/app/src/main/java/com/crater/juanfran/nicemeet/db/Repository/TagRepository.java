package com.crater.juanfran.nicemeet.db.Repository;

import com.crater.juanfran.nicemeet.db.Dao.TagDao;
import com.crater.juanfran.nicemeet.db.model.Tag;

import java.util.ArrayList;

public class TagRepository {
    private ArrayList<Tag> tags;
    private TagDao dao;

    private static TagRepository repository;

    static {
        repository = new TagRepository();
    }


    private TagRepository() {
        this.tags = new ArrayList<>();
        dao= new TagDao();
    }

    public static TagRepository getInstance() {

        if (repository == null)

            repository = new TagRepository();

        return repository;

    }

    public ArrayList<String> getTags()
    {
        tags=dao.loadAll();
        ArrayList<String> tagsString = new ArrayList<>();
        for(int i=0; i<tags.size();i++)
            tagsString.add(tags.get(i).get_name());
        return tagsString;
    }
}
