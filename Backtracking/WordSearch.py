from typing import List

# https://leetcode.com/problems/word-search/solutions/5193035/word-search-python-approach-explanation/

# Medium
# Backtracking
# DFS
# Visited, dfs for up, down, left, right with condition

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        row_size, col_size = len(board), len(board[0])
        visited = set()

        def dfs(row, col, word_index):
            if(word_index == len(word)):
                return True
            if (row < 0 or row >= row_size or col < 0 or col >= col_size or
                word[word_index] != board[row][col] or (row, col) in visited):
                return False
            
            visited.add((row, col))
            word_check = (dfs(row + 1, col, word_index + 1) or
                          dfs(row, col + 1, word_index + 1) or
                          dfs(row - 1, col, word_index + 1) or
                          dfs(row, col - 1, word_index + 1))

            visited.remove((row,col))
            return word_check

        for row in range(row_size):
            for col in range(col_size):
                if dfs(row, col, 0):
                    return True
        
        return False