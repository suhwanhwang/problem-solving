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
int parent[kMAX + 1];
vector<pair<int, int>> depth;  // depth, node

void dfs(int node, int d) {
  visited[node] = true;
  depth.push_back({d, node});

  for (auto next : adj[node]) {
    if (!visited[next]) {
      parent[next] = node;
      dfs(next, d + 1);
    }
  }
}

int solve(int k) {
  dfs(1, 0);
  sort(depth.begin(), depth.end(), greater<pair<int, int>>());
  map<int, int> m;

  for (int i = 0; i < k; ++i) {
    int node = depth[i].second;
    if (m[node] == 0) {
      int cur = parent[node];
      while(cur > 0) {
        m[cur]++;
        cur = parent[cur];
      }
    } else {
      m[node] = 0;

    }
  }
  int sum = 0;
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