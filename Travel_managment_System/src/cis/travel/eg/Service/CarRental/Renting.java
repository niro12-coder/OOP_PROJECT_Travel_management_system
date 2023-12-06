package cis.travel.eg.Service.CarRental;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Renting {
    Date PickUpDate;
    Date ReturnDate;
    long NumberOfRentingDays;
    float TotalCostForRenting;

    public Renting(Date PickUpDate,Date ReturnDate ) {
        this.PickUpDate=PickUpDate;
        this.ReturnDate=ReturnDate;
        CalculateNumberOfRentingDays();
    }

    public Renting(int pickupDay, int pickupMonth, int pickupYear, int returnDay, int returnMonth, int returnYear) {

//        this.pickupDay = pickupDay;
//        this.pickupMonth = pickupMonth;
//        this.pickupYear = pickupYear;
//        this.returnDay = returnDay;
//        this.returnMonth = returnMonth;
//        this.returnYear = returnYear;
//        this.pickupDate = LocalDate.of(pickupYear, pickupMonth, pickupDay);
//        this.returnDate = LocalDate.of(returnYear, returnMonth, returnDay);
    }


    public void CalculateNumberOfRentingDays() {
        long Days = ChronoUnit.DAYS.between(PickUpDate.getDate(), ReturnDate.getDate());
        this.setNumberOfRentingDays(Days);
    }

    public long getNumberOfRentingDays() {
        return NumberOfRentingDays;
    }

    public void setNumberOfRentingDays(long numberOfRentingDays) {
        NumberOfRentingDays = numberOfRentingDays;
    }

    public float getTotalCostForRenting() {
        return TotalCostForRenting;
    }

    public void setTotalCostForRenting(float totalCostForRenting) {
        TotalCostForRenting = totalCostForRenting;
    }


    @Override
    public String toString() {
        return "Renting{" +
                "PickUpDate=" + PickUpDate +
                ", ReturnDate=" + ReturnDate +
                ", NumberOfRentingDays=" + NumberOfRentingDays +
                ", TotalCostForRenting=" + TotalCostForRenting +
                '}';
    }
}
