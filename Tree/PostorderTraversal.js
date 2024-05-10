// https://leetcode.com/problems/binary-tree-postorder-traversal/solutions/5111335/binarytree-postorder-traversal-javascript-approach-recursiveiterative-explanation/

// Easy/Medium (Iterative) - 2 Approach
// Trees, Recursion, Iterative
// Maintain global traversal list
// T:O(N), S:O(N)
// Iterative: Replicate stack call in internal stack in reverse order

var postorderTraversal = function(root) {
    // var resultRecursive = [];
    // postorderRecursiveHelper(root, resultRecursive);
    // return resultRecursive;

    var resultIterative = [];
    postorderIterativeHelper(root, resultIterative);
    return resultIterative;
};

var postorderRecursiveHelper = function(root, result) {
    if(!root){
        return;
    }

    postorderRecursiveHelper(root.left, result);
    postorderRecursiveHelper(root.right, result);
    result.push(root.val);
};

var postorderIterativeHelper = function(root, result) {
    var stack = [];
    while(root || stack.length!=0){
        if(root){
            result.push(root.val);
            stack.push(root);
            root = root.right;
        }
        else{
            root = stack.pop();
            root = root.left;
        }
    }
    //Reverse result
    result.reverse();
}