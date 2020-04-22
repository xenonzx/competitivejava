
import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        // states =>  created, waiting, running, terminated
        ArrayList<Character> runningProcesses = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(br);
        int t = in.nextInt();
        int currentTime = -1;
        // we dont have to read all the entries we are only interested in the entries before or equal to  t
        while (t>=currentTime){
            currentTime =in.nextInt();
            Character processName = in.next().charAt(0);
            String processState = in.next();
            //  if the new entry is after t do not add it
            if (t>=currentTime && processState.equals("running")){
                runningProcesses.add(processName);
            }else if(t>=currentTime){
                runningProcesses.remove(processName);
            }
        }

        String result = "-1";
        if (runningProcesses.size()==1){
            result = ""+runningProcesses.get(0);
        }
        System.out.println(result);
    }

}