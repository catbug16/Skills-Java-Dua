
public class PayrollCalculator { ;
    // Method to calculate weekly pay based on employee type and hours
    public static double calculateWeeklyPay(String employeeType, double hoursWorked, double hourlyRate, double flatRate) {

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
    public static void main(String[] args) {
        double c1 = calculateWeeklyPay("FULL_TIME", 45, 5, 700);
        System.out.println("The weekly pay is: " + c1);
    }

}
