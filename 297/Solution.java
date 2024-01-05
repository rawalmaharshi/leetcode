/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializeHelper(root, new StringBuilder(""));
    }

    private String serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return sb.toString();
        } 

        sb.append(String.valueOf(root.val) + ",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> dataList = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(dataList);
    }

    private TreeNode deserializeHelper(List<String> list) {
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = deserializeHelper(list);
        root.right = deserializeHelper(list);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));