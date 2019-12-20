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
constexpr int kmax=10000;
ll dp[kmax+1];
ll solve(int n) {
	if (n<2) return n;
	
	ll &ans = dp[n];
	if (ans != -1) {
		return ans;
	}
	
	ans = solve(n-1) + solve(n-2);
	return ans;
}

int main(void) {
    ios_base::sync_with_stdio(false);

    int n;
    cin >> n;
    
	memset(dp, -1, sizeof(dp));
    cout << solve(n) << endl;
    return 0;
}