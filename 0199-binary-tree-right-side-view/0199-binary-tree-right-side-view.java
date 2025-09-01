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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans; // ✅ guard clause

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            int val = 0;
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                // node cannot be null here because we only enqueue non-nulls
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
                val = node.val; // last node in this level
            }
            ans.add(val);
        }
        return ans;
    }
}
