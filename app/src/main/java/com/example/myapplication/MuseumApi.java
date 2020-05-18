package com.example.myapplication;

import com.example.myapplication.database.Group;
import com.example.myapplication.database.Object;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MuseumApi {

    @GET("groups/{id}")
    Call<Group> getGroup(@Path("id")int id);

    @GET("objects/{id}")
    Call<Object> getObject(@Path("id")int id);

}
