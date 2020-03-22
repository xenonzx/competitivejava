//package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        //File file = new File("/Users/ahmed/Development/CompetitiveProgramming\ git java/src/com/company/in.txt");
        //Scanner scanner = new Scanner(file);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[] colors = {'R', 'O', 'Y', 'G', 'B', 'I' , 'V' };
        int[] indexes  = new int[n];
        int numberOfColors = colors.length;

        for (int i = 0; i < n ; i++) {
            indexes[i] = i % numberOfColors;
        }


        int mod =n%7;

        if (mod > 0 && mod < 4){
            for (int i = 0; i < mod; i++) {
                swap (indexes,n-i-1, n-i-1-3);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n ; i++) {
            sb.append(colors[indexes[i]]);
        }
        System.out.print(sb.toString());
    }

    static void swap(int[] a, int index1, int index2){
        int tempVal = a[index1];
        a[index1] = a[index2];
        a[index2] = tempVal;
    }
}
