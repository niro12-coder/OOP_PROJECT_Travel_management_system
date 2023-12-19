package cis.travel.eg.Main;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class Voucher implements Serializable {
  // attributes

    ArrayList<Integer> DurationOfVoucherInDays= new ArrayList<Integer>(Arrays.asList(3,7, 11, 14,30));
    ArrayList<Integer> DiscountPercent= new ArrayList<Integer>(Arrays.asList(15,30,40,55,75));

    private int StartDate_Day;
    private int StartDate_Month;
    private int StartDate_Year;
    private int EndDate_Day;
    private int EndDate_Month;
    private int EndDate_Year;
    private double DiscountPercentage;
    private boolean IsUsed;

    final private LocalDate StartDate;
    final private LocalDate EndDate;

    LocalDate currentDate= LocalDate.now();

    //constructors

    public Voucher() {
        //taken from current date-->Time function.
        //Math.random() returns a double between 0.0 and 1.0 (ratio).
        StartDate_Day = currentDate.getDayOfMonth();
        StartDate_Month = currentDate.getMonthValue();
        StartDate_Year = currentDate.getYear();
        StartDate = LocalDate.of(getStartDate_Year(),getStartDate_Month(), getStartDate_Day());

        EndDate = StartDate.plusDays(DurationOfVoucherInDays.get((int) (Math.random() * (4))));

        this.setEndDate_Day(EndDate.getDayOfMonth());
        this.setEndDate_Month(EndDate.getMonthValue());
        this.setEndDate_Year(EndDate.getYear());

        this.setDiscountPercentage(DiscountPercent.get((int)(Math.random() * (4))));

    }

    //methods

    public void DisplayInfo()
    {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedStartDate = StartDate.format(formatter);
        String formattedEndDate = StartDate.format(formatter);


        System.out.println(

                "/nStartDate: " + formattedStartDate +"."+
                "/nEndDate: " + formattedEndDate +"."+
                "DurationOfVoucher: " + DurationOfVoucherInDays +" days."+
                "/nDiscountPercentage= " + DiscountPercentage +"%."+
                "/nIsUsed= " + IsUsed+"."
        );

    }

   Boolean Is_Used()
   {
       return IsUsed;
   }
   Boolean Is_Expired()
   {
       return currentDate.isAfter(EndDate);
   }
    Boolean Is_valid()
    {
        if(Is_Used() || Is_Expired()) return false;
        else return true;
    }

    @Override
    public String toString() {
        return "Voucher{" +
                "DurationOfVoucherInDays=" + DurationOfVoucherInDays +
                ", DiscountPercent=" + DiscountPercent +
                ", StartDate_Day=" + StartDate_Day +
                ", StartDate_Month=" + StartDate_Month +
                ", StartDate_Year=" + StartDate_Year +
                ", EndDate_Day=" + EndDate_Day +
                ", EndDate_Month=" + EndDate_Month +
                ", EndDate_Year=" + EndDate_Year +
                ", DiscountPercentage=" + DiscountPercentage +
                ", IsUsed=" + IsUsed +
                ", StartDate=" + StartDate +
                ", EndDate=" + EndDate +
                ", currentDate=" + currentDate +
                '}';
    }
// setters and getters

    public int getStartDate_Day() {
        return StartDate_Day;
    }

    public void setStartDate_Day(int startDate_Day) {
        StartDate_Day = startDate_Day;
    }

    public int getStartDate_Month() {
        return StartDate_Month;
    }

    public void setStartDate_Month(int startDate_Month) {
        StartDate_Month = startDate_Month;
    }

    public int getStartDate_Year() {
        return StartDate_Year;
    }

    public void setStartDate_Year(int startDate_Year) {
        StartDate_Year = startDate_Year;
    }

    public int getEndDate_Day() {
        return EndDate_Day;
    }

    public void setEndDate_Day(int endDate_Day) {
        EndDate_Day = endDate_Day;
    }

    public int getEndDate_Month() {
        return EndDate_Month;
    }

    public void setEndDate_Month(int endDate_Month) {
        EndDate_Month = endDate_Month;
    }

    public int getEndDate_Year() {
        return EndDate_Year;
    }

    public void setEndDate_Year(int endDate_Year) {
        EndDate_Year = endDate_Year;
    }

    public double getDiscountPercentage() {
        return DiscountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        DiscountPercentage = discountPercentage;
    }

    public boolean isUsed() {
        return IsUsed;
    }

    public void setUsed(boolean used) {
        IsUsed = used;
    }


}
