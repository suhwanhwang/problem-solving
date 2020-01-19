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
 0666
 1666
 2666
 3666
 4666
 5666
 6660 ~ 6669
 7666
 8666
 9666  1 * 6 + pow(10, 1) + 3
10666 ~ 59666 19 * 5
60666 ~ 65666 66600 ~ 66699 67666 ~ 69666 19 + 100
70666 ~ 99666 19 * 3
100666

x * 9 + pow(10, y)
*/

bool is666(int num) {
  int count = 0;
  for (int i = num; i > 0; i /= 10) {
    if (i % 10 == 6) {
      count++;
      if (count == 3) {
        return true;
      }
    } else {
      count = 0;
    }
  }
  return false;
}

int solve(int n) {
  int count = 0;
  int num = 666;
  while (count < n) {
    if (is666(num)) {
      count++;
    }
    num++;
  }
  return num - 1;
}

int main(void) {
  ios_base::sync_with_stdio(false);

  int n;
  cin >> n;

  cout << solve(n) << endl;
  return 0;
}