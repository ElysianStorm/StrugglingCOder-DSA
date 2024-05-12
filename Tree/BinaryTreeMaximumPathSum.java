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