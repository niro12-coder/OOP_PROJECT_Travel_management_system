package cis.travel.eg.Service.Hotels.HotelDetails;

import cis.travel.eg.Service.Hotels.DetailsForSystem.HotelForAgency;
import cis.travel.eg.Service.helpingMethods.helpingMethods;

import java.io.Serializable;
import java.util.Scanner;

public class doubleRooms extends roomsForManager implements Serializable {
    public doubleRooms(){
        this.setRoomType( "Double");
        this.setRoomLimit(2);
        this.setNumberOfBeds(1);
    }
    @Override
    public void assignRoomDetailsForHotel(HotelForAgency Hotel) {
        int numberOfRooms;
        doubleRooms tempRoom= new doubleRooms();
        System.out.println("    DOUBLE rooms");
        System.out.println("---------------------");
        System.out.println("How many double rooms in your hotel?");
        Hotel.setNumberOfDoubleRooms(helpingMethods.checkIntInput());
        numberOfRooms= Hotel.getNumberOfDoubleRooms();
        tempRoom.EnterRoomFees();
        //save rooms to hotel
        for(int i =0 ; i<numberOfRooms;i++ ){
                Hotel.doubleRoom.add(tempRoom);
                Hotel.doubleRoom.get(i).setRoomId(i, "DR");
        }
    }
    @Override
    public void updateRoomDetailsForHotel(HotelForAgency Hotel) {
        Scanner in= new Scanner(System.in);
        int numberOfRooms;
        doubleRooms tempRoom= new doubleRooms();
        System.out.println("    DOUBLE rooms");
        System.out.println("---------------------");
        System.out.println("How many double rooms in your hotel?");
        numberOfRooms= helpingMethods.checkIntInput();
        tempRoom.EnterRoomFees();
        System.out.println("Are you sure you want to confirm changes?(y/n)");
        if(helpingMethods.confirm(in.next().charAt(0))){
            Hotel.setNumberOfDoubleRooms(numberOfRooms);
            //save rooms to hotel
            for(int i =0 ; i<numberOfRooms;i++ ){
                Hotel.doubleRoom.get(i).setRoomPrice(tempRoom.getRoomPrice());
                Hotel.doubleRoom.get(i).foodBoardPrice= tempRoom.foodBoardPrice;
            }
        }
    }
}
