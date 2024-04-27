from typing import List

# https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/solutions/4977238/find-minimum-in-rotated-sorted-array-python-approach-o-logn-time-o-1-space-explanation/

# Medium
# Arrays
# Binary Search
# T:O(logN), S:O(1)
# Find which part of array you are in, squeeze from opposite side

class MinInRotatedSortedArray:
    def minInRotatedSortedArray(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1
        while(low<high):
            mid = low + (high-low)//2
            if(nums[mid] > nums[high]):
                low = mid + 1
            else:
                high = mid
        
        return nums[low]