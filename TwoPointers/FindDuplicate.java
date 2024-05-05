package TwoPointers;

// https://leetcode.com/problems/find-the-duplicate-number/solutions/5021652/find-the-duplicate-number-java-approach-o-n-time-o-1-space-explanation/

// Medium/Hard (not intuitive)
// Arrays
// Slow/Fast pointer
// T:O(N), S:O(1)
// Jump slow/fast to number position in array (i.e. slow=nums[slow], fast=nums[nums[fast]])

class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}