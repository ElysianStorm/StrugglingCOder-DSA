package Arrays_HashMaps_Strings;

// https://leetcode.com/problems/next-permutation/solutions/5547836/next-permutation-java-approach-o-n-time-o-1-space-explanation/

// Easy/Medium
// Arrays
// T:O(N), S:O(1)
// Switch index number, swapping
// Switch index num -> first num from back < prev num. Find switch index, Swap Switch index num with last higher num

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int last_switch_index = -1;

        for(int i = nums.length - 1; i>0; i--){
            if(nums[i] > nums[i-1]){
                last_switch_index = i-1;
                break;
            }
        }

        if(last_switch_index == -1){
            reverse(nums, 0, nums.length-1);
            return;
        }

        for(int i = nums.length - 1; i>last_switch_index; i--){
            if(nums[i]>nums[last_switch_index]){
                swap(nums, last_switch_index, i);
                break;
            }
        }

        reverse(nums, last_switch_index+1, nums.length-1);
        return;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

        return;
    }

    public void reverse(int[] nums, int start, int end){
        while(start<end){
            swap(nums, start, end);
            start++;
            end--;
        }

        return;
    }
}
