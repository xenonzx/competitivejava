class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        // the key is the compemnetary value and the map value it its origioinal index
        val s = hashMapOf<Int,Int>()
        var result =  IntArray(2)
        for ((index,number) in nums.withIndex() ){
            if (s.containsKey(number)){
                val complementIndex = s.get(number)!!
                 result.set(0, index)
                 result.set(1, complementIndex)
                 break
            }else{
                s.put(target-number, index)
            }
            
        }
        return result
    }
}