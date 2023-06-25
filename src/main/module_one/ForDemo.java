package main.module_one;

public class ForDemo {
    public static void demo(){
        System.out.println("For-Loop:");
        for (int i = 0; i < 5; i++){
            System.out.println("Count is " + i);
        }
        System.out.println("For-each:");
        String[] stringArray = {"hello", "world", "good",  "morning"};
        for(String s: stringArray){
            System.out.print(s + "\t");
        }
        System.out.print("\n");
    }
}
