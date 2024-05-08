# https://leetcode.com/problems/binary-tree-right-side-view/solutions/5085162/binary-tree-right-side-python-approach-o-n-time-o-n-space-explanation/

# Medium - 2 Approach
# Trees, Recursion, Queues
# Iterate right to left, maintain global traversal list and level
# T:O(N), S:O(N)
# Incr level -> recursive calls -> decrement level. First time level visit -> append to list

from typing import List, Optional
from Tree.TreeNode import TreeNode

class RightSideView:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        level = 0
        rightView = []
        self.rightViewTraversal(root, rightView, level)
        return rightView

    def rightViewTraversal(self, root, rightView, level):
        if not root:
            return None
        
        if len(rightView) == level:
            rightView.append(root.val)

        level += 1

        self.rightViewTraversal(root.right, rightView, level)
        self.rightViewTraversal(root.left, rightView, level)

        level -= 1