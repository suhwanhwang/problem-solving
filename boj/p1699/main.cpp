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

int solve(int n) { 
    vector<int> dp(n+1); 
  
    dp[0] = 0; 
    dp[1] = 1; 
  
    for (int i = 2; i <= n; ++i) { 
        dp[i] = i; // init max
  
        // find min
        for (int j = 1; j <= i; ++j) { 
            int tmp = j * j; 
            if (tmp > i) {
                break; 
            } else {
                dp[i] = min(dp[i], 1+dp[i - tmp]); 
            }
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