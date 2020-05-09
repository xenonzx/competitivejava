//package com.company;

//import java.io.File;
//import java.io.FileNotFoundException;
//import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;

 public class Main {

    public static void main(String[] args) {
//
//        //File file = new File("/Users/ahmed/Development/CompetitiveProgramming\ git java/src/com/company/in.txt");
//        //Scanner scanner = new Scanner(file);
//        Scanner scanner = new Scanner(System.in);
//        String in = scanner.nextLine();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        ArrayList<Integer>  nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(in.nextInt());
        }
        for (int i = 0; i < nums.size(); i++) {
           System.out.println( calculateNumberOfNonZero(nums.get(i)));
            System.out.println(intat(nums.get(i)));
        }

    }
    private static String intat(int integer){
        int counter = 0 ;
        String s = "";
        while (integer>0){
            if (integer % 10 !=0 ){
                int roundInt = integer % 10 ;
                int multiplier = (int) Math.pow(10,counter);
                roundInt*=multiplier;
                s= +roundInt+" "+s;
            }
            integer/=10;
            counter++;
        }
        return s;
    }

     private static int calculateNumberOfNonZero(Integer integer) {
        int nonZeroElementsCount = 0 ;
        while (integer>0){
            if (integer % 10 !=0 ){
                nonZeroElementsCount++;
            }
            integer/=10;
        }
        return nonZeroElementsCount;
     }
 }
