package com.example.anneh.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Declare ArrayList
    ArrayList<Friend> friends = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create friends (name, bio, drawableId) and add to list
        int cec_id = getResources().getIdentifier("cecile", "drawable", getPackageName());
        Friend cecile = new Friend("Cécile", "Strike", cec_id);
        friends.add(cecile);

        int eva_id = getResources().getIdentifier("eva", "drawable", getPackageName());
        Friend eva = new Friend("Eva", "Nox", eva_id);
        friends.add(eva);

        int flo_id = getResources().getIdentifier("floor", "drawable", getPackageName());
        Friend floor = new Friend("Floor", "Bamboe", flo_id);
        friends.add(floor);

        int har_id = getResources().getIdentifier("harry", "drawable", getPackageName());
        Friend harry = new Friend("Harry", "Bakbeest", har_id);
        friends.add(harry);

        int jo_id = getResources().getIdentifier("joep", "drawable", getPackageName());
        Friend joep = new Friend("Joep", "Bakbeest", jo_id);
        friends.add(joep);

        int jul_id = getResources().getIdentifier("juliet", "drawable", getPackageName());
        Friend juliet = new Friend("Juliët", "Nox", jul_id);
        friends.add(juliet);

        int sab_id = getResources().getIdentifier("sabine", "drawable", getPackageName());
        Friend sabine = new Friend("Sabine", "Nox", sab_id);
        friends.add(sabine);

        int ser_id = getResources().getIdentifier("sergen", "drawable", getPackageName());
        Friend sergen = new Friend("Sergen", "Simba", ser_id);
        friends.add(sergen);

        int ver_id = getResources().getIdentifier("vermee", "drawable", getPackageName());
        Friend vermee = new Friend("HJ Vermee", "Alaska", ver_id);
        friends.add(vermee);

        // Instantiate adapter to store each item
        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);

        // Get reference to gridview
        GridView gridview = (GridView) findViewById(R.id.gridview);

        // Set adapter containing images to gridview
        gridview.setAdapter(adapter);

        gridview.setOnItemClickListener(new GridItemClickListener());


    }

    // Go to corresponding profile activity when friend is clicked
    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            // Pass Friend object to profile activity
            Friend clickedfriend = (Friend) parent.getItemAtPosition(position);
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedfriend);
            startActivity(intent);

            Log.d("Friend", clickedfriend.getName());

        }
    }
}
