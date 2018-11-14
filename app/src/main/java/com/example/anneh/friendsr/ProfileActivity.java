package com.example.anneh.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    Friend retrievedFriend;
    ImageView image;
    TextView name;
    TextView bio;
    RatingBar ratingbar;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        ImageView image = (ImageView) findViewById(R.id.imageview);
        name = findViewById(R.id.name);
        bio = findViewById(R.id.bio);
        ratingbar = findViewById(R.id.rating);
        ratingbar.setOnRatingBarChangeListener(new RatingbarChangeListener());

        //

        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        editor = prefs.edit();
        float saved = prefs.getFloat(retrievedFriend.getName(), 0);
        ratingbar.setRating(saved);

        // Use retrievedFriend to render name, bio, photo and rating
        image.setImageDrawable(getResources().getDrawable(retrievedFriend.getDrawableId()));
        name.setText(retrievedFriend.getName());
        bio.setText(retrievedFriend.getBio());

    }

    private class RatingbarChangeListener implements RatingBar.OnRatingBarChangeListener {

        @Override
        public void onRatingChanged(RatingBar ratingbar, float rating, boolean fromUser) {


            // store rating
            editor.putFloat(retrievedFriend.getName(), rating);

            // save changes
            editor.apply();

            Log.d("jo", "OnRatingsChanged");

        }
    }
}