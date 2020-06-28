package com.example.filmyab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {
    private TextView tvMovieTitle;
    private TextView tvMovieDescription;
    private ImageView ivMovieImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        setData();
    }

    void setData() {
        // get Data
        String MovieName = getIntent().getExtras().getString("title");
        String MovieSummery = getIntent().getExtras().getString("overview");
        String MoviePoster = getIntent().getExtras().getString("backdrop_path");

        // set movie poster selection
        ivMovieImage = findViewById(R.id.d_imageview);
        Glide.with(this).load(MoviePoster).into(ivMovieImage);

        // set movie title selection
        tvMovieTitle = findViewById(R.id.d_title);
        tvMovieTitle.setText(MovieName);

        // set movie summery selection
       tvMovieDescription = findViewById(R.id.d_description);
       tvMovieDescription.setText(MovieSummery);




        //set movie name of header detail activity
        getSupportActionBar().setTitle(MovieName);



    }

}
