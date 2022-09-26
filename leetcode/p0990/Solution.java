class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        
        for(String equation : equations) {
            char[] e = equation.toCharArray();
            
            if (e[1] == '=' && e[2] == '=') {
                uf.union(e[0]-'a', e[3]-'a');
            }
        }
        for(String equation : equations) {
            char[] e = equation.toCharArray();
            
            if (e[1] == '!' && e[2] == '=') {
                if (uf.connected(e[0]-'a', e[3]-'a')) return false;
            }
        }
        return true;
    }
    
    static class UnionFind {
        private int[] id;
        private int[] size;
        
        public UnionFind(int n) {
            id = new int[n];
            size = new int[n];
            for (int i = 0; i < n; ++i) {
                id[i] = i;
                size[i] = 1;
            }
        }
        
        public void union(int a, int b) {
            int aRoot = find(a);
            int bRoot = find(b);
            if (aRoot == bRoot) return;
            
            if (size[aRoot] > size[bRoot]) {
                id[bRoot] = aRoot;
                size[bRoot] += size[aRoot];
            } else {
                id[aRoot] = bRoot;
                size[aRoot] += size[bRoot];
            }
        }
        
        public boolean connected(int a, int b) {
            return find(a) == find(b);
        }
        
        public int find(int a) {
            int index = a;
            
            while(id[index] != index) {
                index = id[index];
            }
            return index;
        }
    }
}
