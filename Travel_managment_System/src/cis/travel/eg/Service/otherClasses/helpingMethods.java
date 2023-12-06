package cis.travel.eg.Service.otherClasses;

import java.util.Scanner;

public class helpingMethods {
    Scanner in = new Scanner(System.in);
 public  boolean confirm(char ans) {
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
}
