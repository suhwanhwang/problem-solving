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

const int kMAX_K = 100;
const int kMAX_T = 10000;

vector<pair<int, int>> coin;
int dp[kMAX_T+1][kMAX_K+1];

int solve(int remain, int cur) {
    if (remain < 0) {
        return 0;
    }
    if (remain == 0) {
        return 1;
    }
    if (cur >= coin.size()) {
        return 0;
    }
    
    int &ans = dp[remain][cur];
    if (ans != -1) return ans;
    
    for(int i = 0; i <= coin[cur].second; ++i) {
        ans += solve(remain - coin[cur].first*i, cur + 1);
    }
    return ans;
}

int main(void) {
    ios_base::sync_with_stdio(false);

    int t,k;
    cin >> t;
    cin >> k;
    for(int i = 0; i < k; ++i) {
        int p, n;
        cin >> p >> n;
        coin.push_back({p,n});
    }
    sort(coin.begin(), coin.end());
    memset(dp, -1, sizeof(dp));
    cout << solve(t, 0) << endl;
    return 0;
}