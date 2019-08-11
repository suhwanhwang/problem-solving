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

int dp[10+1][1<<11];
vector<string> seat;

bool isValid(int prev, int cur) {
    return true;
}
int solve(int n, int m) {
    memset(dp, 0, sizeof(dp));
    
    for (int i = 0; i < n; ++i) {
        int max_j = (1 << (m+1));
        for (int j = 0; j < max_j; ++j) {
        
        }
    }
    return 0;
}

int main(void) {
    ios_base::sync_with_stdio(false);

    int c;
    cin >> c;
    
    while(c-- > 0) {
        int m, n;
        cin >> n >> m;
        seat.resize(n);
        for(int i = 0; i < n; ++i) {
            cin >> seat[i];
        }
        cout << solve(n, m , seat) << endl;
    }
    return 0;
}