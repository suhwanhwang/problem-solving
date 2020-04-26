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

ll solve(ll x, ll y, ll a, ll b) {
  ll diff = x - y;
  if (2 * a <= b) {
    return (abs(x) + abs(y)) * a;
  } else {
    if (x * y >= 0) {
      return abs(min(x, y)) * b + abs(diff) * a;
    } else {
      return (abs(x) + abs(y)) * a;
    }
  }
}

int main(void) {
  ios_base::sync_with_stdio(false);

  int t;
  cin >> t;
  while (t-- > 0) {
    ll x, y, a, b;
    cin >> x >> y >> a >> b;
    cout << solve(x, y, a, b) << endl;
  }
  return 0;
}