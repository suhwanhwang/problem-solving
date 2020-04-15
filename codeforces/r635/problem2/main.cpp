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

string solve(int x, int n, int m) {
  string ans;
  int h = x;
  while (n > 0 || m > 0) {
    int absorption = h / 2 + 10;
    int strike = h - 10;
    if (n > 0 && absorption < h) {
      n--;
      h = absorption;
    } else if (m > 0) {
      m--;
      h = strike;
    } else {
      break;
    }
    if (h <= 0) {
      return "YES";
    }
  }
  return "NO";
}

int main(void) {
  ios_base::sync_with_stdio(false);

  int t;
  cin >> t;
  while (t-- > 0) {
    int x, n, m;
    cin >> x >> n >> m;
    cout << solve(x, n, m) << endl;
  }
  return 0;
}