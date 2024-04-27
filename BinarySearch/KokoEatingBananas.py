from math import ceil
from typing import List

# https://leetcode.com/problems/koko-eating-bananas/solutions/4976561/koko-eating-bananas-python-approach-o-nlogn-time-o-1-space-explanation/

# Medium/Hard (Not Intuitive, if not already solved)
# Arrays
# Binary Search
# T:O(NlogN), S:O(1)
# BS on counts of piles with feasibility check on each potential mid


class KokoEatingBananas:
    def kokoEatingBananas(self, piles: List[int], h: int) -> int:
        def checkEatingSpeed(piles, h, k) -> bool:
            time = 0
            for i in range(len(piles)):
                time = time + ceil(piles[i]/k) 
                    
            if time > h:
                return 0
            if time <= h:
                return 1

        low = 1
        high = max(piles)

        while low<=high:
            mid = low + (high-low)//2
            if checkEatingSpeed(piles, h, mid):
                high = mid-1
            else:
                low = mid+1
        return low
    