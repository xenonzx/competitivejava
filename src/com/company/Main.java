package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        // write your code here

        //File file = new File("/Users/ahmed/Development/CompetitiveProgramming\ git java/src/com/company/in.txt");
        //Scanner scanner = new Scanner(file);
        Scanner scanner = new Scanner(System.in);
        int numberOfMagnets = scanner.nextInt();
        String[] magnets = new String[numberOfMagnets];
        for (int i =0; i<numberOfMagnets;i++){
            magnets[i] = scanner.next();
        }
        int counter = 0;

        Stack<String> stack = new Stack<String>();
        stack.push(magnets[0]);
        // every pop counter ++
        for (int i = 1; i<numberOfMagnets; i++){

            if(magnets[i].equals( stack.peek())){
                stack.push(magnets[i]);
            }else{
                stack.removeAllElements();
                counter++;
                stack.push(magnets[i]);
            }
        }

        //if stack is not empty pop last and counter ++
        if (!stack.empty()){
            counter++;
        }

        System.out.println(counter);


    }
}
