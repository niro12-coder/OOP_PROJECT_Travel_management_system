package cis.travel.eg.Trip;

import cis.travel.eg.Main.Main;
import cis.travel.eg.Service.Activity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public abstract class Trip implements Serializable {
    private int tripID;
    private String tripName;
    private String description;
    private String tripType; //
    private String startDate; //
    private String endDate; //
    private int availableSeats; //
    private double pricePerSeat; //
    private String destination; //
    private String assignedTourGuides;
    private boolean tripStatus = true;


    // private tourGuide TourGuide;
    private ArrayList<Integer> rate;
    private int avgRate;


    public Trip(Trip trip) {
        this.tripName = trip.getTripName();
        this.description = trip.getDescription();
        this.tripType = trip.getTripType();
        this.startDate = trip.getStartDate();
        this.endDate = trip.getEndDate();
        this.availableSeats = trip.getAvailableSeats();
        this.pricePerSeat = trip.getPricePerSeat();
        this.destination = trip.getDestination();
    }

    public Trip(int availableSeats, double pricePerSeat, String destination) {
        this.availableSeats = availableSeats;
        this.pricePerSeat = pricePerSeat;
        this.destination = destination;
    }

    public Trip() {
        this.tripName = null;
        this.description = null;
        this.tripType = null;
        this.startDate = null;
        this.endDate = null;
        this.availableSeats = 0;
        this.pricePerSeat = 0.0;
        this.destination = null;
        this.tripStatus = false;
    }

    public static long calculateDaysBetweenDates(LocalDate date1, LocalDate date2) {
        return ChronoUnit.DAYS.between(date1, date2);
    }

    //  GETTERS
    public int getTripID() {
        return tripID;
    }

    // SETTERS
    public void setTripID(ArrayList<Trip> trips) {
        trips.indexOf(this);
    }

    public int getAvgRate() {
        return avgRate;
    }

    public void setAvgRate(int avgRate) {
        this.avgRate = avgRate;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public double getPricePerSeat() {
        return pricePerSeat;
    }

    public void setPricePerSeat(double pricePerSeat) {
        this.pricePerSeat = pricePerSeat;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getAssigendTourGuides() {
        return assignedTourGuides;
    }

    public void setAssigendTourGuides(String assigendTourGuides) {
        this.assignedTourGuides = assigendTourGuides;
    }

    public boolean isTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(boolean tripStatus) {
        this.tripStatus = tripStatus;
    }

    public ArrayList<Integer> getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = new ArrayList<>();
        this.rate.add(rate);
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

    public void tripNumberOfDays() {

        LocalDate startDate = LocalDate.parse(this.getStartDate());
        LocalDate endDate = LocalDate.parse(this.getEndDate());

        try {
            long daysBetweenDates = calculateDaysBetweenDates(startDate, endDate);
            if (startDate.isAfter(endDate) || endDate.isBefore(startDate)) {
                System.out.println("the start Date should be before the end Date");
            } else {
                System.out.println(Main.ANSI_COLORS[14] + "Duration of the Trip: " + Main.ANSI_COLORS[13] + daysBetweenDates + " days");
            }
        } catch (NullPointerException e) {
            System.out.println("Invalid date: " + e.getMessage());
        }
    }

    public void isTripOngoing() {
        LocalDate currentDateInCountry = LocalDate.now();

        LocalDate startDate = LocalDate.parse(this.getStartDate());
        LocalDate endDate = LocalDate.parse(this.getEndDate());

        // Compare the dates
        if (endDate.isBefore(currentDateInCountry)) {
            long daysBetweenDates = calculateDaysBetweenDates(endDate, currentDateInCountry);
            if (daysBetweenDates == 1) {
                System.out.println("The Trip has ended " + daysBetweenDates + " day ago.");
            } else {
                System.out.println("The Trip has ended " + daysBetweenDates + " days ago.");
            }
            tripStatus = false;
        } else if (startDate.isBefore(currentDateInCountry) && endDate.isAfter(currentDateInCountry)) {
            System.out.println("The Trip is still Active.");
            tripStatus = false;
        } else if (startDate.isAfter(currentDateInCountry)) {
            long daysBetweenDates = calculateDaysBetweenDates(currentDateInCountry, startDate);
            if (daysBetweenDates == 1) {
                System.out.println("The Trip will start " + daysBetweenDates + " days.");
            } else {
                System.out.println("The Trip will start " + daysBetweenDates + " days.");
            }
        } else if (startDate.isEqual(currentDateInCountry)) {
            System.out.println("The Trip will start today.");
            tripStatus = false;
        } else if (endDate.isEqual(currentDateInCountry)) {
            System.out.println("The Trip will end today.");
            tripStatus = false;
        }
    }

    @Override
    public String toString() {
        return "Trip{" +
                "tripID=" + tripID +
                ", tripName='" + tripName + '\'' +
                ", description='" + description + '\'' +
                ", tripType='" + tripType + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", availableSeats=" + availableSeats +
                ", pricePerSeat=" + pricePerSeat +
                ", destination='" + destination + '\'' +
                ", tripStatus=" + tripStatus +
                ", rate=" + rate +
                ", avgRate=" + avgRate +
                '}';
    }
}
