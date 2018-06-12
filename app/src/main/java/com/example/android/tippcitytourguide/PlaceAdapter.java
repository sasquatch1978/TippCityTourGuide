package com.example.android.tippcitytourguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<Place> {

    /**
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param places  A List of places to display in a list
     */
    PlaceAdapter(Activity context, ArrayList<Place> places) {
        super(context, 0, places);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Place} object located at this position in the list.
        Place currentPlace = getItem(position);
        assert currentPlace != null;

        // Check if there is an image.
        ImageView listViewLeftImage = listItemView.findViewById(R.id.listLeftImage);
        if (currentPlace.hasImage()) {
            // If an image is available, display the provided image based on the resource ID.
            listViewLeftImage.setImageResource(currentPlace.getPlaceImageId());
            // Make sure the view is visible.
            listViewLeftImage.setVisibility(View.VISIBLE);
        } else {
            // Hide the ImageView if there isn't an image.
            listViewLeftImage.setVisibility(View.GONE);
        }

        // Get the name of the place and set this text on the TextView.
        TextView placeName = listItemView.findViewById(R.id.placeName);
        placeName.setText(currentPlace.getPlaceNameId());

        // Get the brief information about the place and set this text on the TextView.
        TextView placeInfo = listItemView.findViewById(R.id.placeInfo);
        placeInfo.setText(currentPlace.getPlaceInfoId());

        // Get the price of admission to the place and set this text on the TextView.
        TextView placePrice = listItemView.findViewById(R.id.placePrice);
        placePrice.setText(currentPlace.getPlacePriceId());

        // Return the whole list item layout (containing an ImageView and three TextViews)
        // so that it can be shown in the ListView.
        return listItemView;
    }
}
