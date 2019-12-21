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
/*
4 7
6 13
4 8
3 6
5 12
f(w, next) = max({value[i] + f(w-weight[i], items), ...)});
*/
vector<pair<int,int>> item; // weight value
int dp[100000+1][100+1]; // w, n

int knapsack(int w, int next) {
  if (w <=0 || next >= item.size()) return 0;
    
  int &ans = dp[w][next];
  if(ans != -1) {
    return ans;
  }
  
  int max_v = 0;

  for(int i = next; i < item.size(); ++i) {
    max_v = max(max_v, knapsack(w, i+1));
    
    if (w-item[i].first < 0) continue;
    max_v = max(max_v, item[i].second + knapsack(w - item[i].first, i+1));
  }
  ans = max_v;
  return ans;
}

int main(void) {
  ios_base::sync_with_stdio(false);

  int n, k;
  cin >> n >> k;
  for(int i = 0; i < n; ++i) {
    int w,v;
    cin >> w >> v;
    item.push_back({w,v});
  }
  
  memset(dp,-1,sizeof(dp));
  cout << knapsack(k, 0) << endl;
  return 0;
}