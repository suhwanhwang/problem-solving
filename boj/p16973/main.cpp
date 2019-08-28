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

const int MAX_N = 10;
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

int solveSub(int r, int c, int r0, int c0) {
    if (isOk(r, c) == false) {
        return -1;
    }

    if (r == Fr && c == Fc) {
        return 1;
    }

    int ans = INT_MAX;
    for (int i = 0; i < 4; ++i) {
        int next_r = r + DIR[i].first;
        int next_c = c + DIR[i].second;
        if (next_r == r0 && next_c == c0) {
            continue;
        }
        int tmp = solveSub(next_r, next_c, r, c);
        if (tmp < 0) {
            continue;
        }
        
        ans = min(ans, 1 + tmp);
    }
    return ans;
}
int solve() {
    int ans = INT_MAX;

    for (int i = 0; i < 4; ++i) {
        int tmp = solveSub(Sr + DIR[i].first, Sc + DIR[i].second, Sr, Sc);
        if (tmp < 0) {
            continue;
        }
        ans = min(ans, tmp);
    }
    return ans;
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
    cout << solve() << endl;
    return 0;
}