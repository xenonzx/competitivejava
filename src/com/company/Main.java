//package com.company;

//import java.io.File;
//import java.io.FileNotFoundException;
//import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String s= in.next();
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1; i>=0 ;i--){
            sb.append(s.charAt(i));
        }
        System.out.print(s+sb);
    }
}
