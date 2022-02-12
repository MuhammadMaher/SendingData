package com.example.sendingdata.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sendingdata.NewsAdapter;
import com.example.sendingdata.NewsResponse;
import com.example.sendingdata.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.sendingdata.Network.RetrofitClient.getRetrofit;


public class TechnologyFragment extends Fragment {
    private static final String TAG = "MainActivity";
    RecyclerView recyclerViewNews;
    NewsAdapter newsAdapter;
    private String Category;
    public TechnologyFragment(String technology) {
    }

    //https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=b096c75fdf394e5ea57d0580cdc73e6a

    // BaseUrl: https://newsapi.org --> RetrofitObject

    //EndPoint: v2/top-headlines?country=us&category=business&apiKey=b096c75fdf394e5ea57d0580cdc73e6a
    // --> Interface --> abstract function();




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return  inflater.inflate(R.layout.fragment_technology, container, false);

    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewNews=view.findViewById(R.id.rv_news);


//        Retrofit retrofit=new Retrofit.Builder()
//                .baseUrl("https://newsapi.org")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        // عاوز اربط ال baseurl بال endpoint
//
        //   INewsRequest iNewsRequest= retrofit.create(INewsRequest.class);

        // هكلم السريفر عشان يرجع داتا
        // iNewsRequest.getNews().enqueue(new Callback<NewsResponse>() {
        getRetrofit().getNews("eg",Category).enqueue(new Callback<NewsResponse>() {

            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.isSuccessful()&& response.body()!=null){

                    NewsResponse newsResponse= response.body();

                    Log.i(TAG, "onResponse: "+newsResponse.toString());

                    newsAdapter=new NewsAdapter(newsResponse.getArticles());

                    recyclerViewNews.setAdapter(newsAdapter);
                }
            }
            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                String errorMessage = t.getLocalizedMessage();
            }
        });
    }

        }



