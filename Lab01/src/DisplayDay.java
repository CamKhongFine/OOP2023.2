import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DisplayDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String year;
        String month;
        do {
            System.out.print("Enter month: ");
            month = scanner.nextLine();
            if(isMonthValid(month)) break;
        } while(true);

        do {
            System.out.println("Enter year: ");
            year = scanner.nextLine();
            if(isYearValid(year)) break;
        } while(true);


        switch (month) {
            case "1" : case "January" : case "Jan." : case "Jan" :
            case "March" :case "Mar." :case "Mar" : case "3" :
            case "May" :case "5" :case "July" :case "Jul" :case "7" :
            case "August" :case "Aug." :case "Aug" :case "8" :
            case "October" :case "Oct." :case "Oct" :case "10" :
            case "December" :case "Dec." :case "Dec" :case "12" :
                System.out.println("31 days");
                break;
            case "2": case "February" : case "Feb." : case "Feb" :
                if(isLeapYear(year)) {
                    System.out.println("29 days");
                    break;
                }
                System.out.println("28 days");
                break;
            default:
                System.out.println("30 days");
                break;

        }
    }

    private static boolean isLeapYear(String year) {
        int convertedYear = Integer.parseInt(year);
       if(convertedYear % 4 ==0) {
           if(convertedYear % 100 ==0 && convertedYear % 400 != 0) {
               return false;
           }
           return true;
       } else {
           return false;
       }
    }

    private static boolean isMonthValid(String month) {
        Set<String> setA = new HashSet<String>();
        setA.add("January");
        setA.add("Jan.");
        setA.add("Jan");
        setA.add("1");
        setA.add("February");
        setA.add("Feb.");
        setA.add("Feb");
        setA.add("2");
        setA.add("March");             //Add elements to the set ://
        setA.add("Mar.");
        setA.add("3");
        setA.add("April");
        setA.add("Apr.");
        setA.add("Apr");
        setA.add("4");
        setA.add("May");
        setA.add("June");
        setA.add("Jun");
        setA.add("6");
        setA.add("5");
        setA.add("July");
        setA.add("Jul");
        setA.add("7");
        setA.add("August");
        setA.add("Aug.");
        setA.add("Aug");
        setA.add("8");
        setA.add("September");
        setA.add("Sept.");
        setA.add("Sep");
        setA.add("October");
        setA.add("Oct.");
        setA.add("Oct");
        setA.add("9");
        setA.add("10");
        setA.add("November");
        setA.add("Nov.");
        setA.add("Nov");
        setA.add("11");
        setA.add("December");
        setA.add("Dec.");
        setA.add("Dec");
        setA.add("12");
        if(setA.contains(month)) return true;
        return false;
    }

    private static boolean isYearValid(String year) {
        if(year.length() < 4) return false;
        try {
            int convertedYear = Integer.parseInt(year);
            if (convertedYear < 0) return false;
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
