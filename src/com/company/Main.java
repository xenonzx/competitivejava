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
        int l = scanner.nextInt();
        ArrayList<Integer> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            points.add(scanner.nextInt());
        }

        points.sort(Integer::compareTo);
        double distanceFromStartToFirstPoint =  points.get(0) - 0;
        double distanceFromEndToLastPoint =  l-points.get(n-1) ;
        // inter-distance is the distance between  points
        double maxInterDistance = 0;
        for (int i = 0; i <n-1 ; i++) {
            maxInterDistance = Math.max(points.get(i+1)-points.get(i),maxInterDistance);
        }
        double minInterRadius = maxInterDistance/2.0;
        double minRadius = Math.max(minInterRadius,Math.max(distanceFromEndToLastPoint,distanceFromStartToFirstPoint));
        System.out.println(minRadius);

    }
}
