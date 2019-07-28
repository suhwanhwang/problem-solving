#include <iostream>
#include <algorithm>
#include <vector>
#include <map>
#include <cstdlib>
#include <ctime>

using namespace std;

/*
3 4
1 -3
3 0 6
-2 5 4 2

0 3 6
-2 2 4 5
*/
void solve(int c1, int c2, vector<int> p, vector<int> q) {
    sort(p.begin(), p.end());
    sort(q.begin(), q.end());
    
    int de = abs(c1 - c2);
    map<int, int> dist_map;
    
    for (int x1 : p) {
        auto it = lower_bound(q.begin(), q.end(), x1);
        if (it != q.end()) {
            int d = abs(x1 - *it);
            dist_map[d]++;
        }
        
        if (it != q.begin()) {
            int d = abs(x1 - *(it - 1));
            dist_map[d]++;
        }
    }
    
    cout << (de + dist_map.begin()->first) << " " << (dist_map.begin()->second) <<endl;
}

int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int n, m;
    cin >> n >> m;

    int c1, c2;
    cin >> c1 >> c2;
    
    vector<int> p(n), q(m);
    for (int i = 0; i < n; ++i) {
        cin >> p[i];
    }

    for (int i = 0; i < m; ++i) {
        cin >> q[i];
    }
    
    solve(c1, c2, p, q);
    
    return 0;
}
