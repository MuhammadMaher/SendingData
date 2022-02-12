package com.example.sendingdata;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter  extends RecyclerView.Adapter<NewsAdapter.NewsHolder>{
     List<Article>  articleList;

    public NewsAdapter(List<Article> articleList) {
        this.articleList = articleList;
    }



    @Override
    public NewsHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
       NewsHolder newsHolder=new NewsHolder(view);
        return newsHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull  NewsAdapter.NewsHolder holder, int position) {
      Article article =articleList.get(position);
      holder.textViewTitle.setText(article.getTitle());
        Picasso.get().load(article.getImageUrl()).into(holder.imageViewImage);


    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }


    class NewsHolder extends RecyclerView.ViewHolder {
        ImageView imageViewImage;
        TextView textViewTitle;
        public NewsHolder(@NonNull  View itemView) {
            super(itemView);
            imageViewImage=itemView.findViewById(R.id.image);
            textViewTitle=itemView.findViewById(R.id.tv_title);
        }
    }

}
