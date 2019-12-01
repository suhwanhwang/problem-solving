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

const int kMAX = 16;
int n;
int house[kMAX +1][kMAX + 1];
int total;

int solveSub(int x1, int y1, int x2, int y2) {
    if (x2 == n - 1 && y2 == n - 1) {
        return 1;
    }
    
    int ans = 0;
    
    if (x1 + 1 == x2) {
        if (x2 + 1 < n && house[y2][x2+1] == 0) {
            ans += solveSub(x2, y2, x2+1, y2);
        }
    }
    
    if (y1 + 1 == y2) {
        if (y2 + 1 < n && house[y2+1][x2] == 0) {
            ans += solveSub(x2, y2, x2, y2+1);
        }
    }
    
    if (x2 + 1 < n && y2 + 1 < n && house[y2][x2+1] == 0 && house[y2+1][x2+1] == 0 && house[y2+1][x2] == 0) {
        ans += solveSub(x2, y2, x2+1, y2+1);
    }
    
    return ans;
}

int solve() {   
    return solveSub(0,0,1,0);
}

int main(void) {
    ios_base::sync_with_stdio(false);

    cin >> n;
    
    for (int i = 0; i < n; ++i) {
        for(int j = 0; j < n; ++j) {
            cin >> house[i][j];
        }
    }
    
    cout << solve() << endl;
    return 0;
}