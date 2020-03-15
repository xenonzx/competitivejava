//package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        //File file = new File("/Users/ahmed/Development/CompetitiveProgramming\ git java/src/com/company/in.txt");
        //Scanner scanner = new Scanner(file);

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        System.out.println(SvetaDecoded(s,n));

    }

    static String Sveta(String s){
        // find mid
        int l = s.length();
        if (l == 1)
            return  s;

        int mid = (l%2 == 0)? l/2: (l+1)/2;
        mid --;
        // substing to mid
        System.out.println("mid "+ mid );
        return s.charAt( mid)+ Sveta( s.substring(0,mid)+s.substring(mid+1));
    }
    static String SvetaDecoded(String s, int length){
        int i = 0;
        int midIndex = (length%2==0)? (length-1)/2: length/2;
        //midIndex --;
        char[] out = new char[length];

        // setting mid at index
        out[midIndex] = s.charAt(0);
        i++;
        int p1 ;
        int p2 ;
        int p;
        for (int j = 1; j <length ;j++ ) {

            char c = s.charAt(j);

            if (length%2==1) {
                p1 = midIndex - i;
                p2 = midIndex + i;
            } else {
                p1 = midIndex + i;
                p2 = midIndex - i;
            }

            if (j%2==1){
                out[p1] = c;
            } else {
                out[p2] = c ;
            }



            if (j%2==0)
                i++;

        }
        return new String(out);
    }
}
