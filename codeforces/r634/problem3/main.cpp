// from bits/stdc++.h
// C
#include <cassert>
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
#include <regex>
#include <set>
#include <stack>
#include <string>
#include <tuple>
#include <unordered_map>
#include <unordered_set>
#include <utility>
#include <vector>

using namespace std;

typedef long long ll;
typedef long double ld;

int solve(int n, const vector<int> &a) {
  map<int, int> m;
  int maxSame = 0;
  int maxDistinct = 0;
  for (auto num : a) {
    m[num]++;
  }
  maxDistinct = m.size();

  for (auto it = m.begin(); it != m.end(); ++it) {
    maxSame = max(maxSame, it->second);
  }
  
  if (maxSame <= maxDistinct) {
    maxDistinct--;
  }
  return min({n/2, maxSame, maxDistinct});
}

int main(void) {
  ios_base::sync_with_stdio(false);

  int t;
  cin >> t;
  while (t-- > 0) {
    int n;
    cin >> n;
    vector<int> a(n);
    for (int i = 0; i < n; ++i) {
      cin >> a[i];
    }
    cout << solve(n, a) << endl;
  }
  return 0;
}