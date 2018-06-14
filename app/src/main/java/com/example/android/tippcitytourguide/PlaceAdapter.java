package com.example.android.tippcitytourguide;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.android.tippcitytourguide.databinding.ListItemBinding;

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
        // Check if the existing view is being reused, otherwise inflate the view, set Data Binding.
        ListItemBinding binding;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
            binding = DataBindingUtil.bind(convertView);
            convertView.setTag(binding);
        } else {
            binding = (ListItemBinding) convertView.getTag();
        }

        // Get the {@link Place} object located at this position in the list.
        Place currentPlace = getItem(position);

        // Make sure binding and currentPlace aren't null.
        assert binding != null;
        assert currentPlace != null;

        // Get image that represents the place and set it on the ImageView.
        binding.ivListLeftImage.setImageResource(currentPlace.getPlaceImageId());

        // Get the name of the place and set this text on the TextView.
        binding.tvPlaceName.setText(currentPlace.getPlaceNameId());

        // Get the brief information about the place and set this text on the TextView.
        binding.tvPlaceInfo.setText(currentPlace.getPlaceInfoId());

        // Get the price of admission to the place and set this text on the TextView.
        binding.tvPlacePrice.setText(currentPlace.getPlacePriceId());

        // Return the whole list item layout (containing an ImageView and three TextViews)
        // so that it can be shown in the ListView.
        return binding.getRoot();
    }
}
