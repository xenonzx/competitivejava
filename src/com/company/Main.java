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
        String str1 = in.next();
        String str2 = in.next();

        int removableChars=  deletionDistance(str1,str2)
        System.out.println(removableChars);
    }
     static int deletionDistance(String str1, String str2) {
         // your code goes here
         int lcs = lcs(str1,str2);
         return str1.length()-lcs + str2.length()-lcs;
     }

    static int lcs(String s1, String s2){
        int lcs = 0;
        int sizeRows = s1.length()+1;
        int sizeCols = s2.length()+1;
        int[][] arr = new int[sizeRows][sizeCols];

        // zeroing the fist col of
        for (int i = 0; i <sizeRows; i++) {
            arr[i][0] = 0 ;
        }

        // zeroing the firs row
        for (int i = 0; i <sizeCols; i++) {
            arr[0][i] = 0 ;
        }

        for (int row = 1;row < sizeRows; row++) {
            for (int col = 1; col < sizeCols; col++) {
                int s1Index = row-1;
                int s2Index = col-1;

                if (s1.charAt(s1Index) == s2.charAt(s2Index)){
                    arr[row][col] = arr[row-1][col-1] + 1 ;
                }else {
                    arr[row][col] = Math.max( arr[row-1][col],arr[row][col-1]);
                }

                if (row==sizeRows-1 && col == sizeCols -1){
                    lcs= arr[row][col];
                }
            }
        }
        return lcs;
    }
 }
