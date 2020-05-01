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
        Set<Character> characterSet =  new HashSet<>();
        ArrayList<Pair<Integer,Integer>> shifts = new ArrayList<>();
        Set<Character> oneHandChars = new HashSet<Character>();

        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();
        //n rows m cols
        Character[][] charMatrix =  new Character[n][m];

        // fill array
        HashMap<Character,ArrayList<Pair<Integer,Integer>>>keyboardMap = new HashMap<>();
        for (int i = 0; i < n ; i++) {
            String row = in.next();
            for (int j = 0; j < m; j++) {
                Character c = row.charAt(j);
                charMatrix[i][j] = c ;
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
        for (Pair<Integer, Integer> shiftPos: shifts) {
            // find all points in range of the circle
            // to avoid  invalid index
            int areaStartX = Math.max(0, shiftPos.getKey() - x) ;
            int areaStartY = Math.max(0, shiftPos.getValue() - x) ;

            int areaEndX = Math.min(n-1,shiftPos.getKey() + x) ;
            int areaEndY = Math.min(m-1, shiftPos.getValue() + x);

            for (int i = areaStartX; i <= areaEndX; i++) {
                for (int j = areaStartY; j <= areaEndY  ; j++) {
                    if(i==shiftPos.getKey() && j == shiftPos.getValue())
                        continue;
                    if (calculateDistanceBetweenPoints(i,j,shiftPos.getKey(),shiftPos.getValue()) <= ((double)x))
                        oneHandChars.add(charMatrix[i][j]);

                }
            }
        }

        // can have duplication
        int count2hands = 0;
        for (int i = 0; i <query.length() ; i++) {
            Character queryChar = query.charAt(i);
            if (Character.isUpperCase(queryChar) && !oneHandChars.contains(Character.toLowerCase(queryChar))){
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
