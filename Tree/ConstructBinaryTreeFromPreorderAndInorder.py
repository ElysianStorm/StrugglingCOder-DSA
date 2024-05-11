# https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solutions/5121341/construct-binary-tree-from-preorder-and-inorder-traversal-recursive-explanation/

# Medium/ Hard (Not so intuitive)
# Trees, Recursion
# Root = preorder[0], root divides inorder in left and right
# T:O(N), S:O(N)
# Root divides inorder in left & right, no. of nodes in left and right is division in preorder

from typing import List, Optional
from Tree.TreeNode import TreeNode

class ConstructBinaryTreeFromPreorderAndInorder:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder or not inorder:
            return None
        
        root = TreeNode(preorder[0])
        rootIndex = inorder.index(preorder[0])

        root.left = self.buildTree(preorder[1:rootIndex+1], inorder[:rootIndex])
        root.right = self.buildTree(preorder[rootIndex + 1:], inorder[rootIndex + 1:])
        return root