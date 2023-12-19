package cis.travel.eg.Service.Hotels.HotelDetails;

import cis.travel.eg.Service.Hotels.DetailsForSystem.HotelForAgency;
import cis.travel.eg.Service.helpingMethods.helpingMethods;

import java.io.Serializable;

import static cis.travel.eg.Main.Main.in;

public class singleRooms extends roomsForManager implements Serializable {
    public singleRooms() {
        this.setRoomType("single");
        this.setRoomLimit(1);
        this.setNumberOfBeds(1);
    }

    @Override
    public void assignRoomDetailsForHotel(HotelForAgency Hotel) {
        int numberOfRooms;
        singleRooms tempRoom = new singleRooms();
        System.out.println("    SINGLE rooms ");
        System.out.println("---------------------");
        System.out.println("How many single rooms cars your hotel?");
        Hotel.setNumberOfSingleRooms(helpingMethods.checkIntInput());
        numberOfRooms = Hotel.getNumberOfSingleRooms();
        tempRoom.EnterRoomFees();
        //save rooms to hotel
        for (int i = 0; i < numberOfRooms; i++) {
            Hotel.singleRoom.add(tempRoom);
            Hotel.singleRoom.get(i).setRoomId(i, "SR");
        }
    }

    @Override
    public void updateRoomDetailsForHotel(HotelForAgency Hotel) {

        int numberOfRooms;
        singleRooms tempRoom = new singleRooms();
        System.out.println("    SINGLE rooms ");
        System.out.println("---------------------");
        System.out.println("How many single rooms cars your hotel?");
        numberOfRooms = helpingMethods.checkIntInput();
        tempRoom.EnterRoomFees();
        System.out.println("Are you sure you want to confirm changes?(y/n)");
        if (helpingMethods.confirm(in.next().charAt(0))) {
            Hotel.setNumberOfSingleRooms(numberOfRooms);
            //save rooms to hotel
            for (int i = 0; i < numberOfRooms; i++) {
                Hotel.singleRoom.get(i).setRoomPrice(tempRoom.getRoomPrice());
                Hotel.singleRoom.get(i).foodBoardPrice = tempRoom.foodBoardPrice;
            }
        }


    }
}
