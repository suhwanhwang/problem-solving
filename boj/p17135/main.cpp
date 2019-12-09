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

constexpr int kinf = 987654321;

int n, m, d;
set<pair<int, int>> enemy;

int getDist(const pair<int,int>&a, const pair<int,int>&b) {
    return abs(a.first-b.first)+abs(a.second-b.second);
}

pair<int, int> findVictim(int turn, int archer) {
    pair<int,int> a{n - turn, archer};
    int min_dist = kinf;
    pair<int,int> min_enemy;
    
    for(auto e : enemy) {
        if (e.first >= a.first) {
            continue;
        }
        
        int tmp = getDist(e, a);
        if (min_dist > tmp 
	    || (min_dist == tmp && min_enemy.second > e.second)) {
            min_dist = tmp;
            min_enemy = e;
        } 
    }
    return (min_dist <= d) ? min_enemy : make_pair(-1,-1);
}

int calc(vector<int>& archer) {
    auto remain(enemy);
    
    for (int i = 0; i < n; ++i) {
    	set<pair<int,int>> victim;

        for (int a : archer) {
            auto v = findVictim(i, a);
            if (v.first != -1) {
                victim.insert(v);
            }
        }

	// erase enemy
	for (auto v : victim) {
	    remain.erase(v);
	}
    }
    return enemy.size() - remain.size();
}

int pick(int num, vector<int>&picked, int toPick) {
    if (toPick == 0) {
        return calc(picked);
    }
    
    int ans = 0;
    int last = picked.empty() ? -1 : picked.back();
    for (int i = last + 1; i < num; ++i) {
        picked.push_back(i);
        ans = max(ans , pick(num, picked, toPick - 1));
        picked.pop_back();
    }
    return ans;
}

int solve() {
    vector<int> archer;
    int ans = pick(m, archer, 3);
    return ans;
}

int main(void) {
    ios_base::sync_with_stdio(false);

    cin >> n >> m >> d;
    for(int i = 0; i < n; ++i) {
        for(int j = 0; j < m; ++j) {
            int tmp;
            cin >> tmp;
            if (tmp == 1) {
                enemy.insert({i,j});
            }
        }
    }

    cout << solve() << endl;
    return 0;
}
