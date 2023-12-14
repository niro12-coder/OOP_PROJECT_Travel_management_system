package cis.travel.eg.Service.Hotels.HotelDetails;

import java.io.Serializable;

public  class basicRoomDetails implements Serializable {
    private String roomId;
    private String roomType;
    private int numberOfBeds;
    private int roomLimit;
    private double roomPrice;
    public double[] foodBoardPrice= new double[3]; //1 breakfast 2 lunch 3 dinner
    public String getRoomId() { return roomId;}
    public void setRoomId(String roomId) {this.roomId = roomId;}
    public String getRoomType() {return roomType;}
    public void setRoomType(String roomType) {this.roomType = roomType;}
    public int getNumberOfBeds() {return numberOfBeds;}
    public void setNumberOfBeds(int numberOfBeds) {this.numberOfBeds = numberOfBeds;}
    public int getRoomLimit() {return roomLimit;}
    public void setRoomLimit(int roomLimit) {this.roomLimit = roomLimit;}
    public double getRoomPrice() {return roomPrice;}
    public void setRoomPrice(double roomPrice) { this.roomPrice = roomPrice;}

}
