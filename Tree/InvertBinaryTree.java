package Tree;

// https://leetcode.com/problems/invert-binary-tree/solutions/5050168/invert-binary-tree-java-approach-recursive-explanation/

// Easy
// Trees, Recursion
// Swap left and right
// T:O(N), S:O(1)
// Return at leaf nodes, swap at non leaf nodes

class InvertBinaryTree {
    public TreeNode invertBinaryTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return root;
        }

        TreeNode currLeft = root.left;
        root.left = root.right;
        root.right = currLeft;

        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
        return root;
    }
}