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
        int t = scanner.nextInt();

        for (int i = 0 ;i<t;i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int result = 0;
            if (a%b != 0){
             result = b-(a%b);
            }
            System.out.println(result);
        }


    }
}
