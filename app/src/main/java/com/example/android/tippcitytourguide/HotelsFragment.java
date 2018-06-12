package com.example.android.tippcitytourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelsFragment extends Fragment {

    public HotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Identify the views.
        ListView listView = rootView.findViewById(R.id.list);

        // Create an ArrayList of places for Hotels.
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(R.drawable.holiday_inn, getString(R.string.hotelsNameOne),
                getString(R.string.hotelsInfoOne), getString(R.string.hotelsPriceOne),
                getString(R.string.hotelsHoursOne), getString(R.string.hotelsLocationOne),
                getString(R.string.hotelsPhoneOne), getString(R.string.hotelsWebsiteOne)));
        places.add(new Place(R.drawable.la_quinta, getString(R.string.hotelsNameTwo),
                getString(R.string.hotelsInfoTwo), getString(R.string.hotelsPriceTwo),
                getString(R.string.hotelsHoursTwo), getString(R.string.hotelsLocationTwo),
                getString(R.string.hotelsPhoneTwo), getString(R.string.hotelsWebsiteTwo)));
        places.add(new Place(R.drawable.super_eight, getString(R.string.hotelsNameThree),
                getString(R.string.hotelsInfoThree), getString(R.string.hotelsPriceThree),
                getString(R.string.hotelsHoursCall), getString(R.string.hotelsLocationThree),
                getString(R.string.hotelsPhoneThree), getString(R.string.hotelsWebsiteThree)));
        places.add(new Place(R.drawable.budget_inn, getString(R.string.hotelsNameFour),
                getString(R.string.hotelsInfoFour), getString(R.string.hotelsPriceFour),
                getString(R.string.hotelsHoursCall), getString(R.string.hotelsLocationFour),
                getString(R.string.hotelsPhoneFour), getString(R.string.hotelsWebsiteFour)));
        places.add(new Place(R.drawable.motel_six, getString(R.string.hotelsNameFive),
                getString(R.string.hotelsInfoFive), getString(R.string.hotelsPriceFive),
                getString(R.string.hotelsHoursCall), getString(R.string.hotelsLocationFive),
                getString(R.string.hotelsPhoneFive), getString(R.string.hotelsWebsiteFive)));

        // Set the adapter.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);
        listView.setAdapter(adapter);

        // Remove divider by setting height to zero.
        listView.setDividerHeight(0);

        // Set a listener for the list that starts a new activity for the item that is clicked.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the position of the clicked list item.
                Place listItem = places.get(position);

                // Start the PlaceInfoActivity.
                Intent placeInfo = new Intent(getActivity(), PlaceInfoActivity.class);
                placeInfo.putExtra("name", listItem.getPlaceNameId());
                placeInfo.putExtra("image", listItem.getPlaceImageId());
                placeInfo.putExtra("hours", listItem.getPlaceHoursId());
                placeInfo.putExtra("location", listItem.getPlaceLocationId());
                placeInfo.putExtra("phone", listItem.getPlacePhoneId());
                placeInfo.putExtra("website", listItem.getPlaceWebsiteId());
                startActivity(placeInfo);
            }
        });

        return rootView;
    }

}
