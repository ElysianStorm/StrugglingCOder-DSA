# https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/solutions/5080973/lowest-common-ancestor-of-bst-python-approach-o-n-time-o-1-space-explanation/

# Easy/Medium - 2 Approach
# Trees, Recursion, Iterative
# Recursive: Bubble p or q till parent, then bubble up parent
# T:O(N), S:O(1)
# Iterative: Move the tree nodes till divergence in p and q path, that is ans

from Tree.TreeNode import TreeNode

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        while root:
            if root.val < p.val and root.val < q.val:
                root = root.right
            elif root.val > p.val and root.val > q.val:
                root = root.left
            else:
                return root