package cis.travel.eg.Service.Hotels.HotelDetails;

import cis.travel.eg.Service.Hotels.DetailsForSystem.HotelForAgency;
import cis.travel.eg.Service.helpingMethods.helpingMethods;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public abstract class roomsForManager extends basicRoomDetails implements Serializable {
    public ArrayList<LocalDate> Reservations = new ArrayList<>();

    public void setRoomId(int rNum, String rType) {

        this.setRoomId(rType + rNum);
    }

    public void addNewReservation(LocalDate start, LocalDate end) {
        Reservations.add(start);
        Reservations.add(end);
        Reservations.sort(Comparator.naturalOrder());
    }

    public void EnterRoomFees() {
        System.out.println(" Enter room fees per day:");
        this.setRoomPrice(helpingMethods.checkFeesInput());
        System.out.println("Now you will enter food board fees per day:");
        System.out.println("Breakfast:");
        this.foodBoardPrice[0] = helpingMethods.checkFeesInput();
        System.out.println("Lunch:");
        this.foodBoardPrice[1] = helpingMethods.checkFeesInput();
        System.out.println("Dinner:");
        this.foodBoardPrice[2] = helpingMethods.checkFeesInput();
    }

    public abstract void assignRoomDetailsForHotel(HotelForAgency Hotel);

    public abstract void updateRoomDetailsForHotel(HotelForAgency Hotel);
}
