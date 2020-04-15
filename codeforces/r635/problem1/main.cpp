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

void solve(int a, int b, int c, int d) {
  int y = c;
  int z = c;
  for (int x = a; x <= b; ++x) {
    if (x + y > z) {
      cout << x << " " << y << " " << z << "\n";
      return;
    }
  }
}

int main(void) {
  ios_base::sync_with_stdio(false);

  int t;
  cin >> t;
  while (t-- > 0) {
    int a, b, c, d;
    cin >> a >> b >> c >> d;
    solve(a, b, c, d);
  }
  return 0;
}