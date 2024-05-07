# https://leetcode.com/problems/subtree-of-another-tree/solutions/5079564/subtree-of-another-tree-python-approach-onm-time-onm-space-explanation/

# Easy/Medium - GREAT QUESTION
# Trees, Recursion
# Use SameTree approach recursively OR Merkle Hashing
# T:O(N+M), S:O(N+M)
# Return 0 at leaf nodes, -1 at unbalanced node, height at non leaf balanced nodes

class IsSubTree(object):
    def isSubtree(self, root, subRoot):
        # Get hashes of nodes for both trees
        self.calculateHash(root)
        self.calculateHash(subRoot)

        # Compare the hashes for nodes
        return self.matchingHash(root, subRoot)

    # Function to calculate Hash
    def calculateHash(self, root):
        if not root:
            return '#'

        root.hashVal = self.calculateHash(root.left) + str(root.val) + self.calculateHash(root.right)
        return root.hashVal

    # Function to compare hashes
    def matchingHash(self, root, subroot):
        if not root:
            return False

        if root.hashVal == subroot.hashVal and root.val == subroot.val:
            return True

        return self.matchingHash(root.left, subroot) or self.matchingHash(root.right, subroot)