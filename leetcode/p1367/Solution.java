class Solution {
    private final Set<Integer> visited = new HashSet<>();
    
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        visited.clear();
        int[] parent = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
        for (int i = 0; i < n; ++i) {
            if (leftChild[i] != -1) {
                parent[leftChild[i]] = i;
            }
            
            if (rightChild[i] != -1) {
                parent[rightChild[i]] = i;
            }
        }
        
        int root = getRoot(parent);
        if (root == -1) {
            return false;
        }
        
        boolean result = isTree(n, root, leftChild, rightChild);
        // System.out.println(visited);
        return result && visited.size() == n;
    }
    
    private int getRoot(int[] parent) {
        int cur = 0;
        Set<Integer> prev = new HashSet<>();
        prev.add(cur);
        while (cur != parent[cur]) {
            cur = parent[cur];
            if (prev.contains(cur)) {
                return -1;
            }
            prev.add(cur);
        }
        return cur;
    }
    
    private boolean isTree(int n, int index, int[] leftChild, int[] rightChild) {
        if (index == -1) {
            return true;
        }
        if (visited.contains(index)) {
            return false;
        }
        
        visited.add(index);
        
        return isTree(n, leftChild[index], leftChild, rightChild) && isTree(n, rightChild[index], leftChild, rightChild);
    }
}
