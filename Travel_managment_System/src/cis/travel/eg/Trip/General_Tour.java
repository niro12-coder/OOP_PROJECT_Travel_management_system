package cis.travel.eg.Trip;

import cis.travel.eg.Main.Main;
import cis.travel.eg.Service.Activity;

import java.io.Serializable;
import java.util.ArrayList;

import static cis.travel.eg.Main.Main.in;

public class General_Tour extends Trip implements Serializable {

    private ArrayList<Activity> generalActivities;
    private boolean isStudent;

    public General_Tour(){
        super();
        this.isStudent=false;
    }

    public void addActivity(ArrayList<Activity> activities) {
        activities.stream()
                .filter(activity -> activity.getSuitableFor().equals("General"))
                .forEach(activity -> generalActivities.add(activity));
    }

    public void displayActivityType() {
        for (Activity activity : generalActivities) {
            System.out.println(activity.getName());
            System.out.println(activity.getDescription());
        }

        char answer;
        do {
            System.out.println("What activity do you want to know the details of? ");
            String activityName = in.nextLine();
            boolean found = false;
            for (Activity activity : generalActivities) {
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
            answer = in.next().charAt(0);
        } while (answer == 'y' || answer == 'Y');
    }

    public void displayDetails() {
        System.out.println(Main.ANSI_COLORS[14]);
        System.out.println("                                    ╔═══════════════════════════════════╗");
        System.out.println("                                    ║            "+Main.ANSI_COLORS[16]+"Trip Details"+Main.ANSI_COLORS[14]+"           ║");
        System.out.println("                                    ╚═══════════════════════════════════╝");
    System.out.println(
            Main.ANSI_COLORS[14]+"                                    ║    Name: " +Main.ANSI_COLORS[13]+ getTripName() + '\n' +
            Main.ANSI_COLORS[14]+"                                    ║    Description: " + Main.ANSI_COLORS[13]+getDescription() + '\n' +
            Main.ANSI_COLORS[14]+"                                    ║    Trip type: " +Main.ANSI_COLORS[13]+ getTripType() + '\n' +
            Main.ANSI_COLORS[14]+"                                    ║    Destination: " +Main.ANSI_COLORS[13]+ getDestination() + '\n' +
            Main.ANSI_COLORS[14]+"                                    ║    Price per Person: " +Main.ANSI_COLORS[13]+ getPricePerSeat() + "$ \n" +
            Main.ANSI_COLORS[14]+"                                    ║    Number of available Seats: " +Main.ANSI_COLORS[13]+ getAvailableSeats() + '\n' +
            Main.ANSI_COLORS[14]+"                                    ║    Start Date: " +Main.ANSI_COLORS[13]+ getStartDate() + '\n' +
            Main.ANSI_COLORS[14]+"                                    ║    End Date: " +Main.ANSI_COLORS[13]+ getEndDate() );
        System.out.print(Main.ANSI_COLORS[14]+"                                    ║    ");
                 tripNumberOfDays();
                 System.out.println(Main.ANSI_COLORS[14]+"                                    ╚════════════════════════════════════" + Main.ANSI_COLORS[0]);
    }

    public double generalDiscount() {
        double discount =0.0;
        if (isStudent) {
            discount =0.15;
        }
        return discount ;
    }

    public double calculatePrice(double seats) {
        double priceBeforeDiscount = seats * getPricePerSeat();
        double priceAfterDiscount =  priceBeforeDiscount - priceBeforeDiscount * generalDiscount();
        return priceAfterDiscount;
    }

    public boolean checkAvailableSeats() {
        return true;
    }
}
