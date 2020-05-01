//package com.company;

//import java.io.File;
//import java.io.FileNotFoundException;
//import java.nio.charset.StandardCharsets;
import javafx.util.Pair;

import java.nio.charset.Charset;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        HashMap<Character,Double> map = new HashMap<>();
        Set<Character> characterSet =  new HashSet<>();
        ArrayList<Pair<Integer,Integer>> shifts = new ArrayList<>();

        int n = in.nextInt();
        int m = in.nextInt();
        double x = in.nextDouble();
        //n rows m cols

        // fill array
        HashMap<Character,ArrayList<Pair<Integer,Integer>>>keyboardMap = new HashMap<>();
        for (int i = 0; i < n ; i++) {
            String row = in.next();
            for (int j = 0; j < m; j++) {
                Character c = row.charAt(j);

                ArrayList listOfPairs = keyboardMap.getOrDefault(c,new ArrayList());
                listOfPairs.add(new Pair(i,j));
                keyboardMap.put(c, listOfPairs);
                if (c =='S'){
                  shifts.add(new Pair<>(i,j));
                } else {
                    characterSet.add(c);
                }
            }
        }
        int q = in.nextInt();
        String query = in.next();
        

        // check if all lower case chars in query available in keyboard
        // check all upper case chars are available in the keyboard
        if(!isAllCharsAvailable(characterSet,query)){
            System.out.println("-1");
            return;
        }

        if (hasUpperCase(query)&&shifts.isEmpty()){
            System.out.println("-1");
            return;
        }

        // can have duplication
        ArrayList<Character> upperCaseChars = new ArrayList<>();
        for (int i = 0; i <query.length() ; i++) {
            if (Character.isUpperCase(query.charAt(i))){
                upperCaseChars.add(Character.toLowerCase(query.charAt(i)));
            }
        }
        int count2hands = 0;
        for (Character upChar :upperCaseChars) {
            double shortest=Double.MAX_VALUE;

            for (Pair<Integer,Integer> point: keyboardMap.get(upChar) ) {
                shortest = Math.min(shortest, shortestEclidianDistance(point, shifts));
            }
            if (shortest>x){
                count2hands++;
            }
        }
        System.out.println(count2hands);
    }
    private static double shortestEclidianDistance(Pair<Integer,Integer> point, ArrayList<Pair<Integer,Integer>> shifts){
        Double min = Double.MAX_VALUE;
        for (int i = 0; i <shifts.size() ; i++) {
            Pair<Integer, Integer> shiftKeyPos = shifts.get(i);
            double distanceBetweenPointAndShift = calculateDistanceBetweenPoints(point.getKey(),point.getValue(),shiftKeyPos.getKey(),shiftKeyPos.getValue());
            min = Math.min(min,distanceBetweenPointAndShift);
        }
        return min;
    }

    public static double calculateDistanceBetweenPoints(
            double x1,
            double y1,
            double x2,
            double y2) {
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }

     private static boolean hasUpperCase(String query) {
        return (query.matches(".*[A-Z].*"));
     }

     private static void hasUpperCase2(String query) {
         for (int i = 0; i <query.length() ; i++) {
             if (Character.isUpperCase( query.charAt(i)));
         }
     }

     static boolean isAllCharsAvailable(Set<Character> characterSet, String query){
        String queryLowerCase = query;
        boolean result = true;
        char[] chars= queryLowerCase.toLowerCase().toCharArray();
        for (int i = 0; i < query.length(); i++) {
            if (!characterSet.contains(chars[i])){
                result = false;
                break;
            }
        }
        return result;
    }

}
