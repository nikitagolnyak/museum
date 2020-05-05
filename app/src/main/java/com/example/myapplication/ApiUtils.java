package com.example.myapplication;

import com.google.gson.Gson;

import retrofit2.Retrofit;

public class ApiUtils {
    private static Retrofit retrofit;
    private static Gson gson;
    private static MuseumApi api;


    public static Retrofit getRetrofit() {
        if (gson == null) {
            gson = new Gson();
        }
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.SERVER_URL)
                    .build();
        }
        return retrofit;
    }

    public static MuseumApi getApi() {
        if (api == null) {
            api = getRetrofit().create(MuseumApi.class);
        }
        return api;
    }

}
