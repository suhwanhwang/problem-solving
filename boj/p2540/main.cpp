
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

constexpr int kN = 9;
constexpr int kSum = 45;
int board[kN+1][kN+1];

pair<int,int> findZero(int r, int c) {
  for(int i = r; i < kN; ++i) {
    for (int j = (i == r ? c : 0); j < kN; ++j) {
      if (board[i][j] == 0) {
        return {i, j};
      }
    }
  }
  return {-1, -1};
}

bool solveSub(int r, int c) {
  // find 0
  auto zeroPos = findZero(r, c);
  if (zeroPos.first == -1 && zeroPos.second == -1) {
    return true;
  }

  r = zeroPos.first;
  c = zeroPos.second;

/*
  unordered_set<int> s;
  for(int i = 0; i < kN; ++i) {
    s.insert(board[i][c]); // vertical
    s.insert(board[r][i]); // horizontal
  }
  int r0 = (r/3) * 3;
  int c0 = (c/3) * 3;
  for (int i = r0; i < r0+3; ++i) {
    for (int j = c0; j < c0+3; ++j) {
      s.insert(board[i][j]); // 3x3 rect
    }
  }
*/
  vector<bool> s(10);
  for(int i = 0; i < kN; ++i) {
    s[board[i][c]] = true; // vertical
    s[board[r][i]] = true; // horizontal
  }
  int r0 = (r/3) * 3;
  int c0 = (c/3) * 3;
  for (int i = r0; i < r0+3; ++i) {
    for (int j = c0; j < c0+3; ++j) {
      s[board[i][j]] = true; // 3x3 rect
    }
  }

  for (int i = 1; i <= 9; ++i) {
    if (s[i] == false) {
      board[r][c] = i;
      if (solveSub(r, c + 1)) {
        return true;
      }
    }
  }
  board[r][c] = 0;
  return false;
}
void solve() {
  solveSub(0, 0);
}

int main(void) {
  ios_base::sync_with_stdio(false);

  for (int i = 0; i < kN; ++i) {
    for (int j = 0; j < kN; ++j) {
      cin >> board[i][j];
    }
  }

  solve();

  for (int i = 0; i < kN; ++i) {
    for (int j = 0; j < kN; ++j) {
      cout << board[i][j] << " ";
    }
    cout << endl;
  }
  return 0;
}
