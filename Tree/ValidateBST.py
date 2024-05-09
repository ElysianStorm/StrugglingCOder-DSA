# https://leetcode.com/problems/validate-binary-search-tree/solutions/5090447/validate-binary-search-tree-python-approach-on-time-on-space-explanation/

# Medium
# Trees, Recursion
# Node val will always be between minVal and maxVal
# T:O(N), S:O(N)
# Left nodes -> minVal - parentNodeVal, right nodes -> parentNodeVal - maxVal

from typing import Optional
from Tree.TreeNode import TreeNode

class ValidateBST:
    def validateBST(self, root: Optional[TreeNode]) -> bool:
        minVal = -9223372036854775808
        maxVal = 9223372036854775807
        return self.checkBST(root, minVal, maxVal)

    def checkBST(self, root, minVal, maxVal):
        if not root:
            return True
        
        if root.val >= maxVal or root.val <= minVal:
            return False
        
        return self.checkBST(root.left, minVal, root.val) and self.checkBST(root.right, root.val, maxVal)