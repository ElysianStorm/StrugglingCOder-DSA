# https://leetcode.com/problems/longest-substring-without-repeating-characters/solutions/4983172/longest-substr-without-repeating-characters-python-approach-o-n-time-o-n-space-explanation/

# Medium
# Arrays, sets
# Sliding Window
# T:O(N), S:O(N)
# Window is substr until duplicate, use set to store the chars in sustr.

class LongestSubstringWithoutRepeatingCharacter:
    def longestSubstringWithoutRepeatingCharacter(self, s: str) -> int:
        left = 0
        charSet = set()
        res = 0

        for right in range(len(s)):
            while s[right] in charSet:
                charSet.remove(s[left])
                left += 1
            charSet.add(s[right])
            res = max(res, right - left + 1)
        
        return res