package Arrays_HashMaps_Strings;

// https://leetcode.com/problems/majority-element/solutions/5016814/majority-element-java-approach-o-n-time-o-1-space-explanantion/

// Medium (Not Intuitive)
// Arrays
// Iteration
// T:O(N), S:(1)
// Track “how much lead”, enforce lead if same num, reduce lead if different

class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        int number = 0;

        for(int i=0; i<nums.length; i++){
            if(count == 0){
                number = nums[i];
            }

            if(nums[i] == number){
                count++;
            }
            else if(nums[i] != number){
                count--;
            }
        }

        return number;
    }
}