package com.ahlyclub.omar2.booksapplication.Activity.Activity.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahlyclub.omar2.booksapplication.Activity.Activity.Activity.BooksDetailsActivity;
import com.ahlyclub.omar2.booksapplication.Activity.Activity.Model.Books;
import com.ahlyclub.omar2.booksapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.MyViewHolder>  {

    Context context;
    ArrayList<Books> books;

    public BooksAdapter(Context context, ArrayList<Books> books) {
        this.context = context;
        this.books = books;
    }

    @Override
    public BooksAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.books_items , parent ,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        Picasso.with(context)
                .load(books.get(position).getImage())
                .into(holder.imageView);


        holder.title.setText(books.get(position).getTitle());
        holder.subtitle.setText(books.get(position).getSubtitile());
        holder.publishDate.setText(books.get(position).getPublishDate());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BooksDetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("book",books.get(position));
                intent.putExtras(bundle);
                context.startActivity(intent);
              }
        });



    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        CardView cardView;
        TextView title , subtitle , publishDate;
        public MyViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.myImageView);
            title = itemView.findViewById(R.id.myTitle);
            subtitle = itemView.findViewById(R.id.subTitle);
            publishDate = itemView.findViewById(R.id.date);
            cardView = itemView.findViewById(R.id.myCardView);

        }
    }
}
