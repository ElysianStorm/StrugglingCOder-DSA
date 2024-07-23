from typing import List
# Easy
# DP
# DFS with tabulation
# Tabulation: Curr step cost = Curr Step cost + MIN(2 Step ahead cost, 1 Step ahead cost), reverse iteration

# Recurrence: F(N) = cost[n] + MIN(F(N+2), F(N+1))
class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        cost.append(0)
        for i in range(len(cost) - 3, -1, -1):
            cost[i] = cost[i] + min(cost[i+1], cost[i+2])
        
        return min(cost[0], cost[1])