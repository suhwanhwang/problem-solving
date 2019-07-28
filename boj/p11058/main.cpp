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

ll solve(int n) {
    if (n <= 3) {
        return n;
    }
    vector<ll> dp(n + 1);
    
    // f(i) = max(f(i - 1) + 1
    //      , f(i - 3) * 2
    //      , f(i - 4) * 3
    //      ...
    //      , f(i - (3+j)) * (2+j))
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 3;
    for (int i = 4; i <= n; ++i) {
        dp[i] = dp[i-1] + 1;
        for(int j = 0; j < i-3; ++j) {
            dp[i] = max(dp[i], dp[i-(3+j)] * (2+j));
        }
    }
    return dp[n];
}

int main(void) {
    ios_base::sync_with_stdio(false);

    int n;
    cin >> n;
    
    cout << solve(n) << endl;
    return 0;
}