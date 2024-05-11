# https://leetcode.com/problems/binary-tree-level-order-traversal-ii/solutions/5111486/binary-tree-level-order-traversal-ii-python-approach-recursive-explanation/

# Medium - 2 Approach
# Trees, Recursion, Queues
# Maintain global traversal list and level
# T:O(N), S:O(N)
# Do Level Order Traversal, then reverse lis

from typing import List, Optional
from Tree.TreeNode import TreeNode

class Solution:
    def levelOrderBottom(self, root: Optional[TreeNode]) -> List[List[int]]:
        level = 0
        result = []
        self.levelOrderHelper(root, level, result)
        result.reverse()
        return result

    def levelOrderHelper(self, root, level, result):
        if root is None:
            return None

        if(len(result) == level):
            result.append([])
        result[level].append(root.val)
        level = level + 1
        self.levelOrderHelper(root.left, level, result)
        self.levelOrderHelper(root.right, level, result)
        level = level - 1
    