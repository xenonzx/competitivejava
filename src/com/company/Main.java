//package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {

    public static final int CHUNK_SIZE = 10;

    public static void main(String[] args) {

        //File file = new File("/Users/ahmed/Development/CompetitiveProgramming\ git java/src/com/company/in.txt");
        //Scanner scanner = new Scanner(file);
        Scanner scanner = new Scanner(System.in);
        String in = scanner.next();
        int counter = 0;
        int num = 0;

        if (in.length()<=1){
           //zero print

        } else if(in.length()<9) {
            // can cast int
            num = Integer.parseInt(in);
        } else {
            int sum = 0;
            for (int i = 0; i <in.length() ; i++) {
                sum += Integer.parseInt(""+in.charAt(i));
            }
            counter++;
            num = sum;
        }

        while (num>9){
            num = sumDigits(num);
            counter++;
        }

        System.out.println(counter);
    }

    static String[] chunk(String in){
        int numberChunks = in.length() / CHUNK_SIZE;
        if (in.length() % CHUNK_SIZE > 0) {
            numberChunks++;
        }

        // split string into chuncks
        ArrayList<String> strings=  new ArrayList<>();
        int beginIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < numberChunks-1; i++) {
            endIndex= beginIndex + CHUNK_SIZE;
            strings.add(in.substring(beginIndex,endIndex));
            beginIndex = endIndex;
        }
        // extra step for the last chunk if it was irrigular in size
        strings.add(in.substring(beginIndex));
        return (String[]) strings.toArray();
    }
    int sumChunk(String chunk){
        int sum = 0;
        char[] chars = chunk.toCharArray();
        int length = chunk.length();
        for (int i = 0; i < length; i++) {
            sum += (int) chars[i];
        }
        return  sum;
    }

    static int sumDigits(int num) {
        int divisor = 10;
        int sum = 0;
        while (num>0){
            sum +=  num % divisor;
            num = num / divisor ;
        }
        return sum ;
    }
}
