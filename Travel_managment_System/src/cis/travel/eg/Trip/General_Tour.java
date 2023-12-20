package cis.travel.eg.Trip;

import cis.travel.eg.Main.Main;
import cis.travel.eg.Service.Activity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static cis.travel.eg.Main.Main.ANSI_COLORS;
import static cis.travel.eg.Main.Main.in;

public class General_Tour extends Trip implements Serializable {

    private ArrayList<Activity> generalActivities = new ArrayList<>();
    private boolean isStudent;

    public ArrayList<Activity> getGeneralActivities() {
        return generalActivities;
    }

    public void setGeneralActivities(ArrayList<Activity> generalActivities) {
        this.generalActivities = generalActivities;
    }

    public General_Tour(){
        super();
        this.isStudent=false;
    }


    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    public void addActivity(ArrayList<Activity> activities) {
        activities.stream()
                .filter(activity -> activity.getSuitableFor().equals("General Tour"))
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
        // Format the description into lines with sentences each line
        List<String> formattedDescription = formatDescription(getDescription());

        System.out.println(ANSI_COLORS[14]);
        System.out.println("                                    ╔════════════════════════════════════════╗");
        System.out.println("                                    ║              "+ANSI_COLORS[16]+"Trip Details"+ANSI_COLORS[14]+"              ║");
        System.out.println("                                    ╚════════════════════════════════════════╝");
        System.out.println(ANSI_COLORS[14]+"                                    ║    Name: " +ANSI_COLORS[13]+ getTripName() );
        System.out.println(ANSI_COLORS[14]+"                                    ║    Description: ");
        for (String line : formattedDescription) {
            System.out.println(ANSI_COLORS[14]+"                                    ║    " + ANSI_COLORS[13]+line);
        }
        System.out.println(ANSI_COLORS[14]+"                                    ║");
        System.out.println(ANSI_COLORS[14]+"                                    ║    Trip type: " +ANSI_COLORS[13]+ getTripType() + '\n' +
                ANSI_COLORS[14]+"                                    ║    Destination: " +ANSI_COLORS[13]+ getDestination() + '\n' +
                ANSI_COLORS[14]+"                                    ║    Price per Person: " +ANSI_COLORS[13]+ getPricePerSeat() + "$ \n" +
                ANSI_COLORS[14]+"                                    ║    Number of available Seats: " +ANSI_COLORS[13]+ getAvailableSeats() + '\n' +
                ANSI_COLORS[14]+"                                    ║    Start Date: " +ANSI_COLORS[13]+ getStartDate() + '\n' +
                ANSI_COLORS[14]+"                                    ║    End Date: " +ANSI_COLORS[13]+ getEndDate() );
        System.out.print(ANSI_COLORS[14]+"                                    ║    ");
        tripNumberOfDays();
        System.out.println(ANSI_COLORS[14]+"                                    ╚═════════════════════════════════════════" + ANSI_COLORS[16]);
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
