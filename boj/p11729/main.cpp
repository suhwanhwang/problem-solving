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
vector<pair<int,int>> output;

void hanoi(int n, int from, int to) {
    if (n == 0) {
         return;
    }
    
    int other = 6 - from - to;
    hanoi(n-1, from, other);
    output.push_back({from, to});
    hanoi(n-1, other, to);
}

int solve(int n) {
    hanoi(n, 1, 3);
    
    cout << output.size() << endl;
    for(auto s : output) {
        cout << s.first << " " << s.second << "\n";
    }
    return 0;
}

int main(void) {
    ios_base::sync_with_stdio(false);

    int n;
    cin >> n;

    solve(n);
    return 0;
}