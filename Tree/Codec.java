package Tree;

// Medium/ Hard (Implementation) - GREAT QUESTION
// Trees, Recursion, Arrays, Strings
// Recurse and track nulls
// T:O(N), S:O(N)
// Traverse through while handling nulls accordingly

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        
        return sb.substring(0, sb.length());
    }
    
    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        
        sb.append(root.val);
        sb.append(',');
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        
        String[] splits = data.split(",");
        
        return deserializeHelper(splits, new int[1]);
        
    }
    
    private TreeNode deserializeHelper(String[] splits, int[] index) {
        if (splits[index[0]].equals("null")) {
            index[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(splits[index[0]]));
        index[0]++;
        root.left = deserializeHelper(splits, index);
        root.right = deserializeHelper(splits, index);
        
        return root;
        
    }
}
