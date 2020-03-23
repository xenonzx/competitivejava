//package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        //File file = new File("/Users/ahmed/Development/CompetitiveProgramming\ git java/src/com/company/in.txt");
        //Scanner scanner = new Scanner(file);
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i <t ; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            ArrayList oddInts = generateOddInts(n);
            String message = "NO";
            if (canVariations(n,k,oddInts)){
                message = "Yes";
            }
            System.out.println(message);
        }
    }

    static ArrayList<Integer> generateOddInts(int n){
        ArrayList<Integer> odds = new ArrayList<>();
        for (int i = 1; i <=n ; i+=2) {
            odds.add(i);
        }
        return odds;
    }


    static boolean canVariations(int n, int k, ArrayList<Integer> oddInts){
        if( k==0 && n==0) {

            return true;
        } else if (n>0 && k>0){
            // running case
            for (int i = oddInts.size(); i < oddInts.size(); i++) {
                int potentialOddNumber =  oddInts.get(i);
                if (potentialOddNumber>n)
                    return false;

                ArrayList<Integer> newOddInts = (ArrayList<Integer>) oddInts.clone();
                newOddInts.remove(i);
                if (canVariations((n - potentialOddNumber),k-1, newOddInts)){
                    return true;
                }
            }
        } else {
            // either( n is zero  and k is not  )or k (is zero and n is not)
        }
        return false;
    }
}
