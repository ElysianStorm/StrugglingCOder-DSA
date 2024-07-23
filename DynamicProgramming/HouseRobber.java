package DynamicProgramming;
// Easy/Medium
// DP
// DFS with tabulation

// Recurrence: F(N) = MAX(F(N-2) + N.PROFIT , F(N-1))

public class HouseRobber {
    public int houseRobber(int[] nums) {
        if(nums.length < 2){
            return nums[0];
        }
        nums[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<nums.length; i++){
            nums[i] = Math.max(nums[i-2] + nums[i], nums[i-1]);
        }

        return nums[nums.length - 1];
    }
}
