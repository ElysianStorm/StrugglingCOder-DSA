package Arrays_HashMaps_Strings;
// https://leetcode.com/problems/maximum-subarray/solutions/4942636/maximum-subarray-java-approach-o-n-time-o-1-space-explanation/

// Easy-Medium
// Arrays
// Traversal/Sum
// T: O(N), S: O(1)
// Find maxTillNow, currMax and reset currMax on negative.

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int max_till_now = Integer.MIN_VALUE;
        int curr_max = 0;
        for(int i=0; i<nums.length; i++){
            curr_max = curr_max + nums[i];
            if(max_till_now < curr_max){
                max_till_now = curr_max;
            }
            if(curr_max < 0){
                curr_max = 0;
            }
        }

        return max_till_now;
    }
}
