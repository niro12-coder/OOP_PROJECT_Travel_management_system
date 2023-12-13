package cis.travel.eg.Service.Hotels.DetailsForSystem;

import cis.travel.eg.Service.Hotels.HotelDetails.Hotel;
import cis.travel.eg.Service.Hotels.HotelDetails.doubleRooms;
import cis.travel.eg.Service.Hotels.HotelDetails.generalRooms;
import cis.travel.eg.Service.Hotels.HotelDetails.singleRooms;

import java.io.Serializable;
import java.util.ArrayList;

public  class HotelForAgency extends Hotel implements Serializable {
    public static int hotelNumber; //order of hotel opening
    private int numberOfSingleRooms;
    private int numberOfDoubleRooms;
    private int numberOfFamilyRooms;
    public int getNumberOfSingleRooms() {
        return numberOfSingleRooms;
    }




//    public long totalProfit;
    public ArrayList<singleRooms> singleRoom= new ArrayList<>();
    public ArrayList<doubleRooms> doubleRoom= new ArrayList<>();
    public ArrayList<generalRooms> familyRoom= new ArrayList<>();
    public HotelForAgency(){
        hotelNumber++;
        this.setHotelID("HT" + hotelNumber);
    }
    public void setNumberOfSingleRooms(int numberOfSingleRooms) {
        this.numberOfSingleRooms = numberOfSingleRooms;
    }

    public int getNumberOfDoubleRooms() {
        return numberOfDoubleRooms;
    }

    public void setNumberOfDoubleRooms(int numberOfDoubleRooms) {
        this.numberOfDoubleRooms = numberOfDoubleRooms;
    }

    public int getNumberOfFamilyRooms() {
        return numberOfFamilyRooms;
    }

    public void setNumberOfFamilyRooms(int numberOfFamilyRooms) {
        this.numberOfFamilyRooms = numberOfFamilyRooms;
    }
    public static void hotelDetails(HotelForAgency Hotel){
    System.out.println(" >>"+ Hotel.getHotelName());
    System.out.println(" Rating: "+ Hotel.getHotelRating() +" stars");
    System.out.println(" Location: "+ Hotel.getHotelLocation());
    System.out.println(" Contact number: "+ Hotel.getContactNumber());
    System.out.println("___________________________________________________");
    System.out.println("                   SINGLE ROOMS");
    System.out.println("----------------------------------------------------");
    System.out.println(" - Room Limit: "+ Hotel.singleRoom.get(0).getRoomLimit());
    System.out.println(" - Beds: "+ Hotel.singleRoom.get(0).getNumberOfBeds() +" bed/s");
    System.out.println(" - Room fees (without food board): "+ Hotel.singleRoom.get(0).getRoomPrice() +" $ per day");
    System.out.println("___________________________________________________");
    System.out.println("                <Food board fees>");
    System.out.println(" - Breakfast: "+ Hotel.singleRoom.get(0).foodBoardPrice[0]+" $ per day");
    System.out.println(" - Lunch: "+ Hotel.singleRoom.get(0).foodBoardPrice[1]+" $ per day");
    System.out.println(" - Dinner: "+ Hotel.singleRoom.get(0).foodBoardPrice[2]+" $ per day");
    System.out.println("====================================================");
    System.out.println("                   DOUBLE ROOMS");
    System.out.println("----------------------------------------------------");
    System.out.println(" - Room Limit: "+ Hotel.doubleRoom.get(0).getRoomLimit());
    System.out.println(" - Room fees (without food board): "+ Hotel.doubleRoom.get(0).getRoomPrice() +" $ per day");
    System.out.println(" - Beds: "+ Hotel.doubleRoom.get(0).getNumberOfBeds() +" bed/s");
    System.out.println("___________________________________________________");
    System.out.println("                 <Food board fees>");
    System.out.println(" - Breakfast: "+ Hotel.doubleRoom.get(0).foodBoardPrice[0]+" $ per day");
    System.out.println(" - Lunch: "+ Hotel.doubleRoom.get(0).foodBoardPrice[1]+" $ per day");
    System.out.println(" - Dinner: "+ Hotel.doubleRoom.get(0).foodBoardPrice[2]+" $ per day");
    System.out.println("====================================================");
    System.out.println("                   GENERAL ROOMS");
    System.out.println("----------------------------------------------------");
    System.out.println(" - Room Limit: "+ Hotel.familyRoom.get(0).getRoomLimit());
    System.out.println(" - Room fees (without food board): "+ Hotel.familyRoom.get(0).getRoomPrice() +" $ per day");
    System.out.println(" - Beds: "+ Hotel.familyRoom.get(0).getNumberOfBeds() +" bed/s");
    System.out.println("___________________________________________________");
    System.out.println("                  <Food board fees>");
    System.out.println(" - Breakfast: "+ Hotel.familyRoom.get(0).foodBoardPrice[0]+" $ per day");
    System.out.println(" - Lunch: "+ Hotel.familyRoom.get(0).foodBoardPrice[1]+" $ per day");
    System.out.println(" - Dinner: "+ Hotel.familyRoom.get(0).foodBoardPrice[2]+" $ per day");
    System.out.println("====================================================");
}
}
