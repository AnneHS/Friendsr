package com.example.anneh.friendsr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        Friend cecile = new Friend("Cécile", "jo", cec_id);
        friends.add(cecile);

        int eva_id = getResources().getIdentifier("eva", "drawable", getPackageName());
        Friend eva = new Friend("Eva", "jo", eva_id);
        friends.add(eva);

        int flo_id = getResources().getIdentifier("floor", "drawable", getPackageName());
        Friend floor = new Friend("Floor", "jo", flo_id);
        friends.add(floor);

        int har_id = getResources().getIdentifier("harry", "drawable", getPackageName());
        Friend harry = new Friend("Harry", "jo", har_id);
        friends.add(harry);

        int jo_id = getResources().getIdentifier("joep", "drawable", getPackageName());
        Friend joep = new Friend("Joep", "jo", jo_id);
        friends.add(joep);

        int jul_id = getResources().getIdentifier("juliet", "drawable", getPackageName());
        Friend juliet = new Friend("Juliët", "jo", jul_id);
        friends.add(juliet);

        int sab_id = getResources().getIdentifier("sabine", "drawable", getPackageName());
        Friend sabine = new Friend("Sabine", "jo", sab_id);
        friends.add(sabine);

        int ser_id = getResources().getIdentifier("sergen", "drawable", getPackageName());
        Friend sergen = new Friend("Sergen", "jo", ser_id);
        friends.add(sergen);

        int ver_id = getResources().getIdentifier("vermee", "drawable", getPackageName());
        Friend vermee = new Friend("HJ Vermee", "jo", ver_id);
        friends.add(vermee);

        // Instantiate adapter to store each item
        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);

        // Get reference to gridview
        GridView gridview = (GridView) findViewById(R.id.gridview);

        // Set adapter containing images to gridview
        gridview.setAdapter(adapter);


    }
}
