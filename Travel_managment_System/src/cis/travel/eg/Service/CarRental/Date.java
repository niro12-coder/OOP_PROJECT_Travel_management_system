package cis.travel.eg.Service.CarRental;


import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;

public class Date {
    private int day;
    private int Month;
    private int Year;
    private LocalDate date;
    Scanner in = new Scanner(System.in);
    public Date() {

    }

    public Date(int day, int month, int year) {
        this.day = day;
        Month = month;
        Year = year;
        this.date=LocalDate.of(Year, Month, this.day);
    }

    public void TakeDateFromUser() {
        DayInputAndDayValidation();
        MonthInputAndMonthValidation();
        YearInputAndYearValidation();
        this.date=LocalDate.of(Year, Month, day);
    }
    private void DayInputAndDayValidation() {

        System.out.println("Please Enter Day ");
        this.day = in.nextInt();
        InputValidOrNot(1, 31, this.day);
    }
    private void MonthInputAndMonthValidation() {
        System.out.println("Please Enter Month ");
        int Month=in.nextInt();
        if (Month > 12 || Month < 1) {
            //System.out.println("the month you have entered is not valid please Enter a valid one");
            Month=InputValidOrNot(1,12,Month);
        }
        if (Month == 2 && this.day >= 30) {
            System.out.println("sorry!!! Invalid Date please check Day or Month You entered");
            System.out.println("press (1) if you want to change day \npress (2) if you want to change Month");
            int choice = in.nextInt();
            choice=InputValidOrNot(1, 2, choice);
            if (choice == 2) {
                MonthInputAndMonthValidation();
            } else {
                DayInputAndDayValidation();
            }
        }
        this.Month=Month;
    }
    private void YearInputAndYearValidation() {
        int year;
        System.out.println("Please Enter year ");
        year = in.nextInt();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (year >= currentYear) {
            this.setYear(year);
        } else {
            System.out.println("sorry!! invalid year");
            YearInputAndYearValidation();
        }
    }
    private int InputValidOrNot(int minRange, int maxRage, int number) {
        if (number >= minRange && number <= maxRage) {
            return number;
        } else {
            System.out.printf("the number you have enter is not valid please Enter a number in this range ( %d : %d ) \n", minRange, maxRage);
            number = in.nextInt();
            InputValidOrNot(minRange, maxRage, number);
        }
        return number;
    }



    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this. day = day;
    }

    public int getMonth() {
        return Month;
    }

    public void setMonth(int month) {
        Month = month;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public LocalDate getDate() {
        return date;
    }


    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", Month=" + Month +
                ", Year=" + Year +
                ", date=" + date +
                '}';
    }
}
