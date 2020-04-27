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

ll gcd(ll a, ll b) { return b ? gcd(b, a % b) : a; }

bool isOk(ll x, ll a, ll b) { return (x % a % b) != (x % b % a); }

void solve(ll a, ll b, ll q) {
  ll lcm = a * b / gcd(a, b);
  vector<int> map(lcm);
  int count = 0;
  for (int i = 0; i < lcm; ++i) {
    if (isOk(i, a, b)) {
      count++;
      map[i] = count;
    }
  }

  for (int i = 0; i < q; ++i) {
    ll l, r;
    cin >> l >> r;

    ll countBeforeL = ((l - 1) / lcm) * count + map[(l - 1) % lcm];
    ll countToR = (r / lcm) * count + map[r % lcm];
    cout << (countToR - countBeforeL) << " ";
  }
  cout << "\n";
}

int main(void) {
  ios_base::sync_with_stdio(false);

  int t;
  cin >> t;
  while (t-- > 0) {
    ll a, b, q;
    cin >> a >> b >> q;
    solve(a, b, q);
  }
  return 0;
}