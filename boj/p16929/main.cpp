// from bits/stdc++.h
// C
#include <climits>
#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <ctime>

// C++
#include <algorithm>
#include <bitset>
#include <complex>
#include <deque>
#include <fstream>
#include <functional>
#include <iostream>
#include <istream>
#include <iterator>
#include <limits>
#include <list>
#include <map>
#include <memory>
#include <numeric>
#include <ostream>
#include <queue>
#include <set>
#include <stack>
#include <string>
#include <utility>
#include <vector>
#include <regex>
#include <tuple>
#include <unordered_map>
#include <unordered_set>

using namespace std;

typedef long long ll;
typedef long double ld;
const int dir[][2] = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
vector<string> board;

bool solveSub(pair<int, int> s, pair<int, int> prev, pair<int, int> cur) {
    if (s == cur) {
        return true;
    }
    
    int r = cur.first;
    int c = cur.second;
    
    if (r < 0 || r >= board.size() ||
    c < 0 || c >= board[r].size()) {
        return false;
    }
    
    if (board[s.first][s.second] != board[r][c]) {
        return false;
    }
    
    for (int d = 0; d < 4; ++d) {
        int next_r = r+dir[d][0];
        int next_c = c+dir[d][1];
        if (prev.first == next_r && prev.second == next_c) {
            continue;
        }
        if (solveSub(s, {r, c}, {next_r, next_c})) {
            return true;
        }
    }
    return false;
}

bool solve() {
    for (int i = 0; i < (int)board.size(); ++i) {
        for (int j = 0; j < (int)board[i].size(); ++j) {
            for (int d = 0; d < 4; ++d) {
                //cout << i << j << d << endl;
                
                if (solveSub({i, j}, {i, j}, {i+dir[d][0], j+dir[d][1]})) {
                    return true;
                }
            }
        }
    }
    return false;
}

int main(void) {
    ios_base::sync_with_stdio(false);

    int n, m;
    cin >> n >> m;
    
    for (int i = 0; i < n; ++i) {
        string s;
        cin >> s;
        board.push_back(s);
    }
    /*
    for(string s : board) {
        cout << s << endl;
    }
    */
    cout << (solve() ? "Yes" : "No") << endl;
    return 0;
}