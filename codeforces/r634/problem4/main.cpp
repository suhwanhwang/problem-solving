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
/*
154 873 296
386 592 714
729 641 835

863 725 149
975 314 628
412 968 357

631 457 982
598 236 471
247 189 563


*54 873 296
386 *92 714
729 641 *35

8*3 725 149
975 3*4 628
412 968 3*7

63* 457 982
598 23* 471
247 189 56*
*/
void solve(vector<string> &sudoku) {
  for (int i = 0; i < sudoku.size(); ++i) {
    auto& s = sudoku[i];
    int index = (3 * (i - 3 * (i / 3))) + (i / 3);
    //cout << index << endl;
    s[index] = s[index] == '9' ? '1' : (s[index] + 1);
  }
}

int main(void) {
  ios_base::sync_with_stdio(false);

  int t;
  cin >> t;
  while (t-- > 0) {
    vector<string> sudoku(9);

    for (int i = 0; i < 9; ++i) {
      cin >> sudoku[i];
    }
    solve(sudoku);
    for (int i = 0; i < 9; ++i) {
      cout << sudoku[i] << "\n";
    }
  }
  return 0;
}