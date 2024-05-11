# https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/solutions/5111544/binary-tree-zigzag-level-order-traversal-python-approach-recursive-explanation/

# Medium
# Trees, Recursion
# Odd/Even check at levels
# T:O(N), S:O(N)
# Do Level Order Traversal with append at last for even nodes, append at first for odd

from typing import List, Optional
from Tree.TreeNode import TreeNode

class BinaryTreeZigZagLevelOrder:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        level = 0
        result = []
        self.levelOrderZigzagHelper(root, level, result)
        return result

    def levelOrderZigzagHelper(self, root, level, result):
        if(root is None):
            return None
        
        if(len(result) == level):
            result.append([])

        if level%2 == 0:
            result[level].append(root.val)
        else:
            result[level].insert(0, root.val)

        level += 1
        self.levelOrderZigzagHelper(root.left, level, result)
        self.levelOrderZigzagHelper(root.right, level, result)
        level -= 1