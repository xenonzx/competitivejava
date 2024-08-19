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


        int t = in.nextInt();
        for (int i = 1; i <=t ; i++) {
            // slice size and its count
            TreeMap<Long,Integer> slicesCounters = new TreeMap<>();
            int n = in.nextInt();
            int d = in.nextInt();
            int chops = 0;
            for (int j = 0; j < n; j++) {
                Long sliceSize = in.nextLong();
                int sliceCount  = slicesCounters.getOrDefault(sliceSize,0);
                sliceCount++;
                slicesCounters.put(sliceSize,sliceCount);
            }
            Map.Entry<Long, Integer> maxEntry = getlargestNumberOfSlicesEntry(slicesCounters);
            while (maxEntry.getValue()<d){
                chops++;



                //cut to increase the max

                //now we know which y
                long y;
                Iterator<Long> iterator = slicesCounters.descendingKeySet().descendingIterator();
                Long sizeWithMaxCount = iterator.next();
                if ( sizeWithMaxCount == maxEntry.getKey()){
                    y = iterator.next();
                } else {
                    y = sizeWithMaxCount;
                }
                // cut the one that can give you 2 eqaul slices or the largest one
                int entryToChoppedCounter = 0;
                long entryToChoppedKey = 0;
//                Map.Entry<Long, Integer> entryTobeChopped = null;
//                for (Map.Entry<Long, Integer> entry : slicesCounters.entrySet())
//                {
//                    if ( entry.getValue()/2 == y) {
//                        entryToChoppedKey = entry.getKey();
//                        entryToChoppedCounter = entry.getValue();
//                    }
//                }
                // chop
                long slice1 = y;
                long slice2 = sizeWithMaxCount - y;
                int s1counter = slicesCounters.get(slice1)-1;
                slicesCounters.put(slice1,slicesCounters.getOrDefault(slice1,0)+1);
                slicesCounters.put(slice2,slicesCounters.getOrDefault(slice2,0)+1);
                slicesCounters.put(sizeWithMaxCount,slicesCounters.getOrDefault(sizeWithMaxCount,0)-1);

//                if(entryTobeChopped == null){
//                    entryToChoppedKey = y;
//                    entryToChoppedCounter = slicesCounters.get(y);
//                }

            }
            System.out.println("Case #" + i+ ": " + chops);
        }


    }

    private static Map.Entry<Long, Integer> getlargestNumberOfSlicesEntry(TreeMap<Long, Integer> slicesCounters) {
        Map.Entry<Long, Integer> maxEntry = null;
        for (Map.Entry<Long, Integer> entry : slicesCounters.entrySet())
        {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
            {
                maxEntry = entry;
            }
        }
        return maxEntry;
    }
}