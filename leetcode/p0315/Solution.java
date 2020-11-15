class Solution {
    static class TreeNode {
        int val;
        int count = 1;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    private int addNode(TreeNode root, int val) {
        TreeNode node = root;
        int smallCount = 0;
        while(node != null) {
            if (node.val < val) {
                smallCount += node.count;
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    break;
                } else {
                    node = node.right;
                }
            } else {
                node.count++;
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    break;
                } else {
                    node = node.left;
                }
            }
        }
        return smallCount;
    }
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }
        
        TreeNode root = new TreeNode(nums[nums.length-1]);
        ans.add(0);
        
        for (int i = nums.length - 2; i >= 0; --i) {
            int smallCount = addNode(root, nums[i]);
            ans.add(smallCount);
        }
        Collections.reverse(ans);
        return ans;
    }
}
