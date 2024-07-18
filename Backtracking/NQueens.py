from typing import List
# https://leetcode.com/problems/n-queens/solutions/5219369/n-queen-python-pseudocode-explanation/

# Medium/Hard
# Backtracking
# Board problem
# Maintain col, posDiag, negDiag sets for safe check

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        #Information needed
        column = set()
        posDiag = set()
        negDiag = set()
        
        # Set Up Board
        board = [['.']*n for i in range(n)]
        arrangements = []

        def backtrackHelper(row):
            if row == n:
                # Base Condition -> Reached end of board row, valid board to be added to arrangements
                board_copy = ["".join(row) for row in board]
                arrangements.append(board_copy)
                return

            # For each col in a row
            for col in range(n):
                # Check valid/safe position for queen
                if (col in column or
                    row + col in posDiag or
                    row - col in negDiag):
                    continue
                
                # Put queen at position in board and add position in sets
                column.add(col)
                posDiag.add(row+col)
                negDiag.add(row-col)
                board[row][col] = 'Q'

                backtrackHelper(row+1)

                # Clear position after backtracking for fresh run
                column.remove(col)
                posDiag.remove(row+col)
                negDiag.remove(row-col)
                board[row][col] = '.'

        backtrackHelper(0)
        return arrangements