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

int solve(vector<int>& a) {
  int n = a.size();
  sort(a.begin(), a.end());
  int cur = n / 2;
  for (int i = 0; i < n; ++i) {
    if (i % 2 != 0) {
      cur -= i;
    } else {
      cur += i;
    }
    cout << a[cur] << " ";
  }
  cout << "\n";
  return 0;
}

int main(void) {
  ios_base::sync_with_stdio(false);

  int t;
  cin >> t;
  while (t-- > 0) {
    int n;
    cin >> n;
    vector<int> a(n);
    for (int i = 0; i < a.size(); ++i) {
      cin >> a[i];
    }
    solve(a);
  }
  return 0;
}