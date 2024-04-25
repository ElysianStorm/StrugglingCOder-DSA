from typing import List
# https://leetcode.com/problems/3sum/solutions/4944146/3sum-python-approach-o-n-2-time-o-1-space-explanation/

# Medium
# Arrays/BS/Two Pointer (Optional: Sets)
# Mix BS, Two Pointer and extra third pointer
# T: O(N^2), S: O(1)
# Fix one number, do twoSum2 for the other two, check for duplicate

class ThreeSum:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        result = []
        
        for i in range(0, len(nums)-2):
            if nums[i] > 0:
                break
            if i > 0 and nums[i] == nums[i-1]:
                continue
            left = i + 1
            right = len(nums)-1
            while left<right:
                sum = nums[i] + nums[left] + nums[right]
                if sum == 0:
                    triplet = [nums[i], nums[left], nums[right]]
                    result.append(triplet)
                    while left < right and nums[left] == triplet[1]:
                        left = left + 1
                    while left < right and nums[right] == triplet[2]:
                        right = right - 1
                elif sum < 0:
                    left = left + 1
                else:
                    right = right - 1
        
        return result