package com.example.android.tippcitytourguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private String website;
    private String phone;
    private String location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_info);

        // Retrieve info from intent.
        int image = getIntent().getIntExtra("image", -1);
        String name = getIntent().getStringExtra("name");
        String hours = getIntent().getStringExtra("hours");
        location = getIntent().getStringExtra("location");
        phone = getIntent().getStringExtra("phone");
        website = getIntent().getStringExtra("website");

        Toolbar appToolbar1 = findViewById(R.id.appToolbar);

        // Set the toolbar.
        setSupportActionBar(appToolbar1);

        // Get a support ActionBar corresponding to this toolbar.
        ActionBar appToolbar = getSupportActionBar();

        // Enable the Up button and make sure it's not null.
        assert appToolbar != null;
        appToolbar.setDisplayHomeAsUpEnabled(true);

        setTitle(name);

        ImageView infoImage = findViewById(R.id.infoImage);
        infoImage.setImageResource(image);

        TextView infoHours = findViewById(R.id.infoHours);
        infoHours.setText(hours);

        Button infoLocation = findViewById(R.id.infoLocation);
        infoLocation.setOnClickListener(this);

        Button infoCall = findViewById(R.id.infoCall);
        infoCall.setOnClickListener(this);

        Button infoWebsite = findViewById(R.id.infoWebsite);
        infoWebsite.setOnClickListener(this);
    }

    // Perform action on click.
    public void onClick(View v) {
        switch (v.getId()) {
            // Show map location of the place.
            case R.id.infoLocation:
                Intent placeLocation = new Intent(Intent.ACTION_VIEW);
                placeLocation.setData(Uri.parse("geo:0,0?q=" + location));
                // Make sure an app is installed to complete this action.
                if (placeLocation.resolveActivity(getPackageManager()) != null) {
                    startActivity(placeLocation);
                }
                break;

            // Enter the phone number in the dialer for the place.
            case R.id.infoCall:
                Intent placePhone = new Intent(Intent.ACTION_DIAL);
                placePhone.setData(Uri.parse("tel:" + phone));
                // Make sure an app is installed to complete this action.
                if (placePhone.resolveActivity(getPackageManager()) != null) {
                    startActivity(placePhone);
                }
                break;

            // Go to the website for the place.
            case R.id.infoWebsite:
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
