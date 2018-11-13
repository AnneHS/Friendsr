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

import java.util.List;

public class FriendsAdapter extends ArrayAdapter<Friend> {

    // Instance variables
    private ArrayList friends;
    ImageView image;
    TextView text;
    Context context;

    // Constructor
    public FriendsAdapter(Context context, int resource, ArrayList<Friend> objects) {
        super(context, resource, objects);

        // reference to list of friends = objects?
        friends = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Friend friend;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        // get access to the layout's views
        image = convertView.findViewById(R.id.imageView);
        text = convertView.findViewById(R.id.textView);

        // get friend (for loop in printer?)
        friend = (Friend) friends.get(position);

        // get corresponding name and picture
        String name = friend.getName();
        Drawable picture = getContext().getResources().getDrawable(friend.getDrawableId());

        // load name and picture into text & imageView
        text.setText(name);
        image.setImageDrawable(picture);

        return convertView;
    }
}
