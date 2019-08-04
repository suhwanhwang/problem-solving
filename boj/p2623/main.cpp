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

// 그래프의 인접 리스트 표현
vector<vector<int> > adj;
// 각 정점을 방문했는지 여부를 나타낸다
vector<bool> visited;

vector<bool> tmp_visited;
bool is_cycle;

stack<int> st;

// 깊이 우선 탐색을 구현한다
void dfs(int here) {
	if (visited[here]) {
        return;
    }

    if (tmp_visited[here]) {
        is_cycle = true;
        return;
    }

    tmp_visited[here] = true;
	for(int i = 0; i < adj[here].size(); ++i) {
		int there = adj[here][i];
		dfs(there);
	}
    tmp_visited[here] = false;

    visited[here] = true;
    st.push(here + 1);
}

// 모든 정점을 방문한다
void dfsAll() {
	// visited 를 모두 false 로 초기화한다
	visited = vector<bool>(adj.size(), false);
    tmp_visited = vector<bool>(adj.size(), false);

	// 모든 정점을 순회하면서, 아직 방문한 적 없으면
	// 방문한다
	for(int i = 0; i < adj.size(); ++i)
		dfs(i);
}

int solve() {
    dfsAll();
    if (is_cycle) {
        cout << "0" << endl;
    } else {
        while (!st.empty()) {
            int singer = st.top();
            st.pop();
            cout << singer << endl;
        }
    }
}

int main(void) {
    ios_base::sync_with_stdio(false);

    int n, m;
    cin >> n >> m;

    adj.clear();
    adj.resize(n);

    for (int i = 0; i < m; ++i) {
        int c;
        int prev = -1;
        cin >> c;
        for (int j = 0; j < c; ++j) {
            int tmp;
            cin >> tmp; tmp--;
            if (prev != -1) {
                adj[prev].push_back(tmp);
            }
            prev = tmp;
        }
    }    

    solve();
    return 0;
}