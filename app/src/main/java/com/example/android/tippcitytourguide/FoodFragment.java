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
public class FoodFragment extends Fragment {

    public FoodFragment() {
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

        // Create an ArrayList of places for Food.
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(R.drawable.coldwater_cafe, getString(R.string.foodNameOne),
                getString(R.string.foodInfoOne), getString(R.string.foodPriceThreeSigns),
                getString(R.string.foodHoursOne), getString(R.string.foodLocationOne),
                getString(R.string.foodPhoneOne), getString(R.string.foodWebsiteOne)));
        places.add(new Place(R.drawable.harrisons, getString(R.string.foodNameTwo),
                getString(R.string.foodInfoTwo), getString(R.string.foodPriceTwoSigns),
                getString(R.string.foodHoursTwo), getString(R.string.foodLocationTwo),
                getString(R.string.foodPhoneTwo), getString(R.string.foodWebsiteTwo)));
        places.add(new Place(R.drawable.sam_and_ethels, getString(R.string.foodNameThree),
                getString(R.string.foodInfoThree), getString(R.string.foodPriceOneSign),
                getString(R.string.foodHoursThree), getString(R.string.foodLocationThree),
                getString(R.string.foodPhoneThree), getString(R.string.foodWebsiteThree)));
        places.add(new Place(R.drawable.grounds_for_pleasure, getString(R.string.foodNameFour),
                getString(R.string.foodInfoFour), getString(R.string.foodPriceOneSign),
                getString(R.string.foodHoursFour), getString(R.string.foodLocationFour),
                getString(R.string.foodPhoneFour), getString(R.string.foodWebsiteFour)));
        places.add(new Place(R.drawable.greenfire_bistro, getString(R.string.foodNameFive),
                getString(R.string.foodInfoFive), getString(R.string.foodPriceTwoSigns),
                getString(R.string.foodHoursFive), getString(R.string.foodLocationFive),
                getString(R.string.foodPhoneFive), getString(R.string.foodWebsiteFive)));
        places.add(new Place(R.drawable.hinders, getString(R.string.foodNameSix),
                getString(R.string.foodInfoSix), getString(R.string.foodPriceTwoSigns),
                getString(R.string.foodHoursSix), getString(R.string.foodLocationSix),
                getString(R.string.foodPhoneSix), getString(R.string.foodWebsiteSix)));
        places.add(new Place(R.drawable.hong_kong_kitchen, getString(R.string.foodNameSeven),
                getString(R.string.foodInfoSeven), getString(R.string.foodPriceTwoSigns),
                getString(R.string.foodHoursSeven), getString(R.string.foodLocationSeven),
                getString(R.string.foodPhoneSeven), getString(R.string.foodWebsiteSeven)));
        places.add(new Place(R.drawable.hickory_river, getString(R.string.foodNameEight),
                getString(R.string.foodInfoEight), getString(R.string.foodPriceTwoSigns),
                getString(R.string.foodHoursEight), getString(R.string.foodLocationEight),
                getString(R.string.foodPhoneEight), getString(R.string.foodWebsiteEight)));
        places.add(new Place(R.drawable.jjs_lunchbox, getString(R.string.foodNameNine),
                getString(R.string.foodInfoNine), getString(R.string.foodPriceOneSign),
                getString(R.string.foodHoursNine), getString(R.string.foodLocationNine),
                getString(R.string.foodPhoneNine), getString(R.string.foodWebsiteNine)));

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
