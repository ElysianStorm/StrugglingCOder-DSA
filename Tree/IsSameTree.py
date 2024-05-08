# https://leetcode.com/problems/same-tree/solutions/5078861/same-tree-python-approach-recursion-explanation/

# Easy/Medium
# Trees, Recursion
# Check recursively both trees like arrays
# T:O(N), S:O(N)
# Return if match at nodes, else recursively check and return false at mismatch

from Tree.TreeNode import TreeNode

class IsSameTree():
    def isSameTree(self, p: 'TreeNode', q: 'TreeNode'):
        if (p == None and q == None):
            return True
        
        if (p == None and q != None) or (p != None and q == None):
            return False
        
        if (p.val != q.val):
            return False

        return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)        