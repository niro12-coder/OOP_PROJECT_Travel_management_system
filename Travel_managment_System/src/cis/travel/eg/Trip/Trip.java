package cis.travel.eg.Trip;

import cis.travel.eg.Service.Activity;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Trip {
    private int tripID;
    private String tripName;
    private String description;
    private String tripType;
    private String startDate;
    private String endDate;
    private int availableSeats;
    private double pricePerSeat;
    private String destination;
    private boolean tripStatus = true;
    // private tourGuide TourGuide;

    public Trip( int availableSeats, double pricePerSeat, String destination) {
        this.availableSeats = availableSeats;
        this.pricePerSeat = pricePerSeat;
        this.destination = destination;
    }

    public Trip() {
        this.tripName=null;
        this.description = null;
        this.tripType = null;
        this.startDate = null;
        this.endDate = null;
        this.availableSeats = 0;
        this.pricePerSeat = 0.0;
        this.destination = null;
        this.tripStatus = false;
    }

    //  GETTERS
    public int getTripID() { return  tripID; }

    public String getTripName() {
        return tripName;
    }

    public String getDescription() {
        return description;
    }

    public String getTripType() {
        return tripType;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public double getPricePerSeat() {
        return pricePerSeat;
    }

    public String getDestination() {
        return destination;
    }

    public boolean isTripStatus() {
        return tripStatus;
    }

    // SETTERS
    public void setTripID(ArrayList<Trip> trips) {
        trips.indexOf(this);
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public void setPricePerSeat(double pricePerSeat) {
        this.pricePerSeat = pricePerSeat;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setTripStatus(boolean tripStatus) {
        this.tripStatus = tripStatus;
    }

    public abstract void addActivity(ArrayList<Activity> activities);

    public abstract void displayActivityType();

    public abstract void displayDetails();            //abstract

    public abstract boolean checkAvailableSeats();    //abstract (seats restriction type)

    public abstract double calculatePrice(double seats);

    public void updateAvailableSeats(int seats) {
        if (seats > availableSeats) {
            System.out.println("No Available Seats!");
            System.out.println("The Available Seats are : " + availableSeats);
        } else {
            availableSeats = -seats;
        }
    }

    public static long calculateDaysBetweenDates(LocalDate date1, LocalDate date2) {
        return ChronoUnit.DAYS.between(date1, date2);
    }

    public void tripNumberOfDays() {

        LocalDate startDate = LocalDate.parse(this.getStartDate());
        LocalDate endDate = LocalDate.parse(this.getEndDate());

        try {
            long daysBetweenDates = calculateDaysBetweenDates(startDate, endDate);
            if (startDate.isAfter(endDate) || endDate.isBefore(startDate)) {
                System.out.println("the start Date should be before the end Date");
            } else {
                System.out.println(ANSI_COLORS[14]+"Duration of the Trip: " + ANSI_COLORS[13]+daysBetweenDates + " days");
            }
        }
        catch(NullPointerException e){
            System.out.println("Invalid date: " + e.getMessage());
        }
    }

    public void isTripOngoing() {
        LocalDate currentDateInCountry= LocalDate.now();

        LocalDate startDate = LocalDate.parse(this.getStartDate());
        LocalDate endDate = LocalDate.parse(this.getEndDate());

        // Compare the dates
        if (endDate.isBefore(currentDateInCountry)) {
            long daysBetweenDates = calculateDaysBetweenDates(endDate, currentDateInCountry);
            if (daysBetweenDates == 1) {
                System.out.println("The Trip has ended " + daysBetweenDates + " day ago.");
            }
            else {
                System.out.println("The Trip has ended " + daysBetweenDates + " days ago.");
            }
            tripStatus = false;
        }
        else if (startDate.isBefore(currentDateInCountry) && endDate.isAfter(currentDateInCountry)) {
            System.out.println("The Trip is still Active.");
            tripStatus = false;
        }
        else if (startDate.isAfter(currentDateInCountry)) {
            long daysBetweenDates = calculateDaysBetweenDates(currentDateInCountry, startDate);
            if (daysBetweenDates == 1) {
                System.out.println("The Trip will start " + daysBetweenDates + " days.");
            } else {
                System.out.println("The Trip will start " + daysBetweenDates + " days.");
            }
        }
        else if (startDate.isEqual(currentDateInCountry)) {
            System.out.println("The Trip will start today.");
            tripStatus = false;
        }
        else if (endDate.isEqual(currentDateInCountry)) {
            System.out.println("The Trip will end today.");
            tripStatus = false;
        }
    }

    public static Scanner in= new Scanner(System.in);
    public static final String[] ANSI_COLORS = {
            "\u001B[0m",    // Reset 0
            "\u001B[30m",   // Black 1
            "\u001B[31m",   // Red    2
            "\u001B[32m",   // Green   3
            "\u001B[33m",   // Yellow  4
            "\u001B[34m",   // Blue  5
            "\u001B[35m",   // Purple 6
            "\u001B[36m",   // Cyan 7
            "\u001B[37m",   // White 8
            "\u001B[90m",   // Dark gray 9
            "\u001B[91m",   // Bright red 10
            "\u001B[92m",   // bright green  11
            "\u001B[93m",   // bright yellow  12
            "\u001B[94m",   // bright blue  13
            "\u001B[95m",   // bright purple  14
            "\u001B[96m",   // bright cyan  15
            "\u001B[97m"    // bright white  16
    };
}
