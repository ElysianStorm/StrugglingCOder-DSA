# https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/solutions/5080973/lowest-common-ancestor-of-bst-python-approach-o-n-time-o-1-space-explanation/

# Easy/Medium - 2 Approach
# Trees, Recursion, Iterative
# Recursive: Bubble p or q till parent, then bubble up parent
# T:O(N), S:O(1)
# Iterative: Move the tree nodes till divergence in p and q path, that is ans

from Tree.TreeNode import TreeNode


class LowestCommonAncestor:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root:
            return None
        
        if root == p or root == q:
            return root

        leftNode = self.lowestCommonAncestor(root.left, p, q)
        rightNode = self.lowestCommonAncestor(root.right, p, q)

        if leftNode or rightNode:
            if leftNode and rightNode:
                return root
            else:
                if leftNode:
                    return leftNode
                else:
                    return rightNode 