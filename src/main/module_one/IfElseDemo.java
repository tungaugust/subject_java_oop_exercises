package main.module_one;

public class IfElseDemo {
    public static void demo(){
        System.out.println("If-Else:");
        int testScore = 76;
        char grade;
        if (testScore >= 90){
            grade = 'A';
        } else if(testScore >= 80){
            grade = 'B';
        } else if(testScore >= 70){
            grade = 'C';
        } else if(testScore >= 60){
            grade = 'D';
        }
        else {
            grade = 'F';
        }
        System.out.println("Grade = " + grade);
    }
}
