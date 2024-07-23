from typing import List
# Easy/Medium
# DP
# DFS with tabulation

# Recurrence: F(N) = MAX(F(N-2) + N.PROFIT , F(N-1)), RobFirst, RobLast Scenario

class Solution:
    def rob(self, nums: List[int]) -> int:
        maxFirst = self.robHelper(nums[1:])
        maxLast = self.robHelper(nums[:-1])
        return max(nums[0], maxFirst, maxLast)

    def robHelper(self, nums):
        rob1 = 0
        rob2 = 0
        
        for n in nums:
            currRob = max(rob1 + n, rob2)
            rob1 = rob2
            rob2 = currRob

        return rob2