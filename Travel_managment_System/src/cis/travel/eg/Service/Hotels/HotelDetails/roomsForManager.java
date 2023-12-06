package cis.travel.eg.Service.Hotels.HotelDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public abstract class roomsForManager extends basicRoomDetails {
    int numberOfAvailableRooms;
//    public ArrayList<LocalDate> startDateReservations;
//    public ArrayList<LocalDate> endDateReservations;
    public ArrayList<LocalDate> Reservations;
    public final void setRoomId(int rNum , String rType){
        this.roomId= rType+ rNum;
    }
    public abstract void addRoomTypeDetails();
    public abstract void editRoomTypeDetails();
public void addNewReservation(LocalDate start, LocalDate end){
    Reservations.add(start);
    Reservations.add(end);
    Reservations.sort(Comparator.naturalOrder());

}
}
