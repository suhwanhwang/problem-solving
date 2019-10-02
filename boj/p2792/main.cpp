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

bool isOk(int n, vector<int> &gem, int num) {
    int remain = n;
    
    for(int i = 0; i < (int)gem.size(); ++i) {
        int q = ceil((double)gem[i] / num);
        remain -= q;
        if (remain < 0) {
            return false;
        }
    }
    return true;
}

int solve(int n, vector<int> &gem) {
    sort(gem.begin(), gem.end(), greater<int>());
    
    int s = 1;
    int e = gem[0];
    
    while (s < e) {
        int mid = s + (e-s)/2;
        //cout << s << " " << mid << " " << e << endl;
        
        if (isOk(n, gem, mid)) {
            e = mid;
        } else {
            s = mid + 1;
        }
    }
    return e;
}

int main(void) {
    ios_base::sync_with_stdio(false);

    int n, m;
    cin >> n >> m;
    
    vector<int> gem(m, 0);
    
    for (int i = 0; i < m; ++i) {
        cin >> gem[i];
    }
    
    cout << solve(n, gem) << endl;
    return 0;
}