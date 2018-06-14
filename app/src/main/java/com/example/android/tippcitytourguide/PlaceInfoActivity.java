package com.example.android.tippcitytourguide;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.android.tippcitytourguide.databinding.ActivityPlaceInfoBinding;

public class PlaceInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private String website;
    private String phone;
    private String location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set up Data Binding and set the content.
        ActivityPlaceInfoBinding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_place_info);

        // Retrieve info from intent.
        int image = getIntent().getIntExtra("image", -1);
        String name = getIntent().getStringExtra("name");
        String hours = getIntent().getStringExtra("hours");
        location = getIntent().getStringExtra("location");
        phone = getIntent().getStringExtra("phone");
        website = getIntent().getStringExtra("website");

        // Set the toolbar.
        setSupportActionBar(binding.appToolbar);

        // Get a support ActionBar corresponding to this toolbar.
        ActionBar appToolbar = getSupportActionBar();

        // Enable the Up button and make sure it's not null.
        assert appToolbar != null;
        appToolbar.setDisplayHomeAsUpEnabled(true);

        // Set the title on the Toolbar.
        setTitle(name);

        // Set the image.
        binding.ivInfoImage.setImageResource(image);

        // Set the hours of operation text.
        binding.tvInfoHours.setText(hours);

        // Set the button listeners.
        binding.btnInfoLocation.setOnClickListener(this);
        binding.btnInfoCall.setOnClickListener(this);
        binding.btnInfoWebsite.setOnClickListener(this);
    }

    // Perform action on click.
    public void onClick(View v) {
        switch (v.getId()) {
            // Show map location of the place.
            case R.id.btnInfoLocation:
                Intent placeLocation = new Intent(Intent.ACTION_VIEW);
                placeLocation.setData(Uri.parse("geo:0,0?q=" + location));
                // Make sure an app is installed to complete this action.
                if (placeLocation.resolveActivity(getPackageManager()) != null) {
                    startActivity(placeLocation);
                }
                break;

            // Enter the phone number in the dialer for the place.
            case R.id.btnInfoCall:
                Intent placePhone = new Intent(Intent.ACTION_DIAL);
                placePhone.setData(Uri.parse("tel:" + phone));
                // Make sure an app is installed to complete this action.
                if (placePhone.resolveActivity(getPackageManager()) != null) {
                    startActivity(placePhone);
                }
                break;

            // Go to the website for the place.
            case R.id.btnInfoWebsite:
                Intent placeWebsite = new Intent(Intent.ACTION_VIEW);
                placeWebsite.setData(Uri.parse(website));
                // Make sure an app is installed to complete this action.
                if (placeWebsite.resolveActivity(getPackageManager()) != null) {
                    startActivity(placeWebsite);
                }
                break;

            default:
                break;
        }
    }
}
