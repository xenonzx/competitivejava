package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        //File file = new File("/Users/ahmed/Development/CompetitiveProgramming\ git java/src/com/company/in.txt");
        //Scanner scanner = new Scanner(file);
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        Map <Character,Integer> map =  new TreeMap<Character,Integer>();

        for (int i = 0; i < in.length() ; i++) {
             if (in.charAt(i) != '+'){
                 Integer charCount = map.get(in.charAt(i));

                 map.put(in.charAt(i),charCount!=null? ++charCount:1);
             }
        }
        StringBuilder s = new StringBuilder();
        for (Character c: map.keySet()) {
            for (int i =0 ;i< map.get(c);i++){

                if(! s.toString().isEmpty()){
                    s.append("+");
                }
                s.append(c);

            }

        }
        System.out.print(s);
    }
}
