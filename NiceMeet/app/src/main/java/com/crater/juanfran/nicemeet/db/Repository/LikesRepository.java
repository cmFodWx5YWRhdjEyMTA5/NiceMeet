package com.crater.juanfran.nicemeet.db.Repository;

import com.crater.juanfran.nicemeet.db.Dao.LikeDao;
import com.crater.juanfran.nicemeet.db.model.Likes;

import java.util.ArrayList;

public class LikesRepository {
    private ArrayList<Likes> likes;
    private LikeDao dao;

    private static LikesRepository repository;

    static {
        repository = new LikesRepository();
    }


    private LikesRepository() {
        this.likes = new ArrayList<>();
        dao= new LikeDao();
    }

    public static LikesRepository getInstance() {

        if (repository == null)

            repository = new LikesRepository();

        return repository;

    }

    public ArrayList<String> getLikes()
    {
        likes=dao.loadAll();
        ArrayList<String> tagsString = new ArrayList<>();
        for(int i=0; i<likes.size();i++)
            tagsString.add(likes.get(i).getUidLiker());
        return tagsString;
    }

    public void saveLikes(ArrayList<Likes> likes) {
        dao.saveLikes(likes);
    }

    public void deleteOldLikes() {
        dao.deleteLikes(dao.loadAll());
    }
}
