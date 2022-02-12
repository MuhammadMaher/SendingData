package com.example.sendingdata.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    //Singelton pattern

    private RetrofitClient(){}
    // static --> بيفضل محتفظ بقيمتة طول ماانا فاتح الابليكيشن
    private static Retrofit retrofit;
    public static INewsRequest getRetrofit(){
        if (retrofit==null){
           retrofit=new Retrofit.Builder()
                    .baseUrl("https://newsapi.org")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(INewsRequest.class);
    }
}
