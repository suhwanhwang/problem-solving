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

bool isPalindrome(const vector<int>& a) {
  set<int> numSet;
  for (int i = 0; i < a.size() / 2; ++i) {
    if (a[i] != a[a.size() - 1 - i]) {
      return false;
    }
    numSet.insert(a[i]);
    numSet.insert(a[a.size() - 1 - i]);
    if (numSet.size() > 2) {
      return false;
    }
  }
  if (a.size() % 2 == 1) {
    numSet.insert(a[a.size() / 2]);
    if (numSet.size() > 2) {
      return false;
    }
  }
  return true;
}

int maxLength;
void solveSub(vector<int> &a, int index, vector<int>& p) {
  if (index == a.size()) {
    if (isPalindrome(p)) {
      maxLength = max(maxLength, (int)p.size());
    }
    return;
  }
  p.push_back(a[index]);
  solveSub(a, index + 1, p);
  p.pop_back();
  solveSub(a, index + 1, p);
}

int solve(vector<int> &a) {
  maxLength = 0;
  vector<int> p;
  solveSub(a, 0, p);
  return maxLength;
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
    cout << solve(a) << endl;
  }
  return 0;
}