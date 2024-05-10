// https://leetcode.com/problems/binary-tree-inorder-traversal/solutions/5110516/binary-tree-inorder-traversal-javascript-approach-recursiveiterative-explanation/

// Easy - 2 Approach
// Trees, Recursion, Iterative
// Maintain global traversal list
// T:O(N), S:O(N)
// Iterative: Replicate stack call in internal stack

var inorderTraversal = function(root) {
    // var resultRecursive = [];
    // inorderRecursiveHelper(root, resultRecursive);
    // return resultRecursive;

    var resultIterative = [];
    inorderIterativeHelper(root, resultIterative); 
    return resultIterative;
}

// Recursive Code
var inorderRecursiveHelper = function(root, result){
    if(!root){
        return;
    }
    
    inorderRecursiveHelper(root.left, result);
    result.push(root.val);
    inorderRecursiveHelper(root.right, result);
};

// Iterative Code
var inorderIterativeHelper = function(root, result){
    var stack = [];
    while(true){
        if(root){
            stack.push(root);
            root = root.left;
        }
        else{
            if(stack.length == 0){
                break;
            }
            root = stack.pop();
            result.push(root.val);
            root = root.right;
        }
    }
}