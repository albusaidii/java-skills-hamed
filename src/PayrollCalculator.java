public class PayrollCalculator {

    public static double CalcWeeklyPay(String employeeType, double hoursWorked, double hourlyRate) {
        if (hoursWorked < 0 || hourlyRate < 0) return 0;

        switch (employeeType) {
            case "FULL_TIME":
                double overtime = hoursWorked > 40 ? (hoursWorked - 40) * hourlyRate * 1.5 : 0;
                return (Math.min(hoursWorked, 40) * hourlyRate) + overtime;

            case "PART_TIME":
                return Math.min(hoursWorked, 25) * hourlyRate;
            case "CONTRACTOR":
                return hoursWorked * hourlyRate;
            case "INTERN":
                return Math.min(hoursWorked, 20) * (hourlyRate * 0.8);
            default:
                return 0;
        }
    }

    public static double calculateTaxDeduction(double grossPay, boolean hasHealthInsurance) {
        double tax;
        if (grossPay <= 500) tax = grossPay * 0.10;
        else if (grossPay <= 1000) tax = grossPay * 0.15;
        else if (grossPay <= 2000) tax = grossPay * 0.20;
        else tax = grossPay * 0.25;

        if (hasHealthInsurance) tax -= 50;
        return Math.max(tax, 0);
    }

    public static void processPayroll(String[] employeeTypes, double[] hours, double[] rates, String[] names) {
        int n = Math.min(Math.min(employeeTypes.length, hours.length), Math.min(rates.length, names.length));

        double totalPay = 0, maxPay = 0, minPay = Double.MAX_VALUE;
        String maxName = "", minName = "";
        int overtimeCount = 0;

        System.out.println("\nName\tType\t\tPay");
        System.out.println("-------------------------------");

        for (int i = 0; i < n; i++) {
            double pay = CalcWeeklyPay(employeeTypes[i], hours[i], rates[i]);
            totalPay += pay;

            if (pay > maxPay) { maxPay = pay; maxName = names[i]; }
            if (pay < minPay) { minPay = pay; minName = names[i]; }
            if (hours[i] > 40) overtimeCount++;

            System.out.println(names[i] + "\t" + employeeTypes[i] + "\t$" + pay);
        }

        System.out.println("\nHighest Paid: " + maxName + " ($" + maxPay + ")");
        System.out.println("Lowest Paid : " + minName + " ($" + minPay + ")");
        System.out.println("Average Pay : $" + (totalPay / n));
        System.out.println("Employees with Overtime: " + overtimeCount);
    }

    public static void main(String[] args) {
        String[] types = {"FULL_TIME", "PART_TIME", "CONTRACTOR", "INTERN", "FULL_TIME"};
        double[] hours = {45, 20, 35, 15, 50};
        double[] rates = {25.0, 18.0, 40.0, 12.0, 30.0};
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve"};


        double samplePay = CalcWeeklyPay("FULL_TIME", 45, 25.0);
        double tax = calculateTaxDeduction(samplePay, true);
        System.out.println("Sample Pay: $" + samplePay + " | Tax Deduction: $" + tax);


        processPayroll(types, hours, rates, names);
    }

}


