package com.ahlyclub.omar2.booksapplication.Activity.Activity.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahlyclub.omar2.booksapplication.Activity.Activity.Model.Books;
import com.ahlyclub.omar2.booksapplication.R;
import com.squareup.picasso.Picasso;

public class BooksDetailsActivity extends AppCompatActivity {

    ImageView imageView;
    TextView Title, author, publisher, category, language, country, saleability, descreption;
    Books books;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_details);
        FindID();
        setValues();

    }


    public void setValues() {
        books = (Books) getIntent().getExtras().getSerializable("book");

        Picasso.with(this).load(books.getImage()).into(imageView);
        Title.setText(books.getTitle());
        author.setText(books.getAuthor());
        publisher.setText(books.getPublisher());
        category.setText(books.getCategory());
        language.setText(books.getLanguage());
        country.setText(books.getCountry());
        saleability.setText(books.getSaleability());
        descreption.setText(books.getDescreption());

    }

    public void FindID() {

        imageView = findViewById(R.id.detailsImage);
        Title = findViewById(R.id.detailsTitle);
        author = findViewById(R.id.detailsAuthor);
        publisher = findViewById(R.id.detailsPublisher);
        category = findViewById(R.id.detailsCategory);
        language = findViewById(R.id.detailsLanguage);
        country = findViewById(R.id.detailsCountry);
        saleability = findViewById(R.id.detailsSaleAbility);
        descreption = findViewById(R.id.detailsDescreption);


    }
}
