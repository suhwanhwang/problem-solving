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

const int kMAX = 20;
int edge[(1<<(kMAX + 1)) + 1];


ll dfs(int node, int n) {  
    int left = node * 2;
    int right = node * 2 + 1;
    
    if (left >= n) return 0;
    
    ll leftSum = edge[left] + dfs(left, n);   
    ll rightSum = edge[right] + dfs(right, n);
    
    ll diff = leftSum - rightSum;
    if (diff < 0) {
        edge[left] += -diff;
    } else {
        edge[right] += diff;
    }
    return max(leftSum, rightSum);
}

ll solve(int n) {
    dfs(1, n);
    
    return accumulate(edge + 1, edge + n, 0);
}

int main(void) {
    ios_base::sync_with_stdio(false);

    int k;
    cin >> k;
    
    int n = (1<<(k+1));
    for (int i = 2; i < n; ++i) {
        cin >> edge[i];
    }
    
    cout << solve(n) << endl;
    return 0;
}