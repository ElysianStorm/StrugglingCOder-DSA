# Memoized approach
class ClimbingStairsMemoization:
# Easy
# DP
# DFS with memoization, tabulation
# Memoization: Return answers for target, save in dp before return.
# Tabulation: Last step = Second Last Step + Third Last Step

# Recurrence: F(N) = F(N-1) +F(N-2)
    def climbStairs(self, n: int) -> int:
        curr = 0
        dp = []*n
        return self.climbStairsHelper(curr, n, dp)
         
    def climbStairsHelper(self, curr, target, dp):
        if(target >= 0):    
            if target == 0:
                return 1
            
            if target < 0:
                return 0

            if target < len(dp):
                return dp[target-1]
            
            left = self.climbStairsHelper(curr+1, target-1, dp)
            right = self.climbStairsHelper(curr+2, target-2, dp)
            dp.insert(target, left+right)
            return left+right
        return 0