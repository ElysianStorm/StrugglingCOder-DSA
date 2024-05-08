package Tree;

// https://leetcode.com/problems/diameter-of-binary-tree/solutions/5050695/diameter-of-binary-tree-java-approach-recursion-explanation/

// Medium
// Trees, Recursion
// 2 value tracking in recursion
// T:O(N), S:O(N)
// Track maxDiamater in global variable, return larger branch size in recursion

class DiameterOfBinaryTree {
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        calculateMaxDiameter(root);
        return maxDiameter;
    }

    public int calculateMaxDiameter(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftSize = calculateMaxDiameter(root.left);
        int rightSize = calculateMaxDiameter(root.right); 

        // Set Max Diameter and pass it up the recursion tree
        maxDiameter = Math.max(leftSize + rightSize, maxDiameter);

        // Return the longer branch size
        return 1 + Math.max(leftSize, rightSize);
    }
}