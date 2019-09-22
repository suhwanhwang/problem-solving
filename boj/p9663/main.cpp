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

bool isOk(int index, int n, int cur, vector<int> &row, vector<int> &col) {
    if (col[index] > 0) return false;

    for (int j = 0; j < cur; ++j) {
        int d1 = index - cur + j;
        int d2 = index + cur - j;
        if (d1 >= 0 && ((row[j] & (1<<d1)) != 0)) return false;
        if (d2 < n && ((row[j] & (1<<d2)) != 0)) return false;
    }
    return true;
}

ll solveSub(int n, int cur, vector<int> &row, vector<int> &col) {
    if (cur == n) {
        return 1;
    }

    ll count = 0;
    for (int i = 0; i < n; ++i) {
        if (!isOk(i, n, cur, row, col)) continue;

        row[cur] |= (1<<i);
        col[i] |= (1<<cur);
        count += solveSub(n, cur + 1, row, col);
        row[cur] &= ~(1<<i);
        col[i] &= ~(1<<cur);
    }

    return count;
}

ll solve(int n) {
    vector<int> row(n, 0);
    vector<int> col(n, 0);
    
    return solveSub(n, 0, row, col);
}

int main(void) {
    ios_base::sync_with_stdio(false);

    int n;
    cin >> n;
    
    cout << solve(n) << endl;
    return 0;
}