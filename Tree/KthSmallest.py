# https://leetcode.com/problems/kth-smallest-element-in-a-bst/solutions/5111960/kth-smallest-element-in-a-bst-python-approach-recursive-explanation/

# Medium
# Trees, Recursion
# Store values in array for nodes
# T:O(N), S:O(N)
# Maintain count or store elements in array, inorder traversal

class KthSmallest(object):
    def kthSmallest(self, root, k):
        elementIndex = []
        self.kthSmallestBSThelper(root, elementIndex)
        return elementIndex[k-1]
        
    def kthSmallestBSThelper(self, node, elementIndex):
        if not node:
            return
        
        self.kthSmallestBSThelper(node.left, elementIndex)
        elementIndex.append(node.val)
        self.kthSmallestBSThelper(node.right, elementIndex)