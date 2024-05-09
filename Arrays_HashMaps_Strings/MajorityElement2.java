package Arrays_HashMaps_Strings;

// https://leetcode.com/problems/majority-element-ii/solutions/5017019/majority-element-ii-java-approach-on-time-o1-space-explanation/

// Medium (Not Intuitive)
// Arrays
// Iteration
// T:O(N), S:(1)
// Track “how much lead” with 2 more vars, enforce lead if same num, reduce lead if different

import java.util.List;
import java.util.ArrayList;

public class MajorityElement2 {
    public List<Integer> majorityElement2(int[] nums) {
        int count_1 = 0;
        int number_1 = 0;
        int count_2 = 0;
        int number_2 = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == number_1){
                count_1++;
            }
            else if(nums[i] == number_2){
                count_2++;
            }
            else if(count_1 == 0){
                number_1 = nums[i];
                count_1++;
            }
            else if(count_2 == 0){
                number_2 = nums[i];
                count_2++;
            }
            else{
                count_1--;
                count_2--;
            }
        }

        count_1 = 0;
        count_2 = 0;
        for(int num: nums){
            if(num == number_1){
                count_1++;
            }
            if(num == number_2){
                count_2++;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        if(count_1 > nums.length/3)
            result.add(number_1);
        if(count_2 > nums.length/3 && !result.contains(number_2))
            result.add(number_2);

        return result;
    }
}