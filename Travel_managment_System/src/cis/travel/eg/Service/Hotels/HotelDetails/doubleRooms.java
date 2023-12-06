package cis.travel.eg.Service.Hotels.HotelDetails;

import java.util.ArrayList;

public class doubleRooms extends roomsForManager {
    static int doubleRoomNumber=0;

    public doubleRooms( int numberOfAvailableBoolViewRooms,int numberOfAvailableSideViewRooms  ){
        //super();
        doubleRoomNumber++;
        setRoomId(doubleRoomNumber, "DR"); //sr stands for single room
        this.roomType= "Double";
        this.roomLimit=2;
        this.numberOfBeds=1;
        Reservations=new ArrayList<>();
    }

    @Override
    public void addRoomTypeDetails() {

    }

    @Override
    public void editRoomTypeDetails() {

    }
}
