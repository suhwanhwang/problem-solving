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

bool isAllSame(string t) {
  if (t.size() <= 1) return true;

  for (int i = 1; i < t.size(); ++i) {
    if (t[0] != t[i]) {
      return false;
    }
  }

  return true;
}
string solve(string t) {
  string ans;
  if (isAllSame(t)) {
    return t;
  }

  char prev;
  for (int i = 0; i < t.size(); ++i) {
    if (i == 0) {
      ans += t[i];
      prev = t[i];
    } else {
      if (t[i] == prev) {
        ans += prev == '0' ? '1' : '0';
      }
      ans += t[i];
      prev = t[i];
    }
  }
  return ans;
}

int main(void) {
  ios_base::sync_with_stdio(false);

  int T;
  cin >> T;
  while (T-- > 0) {
    string t;
    cin >> t;
    cout << solve(t) << endl;
  }
  return 0;
}