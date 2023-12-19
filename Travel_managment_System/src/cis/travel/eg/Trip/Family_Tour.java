package cis.travel.eg.Trip;

import cis.travel.eg.Service.Activity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static cis.travel.eg.Main.Main.ANSI_COLORS;
import static cis.travel.eg.Main.Main.in;

public class Family_Tour extends Trip implements Serializable {
    private ArrayList<Activity> familyActivities = new ArrayList<>();
    int numberOfChildren;

    public Family_Tour() {
        super();
        this.numberOfChildren = 0;
    }


    public ArrayList<Activity> getFamilyActivities() {
        return familyActivities;
    }

    public void setFamilyActivities(ArrayList<Activity> familyActivities) {
        this.familyActivities = familyActivities;
    }
    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public void addActivity(ArrayList<Activity> activities) {
        activities.stream()
                .filter(activity -> activity.getSuitableFor().equals("Family"))
                .forEach(activity -> familyActivities.add(activity));
    }

    public void displayActivityType() {

        for (Activity activity : familyActivities) {
            System.out.println(activity.getName());
            System.out.println(activity.getDescription());
        }

        char answer;
        do {
            System.out.println("What activity do you want to know the details of? ");
            String activityName = in.nextLine();
            boolean found = false;
            for (Activity activity : familyActivities) {
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
        System.out.println(ANSI_COLORS[14]+"                                    ╚═════════════════════════════════════════" + ANSI_COLORS[0]);
    }


    public double familyDiscount(int numberOfChildren) {
        double discount = 0.0;
        if(numberOfChildren >= 2) {
            discount = 0.1;
        }
        return discount;
    }

    public double calculatePrice(double seats) {
        double priceBeforeDiscount = seats* getPricePerSeat();
        double priceAfterDiscount =  priceBeforeDiscount - priceBeforeDiscount * familyDiscount(getNumberOfChildren());
        return priceAfterDiscount;
    }

    public boolean checkAvailableSeats() {
       return true;
    }
}
