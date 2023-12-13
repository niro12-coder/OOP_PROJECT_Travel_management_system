package cis.travel.eg.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Activity {
    private int activityID;
    private String name;
    private String activityType; //
    private String suitableFor;
    private String description;
    private String location;
    private int duration;  // minutes
    private String ticketType;
    private double price;


    private String date;

    public Activity(Activity Activity) {
        this.activityID = Activity.getActivityID();
        this.name = Activity.getName();
        this.activityType = Activity.getActivityType();
        this.suitableFor = Activity.getSuitableFor();
        this.description = Activity.getDescription();
        this.location = Activity.getLocation();
        this.duration = Activity.getDuration();
        this.price = Activity.getPrice();
        this.date = Activity.getDate();
    }

    public Activity() {
        this.activityID = 0;
        this.name = null;
        this.activityType = null;
        this.suitableFor = null;
        this.description = null;
        this.location = null;
        this.duration = 0;
        this.price = 0;
        this.date = null;
    }

    // GETTERS
    public int getActivityID() {
        return activityID;
    }

    public String getName() {
        return name;
    }

    public String getActivityType() {
        return activityType;
    }

    public String getSuitableFor() {
        return suitableFor;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public int getDuration() {
        return duration;
    }

    public double getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }

    public String getTicketType() {
        return ticketType;
    }

    // SETTERS
    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public void setSuitableFor(String suitableFor) {
        this.suitableFor = suitableFor;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }


    public String calcDuration() {
        int hours = duration / 60;
        int minutes = duration - (hours * 60);
        return "(" + hours + " Hours ," + minutes + " minutes)";
    }

    public void displayActivityDetails() {
        System.out.println(ANSI_COLORS[15]);
        System.out.println("                                    ╔═════════════════════════════════════╗");
        System.out.println("                                    ║           "+ANSI_COLORS[16]+"Activity Details"+ANSI_COLORS[15]+"          ║");
        System.out.println("                                    ╚═════════════════════════════════════╝");
        System.out.println(
                ANSI_COLORS[15]+"                                    ║    Name: " +ANSI_COLORS[12]+ getName() + '\n' +
                        ANSI_COLORS[15]+"                                    ║    Description: " + ANSI_COLORS[12]+getDescription() + '\n' +
                        ANSI_COLORS[15]+"                                    ║    Activity type: " +ANSI_COLORS[12]+ getActivityType() + '\n' +
                        ANSI_COLORS[15]+"                                    ║    Activity for trip: " +ANSI_COLORS[12]+ getSuitableFor() + '\n' +
                        ANSI_COLORS[15]+"                                    ║    Location: " +ANSI_COLORS[12]+ getLocation()+ '\n' +
                        ANSI_COLORS[15]+"                                    ║    Price per seat: " +ANSI_COLORS[12]+ getPrice() + "$ \n" +
                        ANSI_COLORS[15]+"                                    ║    Duration: " +ANSI_COLORS[12]+ getDuration() + '\n' +
                        ANSI_COLORS[15]+"                                    ║    Date: " +ANSI_COLORS[12]+ getDate() );
        System.out.println(ANSI_COLORS[15]+"                                    ╚══════════════════════════════════════" + ANSI_COLORS[0]);
    }


    public static long calculateDaysBetweenDates(LocalDate date1, LocalDate date2) {
        return ChronoUnit.DAYS.between(date1, date2);
    }

    public void isActivityOngoing() {
        LocalDate currentDateInCountry= LocalDate.now();

        LocalDate Date = LocalDate.parse(this.getDate());

        // Compare the dates
        if (Date.isBefore(currentDateInCountry)) {
            long daysBetweenDates = calculateDaysBetweenDates(Date, currentDateInCountry);
            System.out.println("The Activity has ended " + daysBetweenDates + "days ago.");
        } else if (Date.isEqual(currentDateInCountry)) {
            System.out.println("The Activity is still on going.");
        } else {
            long daysBetweenDates = calculateDaysBetweenDates(currentDateInCountry, Date);
            System.out.println("The The Activity is after " + daysBetweenDates + "days.");
        }
    }

    public boolean EgyptHolidays() {
        LocalDate Date = LocalDate.parse(this.getDate());

        ArrayList<LocalDate> egyptHolidays = new ArrayList<>();
        // List of example holidays in Egypt
        egyptHolidays.add(LocalDate.of(Date.getYear(), 1, 1));   // New Year's Day
        egyptHolidays.add(LocalDate.of(Date.getYear(), 4, 25));  // Sinai Liberation Day
        egyptHolidays.add(LocalDate.of(Date.getYear(), 5, 1));   // Labor Day
        egyptHolidays.add(LocalDate.of(Date.getYear(), 6, 30));  // Revolution Day
        egyptHolidays.add(LocalDate.of(Date.getYear(), 7, 23));  // Revolution Day
        egyptHolidays.add(LocalDate.of(Date.getYear(), 10, 6));  // Armed Forces Day
        egyptHolidays.add(LocalDate.of(Date.getYear(), 12, 25));  // Christmas

        boolean dateExists = egyptHolidays.stream()
                .anyMatch(date -> date.equals(Date));

        return egyptHolidays.contains(Date);
    }

    public double discountForActivity() {
        double discount = 0.0;
        LocalDate activityDate = LocalDate.parse(this.getDate());
        if (EgyptHolidays()) {
            discount = 0.3;
        }
        return discount;
    }

    public double calculatePrice() {
        double priceBeforeDiscount = getPrice();
        double priceAfterDiscount = priceBeforeDiscount - priceBeforeDiscount * discountForActivity();
        return priceAfterDiscount;
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
