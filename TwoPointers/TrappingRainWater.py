# https://leetcode.com/problems/trapping-rain-water/solutions/4950895/trapping-rain-water-python-approach-on-time-o1-space-explanation/

# Hard
# Arrays
# Two Pointers
# T: O(N), S: O(1)
# Similar to containerWithMostWater, just compute volume over each pillar, move inwards from shorter pillar

from typing import List

class TrappingRainWater:
    def trappingRainWater(self, height: List[int]) -> int:
        left = 0
        right = len(height)-1
        capacity = 0
        
        left_max = 0
        right_max = 0
        while(left<right):
            left_max = max(left_max, height[left])
            right_max = max(right_max, height[right])
            capacity = capacity + (right_max - height[right]) + (left_max - height[left])
            if(height[left]<height[right]):
                left+=1
            else:
                right-=1
        return capacity
