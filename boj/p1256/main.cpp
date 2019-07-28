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

int dp[200 + 1][200 + 1]; // nCr
string solve(ll n, ll m, ll k) {
    //nCr = n-1Cr-1 + n-1Cr
    dp[0][0] = 1;
    for(int i = 1; i <= 200; ++i) {
        dp[i][0] = 1;
        dp[i][i] = 1;
        for (int j = 1; j < i; ++j) {
            dp[i][j] = min(dp[i - 1][j - 1] + dp[i - 1][j], (int)1e9);
        }
    }
    if (k > dp[n+m][m]) {
        return "-1";
    }

    /*
    0 0
    1 1 1
    2 1 2 1
    3 1 3 3 1
    4 1 4 6 4 1
    5 1 5 10 10 5 1
    6 1 6 15 20 15 6 1
    */
    string s;
    while(n != 0 || m != 0) {
        ll c = dp[n+m-1][m];
        if (k <= c) {
            s.append("a");
            n--;
        } else {
            s.append("z");
            m--;
            k -= c;
        }
    }
    return s; 
}

int main(void) {
    ios_base::sync_with_stdio(false);

    ll n, m,k;
    cin >> n >> m >> k;
    
    cout << solve(n, m , k) << endl;
    return 0;
}