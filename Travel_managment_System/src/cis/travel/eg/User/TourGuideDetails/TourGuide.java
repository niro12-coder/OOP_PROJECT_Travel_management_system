package cis.travel.eg.User.TourGuideDetails;

import cis.travel.eg.Main.Main;
import cis.travel.eg.Trip.Couple_Tour;
import cis.travel.eg.Trip.Family_Tour;
import cis.travel.eg.Trip.General_Tour;
import cis.travel.eg.Trip.Trip;
import cis.travel.eg.User.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

import static cis.travel.eg.Main.Main.in;

public class TourGuide extends User implements TourGuideFunctionalities , Serializable {
////// attributes

   private static final long serialVersionUID = 7417825546553538399L;

    private String country;
    private ArrayList<Trip> History_Current_trips= new ArrayList<Trip>();
    private ArrayList<Trip> Complainttrips= new ArrayList<Trip>();
    private final ArrayList<String> LanguageOptions= new ArrayList<>(Arrays.asList("English","Arabic","Spanish","French","Deutsch","Hindi"));
    private ArrayList<String> Languages = new ArrayList<String>();
    private double salary;
    private double Salary_per_day;

    //constructors
    public TourGuide() {
        super();
        country=null;

    }



///////// setters and getters
    public ArrayList<Trip> getHistorytrips() {

        return History_Current_trips;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary_per_day() {
        return Salary_per_day;
    }

    public void setSalary_per_day(double salary_per_day) {
        Salary_per_day = salary_per_day;
    }

    public ArrayList<Trip> getComplainttrips() {

        return Complainttrips;
    }

    public ArrayList<Trip> getHistory_Current_trips() {
        return History_Current_trips;
    }

    public void setHistory_Current_trips(ArrayList<Trip> history_Current_trips) {
        History_Current_trips = history_Current_trips;
    }

    public void setComplainttrips(ArrayList<Trip> complainttrips) {
        Complainttrips = complainttrips;
    }

    public ArrayList<String> getLanguageOptions() {
        return LanguageOptions;
    }

    public ArrayList<String> getLanguages() {
        return Languages;
    }

    public void setLanguages(ArrayList<String> languages) {
        Languages = languages;
    }


///////methods

    char confirm()                        //finished
    {
        while(true) {
            String input = in.next();
            input=input.toLowerCase();

            if(input.equals("y") || input.equals("n")) return input.charAt(0);

            System.out.println(Main.ANSI_COLORS[10]+"Invalid input."+Main.ANSI_COLORS[0]);

        }

    }
    static public int FoundUsername(String username, ArrayList<TourGuide> guides) {
        return IntStream.range(0,guides.size())
                .filter(i ->guides.get(i).getUsername().equals(username))
                .findFirst()
                .orElse(-1);
    }
    static public int Is_login_successfully(String username, String password, ArrayList<TourGuide> guide) {
        for (int i = 0; i < guide.size(); i++) {
            TourGuide guides = guide.get(i);
            if (guides.getUsername().equals(username) && guides.getPassword().equals(password)) {
                return i;
            }
        }
        return -1;
    }
    public void Register(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<Manager> Managers, ArrayList<TourGuide> TourGuides) //finished
    {
        System.out.println(Main.ANSI_COLORS[16]+"   ╔═══════════════════════════════════════════╗");
        System.out.println("   ║         "+Main.ANSI_COLORS[13]+"      Registration         "+Main.ANSI_COLORS[16]+"       ║");
        System.out.println("   ╠═══════════════════════════════════════════╣");
        System.out.print(  "   ║    Enter your first name: ");

        super.setFirstName(in.next());

        System.out.print(  "   ║    Enter your last name: ");

        super.setLastName(in.next());

        while(true) {

            System.out.print(  "   ║    Enter username: ");
            String user = in.next();

            if(!super.setUsername(user, Admins, Customers, Managers, TourGuides)) {
                System.out.println(Main.ANSI_COLORS[10]+"  Username already Used."+Main.ANSI_COLORS[16]);
            }else break;
        }


       while(true) {

            System.out.print(  "   ║    Enter password: ");
            String p1=in.next();
            System.out.print(  "   ║    Enter password again: ");
            String p2=in.next();

            if(super.setPassword(p1,p2))
            {
                break;
            }
        }
/*
        while(true) {

            System.out.print(  "   ║    Enter your PhoneNumber: ");
            if(super.setPhoneNumber(in.next()))
            {
                break;
            }
        }

        while(true) {

            System.out.print(  "   ║    Enter your Email:  ");
            if(!super.setEmail(in.next()))
            {
                System.out.println(Main.ANSI_COLORS[10]+"  Invalid email."+Main.ANSI_COLORS[16]);
            }else break;
        }


        while(true) {
            System.out.print(  "   ║    Enter your Age:  ");
            if(super.setAge(in.nextInt())) break;
            System.out.print(Main.ANSI_COLORS[16]);
        }

        while(true){

            System.out.print(  "   ║    Enter your Gender (f/m):  ");
            String gender= in.next();
            gender=gender.toLowerCase();

            if(gender.equals("f") || gender.equals("m"))
            {
                super.setGender(gender.charAt(0));
                break;
            }else {
                System.out.println(Main.ANSI_COLORS[10]+"  Invalid input."+Main.ANSI_COLORS[16]);
            }

        }

        System.out.print(  "   ║    Enter your Country: ");
        this.setCountry(in.next());

        System.out.print(  "   ║    Enter your Salary per day: ");
        this.setSalary_per_day(in.nextDouble());

        System.out.println("   ╚═══════════════════════════════════════════╝"+Main.ANSI_COLORS[0]);
        Main.sleep();
        Main.cls();

        Display_languages_choose();
*/
        Main.cls();

    }
    void Display_languages_choose()     //finished
    {

        System.out.println(Main.ANSI_COLORS[16] +"                  ╔═══════════════════════════════════════════╗");
        System.out.println("                  ║           " + Main.ANSI_COLORS[12] + "  Choose Languages  "+ Main.ANSI_COLORS[16]+"            ║");
        System.out.println("                  ╠═══════════════════════════════════════════╣");
        int i=1;
        for(String language: LanguageOptions)
        {
            System.out.print(Main.ANSI_COLORS[16]+"                  ║        "+Main.ANSI_COLORS[12] +i+") "+Main.ANSI_COLORS[13] );
            System.out.printf("%-10s ", language);
            System.out.println(Main.ANSI_COLORS[16]+"                     ║");
            i++;
        }
        System.out.println("                  ╚═══════════════════════════════════════════╝");

        System.out.print("Enter number of Languages you wish to choose: ");
        int number=Main.input(1,LanguageOptions.size());

        while(number!=0)
        {
            System.out.print("Enter your choice:");
            int choice=Main.input(1,LanguageOptions.size());
            if(Languages.contains(LanguageOptions.get(choice-1)))
            {
                System.out.println(Main.ANSI_COLORS[10]+"You already chose it before!"+Main.ANSI_COLORS[16]);
            }
            else {
                number--;
                Languages.add(LanguageOptions.get(choice-1));
            }
        }

    }
    @Override
    public boolean HomePage(ArrayList<Admin> Admins, ArrayList<Customer> Customers, ArrayList<TourGuide> TourGuides, ArrayList<Manager> Managers, ArrayList<Trip> Trips_system)
    {

        System.out.println(Main.ANSI_COLORS[16]+"   ╔═══════════════════════════════════════════╗");
        System.out.print("   ║" + Main.ANSI_COLORS[14] + "           ✈ Welcome " );
        System.out.printf("%-10s ", getFirstName());
        System.out.println(Main.ANSI_COLORS[16]+"          ║");
        System.out.println("   ╠═══════════════════════════════════════════╣");
        System.out.println("   ║    "+Main.ANSI_COLORS[14]+"1)"+Main.ANSI_COLORS[16]+"View Current Trips                   ║");
        System.out.println("   ║    "+Main.ANSI_COLORS[14]+"2)"+Main.ANSI_COLORS[16]+"View Travel History                  ║");
        System.out.println("   ║    "+Main.ANSI_COLORS[14]+"3)"+Main.ANSI_COLORS[16]+"Monthly Salary Statistics            ║");
        System.out.println("   ║    "+Main.ANSI_COLORS[14]+"4)"+Main.ANSI_COLORS[16]+"View Profile                         ║");
        System.out.println("   ║    "+Main.ANSI_COLORS[14]+"5)"+Main.ANSI_COLORS[16]+"Edit Profile                         ║");
        System.out.println("   ║    "+Main.ANSI_COLORS[14]+"6)"+Main.ANSI_COLORS[16]+"Logout                               ║");
        System.out.println("   ║    "+Main.ANSI_COLORS[14]+"7)"+Main.ANSI_COLORS[16]+"Exit                                 ║");
        System.out.println("   ║                                           ║");
        System.out.println("   ╚═══════════════════════════════════════════╝");


        int Int_theReturn =1;
        System.out.print("Enter your choice: ");
        int choice=Main.input(1,7);
        Main.cls();
        switch (choice){
            case 1:
                Int_theReturn=ViewTrips_Complaints();
                break;
            case 2:
                Int_theReturn=update_TravelHistory();
                break;
            case 3:
                Int_theReturn=view_statistics_SalaryMonthly();
                break;
            case 4:
                Int_theReturn=Display_Profile(Admins, Customers,  Managers, TourGuides);
                break;
            case 5:
                Int_theReturn=Edit_Profile( Admins, Customers, Managers, TourGuides);
                break;
            case 6:
                Int_theReturn=0;
                break;
            case 7:
                Int_theReturn=1;
                break;
        }

        if(Int_theReturn==0)
        {
            return false;
        }
        else if(Int_theReturn==1) return true;
        else return this.HomePage(Admins,Customers,TourGuides,Managers,Trips_system);  //uncertain

    }
    public int Logout_exist()  //finished
    {

        System.out.println(Main.ANSI_COLORS[16]+"   ╔══════════════════════════╗");
        System.out.println("   ║ "+ Main.ANSI_COLORS[12] +"   1)"+ Main.ANSI_COLORS[16] +"Return to Homepage  ║");
        System.out.println("   ║  "+ Main.ANSI_COLORS[12] +"  2)"+ Main.ANSI_COLORS[16] +"Logout              ║");
        System.out.println("   ║  "+ Main.ANSI_COLORS[12] +"  3)"+ Main.ANSI_COLORS[16] +"Exit                ║");
        System.out.println("   ╚══════════════════════════╝");

        System.out.print("Enter your choice: ");
        int choice=Main.input(1,3);

        Main.cls();
        if(choice==3) return 1;
        else if(choice==2) return 0;
        else return 3;
    }
    @Override
    public int Display_Profile(ArrayList<Admin> admin, ArrayList<Customer> customer, ArrayList<Manager> manager, ArrayList<TourGuide> tourguide) {

        //souts
        ///donot display trips, it's useless, we got view trips options, we only want to display account  info

        System.out.println("   ╔═══════════════════════════════════════════╗");
        System.out.print("   ║            " + Main.ANSI_COLORS[14] + "  Profile " );
        System.out.printf("%-10s", getFirstName());
        System.out.println(Main.ANSI_COLORS[16]+"           ║");
        System.out.println("   ╠═══════════════════════════════════════════╣");
        System.out.print("   ║    "+Main.ANSI_COLORS[14]+"First name: "+Main.ANSI_COLORS[16]);
        System.out.printf("%-12s", getFirstName());
        System.out.println(Main.ANSI_COLORS[16]+"               ║");
        System.out.print("   ║    "+Main.ANSI_COLORS[14]+"Last name: "+Main.ANSI_COLORS[16]);
        System.out.printf("%-12s", getLastName());
        System.out.println(Main.ANSI_COLORS[16]+"                ║");
        System.out.print("   ║    "+Main.ANSI_COLORS[14]+"Username: "+Main.ANSI_COLORS[16]);
        System.out.printf("%-12s", getUsername());
        System.out.println(Main.ANSI_COLORS[16]+"                 ║");
        System.out.print("   ║    "+Main.ANSI_COLORS[14]+"Password: "+Main.ANSI_COLORS[16]);
        System.out.printf("%-12s ", getPassword());
        System.out.println(Main.ANSI_COLORS[16]+"                ║");
        System.out.print("   ║    "+Main.ANSI_COLORS[14]+"Age: "+Main.ANSI_COLORS[16]);
        System.out.printf("%-12s", getAge());
        System.out.println(Main.ANSI_COLORS[16]+"                      ║");
        System.out.print("   ║    "+Main.ANSI_COLORS[14]+"Phone number: "+Main.ANSI_COLORS[16]);
        System.out.printf("%-12s", getPhoneNumber());
        System.out.println(Main.ANSI_COLORS[16]+"             ║");
        System.out.print("   ║    "+Main.ANSI_COLORS[14]+"Email: "+Main.ANSI_COLORS[16]);
        System.out.printf("%-12s", getEmail());
        System.out.println(Main.ANSI_COLORS[16]+"                    ║");
        System.out.print("   ║    "+Main.ANSI_COLORS[14]+"Gender: "+Main.ANSI_COLORS[16]);
        System.out.printf("%-12s", getGender());
        System.out.println(Main.ANSI_COLORS[16]+"                   ║");
        System.out.print("   ║    "+Main.ANSI_COLORS[14]+"Country: "+Main.ANSI_COLORS[16]);
        System.out.printf("%-12s", getCountry());
        System.out.println(Main.ANSI_COLORS[16]+"                  ║");
        System.out.print("   ║    "+Main.ANSI_COLORS[14]+"Salary per day: "+Main.ANSI_COLORS[16]);
        System.out.printf("%-12s ", getSalary_per_day());
        System.out.println(Main.ANSI_COLORS[16]+"          ║");
        System.out.println("   ╚═══════════════════════════════════════════╝\n\n\n");

        if(this.Languages.size()!=0) {
            System.out.println(Main.ANSI_COLORS[16] +"   ╔═══════════════════════════════════════════╗");
            System.out.println("   ║              " + Main.ANSI_COLORS[12] + "   Languages  "+ Main.ANSI_COLORS[16]+"               ║");
            System.out.println("   ╠═══════════════════════════════════════════╣");
            int i=1;
            for(String language: Languages)
            {
                System.out.print(Main.ANSI_COLORS[16]+"   ║        "+Main.ANSI_COLORS[12] +i+") "+Main.ANSI_COLORS[13] );
                System.out.printf("%-10s ", language);
                System.out.println(Main.ANSI_COLORS[16]+"                     ║");
                i++;
            }
            System.out.println("   ╚═══════════════════════════════════════════╝");
        }

        System.out.print("Would you like to edit your Profile? (Y/N) :");
        char answer=confirm();
        Main.cls();
        if(answer=='n')
        {
            return Logout_exist();
        }else{
            return Edit_Profile(admin,customer,manager,tourguide);
        }

    }
    @Override
    public int Edit_Profile(ArrayList<Admin> admin, ArrayList<Customer> customer, ArrayList<Manager> manager, ArrayList<TourGuide> tourguide) //finished
    {

        int option;
        char ans;
        do {
            System.out.println(Main.ANSI_COLORS[16] +"   ╔══════════════════════════╗");
            System.out.println("   ║    " + Main.ANSI_COLORS[13] + "Edit Profile "+ Main.ANSI_COLORS[16]+"         ║");
            System.out.println("   ╠══════════════════════════╣");
            System.out.println("   ║  "+ Main.ANSI_COLORS[12] + "  1)"+ Main.ANSI_COLORS[16] +"First name.         ║");
            System.out.println("   ║  "+ Main.ANSI_COLORS[12] +"  2)"+ Main.ANSI_COLORS[16] +"Last name.          ║");
            System.out.println("   ║  "+ Main.ANSI_COLORS[12] +"  3)"+ Main.ANSI_COLORS[16] +"Username.           ║");
            System.out.println("   ║   "+ Main.ANSI_COLORS[12] +" 4)"+ Main.ANSI_COLORS[16] +"Password.           ║");
            System.out.println("   ║  "+ Main.ANSI_COLORS[12] +"  5)"+ Main.ANSI_COLORS[16] +"Age.                ║");
            System.out.println("   ║   "+ Main.ANSI_COLORS[12] +" 6)"+ Main.ANSI_COLORS[16] +"Phone number.       ║");
            System.out.println("   ║  "+ Main.ANSI_COLORS[12] +"  7)"+ Main.ANSI_COLORS[16] +"Email.              ║");
            System.out.println("   ║   "+ Main.ANSI_COLORS[12] +" 8)"+ Main.ANSI_COLORS[16] +"Gender.             ║");
            System.out.println("   ║   "+ Main.ANSI_COLORS[12] +" 9)"+ Main.ANSI_COLORS[16] +"Country.            ║");
            System.out.println("   ║   "+ Main.ANSI_COLORS[12] +" 10)"+ Main.ANSI_COLORS[16] +"Salary per day.    ║");
            System.out.println("   ║   "+ Main.ANSI_COLORS[12] +" 11)"+ Main.ANSI_COLORS[16] +"Languages.         ║");
            System.out.println("   ╚══════════════════════════╝\n");

            System.out.println(Main.ANSI_COLORS[16]+"   ╔═══════════════════════════╗");
            System.out.println("   ║  "+Main.ANSI_COLORS[12]+"  12)"+Main.ANSI_COLORS[10]+"Exit page "+Main.ANSI_COLORS[16]+"          ║");
            System.out.println("   ╚═══════════════════════════╝");


            System.out.print(Main.ANSI_COLORS[16]+"Enter your choice: ");
            option = Main.input(1,12);
            Main.cls();

            switch(option){
                case 1 :
                    System.out.print("Enter your first name: ");
                    super.setFirstName(in.next());
                    break;


                case 2:

                    System.out.print("Enter your last name: ");
                    super.setLastName(in.next());

                    break;
                case 3:

                    while(true) {

                        System.out.print("Enter username: ");
                        String user = in.next();

                        if(!super.setUsername(user, admin, customer, manager, tourguide)) {
                            System.out.println(Main.ANSI_COLORS[10]+"Username already Used."+Main.ANSI_COLORS[16]);
                        }else break;
                    }

                    break;
                case 4:

                    while(true) {

                        System.out.print(Main.ANSI_COLORS[16]+"Enter password: ");
                        String p1=in.next();
                        System.out.print(  "Enter password again: ");
                        String p2=in.next();

                        if(super.setPassword(p1,p2))
                        {
                            break;
                        }
                    }

                    break;
                case 5:

                    while(true) {
                        System.out.print(Main.ANSI_COLORS[16]+"Enter your Age: ");
                        if(super.setAge(in.nextInt())) break;
                    }

                    break;
                case 6 :
                    while(true) {

                        System.out.print(Main.ANSI_COLORS[16]+"Enter your PhoneNumber: ");
                        if(super.setPhoneNumber(in.next()))
                        {
                            break;
                        }
                    }
                    break;
                case 7 :
                    while(true) {

                        System.out.print(Main.ANSI_COLORS[16]+"Enter your Email:  ");
                        if(!super.setEmail(in.next()))
                        {
                            System.out.println(Main.ANSI_COLORS[10]+"Invalid email."+Main.ANSI_COLORS[16]);
                        }else break;
                    }

                    break;
                case 8 :
                    while(true){

                        System.out.print(Main.ANSI_COLORS[16]+"Enter your Gender (f/m):  ");
                        String gender= in.next();
                        gender=gender.toLowerCase();

                        if(gender.equals("f") || gender.equals("m"))
                        {
                            super.setGender(gender.charAt(0));
                            break;
                        }else {
                            System.out.println(Main.ANSI_COLORS[10]+"Invalid input."+Main.ANSI_COLORS[16]);
                        }

                    }
                    break;
                case 9 :

                    System.out.print(Main.ANSI_COLORS[16]+"Enter your Country: ");
                    this.setCountry(in.next());

                    break;
                case 10 :
                    System.out.print(Main.ANSI_COLORS[16]+"Enter your Salary per day: ");
                    this.setSalary_per_day(in.nextDouble());

                    break;

                case 11 :

                    System.out.println(Main.ANSI_COLORS[16]+"Re-choose your languages!\n\n");
                    Languages.clear();
                    Display_languages_choose();
                    break;
                case 12:
                    Main.cls();
                    return Logout_exist();

            }

            Main.cls();

            System.out.println(Main.ANSI_COLORS[12]+"Changes have been successfully saved...");
            System.out.print(Main.ANSI_COLORS[16]+"Do you want to make another change?(Y/N) :");
            ans = confirm();
            Main.cls();
        }while(ans=='y');

        System.out.print(Main.ANSI_COLORS[16]+"Do you want to View your profile?(Y/N) :");
        ans = confirm();
        Main.cls();
        if(ans=='y') {

            return this.Display_Profile(admin,customer,manager,tourguide);
        }
        else {
            return Logout_exist();
        }
    }
   public double calculateMonthlySalary(int year, int month,ArrayList<Trip> History_Current_trips) {
        double monthlySalary=0.0;
       for (Trip trip : History_Current_trips) {
           LocalDate startDate = LocalDate.parse(trip.getStartDate());
           LocalDate endDate = LocalDate.parse(trip.getEndDate());
           int tripYear = endDate.getYear();
           int tripMonth = endDate.getMonthValue();

           long  tripNumberOfDays;
           tripNumberOfDays = Trip.calculateDaysBetweenDates(startDate,endDate);


           if (tripYear == year && tripMonth == month) {
                monthlySalary+=tripNumberOfDays*getSalary_per_day();
           }
       }
       return monthlySalary;
   }

   public int view_statistics_SalaryMonthly()  //finished
   {
       double maxSalary = Integer.MIN_VALUE;
       LocalDate currentDate = LocalDate.now();
       int currentYear = currentDate.getYear();
       int currentMonth = currentDate.getMonthValue();
       int year = currentYear;
       int month = currentMonth;
       char seeAnotheextInt;
       do {
           // Find the maximum salary among the months
           for (int i = 0; i < 12; i++) {
               double monthlySalary = calculateMonthlySalary(year, i + 1, History_Current_trips);
               if (monthlySalary > maxSalary) {
                   maxSalary = monthlySalary;
               }
           }
           ArrayList<String> months = new ArrayList<>(Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"));
           // Display the visually enhanced horizontal bar chart
           System.out.println("_____________________________________________________________________________________________________________________________________________________________________");
           System.out.println(Main.ANSI_COLORS[16]+"                            ╔═══════════════════════════════════════════════╗");
           System.out.println(Main.ANSI_COLORS[16]+"                            ║"+Main.ANSI_COLORS[12]+"     Monthly Salary Statistics for "+year+"        "+Main.ANSI_COLORS[16]+"║");
           System.out.println(Main.ANSI_COLORS[16]+"                            ╚═══════════════════════════════════════════════╝\n");

           for (int i = 0; i < month; i++) {
               String monthName = months.get(i);
               double monthlySalary = calculateMonthlySalary(year, i + 1, History_Current_trips);
               int barLength = (int) (100.0 * monthlySalary / maxSalary); //if you want the bars to be longer increase the number

               System.out.printf(Main.ANSI_COLORS[12]+"%10s ", monthName);
               System.out.print(Main.ANSI_COLORS[16]+"║");

               // Print spaces for alignment
               for (int j = 0; j < 3; j++) {
                   System.out.print(" ");
               }

               // Print the bar chart using ASCII characters between the name and salary
               for (int j = 0; j < barLength; j++) {
                   if (i % 3 == 0) {
                       System.out.print(Main.ANSI_COLORS[13]+"█");
                   } else if (i % 3 == 1) {
                       System.out.print(Main.ANSI_COLORS[13]+"▓");
                   } else {
                       System.out.print(Main.ANSI_COLORS[13]+"▒");
                   }
               }
               System.out.println(Main.ANSI_COLORS[16]+"    " +Main.ANSI_COLORS[12]+ monthlySalary+Main.ANSI_COLORS[16]+" LE");
           }
           System.out.println(Main.ANSI_COLORS[16]+"           ╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
           System.out.print("If you want to see the salary statistics of another year enter 'y' or 'Y':");
           seeAnotheextInt = in.next().charAt(0);
           if (seeAnotheextInt == 'Y' || seeAnotheextInt=='y') {


               while (true) {
                   System.out.print("Enter the year :");
                   year = Main.input(2000, 3000);
                   if (year > currentYear) {
                       try {
                           throw new InvalidHistoryYear(year);
                       } catch (InvalidHistoryYear e) {
                           System.out.println(Main.ANSI_COLORS[10]+e.getMessage()+Main.ANSI_COLORS[16]);
                           Main.sleep();
                           Main.cls();
                       }

                   } else break;
               }
               if (year==currentYear){
                   month=currentMonth;
               }
               else {
                month=12;
               }

           }
       }while (seeAnotheextInt == 'Y' || seeAnotheextInt=='y');
       Main.cls();
       return Logout_exist();
   }
   public int update_TravelHistory()  //finished
   {
       LocalDate currentDate = LocalDate.now();

       System.out.println(Main.ANSI_COLORS[16]+"   ╔═══════════════════════════╗");
       System.out.println("   ║ "+Main.ANSI_COLORS[12]+"   1)"+Main.ANSI_COLORS[16]+"View Recent Trips    ║");
       System.out.println("   ║  "+Main.ANSI_COLORS[12]+"  2)"+Main.ANSI_COLORS[16]+"View All Past Trips  ║");
       System.out.println("   ║   "+Main.ANSI_COLORS[12]+" 3)"+Main.ANSI_COLORS[16]+"View by Date of Trip ║");
       System.out.println("   ║   "+Main.ANSI_COLORS[12]+" 4)"+Main.ANSI_COLORS[16]+"View by Type of Trip ║");
       System.out.println("   ║   "+Main.ANSI_COLORS[12]+" 5)"+Main.ANSI_COLORS[16]+"Clear History        ║");
       System.out.println("   ║   "+Main.ANSI_COLORS[12]+" 6)"+Main.ANSI_COLORS[16]+"Exit                 ║");
       System.out.println("   ╚═══════════════════════════╝"+Main.ANSI_COLORS[16]);

       System.out.print("Enter your choice: ");
       int choice = Main.input(1, 6);

       switch (choice) {

           case 1:

               int number = 4;
               for (int i = History_Current_trips.size() - 1; i >= 0; i--) {

                   LocalDate endDate = LocalDate.parse(History_Current_trips.get(i).getEndDate());
                   if (endDate.isBefore(currentDate)) {

                       History_Current_trips.get(i).displayDetails();
                       number--;
                       if (number == 0) break;
                   }

               }

               if (number == 4) System.out.println(Main.ANSI_COLORS[11]+"History is empty."+Main.ANSI_COLORS[16]);

               break;
           case 2:
               boolean history_Trips=false;
               for (int i = History_Current_trips.size() - 1; i >= 0; i--) {

                   LocalDate endDate = LocalDate.parse(History_Current_trips.get(i).getEndDate());
                   if (endDate.isBefore(currentDate)) {
                       History_Current_trips.get(i).displayDetails();
                       history_Trips=true;
                   }
               }

               if(!history_Trips) System.out.println(Main.ANSI_COLORS[11]+"History is empty."+Main.ANSI_COLORS[16]);


               break;
           case 3:

               Main.cls();
               boolean history=false;
               System.out.print(Main.ANSI_COLORS[16]+"Enter Month number: ");
               int Month =Main.input(1,12);

               System.out.print(Main.ANSI_COLORS[16]+"Enter Year number: ");
               int Year =Main.input(1000,3000);


               for (Trip trip:History_Current_trips) {

                   LocalDate startDate = LocalDate.parse(trip.getStartDate());
                   LocalDate endDate = LocalDate.parse(trip.getEndDate());

                   if (endDate.isBefore(currentDate)) {
                       int tripYear = endDate.getYear();
                       int tripMonth = endDate.getMonthValue();

                       if (tripYear == Year && tripMonth == Month) {
                           history=true;
                           trip.displayDetails();
                       }

                   }


               }

               if(!history) System.out.println(Main.ANSI_COLORS[11]+"None Found."+Main.ANSI_COLORS[16]);

               break;
           case 4:

               Main.cls();
               boolean printed=false;

               System.out.println(Main.ANSI_COLORS[16]+"   ╔═══════════════════════════╗");
               System.out.println("   ║  "+Main.ANSI_COLORS[12]+"  1)"+Main.ANSI_COLORS[16]+"Couple Tours         ║");
               System.out.println("   ║ "+Main.ANSI_COLORS[12]+"   2)"+Main.ANSI_COLORS[16]+"Family Tours         ║");
               System.out.println("   ║  "+Main.ANSI_COLORS[12]+"  3)"+Main.ANSI_COLORS[16]+"General Tours        ║");
               System.out.println("   ╚═══════════════════════════╝"+Main.ANSI_COLORS[16]);
               System.out.print("Enter your choice: ");
               int TripType = Main.input(1, 3);


               for (Trip trip : History_Current_trips) {

                   if (trip instanceof Couple_Tour && TripType == 1) {
                       trip.displayDetails();
                       printed=true;
                   } else if (trip instanceof Family_Tour && TripType == 2) {
                       trip.displayDetails();
                       printed=true;
                   } else if (trip instanceof General_Tour && TripType == 3) {
                       trip.displayDetails();
                       printed=true;
                   }
               }

               if(!printed) System.out.println(Main.ANSI_COLORS[11]+"None Found."+Main.ANSI_COLORS[16]);

               break;
           case 5:
               for (int i = History_Current_trips.size() - 1; i >= 0; i--) {

                   LocalDate endDate = LocalDate.parse(History_Current_trips.get(i).getEndDate());
                   if (endDate.isBefore(currentDate)) {
                       History_Current_trips.remove(i);
                   }

               }
               System.out.println(Main.ANSI_COLORS[12]+"Everything has been successfully cleared!"+Main.ANSI_COLORS[16]);
               break;
           case 6:
               Main.cls();
               return Logout_exist();
       }

       Main.sleep();
       Main.cls();
       System.out.print(Main.ANSI_COLORS[16]+"Do you wish do another operation?(Y/N): ");
       char ans =confirm();
       Main.cls();
       if (ans == 'y') return this.update_TravelHistory();
       else return Logout_exist();
   }
   //count the available tour guides for the next week
    public static int Number_availableGuides(ArrayList<TourGuide> TourGuides) //tourguides from now till next 7 days
    {
        LocalDate currentDate = LocalDate.now();
        LocalDate afterWeekDate = currentDate.plusWeeks(1);
        long count = TourGuides.stream()
                .filter(tourGuide -> tourGuide.isAvailable(currentDate.toString(),afterWeekDate.toString()))
                .count();

        return (int) count;
    }

    //count the available tour guides for a certain trip
    public static int Number_availableGuides(Trip trip, ArrayList<TourGuide> TourGuides)  //tourguides date of trip
    {

       long count = TourGuides.stream()
               .filter(tourGuide -> tourGuide.isAvailable(trip.getStartDate(), trip.getEndDate()))
               .count();

       return (int) count;
   }

    public boolean isAvailable(String startDate, String endDate){
        LocalDate tripStartDate = LocalDate.parse(startDate);
        LocalDate tripEndDate = LocalDate.parse(endDate);
        for (Trip trip : History_Current_trips) {
            LocalDate guideTripStartDate = LocalDate.parse(trip.getStartDate());
            LocalDate guideTripEndDate = LocalDate.parse(trip.getEndDate());
            if (!(tripEndDate.isBefore(guideTripStartDate) || tripStartDate.isAfter(guideTripEndDate))){
                return false;
            }
        }
        return true;
    }

    public int ViewTrips_Complaints()       //finished
    {

        LocalDate currentDate = LocalDate.now();
        ArrayList<Integer> index_Current_trips= new ArrayList<>();
        ArrayList<Trip> Remove_trips= new ArrayList<Trip>();

        int counter_display=1,index_in_Array=0;

        //if there is none in current
        for (Trip trip : History_Current_trips) {

            LocalDate startDate = LocalDate.parse(trip.getStartDate());

            if (startDate.isAfter(currentDate)) {
                System.out.print(Main.ANSI_COLORS[16]+counter_display + ")"+Main.ANSI_COLORS[0]);
                trip.displayDetails();
                index_Current_trips.add(index_in_Array);
                counter_display++;
            }
            index_in_Array++;
        }

        System.out.println(Main.ANSI_COLORS[16]+"   ╔═══════════════════════════╗");
        System.out.println("   ║  "+Main.ANSI_COLORS[12]+"  1)"+Main.ANSI_COLORS[16]+"Complaint on a trip  ║");
        System.out.println("   ║  "+Main.ANSI_COLORS[12]+"  2)"+Main.ANSI_COLORS[16]+"Exit page            ║");
        System.out.println("   ╚═══════════════════════════╝");

        System.out.print("Enter your choice: ");
        int choice=Main.input(1,2);

        if(choice==1)
        {
            int number;
            while (true) {

                System.out.print("\n\nEnter the number of trips that you have a problem with: ");
                 number = Main.input(1, index_Current_trips.size());
                if(index_Current_trips.size()!=1 && number==index_Current_trips.size())
                {

                    try {

                     throw new InvalidNumberOfComplaints(number);

                    }catch(InvalidNumberOfComplaints ex)
                    {
                        System.out.println(Main.ANSI_COLORS[10]+ex.getMessage()+Main.ANSI_COLORS[16]);
                        Main.sleep();
                        Main.cls();
                    }

                }else{
                    break;
                }
            }

            while(number!=0)
            {
                System.out.print("Enter your choice: ");
                int index=Main.input(1,index_Current_trips.size());

                if(Complainttrips.contains(History_Current_trips.get(index_Current_trips.get(index-1))))
                {
                    System.out.println(Main.ANSI_COLORS[10]+"It already exists."+Main.ANSI_COLORS[16]);
                }
                else {
                    number--;
                    Complainttrips.add(History_Current_trips.get(index_Current_trips.get(index-1)));
                    Remove_trips.add(History_Current_trips.get(index_Current_trips.get(index-1)));
                }

            }

            History_Current_trips.removeAll(Remove_trips);
            System.out.println(Main.ANSI_COLORS[11]+"Complaints have been received...."+Main.ANSI_COLORS[16]);
            Main.sleep();
            Main.cls();

        }

        Main.cls();
        return Logout_exist();
    }

//    public static void main(String [] args)
//    {
//
//        TourGuide guide= new TourGuide();
//        TourGuide guide2= new TourGuide();
//        TourGuide guide3= new TourGuide();
//        ArrayList<TourGuide> TourGuides = new ArrayList<>();
//        TourGuides.add(guide);
//        TourGuides.add(guide2);
//        TourGuides.add(guide3);
//
//        ArrayList<Admin> Admins= new ArrayList<>();
//        ArrayList<Manager> Managers = new ArrayList<>();
//        ArrayList<Customer> Customers = new ArrayList<>();
//
//        ArrayList<Trip> Trips = new ArrayList<>();
//
//
//
//        Trip t1 = new General_Tour();
//        t1.setStartDate("2023-12-10");
//        t1.setTripType("General");
//        t1.setEndDate("2023-12-20");
//        Trips.add(t1);
//
//        Trip t2 = new General_Tour();
//        t2.setStartDate("2024-03-10");
//        t2.setTripType("General");
//        t2.setEndDate("2024-03-20");
//
//        Trips.add(t2);
//
//        /////////////////////////////////
//
//        Trip t3 = new Couple_Tour();
//        t3.setStartDate("2023-01-12");
//        t3.setTripType("Couple");
//        t3.setEndDate("2023-01-19");
//
//
//
//        Trips.add(t3);
//
//        Trip t4 = new Couple_Tour();
//        t4.setStartDate("2024-03-01");
//        t4.setTripType("Couple");
//        t4.setEndDate("2024-03-17");
//
//        Trips.add(t4);
//
//        ///////////////////////////////
//
//        Trip t5 = new Family_Tour();
//        t5.setStartDate("2024-03-02");
//        t5.setTripType("Family");
//        t5.setEndDate("2024-03-11");
//
//
//        Trips.add(t5);
//
//        Trip t6 = new Family_Tour();
//        t6.setStartDate("2023-03-12");
//        t6.setTripType("Family");
//        t6.setEndDate("2023-03-19");
//
//        Trips.add(t6);
//        ///////////////////////////////
//
//        Trip t7 = new Family_Tour();
//        t7.setStartDate("2024-03-12");
//        t7.setTripType("Family");
//        t7.setEndDate("2024-03-19");
//
//        Trips.add(t7);
//
//        guide.History_Current_trips.add(t1);
//        guide.History_Current_trips.add(t2);
//        guide2.History_Current_trips.add(t3);
//        guide2.History_Current_trips.add(t4);
//        guide3.History_Current_trips.add(t5);
//        guide3.History_Current_trips.add(t6);
//        //guide.History_Current_trips.add(t7);
//
//        //guide.Register(Admins,Customers,Managers,TourGuides);
//        System.out.println(TourGuide.Number_availableGuides(TourGuides));
//        System.out.println(TourGuide.Number_availableGuides(t7,TourGuides));
//        //guide.HomePage(Admins, Customers , TourGuides, Managers ,Trips);
//
//    }


}