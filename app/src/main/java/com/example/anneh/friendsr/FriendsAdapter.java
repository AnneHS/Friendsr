package com.example.anneh.friendsr;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FriendsAdapter extends ArrayAdapter<Friend> {

    // Instance variables
    private ArrayList friends;
    ImageView image;
    TextView text;

    // Constructor
    public FriendsAdapter(Context context, int resource, ArrayList<Friend> objects) {
        super(context, resource, objects);

        // Reference to list of friends
        friends = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Friend friend;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        // Get reference to image & TextView
        image = convertView.findViewById(R.id.imageView);
        text = convertView.findViewById(R.id.textView);

        // Get friend for position in GridGiew
        friend = (Friend) friends.get(position);

        // Get corresponding name and picture
        String name = friend.getName();
        Drawable picture = getContext().getResources().getDrawable(friend.getDrawableId());

        // Load name and picture into text & imageView
        text.setText(name);
        image.setImageDrawable(picture);

        return convertView;
    }
}
