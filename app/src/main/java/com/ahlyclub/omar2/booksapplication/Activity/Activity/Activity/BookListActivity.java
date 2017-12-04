package com.ahlyclub.omar2.booksapplication.Activity.Activity.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.os.AsyncTask;
import android.widget.Toast;

import com.ahlyclub.omar2.booksapplication.Activity.Activity.Model.Books;
import com.ahlyclub.omar2.booksapplication.R;
import com.ahlyclub.omar2.booksapplication.Activity.Activity.Adapter.BooksAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class BookListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    BooksAdapter booksAdapter;
    ArrayList<Books> books = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        recyclerView = findViewById(R.id.newID);
        progressBar = findViewById(R.id.myPrgressBar);


        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new MyAcyncTask().execute("https://www.googleapis.com/books/v1/volumes?q=android");
            }
        });


    }

    class MyAcyncTask extends AsyncTask<String, Integer, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {
            return CreateURL(strings[0]);
        }

        @Override
        protected void onPostExecute(String print) {
            super.onPostExecute(print);

            progressBar.setVisibility(View.GONE);

            try {
                JSONObject jsonObject = new JSONObject(print);
                JSONArray jsonArray = jsonObject.getJSONArray("items");

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject itemobject = jsonArray.getJSONObject(i);

                    JSONObject volumeinfo = itemobject.getJSONObject("volumeInfo");
                    String title = volumeinfo.getString("title");

                    String subTitle = "";
                    try {
                        subTitle = volumeinfo.getString("subtitle");
                    } catch (Exception e) {

                    }
                    JSONArray authors = volumeinfo.getJSONArray("authors");
                    String author = authors.getString(0);

                    String publisher = volumeinfo.getString("publisher");
                    String publishDate = volumeinfo.getString("publishedDate");
                    String descreption = volumeinfo.getString("description");

                    JSONObject imageObject = volumeinfo.getJSONObject("imageLinks");
                    String image = imageObject.getString("smallThumbnail");

                    JSONArray categories = volumeinfo.getJSONArray("categories");
                    String category = categories.getString(0);

                    String language = volumeinfo.getString("language");

                    JSONObject saleInfo = itemobject.getJSONObject("saleInfo");
                    String country = saleInfo.getString("country");

                    String saleability = saleInfo.getString("saleability");


                    books.add(
                            new Books(image,
                                    title,
                                    subTitle,
                                    author,
                                    publishDate,
                                    descreption,
                                    publisher,
                                    category,
                                    language,
                                    country,
                                    saleability
                            ));

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


            if (print != null) {
                booksAdapter = new BooksAdapter(BookListActivity.this, books);

                recyclerView.setLayoutManager(new LinearLayoutManager(BookListActivity.this));
                recyclerView.setAdapter(booksAdapter);

            } else {
               Toast.makeText(BookListActivity.this, "Error for Loading Page", Toast.LENGTH_LONG).show();
            }


        }

    }


    private static String CreateURL(String theUrl) {
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(theUrl);
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
