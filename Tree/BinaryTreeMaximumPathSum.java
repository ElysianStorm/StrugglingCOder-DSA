package Tree;

// https://leetcode.com/problems/binary-tree-maximum-path-sum/solutions/5132823/binary-tree-maximum-path-sum-java-approach-recursive-explanation/

// Medium/ Hard (Implementation)
// Trees, Recursion
// Global maxSum, localPathSum
// T:O(N), S:O(N)
// Max(maxVal, localSum) -> ans; node return -> val + Max(left, right)

class BinaryTreeMaximumPathSum {    

    public int maxVal = Integer.MIN_VALUE;
    public int binaryTreeMaximumPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return maxVal;
    }

    public int maxPathSumHelper(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = Math.max(maxPathSumHelper(root.left), 0);
        int right = Math.max(maxPathSumHelper(root.right), 0);
        
        int currSum = left + right + root.val;
        maxVal = Math.max(maxVal, currSum);
        return root.val + Math.max(left, right);
    }
}