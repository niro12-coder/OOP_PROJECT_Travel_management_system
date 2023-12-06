package cis.travel.eg.Service.Hotels.Reservation;

import cis.travel.eg.Service.Hotels.HotelDetails.*;
import cis.travel.eg.Service.otherClasses.ticket;
import cis.travel.eg.Service.Hotels.person.manager;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class hotelReservation extends Hotel {
    //basicRoomDetails roomAvailable;
    public ArrayList<basicRoomDetails> roomAvailable=new ArrayList<>();
    public LocalDate startDate;
    public LocalDate endDate;
    long totalDaysOfTrip;
    public double[] finalFoodBoard=new double[3];
    public double totalPayments;
    public hotelReservation(Hotel hotel) {
        this.hotelID= hotel.hotelID;
        this.hotelName= hotel.hotelName;
        this.hotelRating= hotel.hotelRating;
        this.hotelLocation= hotel.hotelLocation;
        this.contactNumber= hotel.contactNumber;
        this.AquaPark= hotel.AquaPark;
    }
    public void assignAvailableRoom(singleRooms avaRoom, LocalDate start, LocalDate end){
        roomAvailable.add(new basicRoomDetails());
        roomAvailable.get(0).roomId=avaRoom.roomId;
        roomAvailable.get(0).roomType=avaRoom.roomType;
        roomAvailable.get(0).numberOfBeds=avaRoom.numberOfBeds;
        roomAvailable.get(0).roomLimit=avaRoom.roomLimit;
        roomAvailable.get(0).roomPrice=avaRoom.roomPrice;
        roomAvailable.get(0).foodBoardPrice=avaRoom.foodBoardPrice;
        this.startDate= start;
        this.endDate= end;
        totalDaysOfTrip= ChronoUnit.DAYS.between(start,end);
    }
    public void assignAvailableRoom(doubleRooms avaRoom, LocalDate start, LocalDate end){
        roomAvailable.add(new basicRoomDetails());
        roomAvailable.get(0).roomId=avaRoom.roomId;
        roomAvailable.get(0).roomType=avaRoom.roomType;
        roomAvailable.get(0).numberOfBeds=avaRoom.numberOfBeds;
        roomAvailable.get(0).roomLimit=avaRoom.roomLimit;
        roomAvailable.get(0).roomPrice=avaRoom.roomPrice;
        roomAvailable.get(0).foodBoardPrice=avaRoom.foodBoardPrice;
        this.startDate= start;
        this.endDate= end;
        totalDaysOfTrip= ChronoUnit.DAYS.between(start,end);
    }
    public void assignAvailableRoom(generalRooms avaRoom, LocalDate start, LocalDate end,int index){
        roomAvailable.add(new basicRoomDetails());
        roomAvailable.get(index).roomId=avaRoom.roomId;
        roomAvailable.get(index).roomType=avaRoom.roomType;
        roomAvailable.get(index).numberOfBeds=avaRoom.numberOfBeds;
        roomAvailable.get(index).roomLimit=avaRoom.roomLimit;
        roomAvailable.get(index).roomPrice=avaRoom.roomPrice;
        roomAvailable.get(index).foodBoardPrice=avaRoom.foodBoardPrice;
        this.startDate= start;
        this.endDate= end;
        totalDaysOfTrip= ChronoUnit.DAYS.between(start,end);
    }
    public void displayAndChooseHotel(int i , boolean familyRoom,int numberOfSeats, boolean confirmation ){
        System.out.println("___________________________________________________");
        if(!confirmation){
            if(i<9){System.out.println("[0"+ (i+1)+"] " +this.hotelName);}
            else {System.out.println("["+(i+1)+"] " +this.hotelName);}
        }else {
            System.out.println("  >>>"+  this.hotelName + "Hotel <<<");
        }
        System.out.println("___________________________________________________");
        System.out.println(" - Type: "+ roomAvailable.get(0).roomType);
        System.out.println(" - Room Limit: "+ roomAvailable.get(0).roomLimit);
        if(familyRoom && !confirmation){
            System.out.println(" *You will be required to book "+ numberOfRoomsRequired(numberOfSeats)+ " rooms./n");
        }
        System.out.println(" - Room fees (without food board): "+ roomAvailable.get(0).roomPrice +" $ per day");
        System.out.println(" - Beds: "+ roomAvailable.get(0).numberOfBeds+" bed/s");
        System.out.println("___________________________________________________");
        System.out.println("            <Food board fees>");
        if(!confirmation){ System.out.println("*you can choose only one or two choices.");}

        System.out.println(" - Breakfast: "+ roomAvailable.get(0).foodBoardPrice[0]+" $ per day");
        System.out.println(" - Lunch: "+ roomAvailable.get(0).foodBoardPrice[1]+" $ per day");
        System.out.println(" - Dinner: "+ roomAvailable.get(0).foodBoardPrice[2]+" $ per day");
        System.out.println("----------------------------------------------------");
        calculateTotalPriceForTotalPeriod();
        System.out.println("====================================================");
        //OPTION :  write total price with and without food board
        // total = (room+ food)*no of rooms
    }
    public void foodBoard(int[]meals,boolean familyRoom,int numberOfSeats ,boolean confirmation){
// meal[0]=3-1=2
        for(int number:meals){

            /*
            index    0 1,2,3
            array 1= 1 2 3 4
            array 2 = 1 2 3 4
             */
           this.finalFoodBoard[number]=roomAvailable.get(0).foodBoardPrice[number];
        }
        if(familyRoom && confirmation){
            int numberOfRooms=numberOfRoomsRequired(numberOfSeats);
             for(int i=1;i<numberOfRooms;i++){
                 roomAvailable.get(i).foodBoardPrice=this.finalFoodBoard;
             }
        }
        else if(confirmation) {roomAvailable.get(0).foodBoardPrice=this.finalFoodBoard;}
    }



    public int numberOfRoomsRequired(int numberOfSeats){
            int numberOfRoomsRequired;
            if((numberOfSeats%roomAvailable.get(0).roomLimit)==0){
                numberOfRoomsRequired=numberOfSeats/roomAvailable.get(0).roomLimit;
            } else { numberOfRoomsRequired=(numberOfSeats/roomAvailable.get(0).roomLimit)+1; }
        return numberOfRoomsRequired;
    }
    public void calculateTotalPriceForTotalPeriod(){
        double totalPriceForRoomPerDay= roomAvailable.get(0).roomPrice;
        for(int i=0;i<3;i++){
            totalPriceForRoomPerDay+= roomAvailable.get(0).foodBoardPrice[i];
        }
        this.totalPayments= totalDaysOfTrip*(totalPriceForRoomPerDay*roomAvailable.size());
        System.out.println(" - Total price for room per day: "+totalPriceForRoomPerDay );
        System.out.println(" - Total price for all rooms per day: "+(totalPriceForRoomPerDay*roomAvailable.size()));
        System.out.println(" - Total payments for Whole days: "+ totalPayments );
    }

    public static void saveReservation(ticket ticket){

        for(int h = 0; h< manager.hotels.size(); h++){
            if(manager.hotels.get(h).hotelID.equals(ticket.Hotel.hotelID)){
                switch(ticket.numberOfSeats){
                    case 1:
                        for(int r=0;r<manager.hotels.get(h).numberOfSingleRooms;r++){
                            if(manager.hotels.get(h).singleRoom.get(r).roomId.equals(ticket.Hotel.roomAvailable.get(0).roomId)){
                                manager.hotels.get(h).singleRoom.get(r).addNewReservation(ticket.Hotel.startDate, ticket.Hotel.endDate);
                                break;
                            }
                        }
                        break;
                    case 2:
                        for(int r=0;r<manager.hotels.get(h).numberOfDoubleRooms;r++){
                            if(manager.hotels.get(h).doubleRoom.get(r).roomId.equals(ticket.Hotel.roomAvailable.get(0).roomId)){
                                manager.hotels.get(h).doubleRoom.get(r).addNewReservation(ticket.Hotel.startDate, ticket.Hotel.endDate);
                                break;
                            }
                        }
                        break;
                    default:
                        for(int n=0;n< ticket.Hotel.roomAvailable.size();n++){
                            for(int r=0;r<manager.hotels.get(h).numberOfFamilyRooms;r++){
                                if(manager.hotels.get(h).familyRoom.get(r).roomId.equals(ticket.Hotel.roomAvailable.get(n).roomId)){
                                    manager.hotels.get(h).familyRoom.get(r).addNewReservation(ticket.Hotel.startDate, ticket.Hotel.endDate);
                                    break;
                                }
                            }
                        }

                }

            }
        }
    }
}
