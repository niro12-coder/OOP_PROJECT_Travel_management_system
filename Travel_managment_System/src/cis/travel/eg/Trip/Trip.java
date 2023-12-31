package cis.travel.eg.Trip;

import cis.travel.eg.Main.Main;
import cis.travel.eg.Main.Ticket;
import cis.travel.eg.Service.Activity;
import cis.travel.eg.User.TourGuideDetails.*;

import java.io.Serializable;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

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
    private TourGuide tourGuide;
    private  ArrayList<Integer> rate;
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


    public TourGuide getTourGuide() {
        return tourGuide;
    }

    public int getTripID() { return  tripID; }

    public int getAvgRate() {
        return avgRate;
    }

    public void setAvgRate(int avgRate) {
        this.avgRate = avgRate;
    }

    public String getTripName() {
        return tripName;
    }
    public void setRate(int rate) {
        this.rate = new ArrayList<>();
        this.rate.add(rate);
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

    public ArrayList<Integer> getRate() {
        return rate;
    }

    public boolean isTripStatus() {
        return tripStatus;
    }

    // SETTERS


    public void setTripID(int tripID) {
        this.tripID = tripID;
    }

    public void setTourGuide(TourGuide tourGuide) {
        this.tourGuide = tourGuide;
    }

    public void setRate(ArrayList<Integer> rate) {
        this.rate = rate;
    }

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
    public void setAssignedTourGuides(String assignedTourGuides){this.assignedTourGuides=assignedTourGuides;}





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
                System.out.println(Main.ANSI_COLORS[14]+"Duration of the Trip: " + Main.ANSI_COLORS[13]+daysBetweenDates + " days");
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

    public static List<String> formatDescription(String userDescription) {
        List<String> lines = new ArrayList<>();
        // Split the description into sentences based on periods or commas
        String[] sentences = userDescription.split("(?<=[.,])\\s*");

        StringBuilder line = new StringBuilder();
        for (String sentence : sentences) {
            if (line.length() + sentence.length() <= 20) {
                // Add the sentence to the current line if it doesn't exceed 20 characters
                line.append(sentence).append(" ");
            } else {
                // If adding the sentence exceeds 20 characters, start a new line
                lines.add(line.toString().trim());
                line = new StringBuilder(sentence + " ");
            }
        }

        // Add the last line
        lines.add(line.toString().trim());

        return lines;
    }
}

