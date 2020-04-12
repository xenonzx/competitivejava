//package com.company;

//import java.io.File;
//import java.io.FileNotFoundException;
//import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;

 class Main {

     public static void main(String[] args) {
         Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
         int n = in.nextInt();
         ArrayList<Integer> v =  new ArrayList<>();
         ArrayList<Integer> u =  new ArrayList<>();

         for (int i = 0; i < n ; i++) {
             int value = in.nextInt();
             v.add(value);
             u.add(value);
         }
         // sort is modified merge sort with O(nlogn)
         u.sort(Integer::compareTo);

         int m = in.nextInt();
         for (int i = 0; i <m ; i++) {
             int type = in.nextInt();
             int l = in.nextInt();
             int r = in.nextInt();
             long sum = 0;
             if (type == 1){
                 // r inclusive
                 sum = findSumValues(v,l-1,r );
             }else {
                 sum = findSumValues(u,l-1,r );
             }
             System.out.println(sum);

         }

     }

     static long findSumValues(ArrayList<Integer> v, int from, int to){
         long sum = 0;
         for (int i = from; i <to ; i++) {
             sum += v.get(i);
         }
         return  sum;
     }

 }
