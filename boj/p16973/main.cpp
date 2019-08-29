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

const int MAX_N = 1000;
const pair<int,int> DIR[] = {{0,1}, {1,0}, {-1,0}, {0,-1}};

int N, M, H, W, Sr, Sc, Fr, Fc;
int B[MAX_N + 1][MAX_N +1];

bool isOk(int r, int c) {
    if (r < 0 || c < 0 || r + H > N || c + W > M) {
        return false;
    }

    for (int i = 0; i < H; ++i) {
        for (int j = 0; j < W; ++j) {
            if (B[r + i][c + j] == 1) {
                return false;
            } 
        }
    }
    return true;
}

// start 에서 시작해 그래프를 너비 우선 탐색하고 각 정점의 방문 순서를 반환한다.
int bfs() {
    // 각 정점의 방문 여부
    vector<vector<bool>> discovered(N, vector<bool>(M,false));
    // 방문할 정점 목록을 유지하는 
    queue<pair<int,int>> q; 
    // 정점의 방문 순서
    vector<pair<int,int>> order;
    discovered[Sr][Sc] = true;
    q.push({Sr,Sc});
    while(!q.empty()) {
        pair<int,int> here = q.front();
        q.pop();
        // here를 방문한다.
        order.push_back(here);
        //cout << here.first << "," << here.second << " ";
        // 모든 인접한 정점을 검사한다.
        for (int i = 0; i < 4; ++i) {
            int next_r = here.first + DIR[i].first;
            int next_c = here.second + DIR[i].second;
            if (next_r == Fr && next_c == Fc) {
                return order.size();
            }
            
            if (isOk(next_r, next_c) && !discovered[next_r][next_c]) {
                q.push({next_r, next_c});
                discovered[next_r][next_c] = true;
            }
        }
    }
    return -1;
}

int main(void) {
    ios_base::sync_with_stdio(false);

    cin >> N >> M;
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < M; ++j) {
            cin >> B[i][j];
        }
    }
    cin >> H >> W >> Sr >> Sc >> Fr >> Fc;
    Sr--;Sc--;Fr--;Fc--;
    cout << bfs() << endl;
    return 0;
}