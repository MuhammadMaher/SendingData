package com.example.sendingdata.Network;


import com.example.sendingdata.NewsResponse;
import com.example.sendingdata.Register;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface INewsRequest {


//@GET(" v2/top-headlines?country=eg&category=business&apiKey=b096c75fdf394e5ea57d0580cdc73e6a")
//    Call<NewsResponse> getNews();

    @GET(" v2/top-headlines?apiKey=b096c75fdf394e5ea57d0580cdc73e6a")
    Call<NewsResponse> getNews(
            @Query("country")String country,
            @Query("category")String category
    );


// --------------------------

    //1-Login
    @POST("login")
    Call<Object> newsLogin(
            @Field("email") String email,
            @Field("password")String password
    );
    //2-Register
    @POST("register")
    Call<Object> register(
            @Body Register register
    );

    //3-Authorization
    @GET("notes")
    Call<Object> Authorization(
            @Header("Authorization")String token

    );
    @GET("notes/delete/{noteId}")
    Call<Object> delete(
            @Header("Authorization") String token,
            @Path ("noteId") String noteId
    );



}
