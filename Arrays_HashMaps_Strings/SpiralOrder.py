from typing import List
# https://leetcode.com/problems/spiral-matrix/solutions/4938571/spiral-matrix-python-approach-o-n-m-time-o-n-m-space-explanation/

# Medium
# Arrays - 2D
# Traversal/Pattern
# T: O(N*M), S: O(N*M)
# Squeeze the array while following the top->right->bottom->left edge pattern.

class SpiralOrder:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        top = 0
        bottom = len(matrix) - 1
        left = 0
        right = len(matrix[0]) - 1
        
        spiral = []
        
        while(top<=bottom and left<=right):
            for j in range(left, right+1):
                spiral.append(matrix[top][j])
                
            top+= 1
                
            for j in range(top, bottom+1):
                spiral.append(matrix[j][right])
            
            right-= 1
            
            if top <= bottom:
                for j in range(right, left-1, -1):
                    spiral.append(matrix[bottom][j])
                
                bottom-= 1
            
            if left<=right:
                for j in range(bottom, top-1, -1):
                    spiral.append(matrix[j][left])
                
                left+= 1
        
        return spiral