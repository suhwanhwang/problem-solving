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
vector<int> a;
vector<int> op_cnt(4); // pl, min, mul, div
int min_val;
int max_val;

int calc(const vector<int> &num, const vector<int> &op) {
    int num_index = 0;
    int ans = num[num_index++];
        
    for (int o : op) {
        switch(o) {
        case 0:
            ans += num[num_index++];
            break;
        case 1:
            ans -= num[num_index++];
            break;
        case 2:
            ans *= num[num_index++];
            break;
        case 3:
            ans /= num[num_index++];
            break;
        }
    }
    return ans;
}
void solveSub(int index, vector<int>&cnt, vector<int>&op) {
    if (index == a.size() - 1) {
        int ans = calc(a, op);
        min_val = min(min_val, ans);
        max_val = max(max_val, ans);
        return;
    }

    for (int i = 0; i < 4; ++i) {
        if (cnt[i] == 0) continue;

        cnt[i]--;
        op.push_back(i);
        solveSub(index+1, cnt, op);
        op.pop_back();
        cnt[i]++;
    }
}

void solve() {
    min_val = INT_MAX;
    max_val = INT_MIN;

    vector<int> cnt(op_cnt);
    vector<int> op;
    solveSub(0, cnt, op);

    cout << max_val << endl;
    cout << min_val << endl;
}

int main(void) {
    ios_base::sync_with_stdio(false);

    int n;
    cin >> n;
    
    a.resize(n);
    for (int i = 0; i < n ; ++i) {
        cin >> a[i];
    }
    for (int i = 0; i < 4; ++i) {
        cin >> op_cnt[i];
    }
    
    solve();
    return 0;
}