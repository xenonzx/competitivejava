//package com.company;

//import java.io.File;
//import java.io.FileNotFoundException;
//import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;

 public class Main {

     public static void main(String[] args) {
         Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
         int n = in.nextInt();
         ArrayList<Long> v =  new ArrayList<>();
         ArrayList<Long> u =  new ArrayList<>();
         // take in input
         for (int i = 0; i < n ; i++) {
             Long value = in.nextLong();
             v.add(value);
             u.add(value);
         }
         // sort is modified merge sort with O(nlogn)
         u.sort(Long::compareTo);

         // construct prefix sum

         for (int i = 1; i < n ; i++) {
             long val = v.get(i) + v.get(i-1);
             v.set(i, val);
             long ual = u.get(i) + u.get(i-1);
             u.set(i, ual);
         }

         int m = in.nextInt();
         for (int i = 0; i <m ; i++) {
             int type = in.nextInt();
             int l = in.nextInt();
             int r = in.nextInt();
             long sum = 0;
             if (type == 1){
                 // r inclusive
                 sum = findSumValues(v,l-1, r-1);
             }else {
                 sum = findSumValues(u,l-1, r-1);
             }
             System.out.println(sum);

         }

     }

     static long findSumValues(ArrayList<Long> v, int from, int to){
         // to include
         from--;
         if (from<0){
             return  v.get(to);
         }
         return  v.get(to)-v.get(from);
     }

 }
