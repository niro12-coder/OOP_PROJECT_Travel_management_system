

import cis.travel.eg.Trip.*;
import cis.travel.eg.User.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

   public static Scanner in= new Scanner(System.in);
    public static final String[] ANSI_COLORS = {
            "\u001B[0m",    // Reset
            "\u001B[30m",   // Black
            "\u001B[31m",   // Red
            "\u001B[32m",   // Green
            "\u001B[33m",   // Yellow
            "\u001B[34m",   // Blue
            "\u001B[35m",   // Purple
            "\u001B[36m",   // Cyan
            "\u001B[37m"    // White
    };


    //// all classes must  'implements Serializable' and have toString function
    public static void ReadingData(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<TourGuide> TourGuides, ArrayList<Manager> Managers, ArrayList<Trip> Trips_system) {

        String filePath = "Data.txt";
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            Admins.addAll((ArrayList<Admin>) inputStream.readObject());
            Customers.addAll((ArrayList<Customer>) inputStream.readObject());
            TourGuides.addAll((ArrayList<TourGuide>) inputStream.readObject());
            Managers.addAll((ArrayList<Manager>) inputStream.readObject());
            Trips_system.addAll((ArrayList<Trip>) inputStream.readObject());

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

    public static void WritingData(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<TourGuide> TourGuides, ArrayList<Manager> Managers, ArrayList<Trip> Trips_system) {

        String filePath = "Data.txt";
        //auto closeable
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(Admins);
            outputStream.writeObject(Customers);
            outputStream.writeObject(TourGuides);
            outputStream.writeObject(Managers);
            outputStream.writeObject(Trips_system);
        } catch (IOException e) {
            System.out.println("File Not Fount!");
        }

    }

    public  static int Input(int mn,int max){

        int answer;
        while(true)
        {
            answer=in.nextInt();
            if(answer>=mn && answer<=max) return answer;
            System.out.println("Invalid input.");
        }

    }

    public static void Welcome()
    {

        System.out.println( ANSI_COLORS[5]);
        System.out.println("        |\\");
        System.out.println("       /  \\");
        System.out.println("      /    \\");
        System.out.println("     /______\\");
        System.out.println("    /________\\");
        System.out.println("   /__________\\");
        System.out.println("  /____________\\");
        System.out.println(" /_/\\/\\/\\/\\/\\__\\");
        System.out.println(" \\ \\/\\/\\/\\/\\/ /");
        System.out.println("  \\__________/");

        System.out.println("   __|__ |__|__");
        System.out.println("  / ********** \\");
        System.out.println(" | ************ |");
        System.out.println(" \\____________/");
        System.out.println("  '----------'"+ANSI_COLORS[0]);
        System.out.println();

        System.out.println( "      **********     "+ANSI_COLORS[7]+"            Welcome to WanderLift       "+ANSI_COLORS[7]+"          **********        ");
        System.out.println( "Embark on Your Journey Beyond Boundaries with WanderLift: Explore, Experience, Enjoy!:3  ");
        sleep();
         cls();
    }
    public static void cls()
    {
        for(int i=0;i<33;i++)
        {
            System.out.println();
        }
    }

    public static void sleep()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
    public static String login_arrays(String username,String password,ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<TourGuide> TourGuides, ArrayList<Manager> Managers)
    {
        int index;
        if(index=Admin.Is_Login_sucess(username,password,Admins)!=-1)
        {
           return "A "+index;
        }
        if(index=Customer.Is_Login_sucess(username,password,Customers)!=-1)
        {
            return "C "+index;
        }
        if(index=Manager.Is_Login_sucess(username,password,Managers)!=-1)
        {
            return "M "+index;
        }
        if(index=TourGuide.Is_Login_sucess(username,password,TourGuides)!=-1)
        {
            return "T "+index;
        }

        return "-1";
    }
    public static int Menu_choice()
    {

        System.out.println("╔══════════════════════╗");
        System.out.println("║  *** WanderLift ***  ║");
        System.out.println("╠══════════════════════╣");
        System.out.println("║    1)Login           ║");
        System.out.println("║    2)Register        ║");
        System.out.println("╚══════════════════════╝");
        cls();
        return Input(1,2);


    }
    public static String Enter_New_password()             //will be changed depending on mariam code
    {

        System.out.println("╔══════════════════════╗");
        System.out.println("║   Forgot Password    ║");
        System.out.println("╠══════════════════════╣");
        System.out.print(  "║ New Password: ");
        String pass = in.next();
        System.out.print(  "║ Confirm Password: ");
        String confirmPass = in.next();
        System.out.println("╚══════════════════════╝");

        cls();
        if(pass.equals(confirmPass))
        {
            return pass;

        }else{
            System.out.println(ANSI_COLORS[2]+"The passwords you entered do not match!"+ANSI_COLORS[0]);
          return Enter_New_password();
        }

    }
    public static void Register( ArrayList<Customer> Customers, ArrayList<TourGuide> TourGuides)
    {

        System.out.println("╔══════════════════════╗");
        System.out.println("║      Register        ║");
        System.out.println("╠══════════════════════╣");
        System.out.println("║    1)Tour guide      ║");
        System.out.println("║    2)Customer        ║");
        System.out.println("╚══════════════════════╝");

        int choice= Input(1,2);
        cls();
        if(choice==1)
        {
            TourGuide tourGuide = new TourGuide();
            tourGuide.Register();
            TourGuides.add(tourGuide);

        }else{
            Customer customer= new Customer();
            customer.Register();
            Customers.add(customer);
        }

    }


    public static int Forgot_Password_OR_Register(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<TourGuide> TourGuides, ArrayList<Manager> Managers)
    {

        cls();
        System.out.println(ANSI_COLORS[2]+"You exceeded the number of trails!"+ANSI_COLORS[0]);
        System.out.println();
        System.out.println("╔══════════════════════╗");
        System.out.println("║1)    Register        ║");
        System.out.println("║2)  Reset password    ║");
        System.out.println("╚══════════════════════╝");

        int choice= Input(1,2);

        if(choice==1)
        {
            return 1;

        }else{

            int trails=0;

            while(true) {
                cls();

                System.out.println("╔══════════════════════╗");
                System.out.print(  "║ Username: ");
                String username = in.next();
                System.out.println("╚══════════════════════╝");


                int index;
                if(index=Admin.FoundUsername(username)!=-1)
                {
                   Admins.get(index).setPassword(Enter_New_password());
                   return 0;
                }
                else if(index=Customer.FoundUsername(username)!=-1)
                {
                    Customers.get(index).setPassword(Enter_New_password());
                    return 0;
                }
                else if(index=Manager.FoundUsername(username)!=-1)
                {
                    Managers.get(index).setPassword(Enter_New_password());
                    return 0;
                }
                else if(index=TourGuide.FoundUsername(username)!=-1)
                {
                    TourGuides.get(index).setPassword(Enter_New_password());

                    System.out.print(ANSI_COLORS[4]+"Password Reset successfully!"+ANSI_COLORS[0]);
                    System.out.println("Directing you to Login...");
                    sleep();
                    return 0;
                }
                else {

                    System.out.println(ANSI_COLORS[2]+"Username Not found!"+ANSI_COLORS[0]);
                    trails++;
                    sleep();

                    if (trails > 3) {
                        System.out.println(ANSI_COLORS[2]+"You exceeded the number of trails!"+ANSI_COLORS[0]);
                        System.out.println("Directing you to registration....");
                        sleep();
                        return 1;
                    }

                }


            }
        }

    }
    public static boolean LoginMenu_ForgotPass_Register(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<TourGuide> TourGuides, ArrayList<Manager> Managers) {

       Welcome();
       int choice=Menu_choice();

       switch(choice)
       {

           case 1:       //login
               int trails=0;

               while(true) {
               System.out.println("╔══════════════════════╗");
               System.out.println("║       Login          ║");
               System.out.println("╠══════════════════════╣");
               System.out.print(  "║ Username: ");
           String username = in.next();
               System.out.print(  "║ Password: ");
           String password = in.next();
               System.out.println("╚══════════════════════╝");

           String Word_Index=login_arrays(username, password, Admins, Customers, TourGuides, Managers);

           if(Word_Index.equals("-1"))
           {
               if(trails<3) {
                   System.out.println(ANSI_COLORS[2]+"Login failed. Please check your credentials...."+ANSI_COLORS[0]);
                   sleep();
                   cls();
                   trails++;
               }
               else {

                  if(Forgot_Password_OR_Register(Admins, Customers, TourGuides, Managers)==1)
                  {
                      cls();
                      Register( Customers,  TourGuides);
                  }

                  cls();
                  LoginMenu_ForgotPass_Register( Admins,  Customers,  TourGuides,  Managers);

               }
           }else{

               boolean state=false;
               switch (Word_Index.charAt(0))
               {
                   case 'A':
                       System.out.println("Login successful....");
                       System.out.println("Directing you to homepage....");
                     state=Admins.get(Integer.parseInt(Word_Index.substring(2))).HomePage();
                       break;

                   case 'C':
                       state=Customers.get(Integer.parseInt(Word_Index.substring(2))).HomePage();
                       break;

                   case 'M':
                       state=Managers.get(Integer.parseInt(Word_Index.substring(2))).HomePage();
                       break;

                   case 'T':
                       state=TourGuides.get(Integer.parseInt(Word_Index.substring(2))).HomePage();
                       break;

               }

               return state;


           }

           }


       break;

           case 2:   //register

               Register( Customers,  TourGuides);
             return LoginMenu_ForgotPass_Register( Admins,  Customers,  TourGuides,  Managers);

           break;
       }


        return false;          //uncertain
    }



    public static void main(String[] args)  {

        ArrayList<Admin> Admins = new ArrayList<Admin>();       //must add at least one
        ArrayList<Customer> Customers = new ArrayList<Customer>();
        ArrayList<TourGuide> TourGuides = new ArrayList<TourGuide>();
        ArrayList<Manager> Managers = new ArrayList<Manager>();       //must add at least one

        // for login
        Admin CurrentAdmin_index = new Admin();                        //not used
        Customer CurrentCustomer_index = new Customer();
        TourGuide CurrentTourGuide_index = new TourGuide();
        Manager CurrentManager_index = new Manager();

        ArrayList<Trip> Trips_system = new ArrayList<Trip>();

        ReadingData(Admins, Customers, TourGuides, Managers, Trips_system);

        while(true) {

            boolean state=LoginMenu_ForgotPass_Register(Admins, Customers, TourGuides, Managers);
            if (state) // 0 logout   // 1 exit
            {
                //exit program
                WritingData(Admins, Customers, TourGuides, Managers, Trips_system);
                return;
            }

        }

    }

}

