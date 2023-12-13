package cis.travel.eg.Service.helpingMethods;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class helpingMethods implements Serializable {
    Scanner in = new Scanner(System.in);
    public static boolean isDateInTheTripeDuration (LocalDate pickupDate, LocalDate returnDate, String tripPickupDate, String tripReturnDate) {
        /*
         // Define the format of the input String
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Parse the String into a LocalDate
        LocalDate localDate = LocalDate.parse(dateString, formatter);
        */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDateForTripPickupDate = LocalDate.parse(tripPickupDate, formatter);
        LocalDate localDateForTripReturnDate = LocalDate.parse(tripReturnDate, formatter);


        return (localDateForTripPickupDate.isBefore(pickupDate) || localDateForTripPickupDate.isEqual(pickupDate)) && (localDateForTripReturnDate.isAfter(returnDate) || localDateForTripReturnDate.isEqual(returnDate));

    }
    public static int InputValidOrNot(int minRange, int maxRage, int number) {
        Scanner in =new Scanner(System.in);
        if (number >= minRange && number <= maxRage) {
            return number;
        } else {
            System.out.printf("the number you have enter is not valid please Enter a number in this range ( %d : %d ) \n", minRange, maxRage);
            number = in.nextInt();
            InputValidOrNot(minRange, maxRage, number);
        }
        return number;
    }
    public static char InputYesOrNo (char ans) {
        Scanner in =new Scanner(System.in);
        if(ans=='N' || ans=='n'||ans=='Y' || ans=='y'){
            return ans;
        }
        else {
            System.out.println("invalid input, enter ( y / n ) /n ");
            ans=in.next().charAt(0);
            InputYesOrNo(ans);
        }
        return ans;
    }
    public static boolean confirm(char ans) {
        Scanner in = new Scanner(System.in);

        if(ans=='N' || ans=='n'){ return false;}
        else if (ans=='Y' || ans=='y') {
            return true;
        }
        else {
            System.out.println("invalid input, enter again: /n ");
            return confirm(in.next().charAt(0));
        }
    }

    public static int choice(int lowerRange, int higherRange){
        Scanner in = new Scanner(System.in);
        int number;
        do {
            number= in.nextInt();
            if(number<lowerRange || number>higherRange) {
                System.out.println("Invalid input please enter number from "+ lowerRange+ " to "+ higherRange +"/n" );
            }
        }while(number<lowerRange || number>higherRange);
        return number;
    }
    public static double checkFeesInput(){
        Scanner in = new Scanner(System.in);
        double fees;
        do {
            fees= in.nextDouble();
            if(fees<0) {
                System.out.println("Invalid input please enter number\n" );
            }
        }while(fees<0);
        return fees;
    }
    public static int checkIntInput(){
        Scanner in = new Scanner(System.in);
        int number;
        do {
            number= in.nextInt();
            if(number<0) {
                System.out.println("Invalid input please enter number\n" );
            }
        }while(number<0);
        return number;
    }
}
