# https://leetcode.com/problems/balanced-binary-tree/solutions/5072677/balanced-binary-tree-python-approach-recursion-explanation/

# Easy/Medium
# Trees, Recursion
# Return size, if unbalanced return -1
# T:O(N), S:O(N)
# Return 0 at leaf nodes, -1 at unbalanced node, height at non leaf balanced nodes

class BalancedBinaryTree(object):
    def isBalanced(self, root):
        return (self.findSize(root) >= 0)
    
    def findSize(self, root):
        if root is None:
            return 0
        
        leftSize = self.findSize(root.left)
        rightSize = self.findSize(root.right)
        
        if leftSize < 0 or rightSize < 0 or abs(leftSize - rightSize) > 1:
            return -1
        
        return max(leftSize, rightSize) + 1