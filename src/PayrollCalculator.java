
import java.io.*;

public class PayrollCalculator { ;
    // Method to calculate weekly pay based on employee type and hours
    public static double calculateWeeklyPay(String employeeType, double hoursWorked, double hourlyRate, double flatRate) {
        // Checking for negative values
        if ( hoursWorked<0 || hourlyRate<0 || flatRate<0){
            throw new IllegalArgumentException("Input values must not be negative");
        }
        // Use switch case for different rules:
        switch (employeeType){
            // FULL_TIME: Regular pay for 40 hours, overtime (1.5x) for hours >
            case "FULL_TIME":
                if (hoursWorked <=40){
                    return hoursWorked*hourlyRate;
                }
                else{
                    return 40*hourlyRate + 1.5*hourlyRate*(hoursWorked-40);
                }
                // PART_TIME: Regular pay, no overtime, max 25 hours
            case "PART_TIME":
                if (hoursWorked <=25){
                    return hoursWorked*hourlyRate;
                }
                else{
                    return 25*hourlyRate;
                }
                // CONTRACTOR: Flat rate, no overtime rules
            case "CONTRACTOR":
                return flatRate;
            // INTERN: 20% discount from hourly rate, max 20 hours
            case "INTERN":
                double Ihourlyrate = hourlyRate - hourlyRate*20/100;
                if (hoursWorked<=20){
                   return hoursWorked*Ihourlyrate;
                }
                else{
                    return Ihourlyrate*20;
                }
            default:
                throw new IllegalArgumentException("Message");
        }
    }
    // Method to calculate tax deduction based on pay brackets
    public static double calculateTaxDeduction(double grossPay, boolean hasHealthInsurance){
        // Checks for negative grossPay
        if (grossPay<0){
            throw new IllegalArgumentException("Gross Pay cannot be negative");
        }
        // Tax brackets using nested if-else:
        double tax=0;
        // $0-500: 10% tax
        if (0<=grossPay && grossPay<=500){
            tax=0.1*grossPay;
            // $501-1000: 15% tax
        } else if (501<=grossPay && grossPay<=1000) {
            tax=0.15*grossPay;
            // $1001-2000: 20% tax
        } else if (1001<=grossPay && grossPay<=2000) {
            tax=0.2*grossPay;
            // Above $2000: 25% tax
        } else if (2001<= grossPay) {
            tax=0.25*grossPay;
        }
        // If hasHealthInsurance is true, reduce tax by $50
        if (hasHealthInsurance){
            tax -=50;
        }
        // Return total tax amount
        return tax;
    }
    // Method to process multiple employees and find statistics
    public static void processPayroll(String[] employeeTypes, double[] hours, double[] rates, String[] names) {
        double[] payroll= new double[names.length];
        System.out.printf("%-15s%-15s%n", "Name", "pay");
        for (int i=0; i< names.length; i++){
            double flatRate=700;
            payroll[i] =calculateWeeklyPay(employeeTypes[i],hours[i],rates[i],flatRate);
            System.out.printf("%-15s%-15s%n",names[i], payroll[i]);
        }
        double minPay=payroll[0];
        for (int i=0; i< payroll.length; i++){
            if(payroll[i]<minPay){
                minPay=payroll[i];
            }
        }
        double maxPay=payroll[0];
        for (int i=0; i< payroll.length; i++){
            if (payroll[i]>maxPay){
                maxPay=payroll[i];
            }
        }
        double avgPay=0;
        for (double value : payroll){
            avgPay+= value;
        }
        avgPay=avgPay/payroll.length;

        int count=0;
        for (int i=0; i<hours.length; i++){
            if (hours[i]>40){
                count+=1;
            }
        }
        System.out.println("\nPayroll Summary:");
        System.out.printf("Highest Paid: $%.2f%n", maxPay);
        System.out.printf("Lowest Paid:  $%.2f%n", minPay);
        System.out.printf("Average Pay:  $%.2f%n", avgPay);
        System.out.printf("Employees with Overtime: %d%n", count);

    }
    public static void main(String[] args) {
        double c1 = calculateWeeklyPay("FULL_TIME", 45, 5, 700);
        System.out.println("The weekly pay is: " + c1);
        double tax1 = calculateTaxDeduction(650, true);
        System.out.println("Total tax: "+tax1);
        String[] types = {"FULL_TIME", "PART_TIME", "CONTRACTOR", "INTERN", "FULL_TIME"};
        double[] hours = {45, 20, 35, 15, 50};
        double[] rates = {25.0, 18.0, 40.0, 12.0, 30.0};
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve"};
        processPayroll(types, hours, rates,names);
    }


}
