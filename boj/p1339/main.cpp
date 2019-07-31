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

int solve(int n, const vector<string> &words) {
    vector<int> num(26);
    
    for (string w : words) {
        for (int i = w.size()-1, j = 1; i >= 0; --i, j *= 10) {
            num[w[i] - 'A'] += j;
        }
    }
    
    sort(num.begin(), num.end(), greater<int>());
    
    int sum = 0;
    for (int i = 0, j = 9; num[i] > 0 || j > 0; ++i, --j) {
        sum += (num[i] * j);
    }
    return sum;
}

int main(void) {
    ios_base::sync_with_stdio(false);

    int n;
    cin >> n;
    vector<string> words(n);
    for (int i = 0; i < n; ++i) {
        cin >> words[i];
    }
    cout << solve(n, words) << endl;
    return 0;
}