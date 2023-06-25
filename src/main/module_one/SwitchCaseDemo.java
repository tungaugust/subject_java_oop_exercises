package main.module_one;

public class SwitchCaseDemo {
    public static void demo(){
        System.out.println("Switch-Case:");
        int month = 8;
        String monthString;
        String season;
        switch (month){
            case 1: monthString = "January"; break;
            case 2: monthString = "February"; break;
            case 3: monthString = "March"; break;
            case 4: monthString = "April"; break;
            case 5: monthString = "May"; break;
            case 6: monthString = "June"; break;
            case 7: monthString = "July"; break;
            case 8: monthString = "August"; break;
            case 9: monthString = "September"; break;
            case 10: monthString = "October"; break;
            case 11: monthString = "November"; break;
            case 12: monthString = "December"; break;
            default: monthString = "Invalid month";
        }
        switch (month){
            case 1: case 2: case 3: season = "Spring"; break;
            case 4: case 5: case 6: season = "Summer"; break;
            case 7: case 8: case 9: season = "Autumn"; break;
            case 10: case 11: case 12: season = "Winter"; break;
            default: season = "Invalid season";
        }
        System.out.println(monthString+ " of " + season);
    }
}
