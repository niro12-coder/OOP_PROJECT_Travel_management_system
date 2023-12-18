package cis.travel.eg.Service.Hotels.HotelDetails;

import java.io.Serializable;

public class Hotel implements Serializable {
    private String hotelID;
    private String hotelName;
    private int hotelRating;
    private String hotelLocation;
    private String contactNumber;
    private boolean AquaPark;

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getHotelRating() {
        return hotelRating;
    }

    public void setHotelRating(int hotelRating) {
        this.hotelRating = hotelRating;
    }

    public String getHotelLocation() {
        return hotelLocation;
    }

    public void setHotelLocation(String hotelLocation) {
        this.hotelLocation = hotelLocation;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public boolean isAquaPark() {
        return AquaPark;
    }

    public void setAquaPark(boolean aquaPark) {
        AquaPark = aquaPark;
    }
}
