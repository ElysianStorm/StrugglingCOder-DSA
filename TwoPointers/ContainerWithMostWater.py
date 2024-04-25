from typing import List
# https://leetcode.com/problems/container-with-most-water/solutions/4946296/container-with-most-water-python-approach-o-n-time-o-1-space-explanation/

# Medium
# Arrays
# Two Pointers
# T: O(N), S: O(1)
# Volume and move lower

class ContainerWithMostWater:
    def maxArea(self, height: List[int]) -> int:
        left = 0
        right = len(height)-1
        area = 0
        while left<right:
            container_height = min(height[left],height[right])
            curr_area = container_height * (right-left)
            area = max(area, curr_area)
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
        return area