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

string solve(int n, int a, int b) {
  string ans;
  
  for (int i = 0; i < n; ++i) {
    ans += ('a' + min(i % a, b - 1));
  }
  return ans;
}

int main(void) {
  ios_base::sync_with_stdio(false);

  int t;
  cin >> t;
  while (t-- > 0) {
    int n, a, b;
    cin >> n >> a >> b;
    cout << solve(n, a, b) << endl;
  }
  return 0;
}