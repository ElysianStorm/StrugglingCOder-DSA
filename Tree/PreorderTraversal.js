// https://leetcode.com/problems/binary-tree-preorder-traversal/solutions/5110891/binary-tree-preorder-traversal-javascript-approach-recursiveiterative-explanation/

// Easy - 2 Approach
// Trees, Recursion, Iterative
// Maintain global traversal list
// T:O(N), S:O(N)
// Iterative: Replicate stack call in internal stack

var preorderTraversal = function(root) {
    // var resultRecursive = [];
    // preorderRecursiveHelper(root, resultRecursive);
    // return resultRecursive;

    var resultIterative = [];
    preorderIterativeHelper(root, resultIterative);
    return resultIterative;
};

var preorderRecursiveHelper = function(root, result) {
    if(!root){
        return;
    }

    result.push(root.val);
    preorderRecursiveHelper(root.left, result);
    preorderRecursiveHelper(root.right, result);
};

var preorderIterativeHelper = function(root, result) {
    if(!root){
        return [];
    }
    
    var stack = [];
    stack.push(root);
    while(stack.length != 0){
        root = stack.pop();
        result.push(root.val);
        if(root.right){
            stack.push(root.right);
        }
        if(root.left){
            stack.push(root.left)
        }
    }
};