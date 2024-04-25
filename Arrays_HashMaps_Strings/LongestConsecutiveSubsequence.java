package Arrays_HashMaps_Strings;
// https://leetcode.com/problems/longest-consecutive-sequence/solutions/4935879/longest-consecutive-sequence-java-approach-o-n-time-o-n-space-explanation 

// Medium
// Arrays
// Hashing
// T: O(N), S: O(N)
// For the smallest number in sequence and keep increasing count till largest number in sequence. 

import java.util.HashSet;

public class LongestConsecutiveSubsequence {
        public int longestConsecutiveSubsequence(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for(int number : nums){
                set.add(number);
            }
    
            int count = 0;
            for(int prefix : set){
                if(!set.contains(prefix-1)){
                    int suffix = prefix + 1;
                    while(set.contains(suffix)){
                        suffix = suffix + 1;
                    }
                    count = Math.max(count, suffix-prefix);
                }         
            }
    
            return count;
        }
}
