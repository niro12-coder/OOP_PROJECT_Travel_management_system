package cis.travel.eg.Main;

import cis.travel.eg.Service.Activity;
import cis.travel.eg.Service.CarRental.Car;
import cis.travel.eg.Service.FlightSystem.Airport;
import cis.travel.eg.Service.Hotels.DetailsForSystem.HotelForAgency;
import cis.travel.eg.Trip.*;
import cis.travel.eg.User.*;
import cis.travel.eg.User.TourGuideDetails.*;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static cis.travel.eg.Service.Activity.Activities;
import static cis.travel.eg.Service.FlightSystem.Airport.Airports;


class pair implements Serializable
{
    String first,second;
}

public class Main implements Serializable{

    public  static int input(int mini, int maxi){
        int number = in.nextInt();
        if (number < mini || number > maxi) {
            System.out.println(ANSI_COLORS[10]+"Invalid input!"+ANSI_COLORS[0]);
            number = input(mini, maxi);
        }
        return number;
    }

    public static Scanner in = new Scanner(System.in);
    public static final String[] ANSI_COLORS = {
            "\u001B[0m",    // Reset     0
            "\u001B[30m",   // Black     1
            "\u001B[31m",   // Red       2
            "\u001B[32m",   // Green     3
            "\u001B[33m",   // Yellow    4
            "\u001B[34m",   // Blue      5
            "\u001B[35m",   // Purple    6
            "\u001B[36m",   // Cyan      7
            "\u001B[37m",   // White     8
            "\u001B[90m",   // Dark Gray 9
            "\u001B[91m",   // Bright Red      10
            "\u001B[92m",   // Bright Green    11
            "\u001B[93m",   // Bright Yellow   12
            "\u001B[94m",   // Bright Blue     13
            "\u001B[95m",   // Bright Purple   14
            "\u001B[96m",   // Bright Cyan     15
            "\u001B[97m"    // Bright White    16
    };

