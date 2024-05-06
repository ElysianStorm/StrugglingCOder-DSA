package Tree;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/solutions/5050348/maximum-depth-of-binary-tree-java-approach-recursion-explanation/

// Easy
// Trees, Recursion
// Return size, check for base conditions
// T:O(N), S:O(N)
// Return 1 at leaf nodes, 0 at no node, function call + 1 for non leaf nodes

class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }

        int leftSize = maxDepth(root.left) + 1;
        int rightSize = maxDepth(root.right) + 1;

        return leftSize>rightSize ? leftSize : rightSize;
    }
}