package main.module_four;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class ProgramsOfModuleFour {
    // Exercise 2

    // Exercise 2
    public static void inputString(boolean flag){
        if (flag){
            Scanner scanner = new Scanner(System.in);
            System.out.print("So luong chuoi muon nhap: ");
            int count = Integer.parseInt(scanner.nextLine().trim());
            HashMap<String, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < count; i++){
                System.out.print("Chuoi thu " + i + ": ");
                String key = scanner.nextLine();
                hashMap.put(key, key.length());
            }
            System.out.println("Danh sach chuoi da nhap va so ky tu cua chuoi:");
            for (String key : hashMap.keySet()) {
                System.out.println("\'" + key + "\'" + " - " + hashMap.get(key));
            }
        }
    }
    // Exercise 3
    public static void useTreeSet(){
        TreeSet<Integer> treeSet1 = new TreeSet<>();
        TreeSet<Integer> treeSet2 = new TreeSet<>();
        int[] arr1 = {5, 3, 9, 7, 8, 6, 10, 1};
        int[] arr2 = {5, 9, 3, 0, 2, 10};
        for (int i = 0; i < arr1.length; i++){
            treeSet1.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++){
            treeSet2.add(arr2[i]);
        }
        System.out.println("- Danh sach phan tu trong hai tap S1 va S2:");
        System.out.print("S1:");
        for (Integer e: treeSet1){
            System.out.print(" " + e);
        }
        System.out.println();
        System.out.print("S2:");
        for (Integer e: treeSet2){
            System.out.print(" " + e);
        }
        System.out.println();

        TreeSet<Integer> treeSet1Clone1 = (TreeSet<Integer>) treeSet1.clone();
        System.out.print("- Tap S1 hoi tap S2:");
        treeSet1Clone1.addAll(treeSet2);
        for (Integer e: treeSet1Clone1){
            System.out.print(" " + e);
        }
        System.out.println();

        TreeSet<Integer> treeSet1Clone2 = (TreeSet<Integer>) treeSet1.clone();
        System.out.print("- Tap S1 giao tap S2:");
        treeSet1Clone2.retainAll(treeSet2);
        for (Integer e: treeSet1Clone2){
            System.out.print(" " + e);
        }
        System.out.println();

        TreeSet<Integer> treeSet1Clone3 = (TreeSet<Integer>) treeSet1.clone();
        System.out.print("- Tap S1 tru tap S2:");
        treeSet1Clone3.removeAll(treeSet2);
        for (Integer e: treeSet1Clone3){
            System.out.print(" " + e);
        }
        System.out.println();
    }
}
