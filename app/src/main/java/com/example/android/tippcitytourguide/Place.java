package com.example.android.tippcitytourguide;

public class Place {
    private int placeImageId;
    private String placeNameId;
    private String placeInfoId;
    private String placePriceId;
    private String placeHoursId;
    private String placeLocationId;
    private String placePhoneId;
    private String placeWebsiteId;

    // Constant value that represents no image was provided for this place.
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Place object.
     *
     * @param placeImage    is the image to the left that represents the place
     * @param placeName     is the name of the place
     * @param placeInfo     is some brief information about the place
     * @param placePrice    is the price of admission to the place
     * @param placeHours    is hours of operation for the place
     * @param placeLocation is the location of the place
     * @param placePhone    is the phone number of the place
     * @param placeWebsite  is the website of the place
     */
    Place(int placeImage, String placeName, String placeInfo, String placePrice, String placeHours,
          String placeLocation, String placePhone, String placeWebsite) {
        placeImageId = placeImage;
        placeNameId = placeName;
        placeInfoId = placeInfo;
        placePriceId = placePrice;
        placeHoursId = placeHours;
        placeLocationId = placeLocation;
        placePhoneId = placePhone;
        placeWebsiteId = placeWebsite;
    }

    // Returns whether or not there is an image for this place.
    public boolean hasImage() {
        return placeImageId != NO_IMAGE_PROVIDED;
    }

    // Get the image that represents the place.
    public int getPlaceImageId() {
        return placeImageId;
    }

    // Get the name of the place.
    public String getPlaceNameId() {
        return placeNameId;
    }

    // Get the brief information about the place.
    public String getPlaceInfoId() {
        return placeInfoId;
    }

    // Get the price of admission to the place.
    public String getPlacePriceId() {
        return placePriceId;
    }

    // Get the hours of operation for the place.
    public String getPlaceHoursId() {
        return placeHoursId;
    }

    // Get the location of the place.
    public String getPlaceLocationId() {
        return placeLocationId;
    }

    // Get the phone number of the place
    public String getPlacePhoneId() {
        return placePhoneId;
    }

    // Get the website of the place.
    public String getPlaceWebsiteId() {
        return placeWebsiteId;
    }
}
