# https://leetcode.com/problems/binary-tree-level-order-traversal/solutions/5084700/binary-tree-level-order-python-approach-o-n-time-o-n-space-explanation/

# Medium - 2 Approach
# Trees, Recursion, Queues
# Maintain global traversal list and level
# T:O(N), S:O(N)
# append at level list, incr level -> recursive calls -> decr. level. First time level visit check

from typing import List, Optional
from Tree.TreeNode import TreeNode

class Solution:
    def levelOrderTraversal(self, root, traversal, level) -> List[List[int]]:
        # Leaf Node Check
        if not root:
            return None

        # First Visit At Level Check
        if len(traversal) == level:
            traversal.append([])

        # Operation at every node to add to level list in traversal list
        traversal[level].append(root.val)
        # Operation to increment level
        level = level + 1

        # Recursive move to lower levels
        self.levelOrderTraversal(root.left, traversal, level)
        self.levelOrderTraversal(root.right, traversal, level)

        # Back at level after recursion, so decrement level
        level = level - 1
        return traversal

    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        # Globally saving level and traversal list
        traversal = []
        level = 0
        
        return self.levelOrderTraversal(root, traversal, level)