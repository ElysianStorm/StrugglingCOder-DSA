# https://leetcode.com/problems/count-good-nodes-in-binary-tree/solutions/5088441/count-good-nodes-in-binary-tree-python-approach-on-time-on-space-explanation/

# Medium
# Trees, Recursion
# Keep track of maxVal
# T:O(N), S:O(N)
# When node.val > maxVal update and then move left and right

from Tree.TreeNode import TreeNode

class CountGoodNodesInBinaryTree:
    def countGoodNodesInBinaryTree(self, root: TreeNode) -> int:
        maxValue = -9223372036854775808
        return self.findGoodNodes(root, maxValue)

    def findGoodNodes(self, root, maxValue) -> int:
        if not root:
            return 0
        
        isGoodNode = 0
        if maxValue <= root.val:
            isGoodNode = 1
            maxValue = root.val

        return self.findGoodNodes(root.left, maxValue) + self.findGoodNodes(root.right, maxValue) + isGoodNode