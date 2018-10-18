package com.crater.juanfran.nicemeet.utils.api;

import com.crater.juanfran.nicemeet.db.model.Likes;
import com.crater.juanfran.nicemeet.db.model.User;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {
    @GET("api/likes")
    Call<ArrayList<Likes>> getLikes(String uid);

    @POST("api/likes")
    Call<Likes> createLike(@Body Likes like);

    @PUT("api/users/{uid}")
    Call<User> updateuser(@Body User user, @Path("uid") int uid);

    @DELETE("api/users/{uid}")
    Call<ResponseBody> deleteUser(@Path("uid") int uid);
}
