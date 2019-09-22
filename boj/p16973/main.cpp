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
int RS[MAX_N + 1][MAX_N +1];

bool isOk(int r, int c) {
    for (int i = 0; i < H; ++i) {
        if (RS[r + i][c + W - 1] - (c == 0 ? 0 : RS[r + i][c - 1]) > 0) {
            return false;
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
    queue<int> depth;
    discovered[Sr][Sc] = true;
    q.push({Sr,Sc});
    depth.push(0);
    while(!q.empty()) {
        pair<int,int> here = q.front();
        q.pop();
        int d = depth.front(); 
        depth.pop();
        // here를 방문한다.
        order.push_back(here);
        //cout << here.first << "," << here.second << " ";
        // 모든 인접한 정점을 검사한다.
        for (int i = 0; i < 4; ++i) {
            int r = here.first + DIR[i].first;
            int c = here.second + DIR[i].second;
            if (r == Fr && c == Fc) {
                return d+1;
            }
            if (r < 0 || c < 0 || r + H > N || c + W > M) {
                continue;
            }
            
            if (!discovered[r][c] && isOk(r, c)) {
                q.push({r, c});
                depth.push(d+1);
                discovered[r][c] = true;
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
    
    //memset(OK, -1, sizeof(OK));
    for (int i = 0; i < N; ++i) {
        int sum = 0;
        for (int j = 0; j < M; ++j) {
            sum += B[i][j];
            RS[i][j] = sum;
        }
    }
    
    cout << bfs() << endl;
    return 0;
}