class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            LinkedList<Integer> current = new LinkedList<>();
            int level = q.size();

            for (int i = 0; i < level; i++) {
                TreeNode curr = q.poll();

                if (leftToRight)
                    current.addLast(curr.val);
                else
                    current.addFirst(curr.val);

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }

            res.add(current);
            leftToRight = !leftToRight;
        }

        return res;
    }
}