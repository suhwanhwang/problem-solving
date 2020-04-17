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

const int kMAX = 200000 + 1;
vector<int> adj[kMAX + 1];
int N;
bool visited[kMAX + 1];
int sz[kMAX + 1];
int det[kMAX + 1];

int dfs(int node, int d) {
  visited[node] = true;
  sz[node] = 1;

  for (auto next : adj[node]) {
    if (!visited[next]) {
      sz[node] += dfs(next, d + 1);
    }
  }
  det[node] = sz[node] - d;
  return sz[node];
}

ll solve(int k) {
  dfs(1, 1);
  sort(det + 1, det + N + 1, greater<int>());
  ll sum = 0;
  for (int i = 1; i <= N - k; ++i) {
    sum += det[i];
  }
  return sum;
}

int main(void) {
  ios_base::sync_with_stdio(false);

  int k;
  cin >> N >> k;
  for (int i = 0; i < N - 1; ++i) {
    int u, v;
    cin >> u >> v;
    adj[u].push_back(v);
    adj[v].push_back(u);
  }
  cout << solve(k) << endl;
  return 0;
}