from typing import List
# https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/solutions/4943563/two-sum-ii-input-array-is-sorted-python-approach-o-n-time-o-1-space-explanation/

# Easy/Medium
# Arrays/BS/Two Pointers
# Mix BS and Two Pointers
# T:O(N), S: O(1)
# incr/decr by 1, mid is sum

class TwoSum2:
    def twoSum2(self, numbers: List[int], target: int) -> List[int]:
        left = 0
        right = len(numbers) - 1

        while left<right:
            sums = numbers[left]+numbers[right]
            if sums == target:
                return left+1,right+1
            elif sums > target:
                right = right - 1
            else:
                left = left + 1