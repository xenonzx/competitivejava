import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
//
//        //File file = new File("/Users/ahmed/Development/CompetitiveProgramming\ git java/src/com/company/in.txt");
//        //Scanner scanner = new Scanner(file);
//        Scanner scanner = new Scanner(System.in);
//        String in = scanner.nextLine();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int[] c = new  int[] { 0, 0, 1 ,0 ,0, 1, 0};
        //jumpingOnClouds(c);
        maxSubArray(new int[]{-2, -1});
    }
    static long sq(long number ){
        long n = number * number ;
        return n;
    }

    public static int countingValleys(int steps, String path) {
        // Write your code here
        int diff = 0;
        int vallies = 0;
        int prevDiff = 0 ;
        for(int i = 0 ; i<steps ; i++){
            if (path.charAt(i)=='U'){
                diff ++;
            } else {
                diff --;
            }
            if (prevDiff ==0&& diff <0){
                vallies ++;
            }
            prevDiff =diff;
        }
        return vallies;
    }

    static int jumpingOnClouds(int[] c) {
        int size = c.length;
        int i = 0;
        int jumps = 0;
        while ( i <size ) {
            if (i== size - 1)
                break;
            if (i+2<size && c[i+2] == 0){
                i+=2;
                jumps++;
                continue;
            }else if (i+1<size && c[i+1] == 0){
                i++;
                jumps++;
            }



        }
    return jumps;
    }

    static long repeatedString(String s, long n) {
        int sLength = s.length();
        // number of as is string
        int nAinS  = 0;
        for (int i = 0; i < sLength; i++) {
            if( s.charAt(i)=='a')
                nAinS++;
        }


        long countA = ((n/sLength)*nAinS);

        // the remaining
        int rem = (int) (n%sLength);
        for (int i = 0; i <rem ; i++) {
            if(s.charAt(i)=='a'){
                countA++;
            }
        }
        return countA;

    }

    //https://leetcode.com/problems/maximum-subarray/
    public int maxSubArray2(int[] nums) {

        int[][] indecesSum = new int [nums.length][nums.length];
        indecesSum[0][0] = nums[0];
        int maxVal = indecesSum[0][0];
        for (int j = 1; j < nums.length; j++) {
            indecesSum[0][j] = nums[j] + indecesSum[0][j-1];
            maxVal = Integer.max(indecesSum[0][j],maxVal);
        }

        for (int i = 1; i <nums.length ; i++) {
            for (int j = i; j <nums.length ; j++) {
                if (i==j){
                    indecesSum[i][j] = nums[i];
                }
                indecesSum[i][j] = indecesSum[i][j-1]+ indecesSum[i-1][j] - indecesSum[i-1][j-1];
                maxVal = Integer.max(indecesSum[i][j],maxVal);
            }
        }
        return  maxVal;
    }
    //https://leetcode.com/problems/maximum-subarray/

    static  int maxSubArray(int[] nums){
        int [] prifix = new int [nums.length];
        prifix[0]= nums[0];
        for (int i = 1; i < nums.length; i++) {
            prifix[i] =  prifix[i-1]+nums[i];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i; j < nums.length ; j++) {
               max = Math.max(max,sumRange(prifix,i,j));
            }
        }
        return max;
    }
    static int sumRange(int[] num, int[] pri, int start,int end){
       return pri[end]-pri[start]+num[start]

    }
}