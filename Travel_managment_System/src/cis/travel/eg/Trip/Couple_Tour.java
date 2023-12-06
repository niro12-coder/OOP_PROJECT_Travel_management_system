package cis.travel.eg.Trip;

import cis.travel.eg.Service.Activity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Couple_Tour extends Trip {

    private ArrayList<Activity> coupleActivities;

    public Couple_Tour(){
        super();
    }

    public void addActivity(ArrayList<Activity> activities) {
        activities.stream()
                .filter(activity -> activity.getSuitableFor().equals("Couple"))
                .forEach(activity -> coupleActivities.add(activity));
    }

    public void displayActivityType() {
        Scanner input = new Scanner(System.in);
        for (Activity activity : coupleActivities) {
            System.out.println(activity.getName());
            System.out.println(activity.getDescription());
        }

        char answer;
        do {
            System.out.println("What activity do you want to know the details of? ");
            String activityName = input.nextLine();
            boolean found = false;
            for (Activity activity : coupleActivities) {
                if (activity.getName().equals(activityName)) {
                    activity.displayActivityDetails();
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("There is no Activity with that name, Please try again");
            }
            System.out.println("if you want to know the details about another activity, please enter 'y' or 'Y'.");
            answer = input.next().charAt(0);
        } while (answer == 'y' || answer == 'Y');
    }


    public void displayDetails() {
        System.out.println(ANSI_COLORS[14]);
        System.out.println("                                    ╔═══════════════════════════════════╗");
        System.out.println("                                    ║            "+ANSI_COLORS[16]+"Trip Details"+ANSI_COLORS[14]+"           ║");
        System.out.println("                                    ╚═══════════════════════════════════╝");
        System.out.println(
                ANSI_COLORS[14]+"                                    ║    Name: " +ANSI_COLORS[13]+ getTripName() + '\n' +
                        ANSI_COLORS[14]+"                                    ║    Description: " + ANSI_COLORS[13]+getDescription() + '\n' +
                        ANSI_COLORS[14]+"                                    ║    Trip type: " +ANSI_COLORS[13]+ getTripType() + '\n' +
                        ANSI_COLORS[14]+"                                    ║    Destination: " +ANSI_COLORS[13]+ getDestination() + '\n' +
                        ANSI_COLORS[14]+"                                    ║    Price per Person: " +ANSI_COLORS[13]+ getPricePerSeat() + "$ \n" +
                        ANSI_COLORS[14]+"                                    ║    Number of available Seats: " +ANSI_COLORS[13]+ getAvailableSeats() + '\n' +
                        ANSI_COLORS[14]+"                                    ║    Start Date: " +ANSI_COLORS[13]+ getStartDate() + '\n' +
                        ANSI_COLORS[14]+"                                    ║    End Date: " +ANSI_COLORS[13]+ getEndDate() );
        System.out.print(ANSI_COLORS[14]+"                                    ║    ");
        tripNumberOfDays();
        System.out.println(ANSI_COLORS[14]+"                                    ╚════════════════════════════════════" + ANSI_COLORS[0]);
    }

    public boolean coupleHolidays(){
        LocalDate startDate = LocalDate.parse(this.getStartDate());
        LocalDate endDate = LocalDate.parse(this.getEndDate());

        if (LocalDate.of(startDate.getYear(), 2, 14).isEqual(startDate) || LocalDate.of(endDate.getYear(), 2, 14).isEqual(startDate)){
            return true;
        }
        else if (LocalDate.of(startDate.getYear(), 11, 4).isEqual(startDate) || LocalDate.of(endDate.getYear(), 11, 4).isEqual(startDate)){
            return true;
        }
        else if(LocalDate.of(startDate.getYear(), 2, 14).isAfter(startDate) || LocalDate.of(endDate.getYear(), 2, 14).isBefore(startDate)){
            return true;
        }
        else if(LocalDate.of(startDate.getYear(), 11, 4).isAfter(startDate) || LocalDate.of(endDate.getYear(), 11, 4).isBefore(startDate)){
            return true;
        }
        else {
            return false;
        }
    }

    public double coupleDiscount() {
        double discount = 0.0;
        if(coupleHolidays()) {
            discount = 0.15;
        }
        return discount;
    }

    public double calculatePrice(double seats) {
        double priceBeforeDiscount = seats* getPricePerSeat();
        double priceAfterDiscount =  priceBeforeDiscount - priceBeforeDiscount * coupleDiscount();
        return priceAfterDiscount;
    }

    public boolean checkAvailableSeats() {
        return true;
    }
}
