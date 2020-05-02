//package com.company;

//import java.io.File;
//import java.io.FileNotFoundException;
//import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;

 public class Main {

    public static void main(String[] args) {

        //File file = new File("/Users/ahmed/Development/CompetitiveProgramming\ git java/src/com/company/in.txt");
        //Scanner scanner = new Scanner(file);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] =  in.nextInt();
        }




        System.out.print(loopthough(n,nums));
    }

     private static String loopthough(int n, int[] nums) {
         String result = "NO";
         for (int i = 0; i < n ; i++) {
             for (int j = 0; j < n && j!=i ; j++) {
                 for (int k = 0; k < n && k!=j && k!=i ; k++) {
                     int a = nums[i];
                     int b = nums[j];
                     int c = nums[k];
                     if (a+b>c && a+c>b && b+c>a) {

                         return "YES";
                     }
                 }
             }
         }
         return result;
     }
 }
