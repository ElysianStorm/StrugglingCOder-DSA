# https://leetcode.com/problems/subtree-of-another-tree/solutions/5079564/subtree-of-another-tree-python-approach-onm-time-onm-space-explanation/

# Easy/Medium - GREAT QUESTION
# Trees, Recursion
# Use SameTree approach recursively OR Merkle Hashing
# T:O(N+M), S:O(N+M)
# Return 0 at leaf nodes, -1 at unbalanced node, height at non leaf balanced nodes

class IsSubTree(object):
    def isSubtree(self, root, subRoot):      
        if root is None:
            return False
        if self.isSameTree(root, subRoot):
            return True
        
        return self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot)

    # Re-use isSameTree
    def isSameTree(self, p, q):
        if p is None or q is None:
            return p is None and q is None

        return p.val == q.val and self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)  