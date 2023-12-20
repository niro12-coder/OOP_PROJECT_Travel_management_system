package cis.travel.eg.Service.Hotels.HotelDetails;

import cis.travel.eg.Service.Hotels.DetailsForSystem.HotelForAgency;
import cis.travel.eg.Service.helpingMethods.helpingMethods;

import java.io.Serializable;

import static cis.travel.eg.Main.Main.in;

public class generalRooms extends roomsForManager implements Serializable {
    public generalRooms() {
        this.setRoomType("Family");
    }

    @Override
    public void assignRoomDetailsForHotel(HotelForAgency Hotel) {
        int numberOfRooms;
        generalRooms tempRoom = new generalRooms();
        System.out.println("    GENERAL/FAMILY rooms");
        System.out.println("-----------------------------");
        System.out.println("How many family rooms cars your hotel?");
        Hotel.setNumberOfFamilyRooms(helpingMethods.checkIntInput());
        numberOfRooms = Hotel.getNumberOfFamilyRooms();
        System.out.println("How many beds are available per room:");
        tempRoom.setNumberOfBeds(helpingMethods.checkIntInput());
        System.out.println("What is the room limit cars respect to people: ");
        tempRoom.setRoomLimit(helpingMethods.checkIntInput());
        tempRoom.EnterRoomFees();
        //save rooms to hotel
        for (int i = 0; i < numberOfRooms; i++) {
            Hotel.familyRoom.add(tempRoom);
            Hotel.familyRoom.get(i).setRoomId(i, "FR");
        }

    }

    @Override
    public void updateRoomDetailsForHotel(HotelForAgency Hotel) {

        int numberOfRooms;
        generalRooms tempRoom = new generalRooms();
        System.out.println("    GENERAL/FAMILY rooms");
        System.out.println("-----------------------------");
        System.out.println("How many family rooms cars your hotel?");
        numberOfRooms = helpingMethods.checkIntInput();
        System.out.println("How many beds are available per room:");
        tempRoom.setNumberOfBeds(helpingMethods.checkIntInput());
        System.out.println("What is the room limit cars respect to people: ");
        tempRoom.setRoomLimit(helpingMethods.checkIntInput());
        tempRoom.EnterRoomFees();
        System.out.println("Are you sure you want to confirm changes?(y/n)");
        if (helpingMethods.confirm(in.next().charAt(0))) {

            //save rooms to hotel
            if(numberOfRooms<Hotel.getNumberOfFamilyRooms()){
                for (int i = 0; i < numberOfRooms; i++) {
                    Hotel.familyRoom.get(i).setRoomPrice(tempRoom.getRoomPrice());
                    Hotel.familyRoom.get(i).foodBoardPrice = tempRoom.foodBoardPrice;
                    Hotel.familyRoom.get(i).setNumberOfBeds(tempRoom.getNumberOfBeds());
                    Hotel.familyRoom.get(i).setRoomLimit(tempRoom.getRoomLimit());
                }
                for(int i =numberOfRooms;i< Hotel.getNumberOfFamilyRooms();i++){
                    Hotel.familyRoom.remove(i);
                }
            }
            else if (numberOfRooms==Hotel.getNumberOfFamilyRooms()){
                for (int i = 0; i < numberOfRooms; i++) {
                    Hotel.familyRoom.get(i).setRoomPrice(tempRoom.getRoomPrice());
                    Hotel.familyRoom.get(i).foodBoardPrice = tempRoom.foodBoardPrice;
                    Hotel.familyRoom.get(i).setNumberOfBeds(tempRoom.getNumberOfBeds());
                    Hotel.familyRoom.get(i).setRoomLimit(tempRoom.getRoomLimit());
                }
            }
            else if(numberOfRooms>Hotel.getNumberOfFamilyRooms()){
                for (int i = 0; i < Hotel.getNumberOfFamilyRooms(); i++) {
                    Hotel.familyRoom.get(i).setRoomPrice(tempRoom.getRoomPrice());
                    Hotel.familyRoom.get(i).foodBoardPrice = tempRoom.foodBoardPrice;
                    Hotel.familyRoom.get(i).setNumberOfBeds(tempRoom.getNumberOfBeds());
                    Hotel.familyRoom.get(i).setRoomLimit(tempRoom.getRoomLimit());
                }
                for(int i =Hotel.getNumberOfFamilyRooms() ; i< numberOfRooms; i++){
                    Hotel.familyRoom.add(i, Hotel.familyRoom.get(i-1));
                    Hotel.familyRoom.get(i).setRoomId(i,"FR");
                    Hotel.familyRoom.get(i).setRoomPrice(tempRoom.getRoomPrice());
                    Hotel.familyRoom.get(i).foodBoardPrice = tempRoom.foodBoardPrice;
                    Hotel.familyRoom.get(i).setNumberOfBeds(tempRoom.getNumberOfBeds());
                    Hotel.familyRoom.get(i).setRoomLimit(tempRoom.getRoomLimit());

                }
            }
            Hotel.setNumberOfFamilyRooms(numberOfRooms);
        }
    }
}
