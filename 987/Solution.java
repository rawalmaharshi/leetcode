/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer, List<Pair>> map = new HashMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //edge case
        if (root == null) {
            return new ArrayList<>();
        }
        
        makeMap(root, 0, 0);
        
        //Sort map Keys, also sort values (list)
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        
        List<List<Integer>> answer = new ArrayList<>();
        for (int key : keys) {
            List<Pair> values = map.get(key);
            Collections.sort(values, new Comparator<Pair>() {
                @Override
                public int compare(Pair a, Pair b) {
                    if (a.level < b.level) {
                        return -1;
                    }
                    
                    if (a.level == b.level) {
                        if (a.value < b.value) {
                            return -1;
                        } else {
                            return 1;
                        }
                    }
                    
                    return 1;
                }
            });
            List<Integer> vals = new ArrayList<>();
            for (Pair p : values) {
                vals.add(p.value);
            }
            answer.add(vals);
        }
        
        return answer;
    }
    
    private void makeMap(TreeNode root, int level, int colIndex) {
        //base case
        if (root == null) {
            return ;
        }
        
        if (!map.containsKey(colIndex)) {
            map.put(colIndex, new ArrayList<>());
        }
        
        Pair pairToAdd = new Pair(level, root.val);
        map.get(colIndex).add(pairToAdd);
        
        //Call left and right subtrees
        makeMap(root.left, level + 1, colIndex - 1);
        makeMap(root.right, level + 1, colIndex + 1);
        
        return ;
    }
}

class Pair {
    int level;
    int value;
    
    Pair(int level, int value) {
        this.level = level;
        this.value = value;
    }
}