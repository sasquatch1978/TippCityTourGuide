package com.example.android.tippcitytourguide;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.android.tippcitytourguide.databinding.PlaceListBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {

    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Set up Data Binding and inflate the fragment.
        PlaceListBinding binding = DataBindingUtil.inflate(inflater, R.layout.place_list,
                container, false);

        // Set the view.
        View rootView = binding.getRoot();

        // Create an ArrayList of places for Events.
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(R.drawable.canal_music, getString(R.string.eventsNameOne),
                getString(R.string.eventsInfoOne), getString(R.string.priceFree),
                getString(R.string.eventsHoursOne), getString(R.string.eventsLocationOne),
                getString(R.string.eventsPhoneOne), getString(R.string.eventsWebsiteOne)));
        places.add(new Place(R.drawable.antique_artisan, getString(R.string.eventsNameTwo),
                getString(R.string.eventsInfoTwo), getString(R.string.priceFree),
                getString(R.string.eventsHoursTwo), getString(R.string.eventsLocationTwo),
                getString(R.string.eventsPhoneDowntownTipp), getString(R.string.eventsWebsiteTwo)));
        places.add(new Place(R.drawable.beer_crawl, getString(R.string.eventsNameThree),
                getString(R.string.eventsInfoThree), getString(R.string.eventsPriceThree),
                getString(R.string.eventsHoursThree), getString(R.string.eventsLocationThree),
                getString(R.string.eventsPhoneDowntownTipp), getString(R.string.eventsWebsiteThree)));
        places.add(new Place(R.drawable.putt_putt, getString(R.string.eventsNameFour),
                getString(R.string.eventsInfoFour), getString(R.string.eventsPriceFour),
                getString(R.string.eventsHoursFour), getString(R.string.eventsLocationFour),
                getString(R.string.eventsPhoneDowntownTipp), getString(R.string.eventsWebsiteFour)));
        places.add(new Place(R.drawable.fulton_farms, getString(R.string.eventsNameFive),
                getString(R.string.eventsInfoFive), getString(R.string.priceFree),
                getString(R.string.eventsHoursFive), getString(R.string.eventsLocationFive),
                getString(R.string.eventsPhoneFive), getString(R.string.eventsWebsiteFive)));
        places.add(new Place(R.drawable.trans_am, getString(R.string.eventsNameSix),
                getString(R.string.eventsInfoSix), getString(R.string.priceFree),
                getString(R.string.eventsHoursSix), getString(R.string.eventsLocationSix),
                getString(R.string.eventsPhoneSix), getString(R.string.eventsWebsiteSix)));
        places.add(new Place(R.drawable.tippapalooza, getString(R.string.eventsNameSeven),
                getString(R.string.eventsInfoSeven), getString(R.string.eventsPriceSeven),
                getString(R.string.eventsHoursSeven), getString(R.string.eventsLocationSeven),
                getString(R.string.eventsPhoneSeven), getString(R.string.eventsWebsiteSeven)));
        places.add(new Place(R.drawable.mums, getString(R.string.eventsNameEight),
                getString(R.string.eventsInfoEight), getString(R.string.priceFree),
                getString(R.string.eventsHoursEight), getString(R.string.eventsLocationEight),
                getString(R.string.eventsPhoneEight), getString(R.string.eventsWebsiteEight)));

        // Set the adapter.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);
        binding.lvPlaceList.setAdapter(adapter);

        // Remove divider by setting height to zero.
        binding.lvPlaceList.setDividerHeight(0);

        // Set a listener for the list that starts a new activity for the item that is clicked.
        binding.lvPlaceList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