    public static void ReadingData(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<TourGuide> TourGuides, ArrayList<Manager> Managers, ArrayList<Trip> Trips_system) {

        File file = new File("DataProject.ser");
       // System.out.println(file.getAbsolutePath());

        try {
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream(file));
            while(true) {

                Object object = obj.readObject();

                if (object instanceof Customer) {
                    Customers.add((Customer) object);
                }else if (object instanceof TourGuide) {
                    TourGuides.add((TourGuide) object);
                }else if (object instanceof Manager) {
                    Managers.add((Manager) object);
                }else if (object instanceof Admin) {
                    Admins.add((Admin) object);
                }else if (object instanceof Trip) {
                    Trips_system.add((Trip) object);
                }else if (object instanceof Car) {
                    Car.cars.add((Car) object);
                } else if (object instanceof HotelForAgency) {
                   HotelForAgency.hotels.add((HotelForAgency) object);
                } else if (object instanceof Airport) {
                    Airports.add((Airport) object);
                }
                else if(object instanceof Activity)
                {
                     Activities.add((Activity) object);
                }

            }

        } catch (EOFException eof) {
            System.out.println("End of file reached.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }

    }


    public static void WritingData(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<TourGuide> TourGuides, ArrayList<Manager> Managers, ArrayList<Trip> Trips_system) {
        File file = new File("DataProject.ser");
        // System.out.println(file.getAbsolutePath());

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Customer customer : Customers) {
                outputStream.writeObject(customer);
            }
            for (TourGuide TourGuide : TourGuides) {
                outputStream.writeObject(TourGuide);
            }
            for (Manager Manager : Managers) {
                outputStream.writeObject(Manager);
            }
            for (Admin Admin : Admins) {
                outputStream.writeObject(Admin);
            }
            for (Trip Trips : Trips_system) {
                outputStream.writeObject(Trips);
            }
            for (Car car :  Car.cars) {
                outputStream.writeObject(car);
            }
            for (HotelForAgency hotel : HotelForAgency.hotels) {
                outputStream.writeObject(hotel);
            }
            for (Airport airport : Airports) {
                outputStream.writeObject(airport);
            }
            for (Activity activity : Activities) {
                outputStream.writeObject(activity);
            }

            System.out.println("Data written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }


    public static void Welcome()
    {

        System.out.println( ANSI_COLORS[13]);     //will be taken from mariam gharib
        System.out.println("                                           |\\");
        System.out.println("                                          /  \\");
        System.out.println("                                         /    \\");
        System.out.println("                                        /______\\");
        System.out.println("                                       /________\\");
        System.out.println("                                      /__________\\");
        System.out.println("                                     /____________\\");
        System.out.println("                                    /_/\\/\\/\\/\\/\\___\\");
        System.out.println("                                     \\ \\/\\/\\/\\/\\/ /");
        System.out.println("                                      \\__________/");

        System.out.println("                                      __|__ |__|__");
        System.out.println("                                     / ********** \\");
        System.out.println("                                    | ************ |");
        System.out.println("                                     \\____________/");
        System.out.println("                                      '----------'"+ANSI_COLORS[16]);
        System.out.println();

        System.out.println( "      **********     "+ANSI_COLORS[15]+"            Welcome to WanderLift       "+ANSI_COLORS[16]+"          **********        ");
        System.out.println( "  Embark on Your Journey Beyond Boundaries with WanderLift: Explore, Experience, Enjoy!:3  ");
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

        index=Admin.Is_login_successfully(username,User.encryptedPassword(password),Admins);
        if(index!=-1)
        {
           return "A "+index;
        }

        index= Customer.Is_login_successfully(username,User.encryptedPassword(password),Customers);
        if(index!=-1)
        {
            return "C "+index;
        }

        index=Manager.Is_login_successfully(username,User.encryptedPassword(password),Managers);
        if(index!=-1)
        {
            return "M "+index;
        }

        index=TourGuide.Is_login_successfully(username,User.encryptedPassword(password),TourGuides);
        if(index!=-1)
        {
            return "T "+index;
        }

        return "-1";
    }
    public static int Menu_choice() {
        System.out.println(ANSI_COLORS[16]+"                                                                                     |                                                                           ");
        System.out.println("                                                                                     |                                                                           ");
        System.out.println("                                                                                   .-'-.                                                                                                                ");
        System.out.println("   ╔══════════════════════╗                                                       ' ___ '                                                                                                          ");
        System.out.println("   ║  ***"+ANSI_COLORS[15]+" WanderLift "+ANSI_COLORS[16]+"***  ║                                             ---------'  .-.  '---------                                           ");
        System.out.println("   ╠══════════════════════╣                             _________________________'  '-'  '_________________________                                           ");
        System.out.println("   ║    1)Login           ║                             ''''''-|---|--/    \\==][^',_m_,'^][==/    \\--|---|-''''''                                           ");
        System.out.println("   ║    2)Register        ║                                           \\    /  ||/   H   \\||  \\    /                                           ");
        System.out.println("   ╚══════════════════════╝                                            '--'   OO   O|O   OO   '--'\n                                           ");
        System.out.print("\nEnter your choice: "+ANSI_COLORS[16]);
        return input(1,2);

    }
    public static pair Enter_New_password()             //will be changed depending on mariam code
    {
        pair passwords= new pair();

        System.out.println("╔══════════════════════╗");
        System.out.println("║  "+ANSI_COLORS[13]+" Forgot Password "+ANSI_COLORS[16]+"   ║");
        System.out.println("╠══════════════════════╣");
        System.out.print(  "║ New Password: ");
        passwords.first = in.next();
        System.out.print(  "║ Confirm Password: ");
        passwords.second = in.next();
        System.out.println("╚══════════════════════╝");

        cls();
        return passwords;
    }
    public static void Register(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<TourGuide> TourGuides, ArrayList<Manager> Managers)
    {

        System.out.println(ANSI_COLORS[16]+"                                                                                                                                                 ");
        System.out.println("                                                                                                                                                 ");
        System.out.println("                                                                        __-------__                                                                                 ");
        System.out.println("                                                                      / _---------_ \\                                                                                 ");
        System.out.println("                                                                     / /           \\ \\                                                                                 ");
        System.out.println("                                                                     | |           | |                                                                                  ");
        System.out.println("                                                                     |_|___________|_|                                                                               ");
        System.out.println("                                                                 /-\\|                 |/-\\                                                                                 ");
        System.out.println("   ╔══════════════════════╗                                     | _ |\\       0       /| _ |                                                                                 ");
        System.out.println("   ║    "+ANSI_COLORS[13]+"  Register   "+ANSI_COLORS[16]+"     ║                                     |(_)| \\      !      / |(_)|                                                                                 ");
        System.out.println("   ╠══════════════════════╣                                     |___|__\\_____!_____/__|___|                                                                                 ");
        System.out.println("   ║    1)Tour guide      ║                                     [_________|MEIN1|_________]                                                                                 ");
        System.out.println("   ║    2)Customer        ║                                      ||||    ~~~~~~~~     ||||                                                                                 ");
        System.out.println("   ╚══════════════════════╝                                      `--'                 `--'                                                                                 ");
        System.out.print("\nEnter your choice: "+ANSI_COLORS[16]);
        int choice= input(1,2);
        cls();
        if(choice==1)
        {
            TourGuide tourGuide = new TourGuide();
            tourGuide.Register( Admins,  Customers ,Managers, TourGuides);
            TourGuides.add(tourGuide);

        }else{
            Customer customer= new Customer();
            customer.Register( Admins,  Customers, Managers,  TourGuides);
            Customers.add(customer);
        }

    }


    public static int Forgot_Password_OR_Register(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<TourGuide> TourGuides, ArrayList<Manager> Managers)
    {

        cls();
        System.out.println(ANSI_COLORS[10]+"You exceeded the number of trails!\n"+ANSI_COLORS[16]);
        sleep();
        cls();


        System.out.println(ANSI_COLORS[16]+"                                                                                                   []=++-                                                                                                            ");
        System.out.println("                                                                                              _II__|                                                                                            ");
        System.out.println("                                                                                             [[__] |                                                                                            ");
        System.out.println("                                                                            _________________||  |___                                                                                            ");
        System.out.println("                                                                           /^^^^^^,-.^^^^^^^^\\|__|^^^\\                                                                                            ");
        System.out.println("                                                                          /     ,',-.`.               \\                                                                                            ");
        System.out.println("                                                                         /    ,','   `.`.     ,-\"\"\"-.  \\                                                                                            ");
        System.out.println("╔══════════════════════╗                                                /___,','__   __`.`.__/_,\"T\"._\\__\\                                                                                             ");
        System.out.println("║1)  "+ANSI_COLORS[13]+"  Register   "+ANSI_COLORS[16]+"     ║                                                |='-'||/\\| |^^||`-`=|_|_|_|_|=|                                                                                            ");
        System.out.println("║2) "+ANSI_COLORS[13]+" Reset password "+ANSI_COLORS[16]+"   ║                                                |= = ||)(| |__||= ==|_|_|_|_|=|                                                                                             ");
        System.out.println("╚══════════════════════╝                                                |= ==|\"\"\"\" \"\"\"\"| = =____= =_==|                                                                                                     ");
        System.out.println("                                                                        |== =| __   __ |= =| [] | |^|=|                                                                                            ");
        System.out.println("                                                                        |= ==||/\\| |==||== |   o|=|_| |                                                                                            ");
        System.out.println("                                                                        |== =||)(| |  || = | == | == =|                                                                                            ");
        System.out.println("                                                                        |= ==|\"\"\"\" \"\"\"\"|== |____|= = =|                                                                                            ");
        System.out.println("                                                                        \"\"\"\"\"|_________|\"\"\"'====`\"\"\"\"\"\"                                                                                            ");
        System.out.print("\nEnter your choice: "+ANSI_COLORS[16]);
        int choice= input(1,2);

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
                index=Admin.FoundUsername(username,Admins);
                if(index!=-1)
                {
                    while(true) {

                       pair passwords=Enter_New_password();

                        if (Admins.get(index).setPassword(passwords.first,passwords.second)) {
                            break;
                        } else {
                            System.out.println(ANSI_COLORS[10] + "Invalid passwords!" + ANSI_COLORS[16]);
                            cls();
                        }
                    }
                    System.out.print(ANSI_COLORS[12]+"Password Reset successfully!"+ANSI_COLORS[16]);
                    System.out.println("Directing you to Login...");
                    sleep();
                   return 0;
                }
                index=Customer.FoundUsername(username,Customers);
                 if(index!=-1)
                {
                    while(true) {

                        pair passwords=Enter_New_password();

                        if (Customers.get(index).setPassword(passwords.first,passwords.second)) {
                            break;
                        } else {
                            System.out.println(ANSI_COLORS[10] + "Invalid passwords!" + ANSI_COLORS[16]);
                            cls();
                        }
                    }
                    System.out.print(ANSI_COLORS[12]+"Password Reset successfully!"+ANSI_COLORS[16]);
                    System.out.println("Directing you to Login...");
                    sleep();
                    return 0;
                }

                index=Manager.FoundUsername(username,Managers);
                if(index!=-1)
                {
                    while(true) {

                        pair passwords=Enter_New_password();

                        if (Managers.get(index).setPassword(passwords.first,passwords.second)) {
                            break;
                        } else {
                            System.out.println(ANSI_COLORS[10] + "Invalid passwords!" + ANSI_COLORS[16]);
                            cls();
                        }
                    }
                    System.out.print(ANSI_COLORS[12]+"Password Reset successfully!"+ANSI_COLORS[16]);
                    System.out.println("Directing you to Login...");
                    sleep();
                    return 0;
                }
                index = TourGuide.FoundUsername(username,TourGuides);
                if(index!=-1)
                {
                    while(true) {

                        pair passwords=Enter_New_password();

                        if (TourGuides.get(index).setPassword(passwords.first,passwords.second)) {
                            break;
                        } else {
                            cls();
                        }
                    }

                    System.out.println(ANSI_COLORS[12]+"Password Reset successfully!"+ANSI_COLORS[16]);
                    System.out.println("Directing you to Login...");
                    sleep();
                    return 0;
                }
                else {

                    System.out.println(ANSI_COLORS[10]+"Username Not found!"+ANSI_COLORS[16]);
                    trails++;
                    sleep();

                    if (trails >= 3) {
                        System.out.println(ANSI_COLORS[10]+"You exceeded the number of trails!"+ANSI_COLORS[16]);
                        System.out.println("Directing you to registration....");
                        sleep();
                        return 1;
                    }

                }


            }
        }

    }
    public static boolean LoginMenu_ForgotPass_Register(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<TourGuide> TourGuides, ArrayList<Manager> Managers,ArrayList<Trip> Trips_system) {

       Welcome();
       int choice=Menu_choice();
       cls();

       switch(choice)
       {

           case 1:       //login
               int trails=0;

               while(true) {
               System.out.println("╔══════════════════════╗");
               System.out.println("║  "+ANSI_COLORS[13]+"     Login    "+ANSI_COLORS[16]+"      ║");
               System.out.println("╠══════════════════════╣");
               System.out.print(  "║ Username: ");
           String username = in.next();
               System.out.print(  "║ Password: ");
           String password = in.next();
               System.out.println("╚══════════════════════╝");

           String Word_Index=login_arrays(username, password, Admins, Customers, TourGuides, Managers);

           if(Word_Index.equals("-1"))
           {
               if(trails<2) {
                   System.out.println(ANSI_COLORS[10]+"Login failed. Please check your credentials...."+ANSI_COLORS[16]);
                   sleep();
                   cls();
                   trails++;
               }
               else {

                  if(Forgot_Password_OR_Register(Admins, Customers, TourGuides, Managers)==1)
                  {
                      cls();
                      Register(Admins, Customers, TourGuides, Managers);
                  }

                  cls();
                 return LoginMenu_ForgotPass_Register( Admins,  Customers,  TourGuides,  Managers, Trips_system);

               }
           }else{

               boolean state=false;

               System.out.println(ANSI_COLORS[11] + "Login successful!" + ANSI_COLORS[16]);
               System.out.println("Directing you to homepage....");
               sleep();
               cls();
               switch (Word_Index.charAt(0))
               {
                   case 'A':

                       state=Admins.get(Integer.parseInt(Word_Index.substring(2))).HomePage( Admins,  Customers,  TourGuides,  Managers,Trips_system);
                       break;

                   case 'C':

                       state=Customers.get(Integer.parseInt(Word_Index.substring(2))).HomePage( Admins,  Customers,  TourGuides,  Managers,Trips_system);
                       break;

                   case 'M':
                       state=Managers.get(Integer.parseInt(Word_Index.substring(2))).HomePage( Admins,  Customers,  TourGuides,  Managers,Trips_system);
                       break;

                   case 'T':
                       state=TourGuides.get(Integer.parseInt(Word_Index.substring(2))).HomePage( Admins,  Customers,  TourGuides,  Managers,Trips_system);
                       break;

               }

               return state;


           }

           }

           case 2:   //register

               Register(Admins, Customers, TourGuides, Managers);
               cls();
              return LoginMenu_ForgotPass_Register( Admins,  Customers,  TourGuides,  Managers,Trips_system);

       }
       //uncertain
        return true;
    }
    


    public static void main(String[] args)  {

        ArrayList<Admin> Admins = new ArrayList<Admin>();
        ArrayList<Customer> Customers = new ArrayList<Customer>();
        ArrayList<TourGuide> TourGuides = new ArrayList<TourGuide>();
        ArrayList<Manager> Managers = new ArrayList<Manager>();

        ArrayList<Trip> Trips_system = new ArrayList<Trip>();

        ReadingData(Admins, Customers, TourGuides, Managers, Trips_system);
//        Admin a1 = new Admin();
//        a1.setUsername("Admin1",Admins,Customers,Managers,TourGuides);
//        a1.setPassword("123#Admin1","123#Admin1");
//        Admins.add(a1);


        while(true) {

            boolean state=LoginMenu_ForgotPass_Register(Admins, Customers, TourGuides, Managers,Trips_system);

            if (state) // 0 logout   // 1 exit
            {
                //exit program
                WritingData(Admins, Customers, TourGuides, Managers, Trips_system);
                return;
            }

        }

    }


}



