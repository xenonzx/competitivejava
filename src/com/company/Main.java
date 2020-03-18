//package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        //File file = new File("/Users/ahmed/Development/CompetitiveProgramming\ git java/src/com/company/in.txt");
        //Scanner scanner = new Scanner(file);
        Scanner scanner = new Scanner(System.in);
        String in = scanner.next();
        BigInteger n =new BigInteger(in);
        BigInteger counter = BigInteger.ZERO;
        if (n.compareTo(new BigInteger("9"))>0){
            counter = BigInteger.ONE;
        }

        BigInteger sum = sumDigits(n);
        while (sum.compareTo(new BigInteger("9"))>0){
            counter = counter.add(BigInteger.ONE);
            sum =  sumDigits(sum);
        }
        System.out.println(counter);
    }
     static BigInteger sumDigits(BigInteger n){
        BigInteger divisor =  BigInteger.ONE;
        BigInteger sum =  BigInteger.ZERO;

        while ((n.divide(divisor).compareTo(BigInteger.ZERO))>0) {
            sum = sum.add(n.mod(BigInteger.TEN));
            n = n.divide(BigInteger.TEN);
        }
        return sum;
     }

}
