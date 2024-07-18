from typing import List

# https://leetcode.com/problems/palindrome-partitioning/solutions/5201132/palindrome-partitioning-python-pseudocode-explanation/

# Medium
# Backtracking
# DFS
# Processed/Unprocessed, similar to Subsets

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        # Main answer list
        answer = []
        #Each Partition List
        partitions = []

        #Backtracking function
        def backtrackHelper(start):
            # Base condition: If traveresed over all characters in string
            if start >= len(s):
                answer.append(partitions.copy())
                return
            
            # DFS Block: Check Palindrome for every substring
            for end in range(start, len(s)):
                if self.isPalindrome(s, start, end):
                    partitions.append(s[start:end+1])
                    backtrackHelper(end+1)
                    partitions.pop()
            
        backtrackHelper(0)
        return answer
        
    # Helper Palindrome Checker function
    def isPalindrome(self, s, start, end):
        while start < end:
            if s[start] != s[end]:
                return False
            start, end = start + 1, end - 1
        
        return True