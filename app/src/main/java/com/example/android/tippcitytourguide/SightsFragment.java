package com.example.android.tippcitytourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
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
public class SightsFragment extends Fragment {

    public SightsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Identify the views.
        ListView listView = rootView.findViewById(R.id.list);

        // Create an ArrayList of places for Sights.
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(R.drawable.roller_mill, getString(R.string.sightsNameOne),
                getString(R.string.sightsInfoOne), getString(R.string.priceFree),
                getString(R.string.sightsHoursOne), getString(R.string.sightsLocationOne),
                getString(R.string.sightsPhoneOne), getString(R.string.sightsWebsiteOne)));
        places.add(new Place(R.drawable.charleston_falls, getString(R.string.sightsNameTwo),
                getString(R.string.sightsInfoTwo), getString(R.string.priceFree),
                getString(R.string.sightsHoursTwo), getString(R.string.sightsLocationTwo),
                getString(R.string.sightsPhoneTwo), getString(R.string.sightsWebsiteTwo)));
        places.add(new Place(R.drawable.waco, getString(R.string.sightsNameThree),
                getString(R.string.sightsInfoThree), getString(R.string.sightsPriceThree),
                getString(R.string.sightsHoursThree), getString(R.string.sightsLocationThree),
                getString(R.string.sightsPhoneThree), getString(R.string.sightsWebsiteThree)));
        places.add(new Place(R.drawable.lost_creek, getString(R.string.sightsNameFour),
                getString(R.string.sightsInfoFour), getString(R.string.priceFree),
                getString(R.string.sightsHoursFour), getString(R.string.sightsLocationFour),
                getString(R.string.sightsPhoneFour), getString(R.string.sightsWebsiteFour)));
        places.add(new Place(R.drawable.taylorsville, getString(R.string.sightsNameFive),
                getString(R.string.sightsInfoFive), getString(R.string.priceFree),
                getString(R.string.sightsHoursFive), getString(R.string.sightsLocationFive),
                getString(R.string.sightsPhoneFive), getString(R.string.sightsWebsiteFive)));
        places.add(new Place(R.drawable.old_mason, getString(R.string.sightsNameSix),
                getString(R.string.sightsInfoSix), getString(R.string.priceFree),
                getString(R.string.sightsHoursSix), getString(R.string.sightsLocationSix),
                getString(R.string.sightsPhoneSix), getString(R.string.sightsWebsiteSix)));

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
                /* Make a parent to child activity transition.
                   Reference: https://stackoverflow.com/questions/27235173
                   Date: 6/13/18
                 */
                Bundle options = ActivityOptionsCompat.makeScaleUpAnimation(
                        view, 0, 0, view.getWidth(), view.getHeight()).toBundle();
                assert getActivity() != null;
                ActivityCompat.startActivity(getActivity(), placeInfo, options);
                // End referenced code.
            }
        });

        return rootView;
    }
}
